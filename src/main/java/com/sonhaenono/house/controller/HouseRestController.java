package com.sonhaenono.house.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sonhaenono.house.model.AptAverageDealDto;
import com.sonhaenono.house.model.AptDealDto;
import com.sonhaenono.house.model.AptDealSummary;
import com.sonhaenono.house.model.HouseInfoDto;
import com.sonhaenono.house.service.HouseService;
import com.sonhaenono.news.model.NewsDto;

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
	
	@GetMapping("/default")
	public ResponseEntity<?> searchDefaultByPnu(@RequestParam @Valid String pnu) {
		HouseInfoDto info = houseService.findByPnu(pnu);
		if(info == null) {
			return new ResponseEntity<Object>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<HouseInfoDto>(info, HttpStatus.OK);
	}
	@GetMapping("/deal")
	public ResponseEntity<?> searchDealsByPnu(@RequestParam @Valid String pnu) {
		List<AptAverageDealDto> averages = houseService.findDealSummaryByPnu(pnu);
		List<AptDealDto> deals = houseService.findDealsByPnu(pnu);
		
		AptDealSummary summary = new AptDealSummary(pnu, averages, deals); 
		return new ResponseEntity<AptDealSummary>(summary, HttpStatus.OK);
	}
	@GetMapping("/detail")
	public ResponseEntity<?> searchDetailByPnu(@RequestParam @Valid String pnu) {
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
}
