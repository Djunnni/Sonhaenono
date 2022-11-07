package com.sonhaenono.exception;

import org.springframework.http.HttpStatus;

public enum ExceptionEnum {
	RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "E0001"),
	ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "E0002"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E0003"),
	API_NOT_EXIST_EXCEPTION(HttpStatus.NOT_FOUND, "E0004", "존재하지 않는 API 입니다."),
	API_METHOD_NOT_ALLOWED_EXCEPTION(HttpStatus.METHOD_NOT_ALLOWED, "E0005", "지원하지 않는 Method입니다."),
	
	DONGCODE_PARAMETER_EXCEPTION(HttpStatus.BAD_REQUEST, "D0001", "필수 파라미터를 넣어주세요."),
	
	MEMBER_ACCESS_EXCEPTION(HttpStatus.FORBIDDEN, "M0001", "접근 권한이 없습니다."),
	MEMBER_TYPE_EXCEPTION(HttpStatus.BAD_REQUEST, "M0010", "존재하지 않는 멤버 타입입니다."),
	MEMBER_PASSWORD_EXCEPTION(HttpStatus.BAD_REQUEST, "M0011", "비밀번호를 확인해주세요.");
	private final HttpStatus status;
	private final String code;
	private String message;
	
	ExceptionEnum(HttpStatus status, String code) {
		this.status = status;
		this.code = code;
	}
	
	ExceptionEnum(HttpStatus status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getCode() {
		return code;
	}
}
