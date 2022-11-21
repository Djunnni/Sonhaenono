package com.sonhaenono.dongcode.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "동코드")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DongCode {
	@ApiModelProperty(example = "1117010400")
	private String dongCode;
	@ApiModelProperty(example = "서울특별시")
	private String sidoName;
	@ApiModelProperty(example = "용산구")
	private String gugunName;
	@ApiModelProperty(example = "갈월동")
	private String dongName;
	
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public String getSidoName() {
		return sidoName;
	}
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	public String getGugunName() {
		return gugunName;
	}
	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}
	public String getDongName() {
		return dongName;
	}
	public void setDongName(String dongName) {
		this.dongName = dongName;
	}
	
	@Override
	public String toString() {
		return "DongCode [dongCode=" + dongCode + ", sidoName=" + sidoName + ", gugunName=" + gugunName + ", dongName="
				+ dongName + "]";
	}
	
	public DongCode() {}
	public DongCode(String dongCode, String sidoName, String gugunName, String dongName) {
		super();
		this.dongCode = dongCode;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
	}
	
	
	
}
