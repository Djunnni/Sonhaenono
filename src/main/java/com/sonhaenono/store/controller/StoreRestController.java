package com.sonhaenono.store.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sonhaenono.store.model.StoreInfoDto;
import com.sonhaenono.store.service.StoreService;

@RestController
@RequestMapping("/api/store")
public class StoreRestController {
	
	@Autowired
	StoreService storeService;
	
	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestParam Map<String, String> query) {
		
		List<StoreInfoDto> data = storeService.search(query);
		
		return new ResponseEntity<List<StoreInfoDto>>(data, HttpStatus.OK);
	}
	
}
