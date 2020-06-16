<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<br/>
		<h2>Vollyball</h2>
		<br />
		<div class="row">
			<br />
			<div class="col-md-3">
				<table class="table ">
					<thead class="thead-dark">
						<tr>
							<th>팀목록</th>
						</tr>
					</thead>
					<tbody id="vollyball__team">
					<c:forEach var="vollyball" items="${teams}">
						<tr>
							<td onclick="goName('${vollyball.team}')" style="cursor: pointer;">${vollyball.team}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-md-3">
				<table class="table ">
					<thead class="thead-dark">
						<tr>
							<th>선수목록</th>
						</tr>
					</thead>
					<tbody id="vollyball__name">
						<tr>
							<td onclick="goDetail('${vollyball.name}','${vollyball.team}')" style="cursor: pointer;">${vollyball.name}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-md-6">
				<table class="table ">
					<thead class="thead-dark">
						<tr>
							<th>번호</th>
							<th>이름</th>
							<th>포지션</th>
						</tr>
					</thead>
					<tbody id="vollyball__detail">
						<tr>
							<td>${vollyball.id}</td>
							<td>${vollyball.name}</td>
							<td>${vollyball.position}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<script src="/vollyball/js/home.js"></script>
</body>
</html>