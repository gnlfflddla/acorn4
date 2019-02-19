package com.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardDTO;
import com.service.BoardService;

public class BoardReplyUICommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String num=request.getParameter("num");
		BoardDTO dto = new BoardDTO();
		BoardService service = new BoardService();
		dto=service.boardReplyUI(num);
		request.setAttribute("replyui", dto);
	}

}
