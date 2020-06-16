package com.milktea.vollyball.action.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.milktea.vollyball.action.Action;
import com.milktea.vollyball.model.Vollyball;
import com.milktea.vollyball.repository.VollyballRepository;


public class GoNameAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// repository 가져옴
		VollyballRepository vollyballRepository = VollyballRepository.getinstance();
		
		// 배열리스트에 저장
		String name = request.getParameter("name");
		List<Vollyball> names = vollyballRepository.goName(name);
		
		// 배열 데이터화 (GSON)
		Gson gson = new Gson();
		String productJson = gson.toJson(names);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(productJson);
		
	}

}
