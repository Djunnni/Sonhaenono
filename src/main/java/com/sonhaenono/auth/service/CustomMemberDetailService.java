package com.sonhaenono.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sonhaenono.member.mapper.MemberMapper;
import com.sonhaenono.member.model.MemberDto;

@Service
public class CustomMemberDetailService implements UserDetailsService {
	
	private final MemberMapper memberMapper;
	
	@Autowired
	public CustomMemberDetailService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		return memberMapper.findOneWithAuthoritiesById(id)
				.map(member -> createUser(id, member))
				.orElseThrow(() -> new UsernameNotFoundException(id + "-> 데이터베이스에서 찾을 수 없는 멤버입니다."));
		
	}
	
	private User createUser(String id, MemberDto member) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		
		grantedAuthorities.add(new SimpleGrantedAuthority(member.getType().name()));
		
		return new User(member.getId(), member.getPassword(), grantedAuthorities);
	}
	
}
