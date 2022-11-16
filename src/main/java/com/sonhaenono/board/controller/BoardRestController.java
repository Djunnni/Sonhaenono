package com.sonhaenono.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonhaenono.board.model.BoardDto;
import com.sonhaenono.board.model.CommentDto;
import com.sonhaenono.board.service.BoardService;
import com.sonhaenono.exception.ApiException;
import com.sonhaenono.exception.ExceptionEnum;
import com.sonhaenono.util.SecurityUtil;


@RestController
@RequestMapping("/api/board")
public class BoardRestController {

	private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping
	public ResponseEntity<?> writeArticle(@RequestBody @Valid BoardDto board) throws Exception {
		String memberId = SecurityUtil.getCurrentUserId().get();
		boardService.writeArticle(memberId, board);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<?> getArticles() throws Exception {
		List<BoardDto> articles = boardService.getArticles();
		return new ResponseEntity<List<BoardDto>>(articles, HttpStatus.OK);
	}
	@GetMapping("/{no}")
	public ResponseEntity<?> getArticle(@PathVariable(name="no", required = true) int no) throws Exception {
		BoardDto article = boardService.getArticle(no);
		if(article == null) {
			throw new ApiException(ExceptionEnum.BOARD_NOT_EXIST_EXCEPTION);
		}
		return new ResponseEntity<BoardDto>(article, HttpStatus.OK);
	}
	
	@PostMapping("/{no}/like")
	public ResponseEntity<?> ArticleLike(@PathVariable(name="no", required = true) int no) throws Exception {
		String memberId = SecurityUtil.getCurrentUserId().get();
		//int like = BoardService.ArticleLike(no);
		throw new ApiException(ExceptionEnum.API_NEW_FUNCTION_WAIT_REQUEST);
	}
	
	@PostMapping("/{no}/unlike")
	public ResponseEntity<?> articleUnlike(@PathVariable(name="no", required = true) int no) throws Exception {
		String memberId = SecurityUtil.getCurrentUserId().get();
		//int like = BoardService.plusArticleLike(no);
		throw new ApiException(ExceptionEnum.API_NEW_FUNCTION_WAIT_REQUEST);
	}
	
	@PostMapping("/{boardNo}/comment")
	public ResponseEntity<?> addComment(@PathVariable(name="boardNo") int boardNo, @RequestBody CommentDto comment) throws Exception {
		String memberId = SecurityUtil.getCurrentUserId().get();
		
		CommentDto savedComment = boardService.addComment(boardNo, memberId, comment);
		
		Map<String, Object> map = new HashMap<>();
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

	}
	
	@PutMapping("/{no}")
	public ResponseEntity<?> updateArticle(@PathVariable(name="no", required = true) int no, @RequestBody BoardDto board) throws Exception {
		String memberId = SecurityUtil.getCurrentUserId().get();
		if(!boardService.isArticleOwner(no, memberId)) {
			throw new ApiException(ExceptionEnum.ACCESS_DENIED_EXCEPTION);
		}
		boardService.updateArticle(no, memberId, board);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);	
	}
	@DeleteMapping("/{no}")
	public ResponseEntity<?> deleteArticle(@PathVariable(name="no", required = true) int no) throws Exception {
		String memberId = SecurityUtil.getCurrentUserId().get();
		if(!boardService.isArticleOwner(no, memberId)) {
			throw new ApiException(ExceptionEnum.ACCESS_DENIED_EXCEPTION);
		}
		
		if(boardService.existArticle(no)) {
			boardService.deleteArticle(no);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		throw new ApiException(ExceptionEnum.BOARD_NOT_EXIST_EXCEPTION);
	}
}
