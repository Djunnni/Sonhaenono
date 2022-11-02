package com.sonhaenono.member;

public enum MemberType {
	USER("U"), ADMIN("A");
	
	private final String type;
	
	MemberType(String type) { this.type = type; }
	
	public String getType() {
		return type;
	}
}