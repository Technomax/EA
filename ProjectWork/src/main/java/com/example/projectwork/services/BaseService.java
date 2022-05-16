package com.example.projectwork.services;

import com.example.projectwork.domain.Badge;
import com.example.projectwork.infrastructure.dto.BadgeDto;

import java.util.List;

public interface BaseService<S,T> {
    public List<S> findAll();
    public T findById(long id);
    public T saveOrUpdate(T badge);
    public void remove(long id);
}
