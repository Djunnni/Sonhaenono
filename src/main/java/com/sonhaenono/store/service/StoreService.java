package com.sonhaenono.store.service;

import java.util.List;
import java.util.Map;

import com.sonhaenono.store.model.StoreInfoDto;

public interface StoreService {

	List<StoreInfoDto> search(Map<String, String> query);

}
