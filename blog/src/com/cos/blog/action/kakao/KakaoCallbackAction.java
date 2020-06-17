package com.cos.blog.action.kakao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.util.Script;

public class KakaoCallbackAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String grant_type = "authorization_code";
		String client_id = "a7de29728d6904ac047cdbfe126c773a";
		String redirect_uri = "http://localhost:8000/blog/oauth/login/kakao?cmd=callback";
		
		// post요청, x-www-form-urlencoded
		
		// Buffered 읽어서
		
		// Gson 으로 파싱
	}

	
	
}
