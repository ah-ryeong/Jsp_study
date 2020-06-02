package com.cos.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.action.user.UsersJoinAction;
import com.cos.blog.action.user.UsersJoinProcAction;
import com.cos.blog.action.user.UsersLoginAction;
import com.cos.blog.action.user.UsersLoginProcAction;
import com.cos.blog.action.user.UsersLogoutAction;

// http ://localhost:8000/blog/user
@WebServlet("/user")
public class UsersController extends HttpServlet {
	
	private final static String TAG = "UsersController : ";
	private static final long serialVersionUID = 1L;

	public UsersController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// http://localhost:8000/blog/user?cmd=join
		String cmd = request.getParameter("cmd");
		System.out.println(TAG + "doProcess : " + cmd);
		
		Action action = router(cmd);
		action.execute(request, response);
	}
	
	public Action router(String cmd) {
		if(cmd.equals("join")) {
			// 회원가입페이지로 이동한다.
			return new UsersJoinAction();
			
		} else if(cmd.equals("joinProc")) {
			// 회원가입을 진행 한 후 -> index.jsp로 이동 
			return new UsersJoinProcAction();
			
		} else if (cmd.equals("update")) {
			// 회원수정페이지로 이동(세션에 User 오브젝트를 가지고 있을 예정)
			
		} else if (cmd.equals("updateProc")) {
			// 회원수정을 진행한 후 -> index.jsp로 이동 
			
		} else if (cmd.equals("delete")) {
			// 회원 삭제를 진행한 후 -> 로그아웃을 하고 -> index.jsp로 이동 
			
		} else if (cmd.equals("login")) {
			// 회원 로그인 페이지로 이동 
			return new UsersLoginAction();
			
		} else if (cmd.equals("loginProc")) {
			// 회원 로그인 수행 후 -> 세션에 등록 -> index.jsp로 이동 
			return new UsersLoginProcAction();
		} else if (cmd.equals("logout")) {
			// 로그아웃
			return new UsersLogoutAction();
		}
		return null;
	}
}
