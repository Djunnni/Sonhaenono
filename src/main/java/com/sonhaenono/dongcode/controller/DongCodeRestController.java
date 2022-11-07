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

import com.sonhaenono.dongcode.model.DongCode;
import com.sonhaenono.dongcode.service.DongCodeService;
import com.sonhaenono.exception.ApiException;
import com.sonhaenono.exception.ExceptionEnum;

import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/dongcode")
public class DongCodeRestController {
	
	@Autowired
	DongCodeService dongCodeService;
	
	@Operation(summary = "동코드 조회하기", description = "시/도/구/군/동 코드를 조회합니다.")
	@ApiResponse(code = 200, message = "정상 동작")
	@GetMapping()
	public ResponseEntity<?> getCode(
			@RequestParam(required = true, defaultValue = "") String type,
			@RequestParam(required = false, defaultValue = "") String code
	) throws Exception {
		// [1] 타입이 없을 경우,[2] 타입이 시/도가 아닐 때, code가 비어있으면 파라미터 요청 에러를 반환
		if(("".equals(type)) || (!"sido".equals(type) && "".equals(code))) {
			throw new ApiException(ExceptionEnum.DONGCODE_PARAMETER_EXCEPTION);
		}
		Map<String, String> map = new HashMap<>();
		map.put("type", type);
		map.put("code", code);
		
		List<DongCode> list = dongCodeService.getDongCode(map);
		
		return new ResponseEntity<List<DongCode>>(list, HttpStatus.OK);
	}
	
}
