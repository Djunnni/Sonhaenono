package com.sonhaenono.board.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class BoardDto implements Serializable {
	private int no;
	private String memberId;
	@NotNull
	@Size(min = 1, max = 100)
	private String subject;
	@Size(min = 0, max = 2000)
	private String content;
	private int hit;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@Override
	public String toString() {
		return "Board [no=" + no + ", memberId=" + memberId + ", subject=" + subject + ", content=" + content + ", hit="
				+ hit + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	public BoardDto(int no, String memberId, String subject, String content, int hit, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.no = no;
		this.memberId = memberId;
		this.subject = subject;
		this.content = content;
		this.hit = hit;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
