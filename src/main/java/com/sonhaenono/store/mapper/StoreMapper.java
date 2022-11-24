package com.sonhaenono.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sonhaenono.store.model.StoreInfoDto;
import com.sonhaenono.store.model.StoreSearchQuery;

@Mapper
public interface StoreMapper {

	List<StoreInfoDto> search(StoreSearchQuery searchQuery);

}
