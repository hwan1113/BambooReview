package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class ReviewUpdateServlet
 */
@WebServlet("/review/reviewUpdate")
public class ReviewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라미터
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		String hotelName = request.getParameter("hotelName");
		String srchWord = request.getParameter("srchWord");
		
		//2. 업무로직
		Review r = new ReviewService().selectOne(reviewNo);
		
		//3. view단처리
		request.setAttribute("srchWord", srchWord);
		request.setAttribute("review", r);
		request.setAttribute("hotelName", hotelName);
		request.getRequestDispatcher("/WEB-INF/views/review/reviewUpdate.jsp")
			   .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
