/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.40
 * Generated at: 2019-05-31 09:24:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import user.model.vo.*;
import javax.servlet.http.*;

public final class LoginView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1559294026279L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1559286465552L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("user.model.vo");
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

      out.write("\r\n");
      out.write(" <style>\r\n");
      out.write(" #space{\r\n");
      out.write(" height:100px;\r\n");
      out.write(" type:inline-block;\r\n");
      out.write(" }\r\n");
      out.write(" </style>\r\n");
      out.write(" ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	User userLoggedIn = (User)session.getAttribute("userLoggedIn");
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
 		switch(userLoggedIn.getStatus()) {
 			case "A":{
      out.write("\r\n");
      out.write(" \t\t\t<p>");
      out.print(userLoggedIn.getUserName() );
      out.write("님 안녕하세요</p>\r\n");
      out.write(" \t\t\t<a class=\"item right\" href=\"");
      out.print(request.getContextPath());
      out.write("/admin/adminList\">\r\n");
      out.write("  \t\t\t\t 관리자페이지\r\n");
      out.write(" \t\t\t</a>\r\n");
      out.write(" \t\t");
} case "U":{
      out.write("\t\r\n");
      out.write(" \t\t\t<a class=\"item\" href=\"");
      out.print(request.getContextPath());
      out.write("/user/userInfo\">\r\n");
      out.write("   \t\t\t\t내 정보 보기\r\n");
      out.write("  \t\t\t</a>\r\n");
      out.write("  \t\t");
} case "G": {
      out.write("\r\n");
      out.write("  \t\t\t<a class=\"item\" href=\"");
      out.print(request.getContextPath());
      out.write("/price/priceInfo\">\r\n");
      out.write("   \t\t\t\t가격정보\r\n");
      out.write("  \t\t\t</a>\r\n");
      out.write("  \t\t\t<a class=\"item\" href=\"");
      out.print(request.getContextPath());
      out.write("/user/userLogin\">\r\n");
      out.write("    \t\t\t로그아웃하기\r\n");
      out.write("  \t\t\t</a>\r\n");
      out.write(" \t\t");
}}} 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write(" <meta name=\"google-signin-client_id\" content=\"401915479611-85lnc5b082en3f07kq9jsd628oshv494.apps.googleusercontent.com\">\r\n");
      out.write(" <script src=\"https://apis.google.com/js/platform.js?onload=renderButton\" async defer></script>\r\n");
      out.write("<title>LoginView</title>\r\n");
      out.write("\t<div class=\"ui two column centered grid\">\r\n");
      out.write("  \t\t<div class=\"column centered row\">\r\n");
      out.write("    \t\t<div class=\"column\" id=\"space\">\r\n");
      out.write("   \t\t\t   <span></span>\r\n");
      out.write("   \t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("  \t\t<div class=\"column\">\r\n");
      out.write("  \t\t  <form class=\"ui form\" action=\"");
      out.print(request.getContextPath() );
      out.write("/user/login\" onsubmit=\"return loginValidate();\">\r\n");
      out.write("\t\t\t  <div class=\"field\" >\r\n");
      out.write("\t\t\t    <label>이메일</label>\r\n");
      out.write("\t\t\t    <input type=\"email\" name=\"email\" placeholder=\"email\" id=\"memberId\"/>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t  <div class=\"field\" >\r\n");
      out.write("\t\t\t    <label>비밀번호</label>\r\n");
      out.write("\t\t\t    <input type=\"password\" name=\"password\" placeholder=\"password\" id=\"password\"/>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t  <div class=\"field\">\r\n");
      out.write("\t\t\t    <div class=\"ui checkbox\">\r\n");
      out.write("\t\t\t      <input type=\"checkbox\" name=\"saveId\">\r\n");
      out.write("\t\t\t      <label>remember me!</label>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t  \r\n");
      out.write("  \t\t\t\t<button class=\"ui button\" type=\"submit\">로그인</button>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t <div class=\"ui message\">\r\n");
      out.write(" \t\t\t\t <div class=\"header\">\r\n");
      out.write("  \t\t\t\t\t  아직도 회원이 아니세요?\r\n");
      out.write(" \t\t\t\t </div>\r\n");
      out.write(" \t\t\t\t <p><a href=\"");
      out.print(request.getContextPath());
      out.write("/user/userSignup\">회원 가입하러가기!</a></p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"my-signin2\"></div>\r\n");
      out.write("\t\t\t<a href=\"#\" onclick=\"signOut();\">Sign out</a>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t</div>\r\n");
      out.write("  \t<form action=\"");
      out.print(request.getContextPath());
      out.write("/user/googleUser\"\r\n");
      out.write("      \t\t\t\tname=\"googleUserFrm\" id=\"googleUserFrm\" method=\"post\">\r\n");
      out.write("       \t\t\t<input type=\"hidden\" name=\"userName\" id=\"userName\"/>\r\n");
      out.write("    \t\t\t<input type=\"hidden\" name=\"email\" id=\"email\">\r\n");
      out.write("    \t\t\t<input type=\"hidden\" name=\"picture\" id=\"picture\">\r\n");
      out.write("   \t</form>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("function signOut() {\r\n");
      out.write("   var auth2 = gapi.auth2.getAuthInstance();\r\n");
      out.write("   auth2.signOut().then(function () {\r\n");
      out.write("     console.log('User signed out.');\r\n");
      out.write("   });\r\n");
      out.write(" }\r\n");
      out.write("\r\n");
      out.write("function onSuccess(googleUser) {\r\n");
      out.write("     var profile = googleUser.getBasicProfile();\r\n");
      out.write("      console.log('ID: ' + profile.getId());\r\n");
      out.write("      console.log('Name: ' + profile.getName());\r\n");
      out.write("      console.log('Image URL: ' + profile.getImageUrl());\r\n");
      out.write("      console.log('Email: ' + profile.getEmail());\r\n");
      out.write("      var id_token = googleUser.getAuthResponse().id_token;\r\n");
      out.write("      \r\n");
      out.write("      $(\"#userName\").val(profile.getName())\r\n");
      out.write("      $(\"#email\").val(profile.getEmail())\r\n");
      out.write("      $(\"#picture\").val(profile.getImageUrl())\r\n");
      out.write("      $(\"#googleUserFrm\").submit()\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("      var param={\r\n");
      out.write("          id_token:id_token\r\n");
      out.write("      }\r\n");
      out.write("      $.ajax({\r\n");
      out.write("        url:'https://oauth2.googleapis.com/tokeninfo',\r\n");
      out.write("        data:param,\r\n");
      out.write("        success: function(data){\r\n");
      out.write("            console.dir(data)\r\n");
      out.write("            \r\n");
      out.write("        },\r\n");
      out.write("        error:function(){\r\n");
      out.write("            \r\n");
      out.write("        }\r\n");
      out.write("        })\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function onFailure(error) {\r\n");
      out.write("   console.log(error);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function renderButton() {\r\n");
      out.write("   gapi.signin2.render('my-signin2', {\r\n");
      out.write("     'scope': 'profile email',\r\n");
      out.write("     'width': 240,\r\n");
      out.write("     'height': 50,\r\n");
      out.write("     'longtitle': true,\r\n");
      out.write("     'theme': 'dark',\r\n");
      out.write("     'onsuccess': onSuccess,\r\n");
      out.write("     'onfailure': onFailure\r\n");
      out.write("   });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function loginValidate(){\r\n");
      out.write("\tif($(\"#memberId\").val().trim().length == 0){\r\n");
      out.write("\t\talert(\"아이디를 입력하세요.\");\r\n");
      out.write("\t\t$(\"#memberId\").focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif($(\"#password\").val().trim().length == 0){\r\n");
      out.write("\t\talert(\"비밀번호를 입력하세요.\");\r\n");
      out.write("\t\t$(\"#password\").focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" ");
      out.write("<div id=\"container\">\r\n");
      out.write("\t<footer>\r\n");
      out.write("\t\t<p id=\"footerp\">&lt;Copyright 2019. <strong>Team Thanos</strong>. All rights reserved.&gt;</p>\r\n");
      out.write("\t</footer>\r\n");
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
