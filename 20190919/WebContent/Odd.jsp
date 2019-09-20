<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<h2>1~10가지 홀수 짝수 여부 출력</h2>

<%for(int i=0; i<11; i++){%>
<tr>
<td><%=i%></td>

<td><%if(i%2==0){
		out.println("짝수입니다.");
		}else{
			out.println("홀수입니다.");
			}%></td>

</tr>
<%}%>

</table>
</body>
</html>



