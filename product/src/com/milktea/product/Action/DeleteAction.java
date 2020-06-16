package com.milktea.product.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.milktea.product.model.Product;
import com.milktea.product.repository.ProductRepository;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("id") == null ||
				request.getParameter("id").equals("")){
			return;
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		ProductRepository productRepository = ProductRepository.getInstance();
		int result = productRepository.Delete(id);
		System.out.println(result);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result+"");
		
//		List<Product> products = productRepository.All();
		
		// 배열 데이터화 (GSON)
//		Gson gson = new Gson();
//		String productJson = gson.toJson(products);
//		
//		response.setCharacterEncoding("UTF-8");
//		out = response.getWriter();
//		out.print(productJson);
		
		
		
	}

}
