package user.controller;

import java.io.IOException;
import java.sql.Date;

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
@WebServlet(name="UserUpdateServlet", 
urlPatterns="/user/userUpdate")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String email= request.getParameter("email");
		String password=null;
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String profile= request.getParameter("profile");
		Date enrollDate=null;
		Date quitDate=null;
		String status = null;
		int customer_no = 0;



		
    	/*User u = new User();
    	u.setEmail(email);
    	u.setUserName(userName);
    	u.setPhone(phone);*/
		
		User u=new User(email, password, userName, phone, profile, enrollDate, quitDate, status, customer_no);
    	
    	int result = new UserService().updateUser(u);
    	
    	
    	String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/";
		
		if(result>0) {
			msg = "성공적으로 회원정보를 수정했습니다.";
			loc = "/user/userView?email="+u.getEmail();
			HttpSession session = request.getSession();
			session.setAttribute("userLoggedIn", new UserService().selectOne(email));
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
