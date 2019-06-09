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
		Review r = service.selectRateCount(reviewNo);
		r.setRateTotal(service.getTotalRate(reviewNo));
		
		double avg = (double)r.getRateTotal() / r.getRateCnt();
		
		//System.out.println("avg@serv1="+String.format("%.2f", (double)r.getRateTotal() / r.getRateCnt()));
		
		//출력 확인
		System.out.println("rateCnt@serv="+r.getRateCnt());
		System.out.println("rateTotal@serv="+r.getRateTotal());
		System.out.println("avg@serv1="+String.format("%.2f", avg));
		
		JSONObject obj = new JSONObject(); 
		
		obj.put("rateTotal", r.getRateTotal());
		obj.put("rateCnt", r.getRateCnt()); //request.setAttribute("json", json);
		obj.put("result", result); //request.setAttribute("json", json);
		
		response.setContentType("application/x-json; charset=UTF-8"); 
		response.getWriter().print(obj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
