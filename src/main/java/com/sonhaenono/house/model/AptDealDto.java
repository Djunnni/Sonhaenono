package com.sonhaenono.house.model;

public class AptDealDto {
	private long no;
	
	private String pnu;
	private int floor;
	private float area;
	
	private String dealAmount;
	private int dealYear;
	private int dealMonth;
	private int dealDay;
	
	private boolean cancelDealType;

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getPnu() {
		return pnu;
	}

	public void setPnu(String pnu) {
		this.pnu = pnu;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public int getDealYear() {
		return dealYear;
	}

	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}

	public int getDealMonth() {
		return dealMonth;
	}

	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}

	public int getDealDay() {
		return dealDay;
	}

	public void setDealDay(int dealDay) {
		this.dealDay = dealDay;
	}

	public boolean isCancelDealType() {
		return cancelDealType;
	}

	public void setCancelDealType(boolean cancelDealType) {
		this.cancelDealType = cancelDealType;
	}

	public AptDealDto() {}
	public AptDealDto(long no, String pnu, int floor, float area, String dealAmount, int dealYear, int dealMonth,
			int dealDay, boolean cancelDealType) {
		this.no = no;
		this.pnu = pnu;
		this.floor = floor;
		this.area = area;
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.cancelDealType = cancelDealType;
	}
	
	
}
