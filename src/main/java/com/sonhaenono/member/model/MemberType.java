package com.sonhaenono.member.model;

public enum MemberType {
	USER("U"), ADMIN("A");
	
	private final String type;
	
	MemberType(String type) { this.type = type; }
	
	public String getType() {
		return type;
	}
	public static MemberType parse(String str) throws Exception {
		if("U".equals(str)) {
			return USER;
		} else if("A".equals(str)) {
			return ADMIN;
		} else {
			return null;
		}
	}
}