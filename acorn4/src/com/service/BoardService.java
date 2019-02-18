package com.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.configuration.MySqlSesstionFactory;
import com.dao.BoardDAO;
import com.dto.BoardDTO;

public class BoardService {
	
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

}
