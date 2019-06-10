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
 * Servlet Filter implementation class ReviewFilter
 */
@WebFilter(urlPatterns = {"/review/reviewList",
		"/review/reviewView",
		"/review/reviewForm",
		"/review/reviewDelete"})
public class ReviewFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ReviewFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest)request; 
		HttpSession session = httpRequest.getSession();
		User userLoggedIn = (User)session.getAttribute("userLoggedIn");
		String reqHotelId = httpRequest.getParameter("hotelId");
		String reqHotelName = httpRequest.getParameter("hotelName");
		
		
		if(userLoggedIn != null && reqHotelId!=null &&reqHotelName!=null)
		
		
		System.out.println("hotelId= "+reqHotelId);
		if(userLoggedIn == null ||
				reqHotelId == null || reqHotelName==null) {
			request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
				   .forward(request, response);
			return;
		}
		

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
