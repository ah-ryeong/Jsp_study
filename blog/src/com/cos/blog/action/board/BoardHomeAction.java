package com.cos.blog.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.model.Board;
import com.cos.blog.repository.BoardRepository;

public class BoardHomeAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		
		// 1. DB 연결해서 Board 목록 다 불러와서
		BoardRepository boardRepository = BoardRepository.getInstance();
		
		// 2. 3건만 페이징해서 가져오기
		List<Board> boards = boardRepository.findAll(page);
		
		// 본문 짧게 가공하기
		for (Board board : boards) {
			String preview = board.getContent();
			preview = preview.substring(0, 5)+"...";
			board.setContent(preview);
		}
		
		// 마지막 페이지 확인 로직 
		int count = boardRepository.count();
		int lastPage = (count-1)/3;
		
		request.setAttribute("lastPage", lastPage);
		
		request.setAttribute("boards", boards);
		
		
		
		RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
		dis.forward(request, response);
	}
}
