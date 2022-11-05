package com.sonhaenono.dongcode.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sonhaenono.dongcode.DongCode;
import com.sonhaenono.dongcode.service.DongCodeService;

@RestController
@RequestMapping("/api/dongcode")
public class DongCodeRestController {
	
	@Autowired
	DongCodeService dongCodeService;
	
	@GetMapping()
	public ResponseEntity<?> getCode(@RequestParam String type, @RequestParam String code) {
		try {
			Map<String, String> map = new HashMap<>();
			map.put("type", type);
			map.put("code", code);
			
			List<DongCode> list = dongCodeService.getDongCode(map);
			
			return new ResponseEntity<List<DongCode>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
