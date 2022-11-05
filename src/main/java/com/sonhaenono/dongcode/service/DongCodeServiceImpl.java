package com.sonhaenono.dongcode.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonhaenono.dongcode.DongCode;
import com.sonhaenono.dongcode.mapper.DongCodeMapper;

@Service
public class DongCodeServiceImpl implements DongCodeService {

	@Autowired
	DongCodeMapper dongCodeMapper;
	
	@Override
	public List<DongCode> getDongCode(Map<String, String> map) throws Exception {
		return dongCodeMapper.getDongCode(map); 
	}

}
