/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.40
 * Generated at: 2019-06-03 07:17:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.payment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import user.model.vo.*;
import review.model.service.*;
import review.model.vo.*;
import javax.servlet.http.*;

public final class NaverPay_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1559544599071L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("user.model.vo");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("review.model.service");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("review.model.vo");
    _jspx_imports_classes = null;
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
      out.write(" \t\t<a class=\"item right\" href=\"");
      out.print(request.getContextPath());
      out.write("/price/priceInfo\">\r\n");
      out.write("   \t\t\t가격정보\r\n");
      out.write("  \t\t</a>\r\n");
      out.write("  \t\t<a class=\"item\" href=\"");
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
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://cdn.iamport.kr/js/iamport.payment-1.1.5.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("IMP.init(\"imp28947597\");\r\n");
      out.write("IMP.request_pay({ // param\r\n");
      out.write("    pg: \"html5_inicis\",\r\n");
      out.write("    pay_method: \"card\",\r\n");
      out.write("    merchant_uid: \"ORD20180131-0000011\",\r\n");
      out.write("    name: \"베이직(한달 이용권)\",\r\n");
      out.write("    amount: 1700,\r\n");
      out.write("    buyer_email: \"gildong@gmail.com\",\r\n");
      out.write("    buyer_name: '홍길동',\r\n");
      out.write("    buyer_tel: \"010-4242-4242\",\r\n");
      out.write("    buyer_addr: \"서울특별시 강남구 신사동\",\r\n");
      out.write("    buyer_postcode: \"01181\"\r\n");
      out.write("}, function (rsp) { // callback\r\n");
      out.write("    if (rsp.success) {\r\n");
      out.write("        alert('결제가 성공하였습니다.')\r\n");
      out.write("    } else {\r\n");
      out.write("    \talert('결제가 취소되었습니다.')\r\n");
      out.write("    }\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
