package com.sonhaenono.board.controller;

import java.util.List;

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
import com.sonhaenono.board.service.BoardService;
import com.sonhaenono.exception.ApiException;
import com.sonhaenono.exception.ExceptionEnum;


@RestController
@RequestMapping("/api/board")
public class BoardRestController {

	private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping
	public ResponseEntity<?> writeArticle(@RequestBody @Valid BoardDto board) throws Exception {
		// TODO: member 정보를 가져와서 board에 넣어주기
		boardService.writeArticle(board);
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
	@PutMapping("/{no}")
	public ResponseEntity<?> updateArticle(@PathVariable(name="no", required = true) int no, @RequestBody BoardDto board) throws Exception {
		boardService.updateArticle(no, board);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);	
	}
	@DeleteMapping("/{no}")
	public ResponseEntity<?> deleteArticle(@PathVariable(name="no", required = true) int no) throws Exception {
		// TODO: 권한이 있는 사용자인지 체크 필요
		if(boardService.existArticle(no)) {
			boardService.deleteArticle(no);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		throw new ApiException(ExceptionEnum.BOARD_NOT_EXIST_EXCEPTION);
	}
}
