package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String picture=request.getParameter("picture");
		
		User userLoggedIn = new UserService().selectOne(email);
		User u = new User();
		String msg = "";
		if(userLoggedIn==null) {
			u.setEmail(email);
			u.setUserName(userName);
			u.setProfile("change");
			u.setPassword("change later");
			u.setPhone("change");
			u.setStatus("U");
			int result= new UserService().insertGoogleUser(u);
			if(result>0) {
				msg="BambooReview 구글 처음 로그인 성공!";
			}else {
				msg="BambooReview 구글 처음 로그인 실패!";
			}
		}else {
			msg="구글 로그인 성공!";
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
