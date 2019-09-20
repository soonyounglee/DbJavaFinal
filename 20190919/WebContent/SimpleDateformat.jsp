<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date" %>
<%@page import="sun.java2d.pipe.SpanShapeRenderer.Simple"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<h2>날짜/시간 출력</h2>
<body>
<%
 Date today = new Date();
 SimpleDateFormat sss = new SimpleDateFormat("yyyy/MM/dd");
 SimpleDateFormat ss = new SimpleDateFormat("hh/mm/ss");
 out.print("현재 날짜 : "+sss.format(today)+"<br>");
 out.print("현재 시간 : "+ss.format(today));
%>
</body>
</html>