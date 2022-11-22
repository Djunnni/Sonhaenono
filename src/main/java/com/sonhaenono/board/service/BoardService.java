package com.sonhaenono.board.service;

import java.util.List;

import com.sonhaenono.board.model.BoardDto;
import com.sonhaenono.board.model.CommentDto;

public interface BoardService {
	/**
	 * 게시글을 작성합니다.
	 * @param board
	 * @return
	 * @throws Exception
	 */
	void writeArticle(String memberId, BoardDto board) throws Exception;
	void writeArticle(String memberId, String type, BoardDto board) throws Exception;
	void writeNotice(String memberId, BoardDto board) throws Exception;
	void writeQna(String memberId, BoardDto board) throws Exception;
	/**
	 * 게시글 리스트를 조회합니다.
	 * @return
	 * @throws Exception
	 */
	List<BoardDto> getArticles() throws Exception;
	List<BoardDto> getArticles(String type) throws Exception;
	List<BoardDto> getNotices() throws Exception;
	List<BoardDto> getQnas() throws Exception;
	/**
	 * NO에 맞는 게시글을 반환합니다.
	 * @param no
	 * @return
	 */
	BoardDto getArticle(int no) throws Exception;
	BoardDto getArticle(String type, int no) throws Exception;
	BoardDto getNotice(int no) throws Exception;
	BoardDto getQna(int no) throws Exception;
	/**
	 * NO에 맞는 게시글을 삭제합니다.
	 * @param no
	 */
	void deleteArticle(int no) throws Exception;
	void deleteArticle(int no, String type) throws Exception;
	void deleteNotice(int no) throws Exception;
	void deleteQna(int no) throws Exception;
	/**
	 * NO에 맞는 게시글이 존재하는지 확인합니다.
	 * @param no
	 * @return
	 * @throws Exception
	 */
	boolean existArticle(int no) throws Exception;
	/**
	 * NO번 게시글을 업데이트 합니다.
	 * @param no
	 * @param board
	 * @return
	 */
	void updateArticle(int no, String memberId, BoardDto board) throws Exception;
	void updateArticle(int no, String memberId, String type, BoardDto board) throws Exception;
	void updateNotice(int no, String memberId, BoardDto board) throws Exception;
	void updateQna(int no, String memberId, BoardDto board) throws Exception;
	
	CommentDto addComment(int boardNo, String memberId, CommentDto comment) throws Exception;
	boolean isArticleOwner(int no, String memberId) throws Exception;

}
