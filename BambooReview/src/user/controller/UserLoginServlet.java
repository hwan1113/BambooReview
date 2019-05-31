package user.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String saveId = request.getParameter("saveId");//null 혹은 on
		
		User u = new User();
		u.setEmail(email);
		u.setPassword(password);
		
		int result = new UserService().loginCheck(u);
		System.out.println("result"+result);
		
		Map<String, String> headerMap = new HashMap<>();
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			String value = request.getHeader(name);
			headerMap.put(name, value);
//			System.out.println(name+"="+value);
		}
		
/////////////////////////////////////수정필요		
		String referer = request.getHeader("Referer");
		//Origin 가져올 수 없음.
		String origin = request.getHeader("Origin");
		System.out.println("origin="+origin);
		String view = "/WEB-INF/views/common/msg.jsp";
		
		String loc = referer.replace(request.getContextPath(), "");
		System.out.println("loc"+loc);
////////////////////////////////////////////
		
		String msg = "";
		if(result ==1) {
			loc="/";
			msg="로그인 성공!";
			User userLoggedIn = new UserService().selectOne(email);
			HttpSession session = request.getSession();
			session.setAttribute("userLoggedIn", userLoggedIn);
			session.setMaxInactiveInterval(60*60);
			if(saveId != null) {
				Cookie c = new Cookie("saveId", email);
				c.setMaxAge(7*24*60*60);
				c.setPath("/");
				response.addCookie(c);
			}else {
				Cookie c = new Cookie("saveId", email);
				c.setMaxAge(0);
				c.setPath("/");
				response.addCookie(c);
			}
		}else {
			msg = "존재하지 않는 아이디이거나 비밀번호가 틀렸습니다.";
			loc="/";
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
