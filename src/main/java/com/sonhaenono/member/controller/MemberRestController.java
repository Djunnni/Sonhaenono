package com.sonhaenono.member.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonhaenono.exception.ApiException;
import com.sonhaenono.exception.ExceptionEnum;
import com.sonhaenono.member.model.MemberDto;
import com.sonhaenono.member.model.MemberType;
import com.sonhaenono.member.service.MemberService;
import com.sonhaenono.util.SecurityUtil;

@RestController
@RequestMapping("/api/member")
public class MemberRestController {

	@Autowired
	MemberService memberService;
	
	@GetMapping()
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<?> getMembers() throws Exception {
		List<MemberDto> members = memberService.getMembers(null);
		return new ResponseEntity<List<MemberDto>>(members, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<?> getMember(@PathVariable(value = "id", required = true) String id) throws Exception {
		MemberDto member = memberService.getMemberById(id);
		if(member == null) {
			return new ResponseEntity<Object>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<MemberDto>(member, HttpStatus.OK);
	}
	
	@PutMapping("/{id}/type")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<?> changeType(@PathVariable("id") String id, @RequestBody String type) throws Exception {
		MemberType parsedType = MemberType.parse(type);
		if(parsedType == null) {
			throw new ApiException(ExceptionEnum.MEMBER_TYPE_EXCEPTION);
		}
		if(!memberService.existMemberId(id)) {
			throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);
		}
		memberService.changeType(id, MemberType.parse(type));
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@GetMapping("/info")
	public ResponseEntity<?> getInfo() throws Exception {
		String id = SecurityUtil.getCurrentUserId().get();
		
		MemberDto member = memberService.getMemberById(id);
		if(member == null) {
			return new ResponseEntity<Object>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<MemberDto>(member, HttpStatus.OK);
	}
	
	@PutMapping("/info")
	public ResponseEntity<?> changeInfo(@RequestBody Map<String, String> map) throws Exception {
		String id = SecurityUtil.getCurrentUserId().get();

		memberService.changeInfo(id, map);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@PutMapping("/password")
	public ResponseEntity<?> changePassword(@RequestBody Map<String, String> map) throws Exception {
		String id = SecurityUtil.getCurrentUserId().get();
		
		String oldPassword = map.get("password");
		String newPassword = map.get("new_password");
		
		if(memberService.changePassword(id, oldPassword, newPassword)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		
		throw new ApiException(ExceptionEnum.MEMBER_PASSWORD_EXCEPTION);
	}
	
	@PutMapping("/favorite-regions")
	public ResponseEntity<?> addFavoriteRegions(@RequestBody Map<String,List<String>> map) throws Exception {
		String id = SecurityUtil.getCurrentUserId().get();
		
		List<String> dongCodes = null;
		try {
			dongCodes = Objects.requireNonNull(map.get("regions"));
		} catch(Exception e) {
			throw new ApiException(ExceptionEnum.API_PARAMETER_EXCEPTION);
		}
		
		memberService.setFavoriteRegions(id, dongCodes);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@GetMapping("/favorite-regions")
	public ResponseEntity<?> getFavoriteRegions() throws Exception {
		String id = SecurityUtil.getCurrentUserId().get();
		
		List<String> regions = memberService.getFavoriteRegions(id);
		return new ResponseEntity<List<String>>(regions, HttpStatus.OK);
	}
	
}
