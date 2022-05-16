package com.example.projectwork.repository;

import com.example.projectwork.domain.Role;
import com.example.projectwork.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
