package com.example.projectwork.infrastructure.mappers;

import com.example.projectwork.domain.Badge;
import com.example.projectwork.domain.Member;
import com.example.projectwork.infrastructure.dto.BadgeDto;
import com.example.projectwork.infrastructure.dto.MemberDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MemberMapperImpl implements  MemberMapper {
    @Override
    public MemberDto domainToDto(Member domain) {
        ModelMapper mapper = new ModelMapper();
        MemberDto dto = mapper.map(domain, MemberDto.class);
        return dto;
    }

    @Override
    public Member dtoToDomain(MemberDto dto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(dto, Member.class);
    }
}
