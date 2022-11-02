package com.sonhaenono.member.controller;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sonhaenono.member.MemberDto;
import com.sonhaenono.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@GetMapping
	public String main() throws Exception {
		return "/";
	}
	
	@GetMapping("/login")
	public String login(@Value("session.key") String key, @RequestParam Map<String,String> map, HttpSession session) throws Exception {
		MemberDto member = memberService.loginMember(map);
		if(member != null) {
			session.setAttribute(key, member);
		}
		return null;
	}
	
	@GetMapping("/logout")
	public String logout(@Value("session.key") String key, HttpSession session) {
		// 관련된 속성을 지우는 동작 수행
		Enumeration<String> names = session.getAttributeNames();
		while(names.hasMoreElements()) {
			String _key = names.nextElement();
			if(_key.equals(key)) {
				session.removeAttribute(_key);
			}
		}
		// 세션 초기화
		session.invalidate();
		
		// 리다이렉트
		return "redirect:/";
	}
}
