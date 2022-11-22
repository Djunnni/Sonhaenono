package com.sonhaenono.board.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@Transactional
	public BoardDto getArticle(int no) throws Exception {
		boardMapper.updateHit(no);
		BoardDto board = boardMapper.getArticle(no);
		List<CommentDto> comments = boardMapper.getComments(no);
		board.setComments(comments);
		return board;
	}
	@Override
	public BoardDto getArticle(String type, int no) throws Exception {
		boardMapper.updateHit(no);
		
		Map<String, String> query = new HashMap<>();
		query.put("no", String.valueOf(no));
		query.put("type", type);
		
		BoardDto board = boardMapper.getArticleByType(query);
		if(board == null) {
			return null;
		}
		List<CommentDto> comments = boardMapper.getComments(no);
		board.setComments(comments);
		
		return board;
	}

	@Override
	public BoardDto getNotice(int no) throws Exception {
		return getArticle("NOTICE", no);
	}

	@Override
	public BoardDto getQna(int no) throws Exception {
		return getArticle("QNA", no);
	}
	@Override
	public void deleteArticle(int no) throws Exception {	
		boardMapper.deleteArticle(no);
	}

	@Override
	public void deleteArticle(int no, String type) throws Exception {
		Map<String, String> query = new HashMap<>();
		query.put("no", String.valueOf(no));
		query.put("type", type);
		boardMapper.deleteArticleByType(query);
		
	}
	@Override
	public void deleteNotice(int no) throws Exception {
		deleteArticle(no, "NOTICE");
	}
	@Override
	public void deleteQna(int no) throws Exception {
		deleteArticle(no, "QNA");
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
	public void updateArticle(int no, String memberId, String type, BoardDto board) throws Exception {
		board.setType(type);
		updateArticle(no, memberId, board);
		
	}
	@Override
	public void updateNotice(int no, String memberId, BoardDto board) throws Exception {
		updateArticle(no, memberId, "NOTICE", board);
	}
	@Override
	public void updateQna(int no, String memberId, BoardDto board) throws Exception {
		updateArticle(no, memberId, "QNA", board);
	}
	@Override
	public CommentDto addComment(int boardNo, String memberId, CommentDto comment) throws Exception {
		comment.setBoardNo(boardNo);
		comment.setMemberId(memberId);
		comment.setReplyAt(LocalDateTime.now());
		boardMapper.insertComment(comment);
		
		return comment;
	}

	@Override
	public boolean isArticleOwner(int no, String memberId) throws Exception {
		BoardDto board = new BoardDto();
		board.setNo(no);
		board.setMemberId(memberId);
		return boardMapper.isArticleOwner(board);
	}
	
	@Override
	public void writeArticle(String memberId, BoardDto board) throws Exception {
		board.setMemberId(memberId);
		boardMapper.writeArticle(board);
	}

	@Override
	public void writeArticle(String memberId, String type, BoardDto board) throws Exception {
		board.setType(type);
		writeArticle(memberId, board);
	}

	@Override
	public void writeNotice(String memberId, BoardDto board) throws Exception {
		writeArticle(memberId, "NOTICE", board);
	}

	@Override
	public void writeQna(String memberId, BoardDto board) throws Exception {
		writeArticle(memberId, "QNA", board);
	}

	@Override
	public List<BoardDto> getArticles() throws Exception {
		return boardMapper.getArticles();
	}

	@Override
	public List<BoardDto> getArticles(String type) throws Exception {
		return boardMapper.getArticlesByType(type);
	}

	@Override
	public List<BoardDto> getNotices() throws Exception {
		return getArticles("NOTICE");
	}

	@Override
	public List<BoardDto> getQnas() throws Exception {
		return getArticles("QNA");
	}
}
