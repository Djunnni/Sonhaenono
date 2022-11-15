package com.sonhaenono.member.model;

public enum MemberType {
	ROLE_USER("U"), ROLE_ADMIN("A");
	
	private final String type;
	
	MemberType(String type) { this.type = type; }
	
	public String getType() {
		return type;
	}
	public static MemberType parse(String str) throws Exception {
		if("U".equals(str) || "ROLE_USER".equals(str)) {
			return ROLE_USER;
		} else if("A".equals(str) || "ROLE_ADMIN".equals(str)) {
			return ROLE_ADMIN;
		} else {
			return null;
		}
	}
}