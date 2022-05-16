package com.example.projectwork.infrastructure.mappers;

import com.example.projectwork.domain.Badge;
import com.example.projectwork.infrastructure.dto.BadgeDto;

public interface BadgeMapper {
    BadgeDto domainToDto(Badge domain);
    Badge dtoToDomain(BadgeDto dto);
}
