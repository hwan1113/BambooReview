package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import user.model.vo.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(servletNames = { "UserViewServlet" })
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, 
						 ServletResponse response, 
						 FilterChain chain) throws IOException, ServletException {
		//현재로그인한 사용자와 요청사용자 비교
		HttpServletRequest httpRequest = (HttpServletRequest)request; 
		HttpSession session = httpRequest.getSession();
		User userLoggedIn = (User)session.getAttribute("userLoggedIn");
		
		String reqUserId = httpRequest.getParameter("email");
		
		if(userLoggedIn != null)
		//비교후, 동일하지 않다면, msg.jsp를 view단으로 forwarding함.
		if(userLoggedIn == null ||
		   reqUserId == null ||
		   (!"A".equals(userLoggedIn.getStatus())&&
		   !reqUserId.equals(userLoggedIn.getEmail()))) {
			request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
				   .forward(request, response);
			return;
		}

		// pass the request along the filter chain
		//다음 필터가 있다면, 해당필터의 doFilter메소드를 호출,
		//없다면, servlet객체의 service()를 호출한다.
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
