package com.example.projectwork.services;

import com.example.projectwork.domain.Badge;
import com.example.projectwork.domain.Member;
import com.example.projectwork.infrastructure.dto.BadgeDto;

import java.util.List;

public interface BadgeService extends BaseService<Badge,BadgeDto> {
    public BadgeDto findByCode(String code);
}
