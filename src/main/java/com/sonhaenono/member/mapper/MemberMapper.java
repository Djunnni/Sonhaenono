package com.sonhaenono.member.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.sonhaenono.member.model.MemberDto;
import com.sonhaenono.member.model.MemberFavoriteRegion;

@Mapper
public interface MemberMapper {

	void joinMember(MemberDto member) throws SQLException;
	MemberDto getMemberById(String id) throws SQLException;
	List<MemberDto> getMembers() throws SQLException;
	boolean existMemberId(String id) throws SQLException;
	int changePassword(Map<String, String> query) throws SQLException;
	int changeInfo(Map<String, String> query) throws SQLException;
	int changeType(Map<String, String> query) throws SQLException;
	List<String> getFavoriteRegions(String id) throws SQLException;
	void addFavoriteRegions(MemberFavoriteRegion addMfr) throws SQLException;
	void removeFavoriteRegions(MemberFavoriteRegion removeMfr) throws SQLException;
	Optional<MemberDto> findOneWithAuthoritiesById(String id);
}
