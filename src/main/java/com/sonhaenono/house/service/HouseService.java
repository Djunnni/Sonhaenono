package com.sonhaenono.house.service;

import java.util.List;
import java.util.Map;

import com.sonhaenono.house.model.HouseInfoDto;

public interface HouseService {

	public List<HouseInfoDto> search(Map<String, String> query);

}
