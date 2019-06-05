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
 * Servlet implementation class ReviewUpdateEndServlet
 */
@WebServlet("/review/reviewUpdateEnd")
public class ReviewUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터 핸들링
		String hotelId = request.getParameter("hotelId");
		String reviewTitle = request.getParameter("reviewTitle");
		String reviewWriter = request.getParameter("reviewWriter");
		String reviewContent = request.getParameter("reviewContent");
		
		Review r = new Review();
		r.setHotelId(hotelId);
		r.setReviewTitle(reviewTitle);
		r.setReviewWriter(reviewWriter);
		r.setReviewContent(reviewContent);
		
		System.out.println(r);
		
		//2. 업무로직
		int result = new ReviewService().updateReview(r);
		
		String msg = "";
		String loc = "/review/reviewList";

		if(result>0) {
			msg = "게시글 등록성공!";
			//성공한 경우, result변수에 새로 등록된 글번호를 가져옴.
			loc = "/review/reviewView?reviewNo="+result;
		}
		else {
			msg = "게시글 등록실패!";
		}
		
		//3.view단 처리
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
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
