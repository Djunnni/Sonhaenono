package com.sonhaenono.auth.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonhaenono.auth.model.LoginDto;
import com.sonhaenono.auth.model.TokenDto;
import com.sonhaenono.jwt.JwtFilter;
import com.sonhaenono.jwt.TokenProvider;
import com.sonhaenono.member.model.MemberDto;
import com.sonhaenono.member.service.MemberService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private final TokenProvider tokenProvider;
	private final AuthenticationManagerBuilder authenticationManagerBuilder;
	
	@Autowired
	MemberService memberService;
	
	public AuthController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
		this.tokenProvider = tokenProvider;
		this.authenticationManagerBuilder = authenticationManagerBuilder;
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<TokenDto> authorize(@Valid @RequestBody LoginDto loginDto) {
		
		UsernamePasswordAuthenticationToken authenticationToken = 
				new UsernamePasswordAuthenticationToken(loginDto.getId(), loginDto.getPassword());
		
		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = tokenProvider.createToken(authentication);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
		
		return new ResponseEntity<TokenDto>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> createMembers(@RequestBody @Valid MemberDto member) throws Exception {
		memberService.joinMember(member);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	@GetMapping("/checkId/{memberId}")
	public ResponseEntity<?> existMember(@PathVariable("memberId") String id) throws Exception {
		boolean exist = memberService.existMemberId(id);
		return new ResponseEntity<Boolean>(exist, HttpStatus.OK);
	}
}
