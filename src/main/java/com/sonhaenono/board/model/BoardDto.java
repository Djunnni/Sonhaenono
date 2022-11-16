package com.sonhaenono.board.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class BoardDto implements Serializable {
	private int no;
	private String memberId;
	
	@NotBlank
	@Size(min = 1, max = 100)
	private String subject;
	
	@Size(min = 0, max = 2000)
	private String content;
	private int hit;
	private int likeCount;
	
	@Size(max = 10)
	private String type;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	private List<CommentDto> comments;
	
	
	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", memberId=" + memberId + ", subject=" + subject + ", content=" + content
				+ ", hit=" + hit + ", likeCount=" + likeCount + ", type=" + type + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", comments=" + comments + "]";
	}
	
	public BoardDto() {
		
	}

	public BoardDto(int no, String memberId, String subject, String content, int hit, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		this.no = no;
		this.memberId = memberId;
		this.subject = subject;
		this.content = content;
		this.hit = hit;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public BoardDto(int no, String memberId, String subject,
			String content, int hit, int likeCount, String type,
			LocalDateTime createdAt, LocalDateTime updatedAt, List<CommentDto> comments) {
		this(no, memberId, subject, content, hit, createdAt, updatedAt);
		this.likeCount = likeCount;
		this.type = type;
		this.comments = comments;
	}
	
	
	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<CommentDto> getComments() {
		return comments;
	}

	public void setComments(List<CommentDto> comments) {
		this.comments = comments;
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
