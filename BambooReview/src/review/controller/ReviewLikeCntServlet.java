package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import review.model.service.ReviewService;

/**
 * Servlet implementation class ReviewLikeCntServlet
 */
@WebServlet("/BambooReview/review/reviewLikeCnt")
public class ReviewLikeCntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReviewService service = new ReviewService(); 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int customerNo = Integer.parseInt(request.getParameter("customerNo"));  
		
		int result = service.increaseLikeCount(reviewNo, customerNo);
		int likeCnt = service.selectLikeCount(reviewNo); 
		System.out.println("like개수@serv="+ likeCnt); 
		
//		String msg = "";
//		String loc = "/review/reviewView?reviewNo="+reviewNo;
//
//		if(result>0) {
//			msg = "좋아요!";
//			//성공한 경우, result변수에 새로 등록된 글번호를 가져옴.
//		}
//		else {
//			msg = "이미 좋아요 한 글입니다.";
//		}
		
/*		//3.view단 처리
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
			   .forward(request, response);*/
		
		
		JSONObject obj = new JSONObject(); 
		
		obj.put("likeCnt", likeCnt); //request.setAttribute("json", json);
		obj.put("result", result); //request.setAttribute("json", json);
		response.setContentType("application/x-json; charset=UTF-8"); 
		response.getWriter().print(obj);
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
