package com.command;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardDTO;
import com.service.BoardService;

public class BoardSearchCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String searchName=request.getParameter("searchName");
		String searchValue=request.getParameter("searchValue");
		System.out.println(searchName);
		System.out.println(searchValue);
		BoardDTO dto = new BoardDTO();
		if(searchName.equals("title")) {
			dto.setTitle(searchValue);
			
		}else if(searchName.equals("author")) {
			dto.setAuthor(searchValue);
		}
		BoardService service = new BoardService();
		List<BoardDTO> list = service.boardSearch(dto);
		request.setAttribute("list", list);
	}

}
