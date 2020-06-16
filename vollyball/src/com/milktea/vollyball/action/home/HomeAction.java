package com.milktea.vollyball.action.home;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.milktea.vollyball.action.Action;
import com.milktea.vollyball.model.Vollyball;
import com.milktea.vollyball.repository.VollyballRepository;

public class HomeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB 연결해서 목록 가져오기
		VollyballRepository vollyballRepository = VollyballRepository.getinstance();
		
		List<Vollyball> teamList = vollyballRepository.teamList();
		
		request.setAttribute("teams", teamList);
		
		RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
		dis.forward(request, response);
		
		
	}
	
}
