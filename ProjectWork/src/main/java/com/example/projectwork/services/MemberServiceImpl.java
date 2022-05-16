package com.example.projectwork.services;

import com.example.projectwork.domain.Badge;
import com.example.projectwork.domain.Member;
import com.example.projectwork.infrastructure.dto.BadgeDto;
import com.example.projectwork.infrastructure.dto.MemberDto;
import com.example.projectwork.infrastructure.mappers.BadgeMapper;
import com.example.projectwork.infrastructure.mappers.MemberMapper;
import com.example.projectwork.repository.BadgeRepository;
import com.example.projectwork.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements  MemberService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public MemberDto findById(long id) {
        return memberMapper.domainToDto(memberRepository.findById(id).orElseThrow());
    }

    @Override
    public MemberDto saveOrUpdate(MemberDto badge) {
        if(badge.getId()==0)
            return memberMapper.domainToDto(memberRepository.save(memberMapper.dtoToDomain(badge)));
        else {
            return memberMapper.domainToDto(memberRepository.save(memberMapper.dtoToDomain(badge)));
        }
    }

    @Override
    public void remove(long id) {
        Member entity=memberRepository.getById(id);
        memberRepository.delete(entity);
    }
}
