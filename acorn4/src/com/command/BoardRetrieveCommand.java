package com.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardDTO;
import com.service.BoardService;

public class BoardRetrieveCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String num=request.getParameter("num");
		
		BoardDTO dto = new BoardDTO();
		BoardService service = new BoardService();
		dto=service.boardRetrieve(num);
		
		request.setAttribute("retrieve", dto);
	}

}
