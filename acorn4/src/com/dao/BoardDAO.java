package com.dao;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;

public class BoardDAO {
	//글자세히 보기
	public BoardDTO boardRetrieve(SqlSession session,String _num) {
		// TODO Auto-generated method stub
		BoardDTO dto = new BoardDTO();
		dto = session.selectOne("BoardMapper.boardRetrieve",_num);
		readCount(session,_num);
		return dto;
	}
	//조회수 1증가
		public void readCount(SqlSession session,String _num) {
			session.update("BoardMapper.boardCnt", _num);
		}
	//목록 보기
	public List<BoardDTO> boardList(SqlSession session) {
		// TODO Auto-generated method stub
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		list = session.selectList("BoardMapper.boardlist");
		
		return list;
	}
	//글쓰기
	public int boardWrite(SqlSession session,BoardDTO dto) {
		// TODO Auto-generated method stub
		int result = session.insert("BoardMapper.boardWrite", dto);
		
		return result;
	}
	//글 수정하기
	public int boardUpdate(SqlSession session,BoardDTO dto) {
		// TODO Auto-generated method stub
		int result = session.update("BoardMapper.boardUpdate", dto);
		
		return result;
	}
	//글 수정하기
	public int boardDelete(SqlSession session,String _num) {
		// TODO Auto-generated method stub
		int result = session.delete("BoardMapper.boardDelete", _num);
		
		return result;
	}
	//글 검색하기
	public List<BoardDTO> boardSearch(SqlSession session,BoardDTO dto){
		List<BoardDTO> list = new ArrayList<>();
		list = session.selectList("BoardMapper.boardSearch", dto);
		return list;
	}
	//답변글 입력폼 보기
	public BoardDTO boardReplyUI(SqlSession session,String _num){
		BoardDTO dto = new BoardDTO();
		dto = session.selectOne("BoardMapper.boardReplyUI", _num);
		return dto;
	}
	//답변글 의 기존 repStep 1증가
	public void makeReply(SqlSession session,BoardDTO dto) {
		session.update("BoardMapper.makeReply", dto);
	}
	//답변달기
	public void boardReply(SqlSession session,BoardDTO dto) {
		makeReply(session,dto);
		session.insert("BoardMapper.boardReply", dto);
	}
}
