package com.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;

public class BoardDAO {
	
	public List<BoardDTO> boardList(SqlSession session) {
		// TODO Auto-generated method stub
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		list = session.selectList("BoardMapper.boardlist");
		
		return list;
	}
	
}
