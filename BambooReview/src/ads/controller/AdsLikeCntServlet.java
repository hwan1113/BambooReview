package ads.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import ads.model.service.AdsService;
import ads.model.vo.Ads;

/**
 * Servlet implementation class AdsLikeCntServlet
 */
@WebServlet("/ads/adsLikeCnt")
public class AdsLikeCntServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdsService service = new AdsService();
		
		int adsNo = Integer.parseInt(request.getParameter("adsNo"));
		int customerNo = Integer.parseInt(request.getParameter("customerNo"));  
		int result = service.increaseLikeCount(adsNo, customerNo);
		Ads ads = service.selectLikeCount(adsNo); 
				
		JSONObject obj = new JSONObject(); 
		
		obj.put("likeCnt", ads.getLikeCnt()); //request.setAttribute("json", json);
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
