package com.sonhaenono.news.service;

import java.util.List;
import java.util.Map;

import com.sonhaenono.news.model.NewsDto;

public interface NewsService {

	List<NewsDto> getNews(Map<String, String> query);

}
