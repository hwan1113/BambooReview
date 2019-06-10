package ads.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.model.service.AdsService;

/**
 * Servlet implementation class adsCommentDeleteServlet
 */
@WebServlet("/ads/adsCommentDelete")
public class AdsCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int adsNo = Integer.parseInt(request.getParameter("adsNo"));
		int adsCommentNo = Integer.parseInt(request.getParameter("del"));

		int result = new AdsService().deleteadsComment(adsCommentNo);
		
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/ads/adsView?adsNo="+adsNo;

		if(result>0)
			msg = "댓글 삭제 성공!";
			
		else 
			msg = "댓글 삭제 실패!";	
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
		reqDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
