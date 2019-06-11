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
 * Servlet implementation class UserEnrollServlet
 */
@WebServlet(urlPatterns= {"/user/signup"},
			name = "UserEnrollServlet")
public class UserEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email =request.getParameter("email");
    	String password= request.getParameter("password");
    	String userName = request.getParameter("name");
    	String phone = request.getParameter("phone");
		
    	User u = new User();
    	u.setEmail(email);
    	u.setPassword(password);
    	u.setUserName(userName);
    	u.setPhone(phone);
    	
    	int result= new UserService().insertUser(u);
    	
    	String msg = "";
    	if(result > 0) {
			msg = "회원가입성공!";
		}
		else {
			msg = "회원가입실패!";
		}
    	request.setAttribute("msg", msg);
		request.setAttribute("loc", "/");
		
		String view = "/WEB-INF/views/common/msg.jsp";
		request.getRequestDispatcher(view)
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
