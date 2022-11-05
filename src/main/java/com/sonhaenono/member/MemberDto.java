package com.sonhaenono.member;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
public class MemberDto implements Serializable {
	
	@NotNull
	@Size(min = 5, max = 20)
	@Pattern(regexp = "[0-9a-z_-]+")
	private String id; // 아이디
	
	@Size(min = 8, max = 16)
	@Pattern(regexp = " ^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$")
	private String password; // 비밀번호
	
	@Size(max = 40)
	@Pattern(regexp = "[가-힣a-zA-Z]+")
	private String name; // 이름
	
	@NotNull
	private MemberType type; // 유저타입
	
	@Size(max = 16)
	@Pattern(regexp="[0-9]+")
	private String phone; // 전화번호
	
	@Size(max = 100)
	private String email; // 이메일
	
	private LocalDateTime joinDate; // 가입날짜
	private LocalDateTime updatedDate; // 수정날짜
	
	public MemberDto() {
		type = MemberType.USER;
	}
	public MemberDto(String id, String password, String name, MemberType type, String phone, String email) {
		this();
		this.id = id;
		this.password = password;
		this.name = name;
		this.type = type;
		this.phone = phone;
		this.email = email;
	}
	public MemberDto(String id, String password, String name, MemberType type, String phone, String email,
			LocalDateTime joinDate, LocalDateTime updatedDate) {
		this(id, password, name, type, phone, email);
		this.joinDate = joinDate;
		this.updatedDate = updatedDate;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MemberType getType() {
		return type;
	}
	public void setType(MemberType type) {
		this.type = type;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", password=" + password + ", name=" + name + ", type=" + type + ", phone="
				+ phone + ", email=" + email + ", joinDate=" + joinDate + ", updatedDate=" + updatedDate + "]";
	}
	
	
	
	
}
