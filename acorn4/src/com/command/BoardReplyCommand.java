package com.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardDTO;
import com.service.BoardService;

public class BoardReplyCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String num=request.getParameter("num");
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String content=request.getParameter("content");
		String repRoot=request.getParameter("repRoot");
		String repStep=request.getParameter("repStep");
		String repIndent=request.getParameter("repIndent");
		
		BoardDTO dto = new BoardDTO();
		dto.setNum(Integer.parseInt(num));
		dto.setTitle(title);
		dto.setAuthor(author);
		dto.setContent(content);
		dto.setRepRoot(Integer.parseInt(repRoot));
		dto.setRepStep(Integer.parseInt(repStep));
		dto.setRepIndent(Integer.parseInt(repIndent));
		BoardService service = new BoardService();
		service.boardReply(dto);
	}

}
