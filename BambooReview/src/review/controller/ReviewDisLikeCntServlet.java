package review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class ReviewDisLikeCntServlet
 */
@WebServlet("/review/reviewDisLikeCnt")
public class ReviewDisLikeCntServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewService service = new ReviewService();
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int customerNo = Integer.parseInt(request.getParameter("customerNo"));  
		int result = service.increaseDisLikeCount(reviewNo, customerNo);
		Review r = service.selectDisLikeCount(reviewNo); 
		
		JSONObject obj = new JSONObject(); 
		
		obj.put("disLikeCnt", r.getDisLikeCnt()); //request.setAttribute("json", json);
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
