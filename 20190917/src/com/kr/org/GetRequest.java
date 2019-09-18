package com.kr.org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetRequest")
public class GetRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetRequest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		String name =request.getParameter("name");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("이 요청은 doPost에서 처리되었습니다.");
		out.println("name = ["+name+"]");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
