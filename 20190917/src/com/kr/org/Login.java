package com.kr.org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		String ID = request.getParameter("ID");
		String PWD = request.getParameter("Password");
		
		PrintWriter out = response.getWriter();
		if(ID.equals("admin") && PWD.contentEquals("1234")) {
			out.println("로그인을 환영합니다.");
		}else {
			out.println("아이디나 비밀번호가 일치하지 않습니다.");
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
