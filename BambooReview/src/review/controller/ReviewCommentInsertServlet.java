package review.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.ReviewComment;

/**
 * Servlet implementation class reviewCommentInsertServlet
 */
@WebServlet("/review/reviewCommentInsert")
public class ReviewCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라미터핸들링
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int customerNo = Integer.parseInt(request.getParameter("customerNo"));
		String commentContent = request.getParameter("commentContent");
		String hotelName = request.getParameter("hotelName");
		String hotelId = request.getParameter("hotelId");
		
		ReviewComment rc = new ReviewComment(0, customerNo, reviewNo, null, commentContent);
		
		//2.업무로직
		int result = new ReviewService().insertReviewComment(rc);
		
		//3.view단처리
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/review/reviewView?reviewNo="+reviewNo+"&hotelName="+hotelName+"&hotelId="+hotelId;
		if(result>0) {
			msg = "댓글 등록 성공!";
		}
		else {
			msg = "댓글 등록 실패!";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
