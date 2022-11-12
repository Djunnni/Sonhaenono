package com.sonhaenono.board.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sonhaenono.board.mapper.BoardMapper;
import com.sonhaenono.board.model.BoardDto;
import com.sonhaenono.exception.ApiException;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public void writeArticle(BoardDto board) throws Exception {
		// TODO: board 타입 검증하기
		
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
	public void updateArticle(int no, BoardDto board) throws Exception {
		// TODO: 유저 검증(업데이트 권한을 가진 사람인지)
		// TODO: 타입 검증(게시글의 타입을 확인합니다.)
		
		boardMapper.updateArticle(board);
	}

}
