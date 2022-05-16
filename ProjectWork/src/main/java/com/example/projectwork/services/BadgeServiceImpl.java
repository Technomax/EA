package com.example.projectwork.services;

import com.example.projectwork.domain.Badge;
import com.example.projectwork.domain.Member;
import com.example.projectwork.infrastructure.dto.BadgeDto;
import com.example.projectwork.infrastructure.mappers.BadgeMapper;
import com.example.projectwork.repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BadgeServiceImpl implements  BadgeService {
    @Autowired
    BadgeRepository badgeRepository;
    @Autowired
    private BadgeMapper badgeMapper;

    @Override
    public List<Badge> findAll() {
        return badgeRepository.findAll();
    }

    @Override
    public BadgeDto findById(long id) {
        return badgeMapper.domainToDto(badgeRepository.findById(id).get());
    }

    @Override
    public BadgeDto findByCode(String textCode) {
        return badgeMapper.domainToDto(badgeRepository.findByCode(textCode));
    }

    @Override
    public BadgeDto saveOrUpdate(BadgeDto badge) {
        return badgeMapper.domainToDto(badgeRepository.save(badgeMapper.dtoToDomain(badge)));
    }

    @Override
    public void remove(long id) {
        Badge entity=badgeRepository.getById(id);
        badgeRepository.delete(entity);
    }
}
