package com.example.projectwork.infrastructure.mappers;

import com.example.projectwork.domain.Badge;
import com.example.projectwork.infrastructure.dto.BadgeDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BadgeMapperImpl implements  BadgeMapper {
    @Override
    public BadgeDto domainToDto(Badge domain) {
        ModelMapper mapper = new ModelMapper();
        BadgeDto dto = mapper.map(domain, BadgeDto.class);
        return dto;
    }

    @Override
    public Badge dtoToDomain(BadgeDto dto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(dto, Badge.class);
    }
}
