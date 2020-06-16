package com.milktea.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.milktea.product.Action.Action;
import com.milktea.product.Action.DeleteAction;
import com.milktea.product.Action.GoCountAction;
import com.milktea.product.Action.GoFirstAction;
import com.milktea.product.Action.GoPriceAction;

@WebServlet("/Products")
public class ProductController extends HttpServlet {
	
	private final static String TAG = "ProductController : ";
	private static final long serialVersionUID = 1L;
	
	public ProductController() {
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
		if(cmd.equals("goFirst")) {
			return new GoFirstAction();
		} else if(cmd.equals("goPrice")) {
			return new GoPriceAction();
		} else if(cmd.equals("goCount")) {
			return new GoCountAction();
		} else if(cmd.equals("Delete")) {
			return new DeleteAction();
		}
		return null;
	}
	
} // end of ProductController
