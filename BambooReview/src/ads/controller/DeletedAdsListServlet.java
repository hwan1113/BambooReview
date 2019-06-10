package ads.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.model.service.AdsService;
import ads.model.vo.Ads;

/**
 * Servlet implementation class AdsListServlet
 */
@WebServlet("/ads/deletedAdsList")
public class DeletedAdsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		
		//파라미터 핸들링
		int numPerPage = 5;//한페이지당 수
		int cPage = 1;//요청페이지
		try{
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch(NumberFormatException e){
		
		}

		List<Ads> adsList = new AdsService().selectDeletedAdsList(cPage, numPerPage);

		int totalAdsCount = new AdsService().selectAdsCount();
		int totalPage = (int)Math.ceil((double)totalAdsCount/numPerPage);
		String pageBar = "";	
		int pageBarSize = 5;
		int pageStart = ((cPage - 1)/pageBarSize) * pageBarSize +1;
		int pageEnd = pageStart+pageBarSize-1;
		int pageNo = pageStart;
		
		if(pageNo == 1 ){
		}
		else {
			pageBar += "<a href='"+request.getContextPath()+"/ads/deletedAdsList?cPage="+(pageNo-1)+"'>[이전]</a> ";
		}

		while(!(pageNo>pageEnd || pageNo > totalPage)){
			
			if(cPage == pageNo ){
				pageBar += "<span class='cPage'>"+pageNo+"</span> ";
			} 
			else {
				pageBar += "<a href='"+request.getContextPath()+"/ads/deletedAdsList?cPage="+pageNo+"'>"+pageNo+"</a> ";
			}
			pageNo++;
		}

		if(pageNo > totalPage){

		} else {
			pageBar += "<a href='"+request.getContextPath()+"/ads/deletedAdsList?cPage="+pageNo+"'>[다음]</a>";
		}
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/WEB-INF/views/ads/deletedAdsList.jsp");
		request.setAttribute("adsList",adsList);
		request.setAttribute("pageBar",pageBar);	
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
