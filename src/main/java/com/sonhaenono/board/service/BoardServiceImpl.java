package com.sonhaenono.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sonhaenono.board.mapper.BoardMapper;
import com.sonhaenono.board.model.BoardDto;
import com.sonhaenono.board.model.CommentDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public void writeArticle(String memberId, BoardDto board) throws Exception {
		board.setMemberId(memberId);
		boardMapper.writeArticle(board);
	}

	@Override
	public List<BoardDto> getArticles() throws Exception {
		return boardMapper.getArticles();
	}

	@Override
	@Transactional
	public BoardDto getArticle(int no) throws Exception {
		boardMapper.updateHit(no);
		return boardMapper.getArticle(no);
	}

	@Override
	public void deleteArticle(int no) throws Exception {	
		boardMapper.deleteArticle(no);
	}

	@Override
	public boolean existArticle(int no) throws Exception {
		return boardMapper.existArticle(no) > 0;
	}

	@Override
	@Transactional
	public void updateArticle(int no, String memberId, BoardDto board) throws Exception {
		board.setNo(no);
		board.setMemberId(memberId);
		boardMapper.updateArticle(board);
	}

	@Override
	public CommentDto addComment(int boardNo, String memberId, CommentDto comment) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isArticleOwner(int no, String memberId) throws Exception {
		BoardDto board = new BoardDto();
		board.setNo(no);
		board.setMemberId(memberId);
		return boardMapper.isArticleOwner(board);
	}
}
