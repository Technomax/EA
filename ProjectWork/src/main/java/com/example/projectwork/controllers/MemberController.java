package com.example.projectwork.controllers;

import com.example.projectwork.domain.Member;
import com.example.projectwork.infrastructure.dto.MemberDto;
import com.example.projectwork.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("members")
public class MemberController {
    @Autowired
    private MemberService service;

    @GetMapping()
    public List<Member> getMembers() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public MemberDto getMember(@PathVariable long id) {
        return service.findById(id);
    }

    @PostMapping()
    public MemberDto addMember(@RequestBody MemberDto Member) {
        return service.saveOrUpdate(Member);
    }

    @DeleteMapping("{id}")
    public void deleteMember(@PathVariable long id) {
        service.remove(id);
    }

    @PutMapping()
    public MemberDto updateMember(@RequestBody MemberDto Member) {
        return service.saveOrUpdate(Member);
    }
}
