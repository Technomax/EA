package com.example.projectwork.repository;

import com.example.projectwork.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {
    @Query("select s from Badge s where s.textCode = :textCode")
    public Badge findByCode(@Param("textCode") String textCode);
}
