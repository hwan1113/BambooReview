package review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.Review;
import review.model.vo.ReviewComment;

/**
 * Servlet implementation class ReviewViewServlet
 */
@WebServlet("/review/reviewView")
public class ReviewViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파리미터 글번호
		int reviewNo  = Integer.parseInt(request.getParameter("reviewNo"));
		String hotelName = request.getParameter("hotelName");
		String hotelId = request.getParameter("hotelId");
		String srchWord = request.getParameter("srchWord");
		
		//2.비지니스로직 호출
		ReviewService reviewService = new ReviewService();
		
		//사용자 읽음여부 쿠키검사
		Cookie[] cookies = request.getCookies();
		boolean hasRead = false;
		String reviewCookieVal = "";
		if(cookies != null) {
			for(Cookie c: cookies) {
				String name = c.getName();
				String value = c.getValue();
				
				if("reviewCookie".equals(name)) {
					reviewCookieVal = value;
					
					if(value.contains("|"+reviewNo+"|")) {
						hasRead = true;
						break;
					}
				}
			}
		}
		
		//쿠키에 읽은 값이 없는 경우
		if(!hasRead) {
			reviewService.increaseReadCount(reviewNo);
			
			//쿠키생성
			Cookie reviewCookie = new Cookie("reviewCookie", reviewCookieVal+"|"+reviewNo+"|");
			reviewCookie.setPath(request.getContextPath()+"/review/reviewView");
//					reviewCookie.setMaxAge();//생략시 영속하게됨.
			
			//응답객체 cookie 전송
			response.addCookie(reviewCookie);
		}
		
		
		
		//게시글 하나 가져오기
		Review review = reviewService.selectOne(reviewNo);
		
		//댓글목록가져오기
		List<ReviewComment> commentList = reviewService.selectReviewComment(reviewNo);
		
		String view = "/WEB-INF/views/review/reviewView.jsp";
		
		request.setAttribute("srchWord", srchWord);
		request.setAttribute("review", review);
		request.setAttribute("commentList", commentList);
		
		//게시글 가져오기에 실패한경우
		if(review == null){
			request.setAttribute("msg", "조회한 게시글이 존재하지 않습니다.");
			request.setAttribute("loc", "/review/reviewList");
			view = "/WEB-INF/views/common/msg.jsp";
		}
		
		
		
		//3.view단 처리위임
		request.setAttribute("hotelId", hotelId);
		request.setAttribute("hotelName", hotelName);
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
