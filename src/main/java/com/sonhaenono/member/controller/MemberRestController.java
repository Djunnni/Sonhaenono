package com.sonhaenono.member.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/api/member")
public class MemberRestController {

	@Autowired
	MemberService memberService;
	

	@GetMapping()
	public ResponseEntity<?> getMembers() {
		try {
			List<MemberDto> members = memberService.getMembers(null);
			return new ResponseEntity<List<MemberDto>>(members, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getMember(@PathVariable(value = "id", required = true) String id) {
		try {
			
			MemberDto member = memberService.getMemberById(id);
			if(member == null) {
				return new ResponseEntity<Object>(null, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<MemberDto>(member, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/id/{memberId}")
	public ResponseEntity<?> existMember(@PathVariable("memberId") String id) {
		try {
			int exist = memberService.existMemberId(id);
			
			boolean answer = exist > 0;
			return new ResponseEntity<Boolean>(answer, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}/type")
	public ResponseEntity<?> changeType(@PathVariable("id") String id, @RequestBody String type) {
		try {
			MemberType parsedType = MemberType.parse(type);
			if(parsedType == null) {
				throw new ApiException(ExceptionEnum.MEMBER_TYPE_EXCEPTION);
			}
			memberService.changeType(id, MemberType.parse(type));
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}/password")
	public ResponseEntity<?> changePassword(@PathVariable("id") String id, @RequestBody Map<String, String> map) {
		try {
			String oldPassword = map.get("password");
			String newPassword = map.get("new_password");
			if(memberService.changePassword(id, oldPassword, newPassword)) {
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			}
			
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
