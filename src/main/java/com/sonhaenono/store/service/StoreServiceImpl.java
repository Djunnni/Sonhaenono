package com.sonhaenono.store.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonhaenono.store.mapper.StoreMapper;
import com.sonhaenono.store.model.StoreInfoDto;
import com.sonhaenono.store.model.StoreSearchQuery;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreMapper storeMapper;
	
	@Override
	public List<StoreInfoDto> search(Map<String, String> query) {
		StoreSearchQuery searchQuery = new StoreSearchQuery();
		
		String southWestLat = query.getOrDefault("southWestLat", "");
		String southWestLng = query.getOrDefault("southWestLng", "");
		String northEastLat = query.getOrDefault("northEastLat", "");
		String northEastLng = query.getOrDefault("northEastLng", "");
		
		searchQuery.setIndsLclsCd(query.getOrDefault("indsLclsCd", ""));
		searchQuery.setIndsMclsCd(query.getOrDefault("indsMclsCd", ""));
		if(!southWestLat.equals(""))
			searchQuery.setSouthWestLat(Float.parseFloat(southWestLat));
		if(!southWestLng.equals(""))
			searchQuery.setSouthWestLng(Float.parseFloat(southWestLng));
		if(!northEastLat.equals(""))
			searchQuery.setNorthEastLat(Float.parseFloat(northEastLat));
		if(!northEastLng.equals(""))
			searchQuery.setNorthEastLng(Float.parseFloat(northEastLng));
		
		return storeMapper.search(searchQuery);
	}
}
