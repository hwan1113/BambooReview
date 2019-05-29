package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String saveId = request.getParameter("saveId");
		User u = new User();
		u.setEmail(email);
		u.setPassword(password);
		
		int result = new UserService().loginCheck(u);
		
		
		String referer = request.getHeader("Referer");
		String origin = request.getHeader("Origin");
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = referer.replace(origin+request.getContextPath(), "");
		if(result ==1) {
			msg="로그인 성공!";
			User userLoggedIn = new UserService().selectOne(email);
			HttpSession session = request.getSession();
			session.setAttribute("userLoggedIn", userLoggedIn);
			session.setMaxInactiveInterval(60*60);
			
			
		}else {
			msg = "존재하지 않는 아이디이거나 비밀번호가 틀렸습니다.";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		RequestDispatcher reqDispatcher 
		= request.getRequestDispatcher(view);
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
