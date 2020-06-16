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

public class GoCountAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// repository 가져옴
		ProductRepository productRepository = ProductRepository.getInstance();
		
		// 배열리스트에 저장
		List<Product> products = productRepository.Count();
		
		// 배열 데이터화 (GSON)
		Gson gson = new Gson();
		String productJson = gson.toJson(products);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(productJson);

	}

}
