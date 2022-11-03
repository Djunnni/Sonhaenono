package com.sonhaenono.member.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sonhaenono.member.MemberDto;

@Mapper
public interface MemberMapper {

	void joinMember(MemberDto member) throws SQLException;
	MemberDto loginMember(Map<String, String> map) throws SQLException;
	MemberDto getMemberById(String id) throws SQLException;
	List<MemberDto> getMembers() throws SQLException;
	int existMemberId(String id) throws SQLException;
	String findPassword(Map<String, String> query) throws SQLException;
	int changePassword(Map<String, String> query) throws SQLException;
	int changeInfo(Map<String, String> query) throws SQLException;
	int changeType(Map<String, String> query) throws SQLException;
}
