package com.sonhaenono.house.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonhaenono.house.mapper.HouseMapper;
import com.sonhaenono.house.model.HouseInfoDto;
import com.sonhaenono.house.model.HouseSearchQuery;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	HouseMapper houseMapper;
	
	@Override
	public List<HouseInfoDto> search(Map<String, String> query) {
		HouseSearchQuery searchQuery = new HouseSearchQuery();
		
		String aptName = query.getOrDefault("aptName", "");
		String buildYearRange = query.getOrDefault("buildYearRange", "");
		String southWestLat = query.getOrDefault("southWestLat", "");
		String southWestLng = query.getOrDefault("southWestLng", "");
		String northEastLat = query.getOrDefault("northEastLat", "");
		String northEastLng = query.getOrDefault("northEastLng", "");
		
		searchQuery.setAptName(aptName);
		if(buildYearRange.equals("")) {
			searchQuery.setBuildYearRange(-1);
		} else {
			searchQuery.setBuildYearRange(Integer.parseInt(buildYearRange));
		}
		if(!southWestLat.equals(""))
			searchQuery.setSouthWestLat(Float.parseFloat(southWestLat));
		if(!southWestLng.equals(""))
			searchQuery.setSouthWestLng(Float.parseFloat(southWestLng));
		if(!northEastLat.equals(""))
			searchQuery.setNorthEastLat(Float.parseFloat(northEastLat));
		if(!northEastLng.equals(""))
			searchQuery.setNorthEastLng(Float.parseFloat(northEastLng));
		
		return houseMapper.search(searchQuery);
	}

}
