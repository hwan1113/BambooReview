package ads.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.model.service.AdsService;
import ads.model.vo.Ads;
import ads.model.vo.AdsComment;

/**
 * Servlet implementation class adsViewServlet
 */
@WebServlet("/ads/adsView")
public class AdsViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파리미터 글번호
		int adsNo  = Integer.parseInt(request.getParameter("adsNo"));
		
		//2.비지니스로직 호출
		AdsService adsService = new AdsService();
		
		//사용자 읽음여부 쿠키검사
		Cookie[] cookies = request.getCookies();
		boolean hasRead = false;
		String adsCookieVal = "";
		if(cookies != null) {
			for(Cookie c: cookies) {
				String name = c.getName();
				String value = c.getValue();
				
				if("adsCookie".equals(name)) {
					adsCookieVal = value;
					
					if(value.contains("|"+adsNo+"|")) {
						hasRead = true;
						break;
					}
				}
			}
		}
		
		//쿠키에 읽은 값이 없는 경우
		if(!hasRead) {
			adsService.increaseReadCount(adsNo);
			
			//쿠키생성
			Cookie adsCookie = new Cookie("adsCookie", adsCookieVal+"|"+adsNo+"|");
			adsCookie.setPath(request.getContextPath()+"/ads/adsView");
//					adsCookie.setMaxAge();//생략시 영속하게됨.
			
			//응답객체 cookie 전송
			response.addCookie(adsCookie);
		}

		//게시글 하나 가져오기
		Ads ads = adsService.selectOne(adsNo);
		
		//댓글목록가져오기
		List<AdsComment> adsCommentList = adsService.selectAdsComment(adsNo);
		
		String view = "/WEB-INF/views/ads/adsView.jsp";
		
		request.setAttribute("ads", ads);
		request.setAttribute("adsCommentList", adsCommentList);
		
		//게시글 가져오기에 실패한경우
		if(ads == null){
			request.setAttribute("msg", "조회한 게시글이 존재하지 않습니다.");
			request.setAttribute("loc", "/ads/adsList");
			view = "/WEB-INF/views/common/msg.jsp";
		}
		
		
		
		//3.view단 처리위임
		RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
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
