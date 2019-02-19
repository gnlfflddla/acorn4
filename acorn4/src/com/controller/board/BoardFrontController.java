package com.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.BoardCommand;
import com.command.BoardDeleteCommand;
import com.command.BoardListCommand;
import com.command.BoardReplyCommand;
import com.command.BoardReplyUICommand;
import com.command.BoardRetrieveCommand;
import com.command.BoardSearchCommand;
import com.command.BoardUpdateCommand;
import com.command.BoardWriteCommand;

@WebServlet("*.do")
public class BoardFrontController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = requestURI.substring(contextPath.length());
		
		BoardCommand command = null;
		String nextPage = null;
		//목록보기
		if(com.equals("/list.do")) {
			command = new BoardListCommand();
			command.execute(request, response);
			nextPage="board/boardList.jsp";		//외부 프레임 만들기 전 테스트용 
		}
		//글쓰기 폼
		if(com.equals("/writeui.do")) {
			nextPage="board/boardWrite.jsp";
		}
		//글쓰기
		if(com.equals("/write.do")) {
			command = new BoardWriteCommand();
			command.execute(request, response);
			nextPage="list.do";
		}
		//글자세히보기
		if(com.equals("/retrieve.do")) {
			command = new BoardRetrieveCommand();
			command.execute(request, response);
			nextPage="board/boardRetrieve.jsp";
		}
		if(com.equals("/update.do")) {
			command = new BoardUpdateCommand();
			command.execute(request, response);
			nextPage="list.do";
		}
		if(com.equals("/delete.do")) {
			command = new BoardDeleteCommand();
			command.execute(request, response);
			nextPage="list.do";
		}
		if(com.equals("/search.do")) {
			command = new BoardSearchCommand();
			command.execute(request, response);
			nextPage="board/boardList.jsp";
		}
		if(com.equals("/replyui.do")) {
			command = new BoardReplyUICommand();
			command.execute(request, response);
			nextPage="board/boardReply.jsp";
		}
		if(com.equals("/reply.do")) {
			command = new BoardReplyCommand();
			command.execute(request, response);
			nextPage="list.do";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
		
	}

}
