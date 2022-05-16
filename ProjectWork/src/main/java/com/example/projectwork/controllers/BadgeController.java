package com.example.projectwork.controllers;

import com.example.projectwork.domain.Badge;
import com.example.projectwork.infrastructure.dto.BadgeDto;
import com.example.projectwork.services.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("badges")
public class BadgeController {
    @Autowired
    private BadgeService service;

    @GetMapping()
    public List<Badge> getBadges() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public BadgeDto getBadge(@PathVariable String id) {
        return service.findByCode(id);
    }

    @PostMapping()
    public BadgeDto addBadge(@RequestBody BadgeDto badge) {
        return service.saveOrUpdate(badge);
    }

    @DeleteMapping("{id}")
    public void deleteBadge(@PathVariable String id) {
        BadgeDto model = service.findByCode(id);
        service.remove(model.getId());
    }

    @PutMapping()
    public BadgeDto updateBadge(@RequestBody BadgeDto badge) {
        return service.saveOrUpdate(badge);
    }
}
