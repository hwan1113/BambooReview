/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.40
 * Generated at: 2019-05-30 07:04:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.payment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class PriceView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1559199633993L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1559199632702L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/header.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.css\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"width:1024px;\" align=\"center\" id=\"listbody\">\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\t\t<header>\r\n");
      out.write("\t\t\t<nav>\r\n");
      out.write("\t\t\t\t<ul class=\"main-nav\">\r\n");
      out.write("\t\t\t\t\t<li class=\"home\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/adminList\">관리자 페이지</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"notice\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/price/priceInfo\">가격정보</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"board\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/user/userInfo\">내 정보보기</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"board\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/user/userLogin\">로그인</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</nav>\r\n");
      out.write("\t\t</header>\r\n");
      out.write("\t</div>");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/payment.css\" />\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Nanum+Gothic+Coding&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<div class=\"all\"></div>\r\n");
      out.write("<div class=\"ui small message\">이용권 안내</div>\r\n");
      out.write("<div class=\"ui placeholder segment\">\r\n");
      out.write("<div class=\"ui green message\" id=\"month\">베이직(한달 이용권)</div>\r\n");
      out.write("<div class=\"ui teal message\" id=\"year\">프리미엄(1년 이용권)</div>\r\n");
      out.write("  <div class=\"ui two column very relaxed stackable grid\">\r\n");
      out.write("          <p class=\"month-detail\">한달간 커뮤니티 모든 글 열람,등록, 수정, 삭제가능</p>\r\n");
      out.write("    <div class=\"column\">\r\n");
      out.write("      <div class=\"ui form\">\r\n");
      out.write("        <div class=\"field\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"field\">\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"middle aligned column\">\r\n");
      out.write("  \t<p class=\"year-detail\">일년간 커뮤니티 모든 글 열람,등록, 수정, 삭제가능</p>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"ui vertical divider\">\r\n");
      out.write("    Or\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"ui buttons\">\r\n");
      out.write("  <button class=\"ui button\">뒤로가기</button>\r\n");
      out.write("  <div class=\"or\"></div>\r\n");
      out.write("  <button class=\"ui positive button\">결제하기</button>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\t\t<footer>\r\n");
      out.write("\t\t\t<p id=\"footerp\">&lt;Copyright 2019. <strong>Team Thanos</strong>. All rights reserved.&gt;</p>\r\n");
      out.write("\t\t</footer>\r\n");
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