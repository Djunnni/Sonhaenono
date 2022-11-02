package com.sonhaenono.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonhaenono.member.MemberDto;
import com.sonhaenono.member.service.MemberService;

@RestController
@RequestMapping("/api/member")
public class MemberRestController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("/{id}")
	public MemberDto getMember(@PathVariable("id") String id) {
		try {
			MemberDto member = memberService.getMemberById(id);
			
			return member;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
	}
}
