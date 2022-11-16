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
	/**
	 * 게시글 리스트를 조회합니다.
	 * @return
	 * @throws Exception
	 */
	List<BoardDto> getArticles() throws Exception;
	/**
	 * NO에 맞는 게시글을 반환합니다.
	 * @param no
	 * @return
	 */
	BoardDto getArticle(int no) throws Exception;
	/**
	 * NO에 맞는 게시글을 삭제합니다.
	 * @param no
	 */
	void deleteArticle(int no) throws Exception;
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
	CommentDto addComment(int boardNo, String memberId, CommentDto comment) throws Exception;
	boolean isArticleOwner(int no, String memberId) throws Exception;

}
