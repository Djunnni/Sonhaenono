package com.sonhaenono.house.model;

public class AptCodeDto {
	private String pnu;
	private String kaptCode;
	
	public String getPnu() {
		return pnu;
	}
	public void setPnu(String pnu) {
		this.pnu = pnu;
	}
	public String getKaptCode() {
		return kaptCode;
	}
	public void setKaptCode(String kaptCode) {
		this.kaptCode = kaptCode;
	}
	
	public AptCodeDto() {}
	public AptCodeDto(String pnu, String kaptCode) {
		this.pnu = pnu;
		this.kaptCode = kaptCode;
	}
	
	@Override
	public String toString() {
		return "AptCodeDto [pnu=" + pnu + ", kaptCode=" + kaptCode + "]";
	}
	
	
}
