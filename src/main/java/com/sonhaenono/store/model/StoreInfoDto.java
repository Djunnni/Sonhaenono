package com.sonhaenono.store.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings("serial")
public class StoreInfoDto implements Serializable {
	private String bizesId;
	private String bizesNm;
	private String brchNm;
	private String indsLclsCd;
	private String indsLclsNm;
	private String indsMclsCd;
	private String indsMclsNm;
	private String dong_code;
	private String pnu;
	private String lnoAdr;
	private String bldNm;
	private String rdnmAdr;
	private String newZipcd;
	private String lng;
	private String lat;
	public String getBizesId() {
		return bizesId;
	}
	public void setBizesId(String bizesId) {
		this.bizesId = bizesId;
	}
	public String getBizesNm() {
		return bizesNm;
	}
	public void setBizesNm(String bizesNm) {
		this.bizesNm = bizesNm;
	}
	public String getBrchNm() {
		return brchNm;
	}
	public void setBrchNm(String brchNm) {
		this.brchNm = brchNm;
	}
	public String getIndsLclsCd() {
		return indsLclsCd;
	}
	public void setIndsLclsCd(String indsLclsCd) {
		this.indsLclsCd = indsLclsCd;
	}
	public String getIndsLclsNm() {
		return indsLclsNm;
	}
	public void setIndsLclsNm(String indsLclsNm) {
		this.indsLclsNm = indsLclsNm;
	}
	public String getIndsMclsCd() {
		return indsMclsCd;
	}
	public void setIndsMclsCd(String indsMclsCd) {
		this.indsMclsCd = indsMclsCd;
	}
	public String getIndsMclsNm() {
		return indsMclsNm;
	}
	public void setIndsMclsNm(String indsMclsNm) {
		this.indsMclsNm = indsMclsNm;
	}
	public String getDong_code() {
		return dong_code;
	}
	public void setDong_code(String dong_code) {
		this.dong_code = dong_code;
	}
	public String getPnu() {
		return pnu;
	}
	public void setPnu(String pnu) {
		this.pnu = pnu;
	}
	public String getLnoAdr() {
		return lnoAdr;
	}
	public void setLnoAdr(String lnoAdr) {
		this.lnoAdr = lnoAdr;
	}
	public String getBldNm() {
		return bldNm;
	}
	public void setBldNm(String bldNm) {
		this.bldNm = bldNm;
	}
	public String getRdnmAdr() {
		return rdnmAdr;
	}
	public void setRdnmAdr(String rdnmAdr) {
		this.rdnmAdr = rdnmAdr;
	}
	public String getNewZipcd() {
		return newZipcd;
	}
	public void setNewZipcd(String newZipcd) {
		this.newZipcd = newZipcd;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public StoreInfoDto() {}
	public StoreInfoDto(String bizesId, String bizesNm, String brchNm, String indsLclsCd, String indsLclsNm,
			String indsMclsCd, String indsMclsNm, String dong_code, String pnu, String lnoAdr, String bldNm,
			String rdnmAdr, String newZipcd, String lng, String lat) {
		this.bizesId = bizesId;
		this.bizesNm = bizesNm;
		this.brchNm = brchNm;
		this.indsLclsCd = indsLclsCd;
		this.indsLclsNm = indsLclsNm;
		this.indsMclsCd = indsMclsCd;
		this.indsMclsNm = indsMclsNm;
		this.dong_code = dong_code;
		this.pnu = pnu;
		this.lnoAdr = lnoAdr;
		this.bldNm = bldNm;
		this.rdnmAdr = rdnmAdr;
		this.newZipcd = newZipcd;
		this.lng = lng;
		this.lat = lat;
	}
	
	
}
