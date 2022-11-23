package com.sonhaenono.house.model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class AptDealSummary implements Serializable {
	private String pnu;
	private List<AptAverageDealDto> averages;
	private List<AptDealDto> deals;
	
	public AptDealSummary() {}
	public AptDealSummary(String pnu, List<AptAverageDealDto> averages, List<AptDealDto> deals) {
		this.averages = averages;
		this.deals = deals;
		this.pnu = pnu;
	}
	
	public List<AptAverageDealDto> getAverages() {
		return averages;
	}
	public void setAverages(List<AptAverageDealDto> averages) {
		this.averages = averages;
	}
	public List<AptDealDto> getDeals() {
		return deals;
	}
	public void setDeals(List<AptDealDto> deals) {
		this.deals = deals;
	}
	public String getPnu() {
		return pnu;
	}
	public void setPnu(String pnu) {
		this.pnu = pnu;
	}
	
	
}
