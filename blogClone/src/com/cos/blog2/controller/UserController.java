package com.cos.blog2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog2.action.Action;

@WebServlet("/user")
public class UserController extends HttpServlet{
	
	private final static String TAG = "UserController : ";
	
	private static final long serialVersionUID = 1L;
	
	public UserController() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println(TAG + "router() : " + cmd);
		
//		Action action router(cmd);
//		action.execute(request, response);
	}
	
	private Action router(String cmd) {
		
		return null;
	}
}
