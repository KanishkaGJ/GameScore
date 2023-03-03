package com.score;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class scoreInsertServlet
 */
@WebServlet("/scoreInsertServlet")
public class scoreInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String sid = request.getParameter("sid");
		String uidStr = request.getParameter("uid");
		int uid = Integer.parseInt(uidStr);
		
		String gidStr = request.getParameter("gid");
		int gid = Integer.parseInt(gidStr);
		
		String scoreStr = request.getParameter("score");
		int score = Integer.parseInt(scoreStr);
		
		boolean isTrue; 
		
		
		isTrue = scoreDBUtil.insertScore(uid, gid, score);
		
		if(isTrue == true) {
			
			RequestDispatcher dispatch1 = request.getRequestDispatcher("success.jsp");
			dispatch1.forward(request, response);
			
		}else {
			RequestDispatcher dispatch2 = request.getRequestDispatcher("unSuccess.jsp");
			dispatch2.forward(request, response);
		}
	}

}
