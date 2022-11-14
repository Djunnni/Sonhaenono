package com.sonhaenono.auth.model;


public class TokenDto {
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public TokenDto() {}
	
	public TokenDto(String token) {
		this.token = token;
	}
	
	
}
