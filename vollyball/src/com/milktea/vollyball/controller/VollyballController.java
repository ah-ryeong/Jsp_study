package com.milktea.vollyball.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.milktea.vollyball.action.Action;
import com.milktea.vollyball.action.home.GoDetailAction;
import com.milktea.vollyball.action.home.GoNameAction;
import com.milktea.vollyball.action.home.HomeAction;

@WebServlet("/home")
public class VollyballController extends HttpServlet {
	private final static String TAG = "VollyballController : ";
	private static final long serialVersionUID = 1L;
	
	public VollyballController() {
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
		if(cmd.equals("home")) {
			return new HomeAction();
		} else if (cmd.equals("goName")) {
			return new GoNameAction();
		} else if (cmd.equals("goDetail")) {
			return new GoDetailAction();
		}
		return null;
	}
	
} // end of VollyballController
