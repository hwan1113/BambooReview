/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.40
 * Generated at: 2019-06-09 00:48:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import user.model.vo.*;
import review.model.service.*;
import review.model.vo.*;
import javax.servlet.http.*;

public final class InfoView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1559924033280L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1559717494180L));
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
      out.write("    \r\n");
User user = (User)request.getAttribute("user"); 
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
      out.write("ga('create', 'UA-128561305-2', 'auto');\r\n");
      out.write("\r\n");
      out.write("if (document.location.pathname.indexOf('/user') > -1 ||\r\n");
      out.write("\t\tdocument.location.pathname.indexOf('/price') > -1 ||\r\n");
      out.write("\t\tdocument.location.pathname.indexOf('/review') > -1 ||\r\n");
      out.write("\t\tdocument.location.pathname.indexOf('/hotel') > -1) {\r\n");
      out.write("\t  var pathArr = document.location.pathname.split('/');\r\n");
      out.write("\r\n");
      out.write("\t  var page = \"/\"+pathArr[1]+\"/\"+pathArr[2];\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t  // Sets the page value on the tracker.\r\n");
      out.write("\t  ga('set', 'page', page);\r\n");
      out.write("\r\n");
      out.write("\t  // Sending the pageview no longer requires passing the page\r\n");
      out.write("\t  // value since it's now stored on the tracker object.\r\n");
      out.write("\t  ga('send', 'pageview');\r\n");
      out.write("\t}\r\n");
      out.write("ga('send', 'pageview');\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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
      out.write("<div class=\"ui menu\" style=\"background-color:#68b30d; opacity: 0.8; height:67px; width:1024px;\">\r\n");
      out.write("\r\n");
      out.write("  \t\t<div class=\"header item\">\r\n");
      out.write("    \t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("\" class=\"home-logo\"><img style= \"height:68px\"src=\"");
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
} else if(userLoggedIn!=null && "A".equals(userLoggedIn.getStatus())){
      out.write("\r\n");
      out.write(" \t\t\t<a class=\"item right\" href=\"");
      out.print(request.getContextPath());
      out.write("/admin/adminList\">\r\n");
      out.write("  \t\t\t\t 관리자페이지\r\n");
      out.write(" \t\t\t</a>\t\t\r\n");
      out.write(" \t\t\t<a class=\"item\" href=\"");
      out.print(request.getContextPath());
      out.write("/user/userView?email=");
      out.print(userLoggedIn.getEmail());
      out.write("\">\r\n");
      out.write("   \t\t\t\t내 정보 보기\r\n");
      out.write("  \t\t\t</a>\r\n");
      out.write("  \t\t\t<a class=\"item\" href=\"");
      out.print(request.getContextPath());
      out.write("/price/priceInfo\">\r\n");
      out.write("   \t\t\t\t가격정보\r\n");
      out.write("  \t\t\t</a>\r\n");
      out.write("  \t\t\t<a class=\"item\" href=\"");
      out.print(request.getContextPath());
      out.write("/user/userLogout\" onclick=\"signOut();\">\r\n");
      out.write("    \t\t\t로그아웃하기\r\n");
      out.write("  \t\t\t</a>\r\n");
      out.write(" \t\t");
}else{
      out.write("\r\n");
      out.write(" \t\t<a class=\"item right\" href=\"");
      out.print(request.getContextPath());
      out.write("/admin/adminList\" style=\"visibility:hidden;\" id=\"admin-board\">\r\n");
      out.write("  \t\t\t\t 관리자페이지\r\n");
      out.write(" \t\t\t</a>\t\t\r\n");
      out.write(" \t\t\t<a class=\"item\" href=\"");
      out.print(request.getContextPath());
      out.write("/user/userView?email=");
      out.print(userLoggedIn.getEmail());
      out.write("\">\r\n");
      out.write("   \t\t\t\t내 정보 보기\r\n");
      out.write("  \t\t\t</a>\r\n");
      out.write("  \t\t\t<a class=\"item\" href=\"");
      out.print(request.getContextPath());
      out.write("/price/priceInfo\">\r\n");
      out.write("   \t\t\t\t가격정보\r\n");
      out.write("  \t\t\t</a>\r\n");
      out.write("  \t\t\t<a class=\"item\" href=\"");
      out.print(request.getContextPath());
      out.write("/user/userLogout\" onclick=\"signOut();\">\r\n");
      out.write("    \t\t\t로그아웃하기\r\n");
      out.write("  \t\t\t</a>\r\n");
      out.write(" \t\t");
}
      out.write("\r\n");
      out.write(" \r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"https://apis.google.com/js/api.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write(" gapi.load('auth2', function() {\r\n");
      out.write("\t  auth2 = gapi.auth2.init({\r\n");
      out.write("\t    client_id: '1048068622103-udnmctl1b1p2p8g9tqtcaflcb3c7p1e7.apps.googleusercontent.com',\r\n");
      out.write("\t    scope: 'email'\r\n");
      out.write("\t  }).then(()=>{\r\n");
      out.write("\t\t  console.log('fetched perfectly!')\r\n");
      out.write("\t\t  })\r\n");
      out.write("})\r\n");
      out.write("function signOut() {\r\n");
      out.write("   var auth2 = gapi.auth2.getAuthInstance();\r\n");
      out.write("   auth2.signOut().then(function () {\r\n");
      out.write("     console.log('User signed out.');\r\n");
      out.write("   });\r\n");
      out.write(" }\r\n");
      out.write(" </script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/info.css\" />\n");
      out.write("<style>\r\n");
      out.write("#space{\r\n");
      out.write("height:100px;\r\n");
      out.write("type:inline-block;\r\n");
      out.write("}\r\n");
      out.write("</style>\n");
      out.write("<script>\r\n");
      out.write("function deleteUser(){\r\n");
      out.write("\tvar bool = confirm(\"정말로 탈퇴하시겠습니까?\");\r\n");
      out.write("\tif(bool){\r\n");
      out.write("\t\tlocation.href = \"");
      out.print(request.getContextPath());
      out.write("/user/userDelete?email=");
      out.print(user.getEmail());
      out.write("\"\r\n");
      out.write("\t\t}\r\n");
      out.write("}\r\n");
      out.write("\t\r\n");
      out.write("function updatePassword(){\r\n");
      out.write("\tvar url = \"");
      out.print(request.getContextPath());
      out.write("/user/updatePassword?email=");
      out.print(user.getEmail());
      out.write("\";\r\n");
      out.write("    var title = \"updatePassword\";\r\n");
      out.write("    var status =  \"left=500px, top=200px, width=400px, height=210px\";\r\n");
      out.write("\tvar popup = window.open(url,title,status);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function loadImg(f){\r\n");
      out.write("    console.log(f.files[0].name); //File 실제 업로드한 파일\r\n");
      out.write("    if(f.files && f.files[0]){\r\n");
      out.write("    \tvar reader = new FileReader();\r\n");
      out.write("    \t//파일 읽기 메소드 호출. 읽기완료하면 onload에 등록된 함수를 호출\r\n");
      out.write("    \treader.readAsDataURL(f.files[0]);\r\n");
      out.write("    \treader.onload = function(){\r\n");
      out.write("    \t\t//result속성에는 파일 컨텐츠가 담겨있음.\r\n");
      out.write("    \t\t$(\"#img-viewer\").attr(\"src\", reader.result);\r\n");
      out.write("    \t}\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<form name=\"checkIdDuplicateFrm\" method=\"post\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"email\" />\r\n");
      out.write("</form>\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath() );
      out.write("/user/passwordUpdate\" onsubmit=\"return passwordCheck();\">\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\t\n");
      out.write("<div class=\"column\" id=\"space\"></div>\r\n");
      out.write("\r\n");
      out.write("<form name=\"userUpdateFrm\" method=\"post\" enctype=\"multipart/form-data\" action=\"");
      out.print(request.getContextPath());
      out.write("/user/userUpdate\">\r\n");
      out.write("<div class=\"ui grid centered\">\r\n");
      out.write("\t\r\n");
      out.write("  \t\t<div class=\"four wide column\" id=\"profile-img\">\r\n");
      out.write("    \t\t<div class=\"column\">\r\n");
      out.write("\t\t\t\t<div class=\"ui card\">\r\n");
      out.write("\t\t\t\t  \t<a class=\"image\" href=\"#\">\r\n");
      out.write("\t\t\t\t  \t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/upload/profile/Yondu.png\" id=\"img-viewer\" width=350 />\r\n");
      out.write("\t\t\t\t\t<input type=\"file\" name=\"upFile\" id=\"profile-img-change-btn\" onchange=\"loadImg(this)\"/>\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t  \t</a>\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- 사용자가 첨부파일관련해서 아무런 수정도 하지 않은경우 -->\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"originalFileNameOld\" value=\"");
      out.print(user.getOriginalFile()!=null?user.getOriginalFile():"");
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"renamedFileNameOld\" value=\"");
      out.print(user.getRenamedFile()!=null?user.getRenamedFile():"");
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- 사용자가 업로드한 첨부파일을 삭제하는 경우 -->\r\n");
      out.write("\t\t\t\t\t");
if(user.getOriginalFile()!=null) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t<div id=\"profile-img-delete\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" name=\"delFile\" id=\"delFile\" />\r\n");
      out.write("\t\t\t\t\t\t<label for=\"delFile\">사진삭제</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"content\">\r\n");
      out.write("\t\t   \t \t\t\t<a class=\"header\" href=\"#\">");
      out.print(user.getUserName());
      out.write("</a>\r\n");
      out.write("\t\t  \t \t\t\t<div class=\"meta\">\r\n");
      out.write("\t\t  \t \t\t\t\t");
if("U".equals(user.getStatus())) {
      out.write("\r\n");
      out.write("\t\t     \t\t\t\t<a>일반 회원</a>\r\n");
      out.write("\t\t     \t\t\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t     \t\t\t\t<a>관리자</a>\r\n");
      out.write("\t\t     \t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t   \t \t\t\t</div>\r\n");
      out.write("\t\t  \t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t \t<div class=\"five wide column\">\r\n");
      out.write("\t\t\t<h2 class=\"ui icon header\" id=\"topimg\">\r\n");
      out.write("\t\t  \t<i class=\"settings icon\"></i>\r\n");
      out.write("\t\t  \t<div class=\"content\">\r\n");
      out.write("\t\t    Account Settings\r\n");
      out.write("\t\t    \t<div class=\"sub header\">");
      out.print(user.getUserName());
      out.write("회원님의 개인정보 수정 및 회원 탈퇴가 가능합니다</div>\r\n");
      out.write("\t\t \t</div>\r\n");
      out.write("\t\t \t</h2>\r\n");
      out.write("\t\t\t<div class=\"ui input\" id=\"email-div\">\r\n");
      out.write("\t\t\t\t<label class=\"email-title\">이메일</label>\r\n");
      out.write("\t\t\t \t<input type=\"email\" name=\"email\" value=\"");
      out.print(user.getEmail());
      out.write("\" required readonly class=\"email-input-bar\"/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <div class=\"ui input\" id=\"name-div\">\r\n");
      out.write("\t\t    <label class=\"name-title\">이름</label>\r\n");
      out.write("\t\t    <input type=\"text\" name=\"name\" value=\"");
      out.print(user.getUserName());
      out.write("\" required />\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <div class=\"ui input\" id=\"phone-div\">\r\n");
      out.write("\t\t    <label class=\"phone-title\">전화 번호</label>\r\n");
      out.write("\t\t    <input type=\"text\" name=\"phone\" id=\"phone\" value=\"");
      out.print(user.getPhone());
      out.write("\" required class=\"phone-input-bar\">\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <div class=\"blue ui buttons\" id=\"submit-button\">\r\n");
      out.write("\t\t\t  <button type=\"submit\" class=\"ui button active\" onclick=\"updateUser();\" id=\"update-button\"><i class=\"edit icon\"></i>회원정보수정</button>\r\n");
      out.write("\t\t\t  <button type=\"button\" class=\"ui button\" onclick=\"updatePassword();\" id=\"password-button\"><i class=\"file powerpoint outline icon\"></i>비밀번호 변경</button>\r\n");
      out.write("\t\t\t  <button type=\"button\" class=\"ui button\" onclick=\"deleteUser();\" id=\"delete-button\"><i class=\"trash alternate outline icon\"></i>회원 탈퇴</button>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</form>\r\n");

if(userLoggedIn.getRenamedFile()!=null){

      out.write("\r\n");
      out.write("<input type=\"hidden\" value=\"");
      out.print(userLoggedIn.getRenamedFile());
      out.write("\" id=\"getFile\"/>\t\r\n");
} 
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("if($('#getFile').val()){\r\n");
      out.write("$(\"#img-viewer\").attr(\"src\", \"");
      out.print(request.getContextPath());
      out.write("/upload/profile/\"+$('#getFile').val());\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"ui menu\" style=\"position:absolute; background-color:#68b30d; height:2.5rem; bottom:0; width:100%\">\r\n");
      out.write("  <div style=\"position:absolute; left:34%; top:6px; width:1024px;\">\r\n");
      out.write("    <p style=\"font-size:17px;\">&lt;Copyright 2019. Team Thanos. All rights reserved.&gt;</p>\r\n");
      out.write("  </div>");
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
