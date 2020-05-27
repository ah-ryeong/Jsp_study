<%@page import="ch04.Users"%>
<%@page import="org.apache.catalina.User"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Driver"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	
	// DB 연결
	final String SQL = "INSERT INTO users(id, username, password, email) VALUES(?, ?, ?, ?)";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "cos", "bitc5600");
	
	// DB에 insert
	PreparedStatement pstmt = conn.prepareStatement(SQL);
	pstmt.setInt(1, 2);
	pstmt.setString(2, username);
	pstmt.setString(3, password);
	pstmt.setString(4, email);
	int result = pstmt.executeUpdate();
	
	// 회원가입 완료 페이지 이동
	if(result ==1 ) {
		Users user = new Users(4, username, password, email);
		request.setAttribute("user", user);
		RequestDispatcher dis = request.getRequestDispatcher("joinComplete.jsp");
		dis.forward(request, response);
		
		// response.sendRedirect("joinComplete.jsp");
	} else {
		response.sendRedirect("joinError.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>