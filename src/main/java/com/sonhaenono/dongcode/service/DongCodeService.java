package com.sonhaenono.dongcode.service;

import java.util.List;
import java.util.Map;

import com.sonhaenono.dongcode.DongCode;

public interface DongCodeService {
	List<DongCode> getDongCode(Map<String, String> map) throws Exception; 
}
