package common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Filter
 * Servlet 2.3이상에서 사용가능
 * 서블릿필터는 request, response가 servlet/jsp에 
 * 도달하기 전이나, 응답을 전송하기전에 필요한 전/후처리작업을 맡는다.
 * 
 * 필터 등록방법
 * 1. web.xml에 필터 직접등록. 모아보기
 * 2. annotation @WebFilter를 통해 등록.
 * 
 * 필터의 생명주기
 * init() - doFilter() - destroy() 
 */
//@WebFilter("/*")
public class EncodeFilter implements Filter {
	
    private FilterConfig fConfig;

	/**
     * Default constructor. 
     */
    public EncodeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		//System.out.println("EncodeFilter.destroy()");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String encodeType = fConfig.getInitParameter("encode_type");
		
		//전처리
		request.setCharacterEncoding(encodeType);
		System.out.println("Encoding처리되었음@EncodeFilter");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		//후처리
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 * 
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
		//System.out.println("EncodeFilter.init(FilterConfig)");
	}

}
