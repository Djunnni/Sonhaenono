package com.sonhaenono.member.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sonhaenono.exception.ApiException;
import com.sonhaenono.exception.ExceptionEnum;
import com.sonhaenono.member.model.MemberDto;
import com.sonhaenono.member.model.MemberType;
import com.sonhaenono.member.service.MemberService;

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
	
	@PostMapping
	public ResponseEntity<?> createMembers(@RequestBody @Valid MemberDto member) throws Exception {
		if(memberService.existMemberId(member.getId())) {
			throw new ApiException(ExceptionEnum.MEMBER_EXIST_EXCEPTION);
		}
		
		memberService.joinMember(member);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getMember(@PathVariable(value = "id", required = true) String id) throws Exception {
		MemberDto member = memberService.getMemberById(id);
		if(member == null) {
			return new ResponseEntity<Object>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<MemberDto>(member, HttpStatus.OK);
	}
	
	@GetMapping("/id/{memberId}")
	public ResponseEntity<?> existMember(@PathVariable("memberId") String id) throws Exception {
		boolean exist = memberService.existMemberId(id);
		return new ResponseEntity<Boolean>(exist, HttpStatus.OK);
	}
	
	@PutMapping("/{id}/type")
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
	@PutMapping("/{id}/info")
	public ResponseEntity<?> changeInfo(@PathVariable("id") String id, @RequestBody Map<String, String> map) throws Exception {
		if(!memberService.existMemberId(id)) {
			throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);
		}
		memberService.changeInfo(id, map);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@GetMapping("/password/{memberId}")
	public ResponseEntity<?> getPassword(@PathVariable(name = "memberId", required = true) String id, @RequestParam(name = "name", required = true) String name, @RequestParam(name = "phone", required = true) String phone) throws Exception {
		if(!memberService.existMemberId(id)) {
			throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);
		}
		String pw = memberService.findPassword(id, name, phone);
		if(pw == null) {
			throw new ApiException(ExceptionEnum.API_PARAMETER_EXCEPTION);
		}
		return new ResponseEntity<String>(pw, HttpStatus.OK);
	}
	
	@PutMapping("/{id}/password")
	public ResponseEntity<?> changePassword(@PathVariable("id") String id, @RequestBody Map<String, String> map) throws Exception {
		String oldPassword = map.get("password");
		String newPassword = map.get("new_password");
		if(newPassword.equals(oldPassword)) {
			throw new ApiException(ExceptionEnum.MEMBER_PASSWORD_EXCEPTION);
		}
		if(memberService.changePassword(id, oldPassword, newPassword)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		
		throw new ApiException(ExceptionEnum.MEMBER_PASSWORD_EXCEPTION);
	}
	
	@PutMapping("/{id}/favorite-regions")
	public ResponseEntity<?> addFavoriteRegions(@PathVariable("id") String id, @RequestBody Map<String,List<String>> map) throws Exception {
		if(!memberService.existMemberId(id)) {
			throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);
		}
		List<String> dongCodes = null;
		try {
			dongCodes = Objects.requireNonNull(map.get("regions"));
		} catch(Exception e) {
			throw new ApiException(ExceptionEnum.API_PARAMETER_EXCEPTION);
		}
		
		memberService.setFavoriteRegions(id, dongCodes);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/favorite-regions")
	public ResponseEntity<?> getFavoriteRegions(@PathVariable("id") String id) throws Exception {
		if(!memberService.existMemberId(id)) {
			throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);
		}
		
		List<String> regions = memberService.getFavoriteRegions(id);
		return new ResponseEntity<List<String>>(regions, HttpStatus.OK);
	}
	
}
