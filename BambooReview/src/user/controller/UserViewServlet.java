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
 * Servlet implementation class UserViewServlet
 */
@WebServlet("/UserViewServlet")
public class UserViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		User u = new UserService().selectOne(email);
		
		String view = "";
		String loc = "";
		String msg = "";
		
		if(u != null) {
			view = "/WEB-INF/views/member/memberView.jsp";
			request.setAttribute("user", u);
		}else {
			view = "/WEB-INF/views/common/msg.jsp";
			msg = "해당 회원이 없습니다.";
			loc = "/";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
		}
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
