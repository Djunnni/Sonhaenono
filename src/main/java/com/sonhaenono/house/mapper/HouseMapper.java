package com.sonhaenono.house.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sonhaenono.house.model.HouseInfoDto;
import com.sonhaenono.house.model.HouseSearchQuery;

@Mapper
public interface HouseMapper {

	List<HouseInfoDto> search(HouseSearchQuery query);

}
