package com.score;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class highScoreServlet
 */
@WebServlet("/highScoreServlet")
public class highScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uidStr = request.getParameter("huid");
		int huid = Integer.parseInt(uidStr);
		
		try {
			List<highScore> scoreDetails = scoreDBUtil.findScore(huid);
			request.setAttribute("scoreDetails", scoreDetails);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher dispatch = request.getRequestDispatcher("highScorePage.jsp");
		dispatch.forward(request, response);
		

	}
}
