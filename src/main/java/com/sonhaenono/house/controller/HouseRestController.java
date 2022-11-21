package com.sonhaenono.house.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sonhaenono.house.model.HouseInfoDto;
import com.sonhaenono.house.service.HouseService;

@RestController
@RequestMapping("/api/house")
public class HouseRestController {
	
	@Autowired
	HouseService houseService;
	
	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestParam Map<String, String> query) {
		
		List<HouseInfoDto> data = houseService.search(query);
		
		return new ResponseEntity<List<HouseInfoDto>>(data, HttpStatus.OK);
	}
	
}
