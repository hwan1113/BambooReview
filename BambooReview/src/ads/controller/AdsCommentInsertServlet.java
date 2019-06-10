package ads.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.model.service.AdsService;
import ads.model.vo.AdsComment;

/**
 * Servlet implementation class adsCommentInsertServlet
 */
@WebServlet("/ads/adsCommentInsert")
public class AdsCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1.파라미터핸들링
		int adsNo = Integer.parseInt(request.getParameter("adsNo"));
		int customerNo = Integer.parseInt(request.getParameter("customerNo"));
		String adsCommentContent = request.getParameter("adsCommentContent");
		
		AdsComment ac = new AdsComment(0, customerNo, adsNo, null, adsCommentContent);
				
		//2.업무로직
		int result = new AdsService().insertAdsComment(ac);
		
		//3.view단처리
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/ads/adsView?adsNo="+adsNo;
		
		if(result>0) {
			msg = "댓글 등록 성공!";
		}
		else {
			msg = "댓글 등록 실패!";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
