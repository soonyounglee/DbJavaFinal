<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int a = 10;
	int b = 3;
	public int add(int a, int b){
		return a + b;
	}
	public int sub(int a, int b){
		return a - b;
	}
	public int mul(int a, int b){
		return a * b;
	}
	public int div(int a, int b){
		return a / b;
	}
	public int namu(int a, int b){
		return a % b;
	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>10,3의 오칙연산 결과</h2>

10 + 3 =<%=add(a,b) %>입니다.<br/>
10 - 3 =<%=sub(a,b) %>입니다.<br/>
10 * 3 =<%=mul(a,b) %>입니다.<br/> 
10 / 3 =<%=div(a,b) %>입니다.<br/> 
10 % 3 =<%=namu(a,b) %>입니다.<br/>

</body>
</html>