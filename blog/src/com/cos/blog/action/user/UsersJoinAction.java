package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;

public class UsersJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라메터 받기
		
		// 2. User  오브젝트 변환 
		
		// 3. DB 연결 - UsersRepository 의 save() 호출
		
		// 4. index.jsp 페이지로 이동 
	}
}
