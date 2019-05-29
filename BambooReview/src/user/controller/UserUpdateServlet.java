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
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String userName = request.getParameter("userName");
    	String phone = request.getParameter("phone");
		
    	User u = new User();
    	u.setUserName(userName);
    	u.setPhone(phone);
    	
    	int result = new UserService().updateUser(u);
    	
    	String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/";
		
		if(result>0) {
			msg = "성공적으로 회원정보를 수정했습니다.";
			loc = "/member/memberView?memberId="+u.getEmail();
			HttpSession session = request.getSession();
			session.setAttribute("userLoggedIn", new UserService().selectOne(u.getEmail()));
		}
		else 
			msg = "회원정보수정에 실패했습니다.";	
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
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
