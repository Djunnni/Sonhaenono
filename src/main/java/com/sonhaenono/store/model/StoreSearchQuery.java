package com.sonhaenono.store.model;

import java.io.Serializable;


@SuppressWarnings("serial")
public class StoreSearchQuery implements Serializable {
	private float southWestLat;
	private float southWestLng;
	private float northEastLat;
	private float northEastLng;
	
	private String indsLclsCd;
	private String indsMclsCd;

	private String dongCode;
	
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

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getIndsLclsCd() {
		return indsLclsCd;
	}

	public void setIndsLclsCd(String indsLclsCd) {
		this.indsLclsCd = indsLclsCd;
	}

	public String getIndsMclsCd() {
		return indsMclsCd;
	}

	public void setIndsMclsCd(String indsMclsCd) {
		this.indsMclsCd = indsMclsCd;
	}
	
}
