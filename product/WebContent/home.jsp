<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.milktea.product.model.Product" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
	<div class="container">
		<br />
		<h2>Version 1</h2>
		<br />
		<button onclick="goFirst()" type="button" class="btn btn-dark">처음으로</button>
		<button onclick="goPrice()" type="button" class="btn btn-dark">가격순</button>
		<button onclick="goCount()" type="button" class="btn btn-dark">판매순</button>
		<br />
		<br />
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>종류</th>
					<th>가격</th>
					<th>판매순</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody id="product__list">
				<tr id="product__${product.id}">
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.type}</td>
					<td>${product.price}</td>
					<td>${product.count}</td>
				</tr>
			</tbody>
	</div>
	
<script src="/product/js/home.js"></script>
</body>
</html>
