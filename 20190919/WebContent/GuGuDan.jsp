<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>구구단 출력</h2>
<table border="1">
<tr>

<th>2단</th>
<th>3단</th>
<th>4단</th>
<th>5단</th>
<th>6단</th>
<th>7단</th>
<th>8단</th>
<th>9단</th>

</tr>
<%
	for(int y =1; y<10; y++){
		out.write("<tr>");
		for(int x=2; x<10; x++){
			out.write("<td>"+x+"x"+y+"="+x*y+"<br></td>");
		}
		out.write("</tr>");
	}
%>

</table>
</body>
</html>