package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class MemberUpdatePasswordEndServlet
 */
@WebServlet(name="UserUpdatePasswordEndServlet",
			urlPatterns="/user/updatePasswordEnd")
public class UserUpdatePasswordEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdatePasswordEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전송값 꺼내서 변수에 기록하기.
		//String javax.servlet.ServletRequest.getParameter(String arg0)
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password_new = request.getParameter("password_new");
		
		System.out.println("email ="+email);
		System.out.println(password);//ohiwoji;wadfjiop'waedfojisdffd
		System.out.println(password_new);//12345
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		//2.서비스로직호출
		int result = userService.loginCheck(user);
		
		//3. 현재패스워드를 맞게 입력했으면, 비밀번호를 업데이트함. 
		//그렇지 않으면, 다시 팝업창 url을 호출함.
		String msg = "";
		String loc = "";
		String view = "/WEB-INF/views/common/msg.jsp";
		if(result == UserService.LOGIN_OK){
			//현재 member객체에 갱신할 비밀번호를 업데이트
			user.setPassword(password_new);
			result = userService.updatePassword(user);
			if(result>0){
				msg = "패스워드 변경 성공";
				request.setAttribute("script", "self.close();");
				
			}
				
		}
		else {
			msg = "패스워드를 잘못 입력하셨습니다.";
			loc = "/user/updatePassword?email="+email;
		}
		request.setAttribute("msg", msg);
		//팝업창 닫기용 스크립트생성
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
