/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.40
 * Generated at: 2019-06-03 14:17:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.review;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import review.model.vo.Review;
import review.model.service.*;
import java.util.*;
import user.model.vo.*;
import review.model.service.*;
import review.model.vo.*;
import javax.servlet.http.*;

public final class reviewList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1559571274474L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1559544598597L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("user.model.vo");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("review.model.service");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("review.model.vo");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("review.model.vo.Review");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

	List<Review> list = (List<Review>)request.getAttribute("list");
	String pageBar = (String)request.getAttribute("pageBar");
	/* String userName = ""; */


      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	User userLoggedIn = (User)session.getAttribute("userLoggedIn");

	ReviewService service = new ReviewService();
	//Cookie[] cookies = request.getCookies();
	boolean saveIdFlag = false;
	String userId = "";
 	/////////////////////////////////쿠키문제////////////////////////
	/* if(cookies != null){
		for(Cookie c: cookies){
			String key = c.getName();
			String value = c.getValue();
			if("saveId".equals(key)){
				saveIdFlag = true;
				userId = value;
			}
		}
	} */
	////////////////////////////////////////////////////////////

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write(" <script>\r\n");
      out.write("(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\r\n");
      out.write("(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\r\n");
      out.write("m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\r\n");
      out.write("})(window,document,'script','https://www.google-analytics.com/analytics.js','ga');\r\n");
      out.write("\r\n");
      out.write("ga('create', 'UA-128561305-2', 'auto');\r\n");
      out.write("ga('send', 'pageview');\r\n");
      out.write("</script>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("  <!-- 시맨틱 UI -->\r\n");
      out.write(" <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.css\"/>\r\n");
      out.write(" <!----------------------------------------------->  \r\n");
      out.write(" \r\n");
      out.write(" <!--------------------JQuery--------------------------->\r\n");
      out.write(" <script\r\n");
      out.write("  src=\"https://code.jquery.com/jquery-3.4.1.js\"\r\n");
      out.write("  integrity=\"sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=\"\r\n");
      out.write("  crossorigin=\"anonymous\"></script>\r\n");
      out.write("  <!----------------------------------------------->\r\n");
      out.write(" \r\n");
      out.write("  <!--bootstrap-->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n");
      out.write("  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("  <!----------------------------------------------->\r\n");
      out.write("  \r\n");
      out.write("</head>\r\n");
      out.write("<div class=\"ui menu\" style=\"background-color:#68b30d; opacity: 0.8;\">\r\n");
      out.write("\r\n");
      out.write("  \t\t<div class=\"header item\">\r\n");
      out.write("    \t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("\" class=\"home-logo\"><img style= \"height:85px\"src=\"");
      out.print(request.getContextPath());
      out.write("/images/bambooHeader.png\"></a>\r\n");
      out.write(" \t\t</div>\r\n");
      out.write(" \t\t\r\n");
      out.write(" \t\t\r\n");
      out.write(" \t\t");
if(userLoggedIn==null){
      out.write("\r\n");
      out.write(" \t\t<a data-event-category=\"User\"\r\n");
      out.write("  \t\t\tdata-event-action=\"Price\" class=\"item right\" href=\"");
      out.print(request.getContextPath());
      out.write("/price/priceInfo\">\r\n");
      out.write("   \t\t\t가격정보\r\n");
      out.write("  \t\t</a>\r\n");
      out.write("  \t\t<a data-event-category=\"User\"\r\n");
      out.write("  \t\t\tdata-event-action=\"signout\" class=\"item\" href=\"");
      out.print(request.getContextPath());
      out.write("/user/userLogin\">\r\n");
      out.write("    \t\t로그인\r\n");
      out.write("  \t\t</a>\r\n");
      out.write(" \t\t");
} else{
      out.write("\r\n");
      out.write(" \t\t\t<a class=\"item right\" href=\"");
      out.print(request.getContextPath());
      out.write("/admin/adminList\">\r\n");
      out.write("  \t\t\t\t 관리자페이지\r\n");
      out.write(" \t\t\t</a>\t\r\n");
      out.write(" \t\t\t<a class=\"item\" href=\"");
      out.print(request.getContextPath());
      out.write("/user/userView?email=");
      out.print(userLoggedIn.getEmail());
      out.write("\">\r\n");
      out.write("   \t\t\t\t내 정보 보기\r\n");
      out.write("  \t\t\t</a>\r\n");
      out.write("  \t\t\t");
      out.write("\r\n");
      out.write("  \t\t\t<a class=\"item\" href=\"");
      out.print(request.getContextPath());
      out.write("/price/priceInfo\">\r\n");
      out.write("   \t\t\t\t가격정보\r\n");
      out.write("  \t\t\t</a>\r\n");
      out.write("  \t\t\t<a class=\"item\" href=\"");
      out.print(request.getContextPath());
      out.write("/user/userLogout\">\r\n");
      out.write("    \t\t\t로그아웃하기\r\n");
      out.write("  \t\t\t</a>\r\n");
      out.write(" \t\t");
} 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\t\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/review.css\" />\t\t\r\n");
      out.write("<section id=\"review-container\">\r\n");
      out.write("\t<h2>게시판</h2>\r\n");
      out.write("\t\t<input type=\"button\" value=\"글쓰기\" \r\n");
      out.write("\t\t\t   id=\"btn-add\"\r\n");
      out.write("\t\t\t   onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/review/reviewForm'\"/>\r\n");
      out.write("\t<table id=\"tbl-review\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>번호</th>\r\n");
      out.write("\t\t\t<th>제목</th>\r\n");
      out.write("\t\t\t<th>작성자</th>\r\n");
      out.write("\t\t\t<th>작성일</th>\r\n");
      out.write("\t\t\t<th>조회수</th>\r\n");
      out.write("\t\t\t<th>추천수</th>\r\n");
      out.write("\t\t\t<th>신고수</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
 for(Review r : list){ 
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>");
      out.print( r.getReviewNo() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/review/reviewView?reviewNo=");
      out.print( r.getReviewNo() );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t");
      out.print( r.getReviewTitle() );
      out.write("\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>");
      out.print( r.getReviewWriter() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print( r.getWrittenDate() );
      out.write("</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td>");
      out.print(r.getReadCnt() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(r.getLikeCnt() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(r.getDisLikeCnt() );
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"pageBar\">\r\n");
      out.write("\t\t");
      out.print(pageBar );
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</section>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("<div class=\"ui menu\" style=\"position:absolute; height:2.5rem; bottom:0; width:100%\">\r\n");
      out.write("  <div class=\"header item\">\r\n");
      out.write("    Our Company\r\n");
      out.write("  </div>\r\n");
      out.write("  <a class=\"item\">\r\n");
      out.write("    About Us\r\n");
      out.write("  </a>\r\n");
      out.write("  <a class=\"item\">\r\n");
      out.write("    Jobs\r\n");
      out.write("  </a>\r\n");
      out.write("  <a class=\"item\">\r\n");
      out.write("    Locations\r\n");
      out.write("  </a>\r\n");
      out.write("</div>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
