package com.example.projectwork.services;

import com.example.projectwork.domain.Member;

import java.util.List;

public interface RoleService {
    public List<Member> findAll();
    public Member findById(long id);
    public Member saveOrUpdate(long id, Member member);
    public Member remove(long id, Member member);
}
