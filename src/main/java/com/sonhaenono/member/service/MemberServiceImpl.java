package com.sonhaenono.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonhaenono.member.MemberDto;
import com.sonhaenono.member.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public void joinMember(MemberDto member) throws Exception {
		memberMapper.joinMember(member);
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) throws Exception {
		return memberMapper.loginMember(map);
	}

	@Override
	public MemberDto getMemberById(String id) throws Exception {
		return memberMapper.getMemberById(id);
	}

	@Override
	public List<MemberDto> getMembers(Map<String, Object> query) throws Exception {
		//TODO: 쿼리에 따라 member조회문 수정하기
		return memberMapper.getMembers();
	}

	@Override
	public int existMemberId(String id) throws Exception {
		return memberMapper.existMemberId(id);
	}

	@Override
	public String findPassword(String id, String name, String phone) throws Exception {
		Map<String, String> query = new HashMap<String, String>();
		
		query.put("id", id);
		query.put("name", name);
		query.put("phone", phone);
		
		return memberMapper.findPassword(query);
	}

	
	
}
