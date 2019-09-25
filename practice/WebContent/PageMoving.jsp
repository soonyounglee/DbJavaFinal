<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>페이지 이동</title>
</head>
<body>
	<h3>페이지 이동 방식을 지정합니다.</h3>
<%
	String move = request.getParameter("move");
	
	if(move == null){
%>
		이동 방식을 GET 방식으로 지정합니다. 파라미터 이름은 "move" 입니다.<br/>
		파라미터의 값은 각각 아래와 같이 지정합니다.<hr/>
		리다이렉트 : "redirect"<br/>
		포워드 : "forward"<br/>
		인클루드 : "include"<hr/>	
	
<% 		}else if(move.equals("redirect")){
			response.sendRedirect("http://localhost:8111/practice/PageMovingRedirect.jsp");
		}else if(move.equals("forward")){
			pageContext.forward("PageMovingForward.jsp");
		}else if(move.equals("include")){
			pageContext.include("PageMovingInclude.jsp");
		}
%>
</body>
</html>