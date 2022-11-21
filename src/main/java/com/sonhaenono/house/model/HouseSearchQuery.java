package com.sonhaenono.house.model;

import java.io.Serializable;


@SuppressWarnings("serial")
public class HouseSearchQuery implements Serializable {
	private float southWestLat;
	private float southWestLng;
	private float northEastLat;
	private float northEastLng;
	
	private String aptName;
	private String dongCode;
	
	private int buildYearRange;

	public float getSouthWestLat() {
		return southWestLat;
	}

	public void setSouthWestLat(float southWestLat) {
		this.southWestLat = southWestLat;
	}

	public float getSouthWestLng() {
		return southWestLng;
	}

	public void setSouthWestLng(float southWestLng) {
		this.southWestLng = southWestLng;
	}

	public float getNorthEastLat() {
		return northEastLat;
	}

	public void setNorthEastLat(float northEastLat) {
		this.northEastLat = northEastLat;
	}

	public float getNorthEastLng() {
		return northEastLng;
	}

	public void setNorthEastLng(float northEastLng) {
		this.northEastLng = northEastLng;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public int getBuildYearRange() {
		return buildYearRange;
	}

	public void setBuildYearRange(int buildYearRange) {
		this.buildYearRange = buildYearRange;
	}
	
}
