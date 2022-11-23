package com.sonhaenono.house.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AptAverageDealDto implements Serializable {
	private int dealYear;
	private int averageDeal;
	
	public int getDealYear() {
		return dealYear;
	}
	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}
	public int getAverageDeal() {
		return averageDeal;
	}
	public void setAverageDeal(int averageDeal) {
		this.averageDeal = averageDeal;	}
	public AptAverageDealDto() {}
	public AptAverageDealDto(int dealYear, int averageDeal) {
		this.dealYear = dealYear;
		this.averageDeal = averageDeal;
	}
}
