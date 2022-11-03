package com.sonhaenono.exception;

public class MemberTypeException extends RuntimeException {
	public MemberTypeException() {
		this("MEMBER_TYPE_EXCEPTION");
	}
	public MemberTypeException(String errMessage) {
		super(errMessage);
	}
}
