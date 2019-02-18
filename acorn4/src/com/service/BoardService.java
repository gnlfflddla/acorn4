package com.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.configuration.MySqlSesstionFactory;
import com.dao.BoardDAO;
import com.dto.BoardDTO;

public class BoardService {
	
	public BoardDTO boardRetrieve(String _num) {
		SqlSession session = MySqlSesstionFactory.getSesstion();
		BoardDTO dto = new BoardDTO();
		try {
			BoardDAO dao = new BoardDAO();
			dto = dao.boardRetrieve(session,_num);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return dto;
	}
	public List<BoardDTO> boardList() {
		SqlSession session = MySqlSesstionFactory.getSesstion();
		List<BoardDTO> list = new ArrayList<>();
		try {
			BoardDAO dao = new BoardDAO();
			list = dao.boardList(session);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return list;
	}
	public int boardWrite(BoardDTO dto) {
		SqlSession session = MySqlSesstionFactory.getSesstion();
		int result=0;
		try {
			BoardDAO dao = new BoardDAO();
			result = dao.boardWrite(session,dto);
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return result;
	}
	

}
