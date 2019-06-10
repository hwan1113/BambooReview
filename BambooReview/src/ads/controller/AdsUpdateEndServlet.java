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
 * Servlet implementation class AdsUpdateEndServlet
 */
@WebServlet("/ads/adsUpdateEnd")
public class AdsUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터 핸들링
		String adsTitle = request.getParameter("adsTitle");
		String adsWriter = request.getParameter("adsWriter");
		String adsContent = request.getParameter("adsContent");
		int adsNo = Integer.parseInt(request.getParameter("adsNo"));
		String address = request.getParameter("address");
		String details = request.getParameter("details");
		String fullAddress = address + " " + details;
		String[] arrFacilities = request.getParameterValues("facilities");
		String facilities = Arrays.toString(arrFacilities);

		Ads ads = new Ads();
		ads.setAdsTitle(adsTitle);
		ads.setAdsWriter(adsWriter);
		ads.setAdsContent(adsContent);
		ads.setAdsNo(adsNo);
		ads.setFullAddress(fullAddress);
		ads.setFacilities(facilities);
		
		//2. 업무로직
		int result = new AdsService().updateAds(ads);
		
		String msg = "";
		String loc = "/ads/adsList";

		if(result>0) {
			msg = "게시글 등록성공!";
			ads = new AdsService().selectOne(adsNo);
			//성공한 경우, result변수에 새로 등록된 글번호를 가져옴.
			loc = "/ads/adsView?adsNo="+ads.getAdsNo();
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
