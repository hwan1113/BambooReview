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
 * Servlet implementation class ReviewRateServlet
 */
@WebServlet("/review/reviewRate")
public class ReviewRateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewService service = new ReviewService();
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int customerNo = Integer.parseInt(request.getParameter("customerNo"));
		int reviewRate = Integer.parseInt(request.getParameter("reviewRate"));
		int result = service.updateRateTotal(reviewNo, customerNo, reviewRate);
		//평균을 여기서 계산하는 것이 아니라, ReviewView.jsp넘어오기전 ReviewviewServlet에서 selectOne시에 rate count와 rate총점을 넣어주어야함.
		Review r = service.selectRateCount(reviewNo);
		
		JSONObject obj = new JSONObject(); 
		
		obj.put("result", result); //request.setAttribute("json", json);
		
		response.setContentType("application/x-json; charset=UTF-8"); 
		response.getWriter().print(obj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
