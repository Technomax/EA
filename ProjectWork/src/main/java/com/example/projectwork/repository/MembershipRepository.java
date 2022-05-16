package com.example.projectwork.repository;

import com.example.projectwork.domain.Member;
import com.example.projectwork.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
}
