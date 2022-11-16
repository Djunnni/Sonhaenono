package com.sonhaenono.board.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

public class CommentDto {
	private int no;
	@NotNull
	private String memberId;
	private int boardNo;
	private LocalDateTime replyAt;
	@NotNull
	private String content;
	
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
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public LocalDateTime getReplyAt() {
		return replyAt;
	}
	public void setReplyAt(LocalDateTime replyAt) {
		this.replyAt = replyAt;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "CommentDto [no=" + no + ", memberId=" + memberId + ", boardNo=" + boardNo + ", replyAt=" + replyAt
				+ ", content=" + content + "]";
	}
	public CommentDto() {}
	public CommentDto(int no, String memberId, int boardNo, LocalDateTime replyAt, String content) {
		this.no = no;
		this.memberId = memberId;
		this.boardNo = boardNo;
		this.replyAt = replyAt;
		this.content = content;
	}
	
	
	
}
