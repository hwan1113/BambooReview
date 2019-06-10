package ads.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.model.service.AdsService;
import ads.model.vo.Ads;

/**
 * Servlet implementation class AdsUpdateServlet
 */
@WebServlet("/ads/adsUpdate")
public class AdsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라미터
		int adsNo = Integer.parseInt(request.getParameter("adsNo"));
		
		//2. 업무로직
		Ads ads = new AdsService().selectOne(adsNo);
		
		//3. view단처리
		request.setAttribute("ads", ads);
		request.getRequestDispatcher("/WEB-INF/views/ads/adsUpdate.jsp")
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
