package com.sonhaenono.member.service;

import java.util.List;
import java.util.Map;

import com.sonhaenono.member.model.MemberDto;
import com.sonhaenono.member.model.MemberType;


public interface MemberService {
	/**
	 * 회원가입
	 * @param member
	 * @throws Exception
	 */
	public void joinMember(MemberDto member) throws Exception;
	/**
	 * 아이디와 비밀번호를 받아 로그인합니다.
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public MemberDto loginMember(Map<String, String> map) throws Exception;
	/**
	 * 아이디로 유저 정보를 얻습니다.
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public MemberDto getMemberById(String id) throws Exception;
	/**
	 * 전체 멤버들을 조회합니다.
	 * @return
	 * @throws Exception
	 */
	public List<MemberDto> getMembers(Map<String, Object> query) throws Exception;
	/**
	 * 아이디가 존재하는 지 체크합니다.
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int existMemberId(String id) throws Exception;
	/**
	 * 비밀번호 찾기
	 * @param id
	 * @param name
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	public String findPassword(String id, String name, String phone) throws Exception;
	/**
	 * 비밀번호 변경하기
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	public boolean changePassword(String id, String oldPassword, String newPassword) throws Exception;
	/**
	 * 유저 정보 변경하기
	 * @param id
	 * @param map 
	 * {
	 * 	 name: String,
	 * 	 phone: String,
	 *   email: String
	 * }
	 * @return
	 * @throws Exception
	 */
	public boolean changeInfo(String id, Map<String, String> map) throws Exception;
	/**
	 * 유저 타입을 변경합니다.
	 * @param id
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public boolean changeType(String id, MemberType type) throws Exception;
}
