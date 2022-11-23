package com.sonhaenono.news.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sonhaenono.news.model.NewsDto;

@Mapper
public interface NewsMapper {
	public List<NewsDto> getNews(Map<String, Object> query);

}
