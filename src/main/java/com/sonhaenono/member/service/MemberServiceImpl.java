package com.sonhaenono.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sonhaenono.member.mapper.MemberMapper;
import com.sonhaenono.member.model.MemberDto;
import com.sonhaenono.member.model.MemberType;

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
	public boolean existMemberId(String id) throws Exception {
		return memberMapper.existMemberId(id) > 0;
	}

	@Override
	public String findPassword(String id, String name, String phone) throws Exception {
		Map<String, String> query = new HashMap<String, String>();
		
		query.put("id", id);
		query.put("name", name);
		query.put("phone", phone);
		
		return memberMapper.findPassword(query);
	}

	@Override
	@Transactional
	public boolean changePassword(String id, String oldPassword, String newPassword) throws Exception {
		Map<String, String> query = new HashMap<String, String>();
		
		query.put("id", id);
		query.put("old_password", oldPassword);
		query.put("new_password", newPassword);
		
		return memberMapper.changePassword(query) == 1;
	}

	@Override
	public boolean changeInfo(String id, Map<String, String> map) throws Exception {
		map.put("id", id);
		return memberMapper.changeInfo(map) == 1;
	}
	
	@Override
	public boolean changeType(String id, MemberType type) throws Exception {
		Map<String, String> query = new HashMap(); 
		query.put("id", id);
		query.put("type", type.getType());
		
		return memberMapper.changeType(query) == 1;
	}
	
}
