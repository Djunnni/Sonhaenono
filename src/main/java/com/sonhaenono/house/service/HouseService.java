package com.sonhaenono.house.service;

import java.util.List;
import java.util.Map;

import com.sonhaenono.house.model.AptAverageDealDto;
import com.sonhaenono.house.model.AptDealDto;
import com.sonhaenono.house.model.AptDealSummary;
import com.sonhaenono.house.model.HouseInfoDto;

public interface HouseService {

	public List<HouseInfoDto> search(Map<String, String> query);

	public HouseInfoDto findByPnu(String pnu);

	public List<AptDealDto> findDealsByPnu(String pnu);

	public List<AptAverageDealDto> findDealSummaryByPnu(String pnu);

}
