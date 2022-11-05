package com.sonhaenono.dongcode.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sonhaenono.dongcode.model.DongCode;

@Mapper
public interface DongCodeMapper {
	List<DongCode> getDongCode(Map<String, String> map) throws SQLException;

}
