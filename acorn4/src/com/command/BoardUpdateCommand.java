package com.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardDTO;
import com.service.BoardService;

public class BoardUpdateCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String content=request.getParameter("content");
		BoardDTO dto = new BoardDTO();
		dto.setNum(Integer.parseInt(num));
		dto.setTitle(title);
		dto.setAuthor(author);
		dto.setContent(content);
		BoardService service = new BoardService();
		service.boardUpdate(dto);
	}

}
