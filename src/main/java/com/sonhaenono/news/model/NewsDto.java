package com.sonhaenono.news.model;

public class NewsDto {
	private int no;
	private String title;
	private String url;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public NewsDto() {}
	public NewsDto(int no, String title, String url) {
		this.no = no;
		this.title = title;
		this.url = url;
	}
	
	
}
