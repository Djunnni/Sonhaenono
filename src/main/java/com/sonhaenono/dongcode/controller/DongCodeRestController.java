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

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/dongcode")
public class DongCodeRestController {
	
	@Autowired
	DongCodeService dongCodeService;
	
	@ApiOperation(
			notes = "type과 code를 전달받아 시/도/군구/동 정보를 조회합니다.",
			value ="시/도/군구/동 조회"
	)
	@ApiResponses({
		@ApiResponse(
				code = 200,
				message = "성공",
				response = DongCode.class
		),
		@ApiResponse(
				code = 400,
				message = "필수 파라미터 입력 요망"
		),
	})
	@GetMapping()
	public ResponseEntity<?> getCode(
			@ApiParam(value = "sido: 시/도, gugun: 구/군, dong: 동", required = true, example = "sido") @RequestParam(required = true, defaultValue = "") String type,
			@ApiParam(value = "dongCode: 동코드", required = false, example = "") @RequestParam(required = false, defaultValue = "") String code
	) throws Exception {
		// [1] 타입이 없을 경우,[2] 타입이 시/도가 아닐 때, code가 비어있으면 파라미터 요청 에러를 반환
		if(("".equals(type)) || (!"sido".equals(type) && "".equals(code))) {
			throw new ApiException(ExceptionEnum.API_PARAMETER_EXCEPTION);
		}
		Map<String, String> map = new HashMap<>();
		map.put("type", type);
		map.put("code", code);
		
		List<DongCode> list = dongCodeService.getDongCode(map);
		
		return new ResponseEntity<List<DongCode>>(list, HttpStatus.OK);
	}
	
}
