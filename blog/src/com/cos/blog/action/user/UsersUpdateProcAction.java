package com.cos.blog.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.Users;
import com.cos.blog.repository.UsersRepository;
import com.cos.blog.util.SHA256;
import com.cos.blog.util.Script;

public class UsersUpdateProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return;
		}
		
		// 0. 유효성검사 
		if (request.getParameter("id") == null ||
				request.getParameter("id").equals("") ||
				request.getParameter("password") == null ||
				request.getParameter("password").equals("") ||
				request.getParameter("email") == null ||
				request.getParameter("email").equals("") ||
				request.getParameter("address") == null ||
				request.getParameter("address").equals("")
				) {
			Script.back("입력되지 않은 필드가 있습니다.", response);
			return;
		}
		
		// 1. 파라메터 받기 (x-www-form-urlencoded 라는 MIME 타입 key = value)
		int id = Integer.parseInt(request.getParameter("id"));
		String rawPassword = request.getParameter("password");
		String password = SHA256.encodeSha256(rawPassword);
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		// 2. User 오브젝트 변환
		Users user = Users.builder()
				.id(id)
				.password(password)
				.email(email)
				.address(address)
				.build();
		
		// 3. DB 연결 - UsersRepository 의 update() 호출
		UsersRepository usersRepository = UsersRepository.getInstance();
		int result = usersRepository.update(user);
		
		// 4. update가 성공적으로 이루어지면 세션을 재등록한다.
		if (result == 1) {
			Users principal = usersRepository.findById(id);
			System.out.println("UsersUpdateProc : username : " + principal.getUsername());
			session.setAttribute("principal", principal);
			
			Script.href("회원수정 성공","/blog/index.jsp" , response);
		} else {
			Script.back("회원수정 실패.", response);
		}
		
	}
}
