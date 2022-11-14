package com.sonhaenono.auth.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginDto {
	
	@NotNull
	@Size(min = 5, max = 20)
	@Pattern(regexp = "[0-9a-z_-]+")
	private String id; // 아이디
	
	@NotNull
	@Size(min = 8, max = 16)
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$")
	private String password; // 비밀번호
	
	LoginDto() {}

	public LoginDto(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
