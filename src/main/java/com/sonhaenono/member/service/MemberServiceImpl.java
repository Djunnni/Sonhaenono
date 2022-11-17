package com.sonhaenono.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sonhaenono.exception.ApiException;
import com.sonhaenono.exception.ExceptionEnum;
import com.sonhaenono.member.mapper.MemberMapper;
import com.sonhaenono.member.model.MemberDto;
import com.sonhaenono.member.model.MemberFavoriteRegion;
import com.sonhaenono.member.model.MemberType;

@Service
public class MemberServiceImpl implements MemberService {

	private final MemberMapper memberMapper;
	private final PasswordEncoder PasswordEncoder;

	@Autowired
	public MemberServiceImpl(MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
		this.memberMapper = memberMapper;
		this.PasswordEncoder = passwordEncoder;
	}

	@Override
	public boolean existMemberId(String id) throws Exception {
		return memberMapper.existMemberId(id);
	}
	
	@Override
	@Transactional
	public void joinMember(MemberDto memberDto) throws Exception {
		if(memberMapper.findOneWithAuthoritiesById(memberDto.getId()).orElse(null) != null) {
			throw new ApiException(ExceptionEnum.MEMBER_EXIST_EXCEPTION);
		}
		
		memberDto.setPassword(PasswordEncoder.encode(memberDto.getPassword()));
		memberMapper.joinMember(memberDto);
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
	@Transactional
	public boolean changePassword(String id, String oldPassword, String newPassword) throws Exception {
		// 현재 비밀번호와 이전 비밀번호가 동일하다면 return false
		if(newPassword.equals(oldPassword)) {
			return false;
		} 
		// DB에 저장된 암호화된 비밀번호와 이전 비밀번호가 일치하는지 확인
		String encodedPassword = memberMapper.findOneWithAuthoritiesById(id).get().getPassword();
		if(!PasswordEncoder.matches(oldPassword, encodedPassword)) {
			return false;
		}
		
		Map<String, String> query = new HashMap<String, String>();
		query.put("id", id);
		query.put("new_password", PasswordEncoder.encode(newPassword));
		
		return memberMapper.changePassword(query) != 0;
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

	@Override
	public List<String> getFavoriteRegions(String id) throws Exception {
		return memberMapper.getFavoriteRegions(id);
	}

	@Override
	@Transactional
	public void setFavoriteRegions(String id,  List<String> dongCodes) throws Exception {
		List<String> originalList = memberMapper.getFavoriteRegions(id);
		
		Set<String> addSet = new HashSet<>(dongCodes);
		addSet.removeAll(new HashSet<>(originalList));
		Set<String> removeSet = new HashSet<>(originalList);
		removeSet.removeAll(new HashSet<>(dongCodes));
		
		List<String> removeList = new ArrayList<String>(removeSet); 
		List<String> addList = new ArrayList<String>(addSet);
		
		if(removeList.size() > 0) {
			MemberFavoriteRegion removeMfr = new MemberFavoriteRegion(id, removeList);
			memberMapper.removeFavoriteRegions(removeMfr);
		}
		if(addList.size() > 0) {
			MemberFavoriteRegion addMfr = new MemberFavoriteRegion(id, addList);
			memberMapper.addFavoriteRegions(addMfr);
		}
	}
	
}
