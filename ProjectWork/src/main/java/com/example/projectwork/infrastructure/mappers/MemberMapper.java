package com.example.projectwork.infrastructure.mappers;

import com.example.projectwork.domain.Badge;
import com.example.projectwork.domain.Member;
import com.example.projectwork.infrastructure.dto.BadgeDto;
import com.example.projectwork.infrastructure.dto.MemberDto;

public interface MemberMapper {
    MemberDto domainToDto(Member domain);
    Member dtoToDomain(MemberDto dto);
}
