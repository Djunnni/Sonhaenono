package com.sonhaenono.board.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sonhaenono.board.model.BoardDto;

@Mapper
public interface BoardMapper {
	BoardDto getArticle(int no) throws SQLException;
	List<BoardDto> getArticles() throws SQLException;
	void writeArticle(BoardDto board) throws SQLException;
	void deleteArticle(int no) throws SQLException;
	int existArticle(int no) throws SQLException;
	void updateArticle(BoardDto board) throws SQLException;
}