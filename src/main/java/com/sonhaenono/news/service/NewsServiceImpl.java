package com.sonhaenono.news.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonhaenono.news.mapper.NewsMapper;
import com.sonhaenono.news.model.NewsDto;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsMapper newsMapper;
	
	@Override
	public List<NewsDto> getNews(Map<String, String> query) {
		// TODO: 추가 validation 검증필요.
		int page = Integer.parseInt(query.getOrDefault("page", "1"));
		int count = Integer.parseInt(query.getOrDefault("count", "10"));
		
		Map<String, Object> map = new HashMap<>();
		map.put("title", query.getOrDefault("title", ""));
		map.put("startIndex", (page - 1) * count);
		map.put("limit", count);
		
		
		return newsMapper.getNews(map); 
	}

}
