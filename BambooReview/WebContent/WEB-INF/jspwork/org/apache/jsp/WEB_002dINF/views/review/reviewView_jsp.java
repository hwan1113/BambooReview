/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.40
 * Generated at: 2019-06-10 14:46:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.review;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import user.model.vo.*;
import review.model.service.*;
import review.model.vo.*;
import ads.model.service.*;
import ads.model.vo.*;
import javax.servlet.http.*;
import review.model.vo.*;
import java.util.*;
import review.model.service.*;

public final class reviewView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1560151552529L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("user.model.vo");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("ads.model.vo");
    _jspx_imports_packages.add("review.model.service");
    _jspx_imports_packages.add("ads.model.service");
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
	AdsService adsService = new AdsService();
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
      out.write("\t  // Sets the page value on the tracker.\r\n");
      out.write("\t  ga('set', 'page', page);\r\n");
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
      out.write("/ads/adsList\">\r\n");
      out.write("   \t\t\t\t광고게시판\r\n");
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
      out.write("/ads/adsList\">\r\n");
      out.write("   \t\t\t\t광고게시판\r\n");
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
      out.write("gapi.load('auth2', function() {\r\n");
      out.write("\t  auth2 = gapi.auth2.init({\r\n");
      out.write("\t    client_id: '1048068622103-udnmctl1b1p2p8g9tqtcaflcb3c7p1e7.apps.googleusercontent.com',\r\n");
      out.write("\t    scope: 'email'\r\n");
      out.write("\t  }).then(()=>{\r\n");
      out.write("\t\t  console.log('fetched perfectly!')\r\n");
      out.write("\t\t  })\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("function signOut() {\r\n");
      out.write("   var auth2 = gapi.auth2.getAuthInstance();\r\n");
      out.write("   auth2.signOut().then(function () {\r\n");
      out.write("     console.log('User signed out.');\r\n");
      out.write("   });\r\n");
      out.write(" }\r\n");
      out.write(" </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");

    Review r = (Review)request.getAttribute("review");
	List<ReviewComment> commentList = (List<ReviewComment>)request.getAttribute("commentList");
	String hotelName = (String)request.getAttribute("hotelName");
	String hotelId = (String)request.getAttribute("hotelId");
	double avg = (double)r.getRateTotal() / r.getRateCnt();
	if(Double.isNaN(avg)){
		avg=0;
	}

      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("span.star-prototype, span.star-prototype > * {\r\n");
      out.write("    height: 16px; \r\n");
      out.write("    background: url(");
      out.print(request.getContextPath());
      out.write("/images/starImage.png) 0 -16px repeat-x;\r\n");
      out.write("    width: 80px;\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("span.star-prototype > * {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("    background-position: 0, 0;\r\n");
      out.write("    width:80px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/review.css\" />\r\n");
      out.write("<div class=\"ui centered grid\">\n");
      out.write("\t<div class=\"area\" style=\"width:750px; margin:0px 0px 14px 0px;\">\n");
      out.write("\t\t<section id=\"review-container\">\n");
      out.write("\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <h3>");
      out.print(r.getReviewTitle() );
      out.write("</h3>\r\n");
      out.write("\r\n");
      out.write("    \t<div class=\"ui olive segment\">\r\n");
      out.write("\t    \t<div class=\"ui grid\">\r\n");
      out.write("\t\t  \t\t<div class=\"four column row\" id=\"wwww\">\r\n");
      out.write("\t\t    \t\t<div class=\"left floated column\">");
      out.print(r.getReviewWriter() );
      out.write("님\r\n");
      out.write("\t\t    \t\t</div>\r\n");
      out.write("\t\t    \t\t평가 : <span class=\"star-prototype\">");
      out.print(avg );
      out.write("</span>");
      out.print(avg );
      out.write("\r\n");
      out.write("\t\t    \t\t<div class=\"right floated column\">\r\n");
      out.write("\t\t\t    \t\t<i class=\"eye icon\"></i>\r\n");
      out.write("\t\t\t    \t\t");
      out.print(r.getReadCnt() );
      out.write("\r\n");
      out.write("\t\t\t    \t\t<i class=\"thumbs up outline icon\"></i>\r\n");
      out.write("\t\t\t    \t\t");
      out.print(r.getLikeCnt());
      out.write("\r\n");
      out.write("\t\t\t    \t\t<i class=\"thumbs down outline icon\"></i>\r\n");
      out.write("\t\t\t    \t\t");
      out.print(r.getDisLikeCnt());
      out.write("\r\n");
      out.write("\t\t\t    \t</div>\r\n");
      out.write("\t\t \t \t</div>\r\n");
      out.write("  \t\t\t</div>\n");
      out.write("\t \t\t <div class=\"ui green segment\" style=\"height:1oo%; min-height:505px; text-align:center;\">\n");
      out.write("\t  \t\t\t<div class=\"ui grid\">\r\n");
      out.write("\t  \t\t\t\t<div class=reviewContent>");
      out.print(r.getReviewContent());
      out.write("</div>\r\n");
      out.write("\t  \t\t\t</div>\r\n");
      out.write("\t  \t\t</div>\r\n");
      out.write("\t      \t         <!-- 댓글 부분 -->\r\n");
      out.write("<hr style=\"margin-top:30px;\" />\r\n");
      out.write("\r\n");
      out.write("<div id=\"comment-container\">\r\n");
      out.write("\t<div class=\"comment-editor\">\r\n");
      out.write("\t\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/review/reviewCommentInsert\"\r\n");
      out.write("\t\t\t  name=\"reviewCommentFrm\"\r\n");
      out.write("\t\t\t  method=\"post\">\r\n");
      out.write("\t\t\t<textarea name=\"commentContent\" style=\"resize: none;\"\r\n");
      out.write("\t\t\t\t\t  cols=\"60\" rows=\"2\"></textarea>\r\n");
      out.write("\t\t\t<button type=\"submit\" id=\"btn-insert\">댓글쓰기</button>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"hotelId\" value=\"");
      out.print(hotelId);
      out.write("\"/>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"hotelName\" value=\"");
      out.print(hotelName);
      out.write("\"/>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"reviewNo\" value=\"");
      out.print(r.getReviewNo() );
      out.write("\" />  \r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"customerNo\" value=\"");
      out.print(userLoggedIn.getCustomer_no() );
      out.write("\" />\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"reviewCommentWriter\" value=\"");
      out.print(userLoggedIn!=null?userLoggedIn.getUserName():"");
      out.write("\" />\r\n");
      out.write("\t\t\t<!-- <input type=\"hidden\" name=\"reviewCommentLevel\" value=\"1\" /> -->\r\n");
      out.write("\t\t\t<!-- <input type=\"hidden\" name=\"reviewCommentRef\" value=\"0\" /> -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 댓글목록 테이블 -->\r\n");
      out.write("\t<div class=\"ui centered grid\">\r\n");
      out.write("\t<table id=\"tbl-comment\">\r\n");
      out.write("\t");
if(!commentList.isEmpty()) {
		for(ReviewComment bc: commentList){
	
      out.write("\r\n");
      out.write("\t\t\t<tr class=\"level1\">\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<sub class=\"comment-writer\">");
      out.print(userLoggedIn.getUserName() );
      out.write("</sub>\r\n");
      out.write("\t\t\t\t\t<sub class=\"comment-date\">");
      out.print(bc.getWrittenDate() );
      out.write("</sub>\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t");
      out.print(bc.getCommentContent() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t");
 if(userLoggedIn != null &&
						((userLoggedIn.getCustomer_no() == bc.getCustomerNo())
						|| "A".equals(userLoggedIn.getStatus()))) {
      out.write("\r\n");
      out.write("\t\t\t\t\t<button class=\"btn-delete\" value=\"");
      out.print(bc.getCommentNo());
      out.write("\">삭제</button>\r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t");
			
			}	
		}
	
      out.write("\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("       </div>\r\n");
      out.write("\n");
      out.write("           \t     ");
      out.write("\r\n");
      out.write("           \t     <div class=\"ui centered grid\">\r\n");
      out.write("\t  \r\n");
      out.write("\t\t\t\t\t  <div class=\"ui buttons\" id=\"like-form\">\r\n");
      out.write("\t\t\t\t\t \t\t<form id=\"like_form\" action=\"");
      out.print(request.getContextPath());
      out.write("/review/reviewLikeCnt?reviewNo=");
      out.print(r.getReviewNo());
      out.write("\">  \r\n");
      out.write("\t\t\t    \t\t\t\t<input type=\"hidden\" name=\"command\" value=\"likeCnt\"> \r\n");
      out.write("\t\t\t    \t\t\t\t<input type=\"hidden\" name=\"reviewNo\" value=\"");
      out.print(r.getReviewNo());
      out.write("\">\r\n");
      out.write("\t\t\t    \t\t\t\t<input type=\"hidden\" name=\"customerNo\" value=\"");
      out.print(userLoggedIn.getCustomer_no());
      out.write("\"> \r\n");
      out.write("\t\t\t    \t\t\t\t<button type=\"button\" class=\"btn btn-primary\" onclick=\"return like()\" style=\"height:100%;\"><i class=\"thumbs up outline icon\"></i>좋아요!</button>\r\n");
      out.write("\t\t\t\t    \t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t <div class=\"or\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t <form id=\"disLike_form\" action=\"");
      out.print(request.getContextPath());
      out.write("/review/reviewDisLikeCnt?reviewNo=");
      out.print(r.getReviewNo());
      out.write("\">  \r\n");
      out.write("\t\t\t    \t\t\t\t<input type=\"hidden\" name=\"command\" value=\"disLikeCnt\"> \r\n");
      out.write("\t\t\t    \t\t\t\t<input type=\"hidden\" name=\"reviewNo\" value=\"");
      out.print(r.getReviewNo());
      out.write("\">\r\n");
      out.write("\t\t\t    \t\t\t\t<input type=\"hidden\" name=\"customerNo\" value=\"");
      out.print(userLoggedIn.getCustomer_no());
      out.write("\"> \r\n");
      out.write("\t\t\t    \t\t\t\t<button type=\"button\" class=\"btn btn-danger\" onclick=\"return disLike()\" style=\"height:100%;\"><i class=\"thumbs down outline icon\"></i>신고하기</button>\r\n");
      out.write("\t\t\t\t    \t\t</form>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t  </div>\r\n");
      out.write("\t      \r\n");
      out.write("       \t\t\t</div>\r\n");
      out.write("       \t\t\t");
 if(userLoggedIn != null &&
		    		((userLoggedIn.getCustomer_no() == r.getCustomerNo())
		    		|| "A".equals(userLoggedIn.getStatus()))) {
      out.write("\r\n");
      out.write("\t\t    <div class=\"listbtn\">\r\n");
      out.write("\t\t    <tr>\r\n");
      out.write("\t\t        <th colspan=\"2\">\r\n");
      out.write("\t\t            <input type=\"button\" value=\"수정하기\" class=\"btn btn-success\"\r\n");
      out.write("\t\t            \t   onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/review/reviewUpdate?reviewNo=");
      out.print(r.getReviewNo());
      out.write("&hotelName=");
      out.print(hotelName);
      out.write("'\"/>\r\n");
      out.write("\t\t            <input type=\"button\" value=\"삭제하기\" class=\"btn btn-warning\" onclick=\"deleteReview();\"/>\r\n");
      out.write("\t\t        </th>\r\n");
      out.write("\t\t    </tr>\n");
      out.write("\t\t    ");
} 
      out.write("\r\n");
      out.write("\t\t    <input type=\"button\" value=\"목록으로\" class=\"btn btn-success\" style=\"background-color:#aacc19; border:1px solid #aacc19\"\r\n");
      out.write("\t\t           onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/review/reviewList?hotelName=");
      out.print(hotelName );
      out.write("&hotelId=");
      out.print(hotelId);
      out.write("'\"/>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t    ");
  //글작성자와 관리자가 아닌 사람만 평가가 가능
			if(userLoggedIn != null &&
				((userLoggedIn.getCustomer_no() != r.getCustomerNo())
					&& !"A".equals(userLoggedIn.getStatus()))) {
      out.write("\r\n");
      out.write("\t\t    <form id=\"rate_form\" action=\"");
      out.print(request.getContextPath());
      out.write("/review/reviewRate?reviewNo=");
      out.print(r.getReviewNo());
      out.write("\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"command\" value=\"rateCnt\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"command\" value=\"rateTotal\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"reviewNo\" value=\"");
      out.print(r.getReviewNo());
      out.write("\">\r\n");
      out.write("   \t\t\t\t<input type=\"hidden\" name=\"customerNo\" value=\"");
      out.print(userLoggedIn.getCustomer_no());
      out.write("\"> \r\n");
      out.write("   \t\t\t\t<select name=\"reviewRate\">\r\n");
      out.write("\t\t\t\t    <option value=\"\" disabled selected>점수선택</option>\r\n");
      out.write("\t\t\t\t    <option value=\"5\">아주 만족해요(5)</option>\r\n");
      out.write("\t\t\t\t    <option value=\"4\">만족해요(4)</option>\r\n");
      out.write("\t\t\t\t    <option value=\"3\">보통이에요(3)</option>\r\n");
      out.write("\t\t\t\t    <option value=\"2\">그냥 그래요(2)</option>\r\n");
      out.write("\t\t\t\t    <option value=\"1\">별로에요(1)</option>\t\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<button type=\"button\" onclick=\"return rate()\" >평가</button>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t");
} 
      out.write("\n");
      out.write("\t\t    </div>\n");
      out.write("\n");
      out.write("\t     </section>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("  \r\n");
      out.write("\t<div class=\"ui menu\" style=\" background-color:#68b30d; height:2.5rem; bottom:0; width:1024px; margin:0;\" id=\"footer\">\r\n");
      out.write("  <div style=\" left:34%; top:6px; width:1024px;text-align:center;\">\r\n");
      out.write("    <p style=\"font-size:17px;\">&lt;Copyright 2019. Team Thanos. All rights reserved.&gt;</p>\r\n");
      out.write("  </div>\r\n");
      out.write("\t</div>\r\n");
      out.write(" \r\n");
 if(userLoggedIn != null &&
		((userLoggedIn.getCustomer_no() == r.getCustomerNo())
		|| "A".equals(userLoggedIn.getStatus()))) {
      out.write("\r\n");
      out.write("\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/review/reviewDelete\"\r\n");
      out.write("\t\tid=\"reviewDelFrm\"\r\n");
      out.write("  \t\tmethod=\"post\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"reviewNo\" value=\"");
      out.print(r.getReviewNo());
      out.write("\"/>\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"hotelId\" value=\"");
      out.print(hotelId);
      out.write("\"/>\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"hotelName\" value=\"");
      out.print(hotelName);
      out.write("\"/>\r\n");
      out.write("\t</form>\r\n");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(function(){\r\n");
      out.write("\t//댓글 textarea focus시에 로그인여부확인\r\n");
      out.write("\t$(\"[name=boardCommentContent]\").focus(function(){\r\n");
      out.write("\t\tif(");
      out.print(userLoggedIn==null);
      out.write("){\r\n");
      out.write("\t\t\tloginAlert();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t//댓글폼 submit이벤트처리\r\n");
      out.write("\t$(\"[name=boardCommentFrm]\").submit(function(e){\r\n");
      out.write("\t\t//로그인여부검사\r\n");
      out.write("\t\tif(");
      out.print(userLoggedIn==null);
      out.write("){\r\n");
      out.write("\t\t\tloginAlert();\r\n");
      out.write("\t\t\te.preventDefault();//기본행위인 submit을 하지 않는다.\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//댓글작성여부 검사\r\n");
      out.write("\t\tvar content = $(\"[name=reviewCommentContent]\").val().trim();\r\n");
      out.write("\t\tif(content.length == 0){\r\n");
      out.write("\t\t\talert(\"댓글을 작성해 주세요.\");\r\n");
      out.write("\t\t\te.preventDefault();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t//삭제버튼 클릭시\r\n");
      out.write("\t$(\".btn-delete\").click(function(){\r\n");
      out.write("\t\tif(!confirm(\"정말 삭제하시겠습니까?\")) return;\r\n");
      out.write("\t\t//삭제처리후 돌아올 현재게시판번호도 함께 전송함.\r\n");
      out.write("\t\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("/review/reviewCommentDelete?reviewNo=");
      out.print(r.getReviewNo());
      out.write("&del=\"+$(this).val()+\"&hotelName=");
      out.print(hotelName);
      out.write("&hotelId=");
      out.print(hotelId);
      out.write("\";\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function loginAlert(){\r\n");
      out.write("\talert(\"로그인 후 이용할 수 있습니다.\");\r\n");
      out.write("\t$(\"#memberId\").focus();\r\n");
      out.write("}\r\n");
      out.write("function deleteReview(){\r\n");
      out.write("\tif(!confirm(\"이 게시글을 정말 삭제 하시겠습니까?\")){\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t//폼을 사용해서 삭제요청\r\n");
      out.write("\t$(\"#reviewDelFrm\").submit();\r\n");
      out.write("}\r\n");
      out.write("function like(){ \n");
      out.write("\t$.ajax({ \r\n");
      out.write("\t\turl: \"");
      out.print(request.getContextPath());
      out.write("/review/reviewLikeCnt\", \r\n");
      out.write("\t\ttype: \"POST\",\r\n");
      out.write("\t\tdata: $('#like_form').serialize(), //아이디가 like_form인 곳의 모든 정보를 가져와 파라미터 전송 형태(표준 쿼리형태)로 만들어줌 \r\n");
      out.write("\t\tsuccess: \r\n");
      out.write("\t\t\tfunction(data){ //ajax통신 성공시 넘어오는 데이터 통째 이름 =data \r\n");
      out.write("\t\t\t\tif (data.result == \"0\"){\r\n");
      out.write("\t\t\t\t\talert(\"이미 좋아요를 누르셨어요.\");\r\n");
      out.write("\t\t\t\t\tlocation.reload();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\talert(\"이 글에 좋아요를 눌렀습니다.\");\r\n");
      out.write("\t\t\t\t} \r\n");
      out.write("\t\t\t}, \r\n");
      out.write("\t\terror: \r\n");
      out.write("\t\t\tfunction (request, status, error){ \r\n");
      out.write("\t\t\talert(\"ajax실패\");\r\n");
      out.write("\t\t\tconsole.log(request);\r\n");
      out.write("\t\t\tconsole.log(status);\r\n");
      out.write("\t\t\tconsole.log(error);\r\n");
      out.write("\t\t} \r\n");
      out.write("\t});\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function disLike(){ \r\n");
      out.write("\tif(!confirm(\"이 게시글을 정말 신고 하시겠습니까?\")){\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t$.ajax({ \r\n");
      out.write("\t\turl: \"");
      out.print(request.getContextPath());
      out.write("/review/reviewDisLikeCnt\", \r\n");
      out.write("\t\ttype: \"POST\",\r\n");
      out.write("\t\tdata: $('#disLike_form').serialize(), \r\n");
      out.write("\t\tsuccess: \r\n");
      out.write("\t\t\tfunction(data){ //ajax통신 성공시 넘어오는 데이터 통째 이름 =data \r\n");
      out.write("\t\t\t\tif (data.result == \"0\"){\r\n");
      out.write("\t\t\t\t\talert(\"이미 신고하기를 누르셨어요.\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\talert(\"이 글을 신고 하셨어요.\");\r\n");
      out.write("\t\t\t\t\tlocation.reload();\r\n");
      out.write("\t\t\t\t} \r\n");
      out.write("\t\t\t}, \r\n");
      out.write("\t\terror: \r\n");
      out.write("\t\t\tfunction (request, status, error){ \r\n");
      out.write("\t\t\talert(\"ajax실패\");\r\n");
      out.write("\t\t\tconsole.log(request);\r\n");
      out.write("\t\t\tconsole.log(status);\r\n");
      out.write("\t\t\tconsole.log(error);\r\n");
      out.write("\t\t} \r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("function rate(){\r\n");
      out.write("\t$.ajax({ \r\n");
      out.write("\t\turl: \"");
      out.print(request.getContextPath());
      out.write("/review/reviewRate\", \r\n");
      out.write("\t\ttype: \"POST\",\r\n");
      out.write("\t\tdata: $('#rate_form').serialize(), \r\n");
      out.write("\t\tsuccess: \r\n");
      out.write("\t\t\tfunction(data){ //ajax통신 성공시 넘어오는 데이터 통째 이름 =data \r\n");
      out.write("\t\t\t\tif (data.result == \"0\"){\r\n");
      out.write("\t\t\t\t\talert(\"이미 평가를 하셨어요.\");\r\n");
      out.write("\t\t\t\t\tlocation.reload();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\talert(\"평가해 주셔서 감사합니다.\");\r\n");
      out.write("\t\t\t\t\tlocation.reload();\r\n");
      out.write("\t\t\t\t} \r\n");
      out.write("\t\t\t}, \r\n");
      out.write("\t\terror: \r\n");
      out.write("\t\t\tfunction (request, status, error){ \r\n");
      out.write("\t\t\talert(\"ajax실패\");\r\n");
      out.write("\t\t\tconsole.log(request);\r\n");
      out.write("\t\t\tconsole.log(status);\r\n");
      out.write("\t\t\tconsole.log(error);\r\n");
      out.write("\t\t} \r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("$.fn.generateStars = function() {\r\n");
      out.write("return this.each(function(i,e){$(e).html($('<span/>').width($(e).text()*16));});\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("// 숫자 평점을 별로 변환하도록 호출하는 함수\r\n");
      out.write("$('.star-prototype').generateStars();\r\n");
      out.write("</script>\r\n");
      out.write("\n");
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
