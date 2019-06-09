package ads.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.model.service.AdsService;
import ads.model.vo.Ads;

/**
 * Servlet implementation class adsFormEndServlet
 */
@WebServlet("/ads/adsFormEnd")
public class AdsFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터 핸들링
		String adsTitle = request.getParameter("adsTitle");
		int customerNo = Integer.parseInt(request.getParameter("customerNo"));
		System.out.println("customerNo@serv="+customerNo);
		String adsWriter = request.getParameter("adsWriter");
		System.out.println("writer@serv="+adsWriter);
		String adsContent = request.getParameter("adsContent");
		String address = request.getParameter("address");
		String details = request.getParameter("details");
		String fullAddress = address + " " + details;
		String[] arrFacilities = request.getParameterValues("facilities");
		String facilities = Arrays.toString(arrFacilities);
		
		Ads ads = new Ads();
		ads.setAdsTitle(adsTitle);
		ads.setCustomerNo(customerNo);
		ads.setAdsWriter(adsWriter);
		ads.setAdsContent(adsContent);
		ads.setFullAddress(fullAddress);
		ads.setFacilities(facilities);
		
		//2. 업무로직
		int result = new AdsService().insertAds(ads);
		String msg = "";
		String loc = "/ads/adsList";

		if(result>0) {
			msg = "게시글 등록성공!";

			loc = "/ads/adsView?adsNo="+result;
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
