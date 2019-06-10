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
 * Servlet implementation class AdsRateServlet
 */
@WebServlet("/ads/adsRate")
public class AdsRateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdsService service = new AdsService();
		
		int adsNo = Integer.parseInt(request.getParameter("adsNo"));
		int customerNo = Integer.parseInt(request.getParameter("customerNo"));
		int adsRate = Integer.parseInt(request.getParameter("adsRate"));
		int result = service.updateRateTotal(adsNo, customerNo, adsRate);
		
		Ads ads = service.selectRateCount(adsNo);
		
		JSONObject obj = new JSONObject(); 
		
		obj.put("result", result); //request.setAttribute("json", json);
		
		response.setContentType("application/x-json; charset=UTF-8"); 
		response.getWriter().print(obj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
