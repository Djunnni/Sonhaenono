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
import com.sonhaenono.board.model.CommentDto;
import com.sonhaenono.board.service.BoardService;
import com.sonhaenono.exception.ApiException;
import com.sonhaenono.exception.ExceptionEnum;
import com.sonhaenono.util.SecurityUtil;


@RestController
@RequestMapping("/api/qna")
public class QnaRestController {

	private static final Logger logger = LoggerFactory.getLogger(QnaRestController.class);
	
	@Autowired
	private BoardService boardService;

	@PostMapping
	public ResponseEntity<?> writeQna(@RequestBody @Valid BoardDto board) throws Exception {
		String memberId = SecurityUtil.getCurrentUserId().get();
		boardService.writeQna(memberId, board);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<?> getQnas() throws Exception {
		List<BoardDto> notices = boardService.getQnas();
		return new ResponseEntity<List<BoardDto>>(notices, HttpStatus.OK);
	}
	@GetMapping("/{qnaNo}")
	public ResponseEntity<?> getNotice(@PathVariable(name="qnaNo", required = true) int no) throws Exception {
		BoardDto qna = boardService.getQna(no);
		if(qna == null) {
			throw new ApiException(ExceptionEnum.BOARD_NOT_EXIST_EXCEPTION);
		}
		return new ResponseEntity<BoardDto>(qna, HttpStatus.OK);
	}
	
	@PostMapping("/{qnaNo}/like")
	public ResponseEntity<?> ArticleLike(@PathVariable(name="qnaNo", required = true) int no) throws Exception {
		String memberId = SecurityUtil.getCurrentUserId().get();
		//int like = BoardService.ArticleLike(no);
		throw new ApiException(ExceptionEnum.API_NEW_FUNCTION_WAIT_REQUEST);
	}
	
	@PostMapping("/{qnaNo}/unlike")
	public ResponseEntity<?> articleUnlike(@PathVariable(name="qnaNo", required = true) int no) throws Exception {
		String memberId = SecurityUtil.getCurrentUserId().get();
		//int like = BoardService.plusArticleLike(no);
		throw new ApiException(ExceptionEnum.API_NEW_FUNCTION_WAIT_REQUEST);
	}
	
	@PostMapping("/{qnaNo}/comment")
	public ResponseEntity<?> addComment(@PathVariable(name="qnaNo") int boardNo, @RequestBody CommentDto comment) throws Exception {
		String memberId = SecurityUtil.getCurrentUserId().get();
		
		CommentDto savedComment = boardService.addComment(boardNo, memberId, comment);
		
		return new ResponseEntity<CommentDto>(savedComment, HttpStatus.OK);

	}
	
	@PutMapping("/{qnaNo}")
	public ResponseEntity<?> updateArticle(@PathVariable(name="qnaNo", required = true) int no, @RequestBody BoardDto board) throws Exception {
		String memberId = SecurityUtil.getCurrentUserId().get();
		if(!boardService.isArticleOwner(no, memberId)) {
			throw new ApiException(ExceptionEnum.ACCESS_DENIED_EXCEPTION);
		}
		boardService.updateQna(no, memberId, board);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);	
	}
	@DeleteMapping("/{qnaNo}")
	public ResponseEntity<?> deleteArticle(@PathVariable(name="qnaNo", required = true) int no) throws Exception {
		String memberId = SecurityUtil.getCurrentUserId().get();
		if(!boardService.isArticleOwner(no, memberId)) {
			throw new ApiException(ExceptionEnum.ACCESS_DENIED_EXCEPTION);
		}
		
		if(boardService.existArticle(no)) {
			boardService.deleteQna(no);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		throw new ApiException(ExceptionEnum.BOARD_NOT_EXIST_EXCEPTION);
	}
}
