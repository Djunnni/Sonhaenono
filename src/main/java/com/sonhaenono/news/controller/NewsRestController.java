package com.sonhaenono.news.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sonhaenono.news.model.NewsDto;
import com.sonhaenono.news.service.NewsService;

@RestController
@RequestMapping("/api/news")
public class NewsRestController {
	
	@Autowired
	NewsService newsService;
	
	@GetMapping
	public ResponseEntity<?> getNews(@RequestParam Map<String, String> query) {
		List<NewsDto> news = newsService.getNews(query);
		return new ResponseEntity<List<NewsDto>>(news, HttpStatus.OK);
	}
}
