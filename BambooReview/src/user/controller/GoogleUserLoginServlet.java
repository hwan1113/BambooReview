package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class GoogleUserLoginServlet
 */
@WebServlet("/user/googleUser")
public class GoogleUserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName= request.getParameter("userName");
		String email=request.getParameter("email");
		
		User userLoggedIn = new UserService().selectOne(email);
		
		User u = new User();
		String msg = "";
		HttpSession session = request.getSession();
		
		if(userLoggedIn==null) {
			u.setEmail(email);
			u.setUserName(userName);
			u.setStatus("G");
			int result= new UserService().insertGoogleUser(u);
			if(result>0) {
				msg="BambooReview 구글 처음 로그인 성공!";
				userLoggedIn = new UserService().selectOne(email);
				session.setAttribute("userLoggedIn", userLoggedIn);
				session.setMaxInactiveInterval(60*60);
			}else {
				msg="BambooReview 구글 처음 로그인 실패!";
			}
		}else {
			msg="구글 로그인 성공!";
			session.setAttribute("userLoggedIn", userLoggedIn);
			session.setMaxInactiveInterval(60*60);
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", "/");
		String view = "/WEB-INF/views/common/msg.jsp";
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
