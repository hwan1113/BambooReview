<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.model.vo.*, review.model.service.*, review.model.vo.*" %>
<%@ page import="javax.servlet.http.*" %>
<%
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
%>
<!DOCTYPE html>
<html>
<head>
 <script>
(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
})(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
ga('create', 'UA-128561305-2', 'auto');

if (document.location.pathname.indexOf('/user') > -1 ||
		document.location.pathname.indexOf('/price') > -1 ||
		document.location.pathname.indexOf('/review') > -1 ||
		document.location.pathname.indexOf('/hotel') > -1) {
	  var pathArr = document.location.pathname.split('/');

	  var page = "/"+pathArr[1]+"/"+pathArr[2];


	  // Sets the page value on the tracker.
	  ga('set', 'page', page);

	  // Sending the pageview no longer requires passing the page
	  // value since it's now stored on the tracker object.
	  ga('send', 'pageview');
	}
ga('send', 'pageview');
</script>
<meta charset="UTF-8">
  <!-- 시맨틱 UI -->
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.css"/>
 <!----------------------------------------------->  
 
 <!--------------------JQuery--------------------------->
 <script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
  <!----------------------------------------------->
 
  <!--bootstrap-->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <!----------------------------------------------->
  
</head>
<div class="ui menu" style="background-color:#68b30d; opacity: 0.8;">

  		<div class="header item">
    		<a href="<%=request.getContextPath()%>" class="home-logo"><img style= "height:85px"src="<%=request.getContextPath()%>/images/bambooHeader.png"></a>
 		</div>
 		
 		
 		<%if(userLoggedIn==null){%>
 		<a data-event-category="User"
  			data-event-action="Price" class="item right" href="<%=request.getContextPath()%>/price/priceInfo">
   			가격정보
  		</a>
  		<a data-event-category="User"
  			data-event-action="signout" class="item" href="<%=request.getContextPath()%>/user/userLogin">
    		로그인
  		</a>
 		<%} else if(userLoggedIn!=null && "admin@naver.com".equals(userLoggedIn.getEmail())){%>
 			<a class="item right" href="<%=request.getContextPath()%>/admin/adminList">
  				 관리자페이지
 			</a>		
 			<a class="item" href="<%=request.getContextPath()%>/user/userView?email=<%=userLoggedIn.getEmail()%>">
   				내 정보 보기
  			</a>
  			<a class="item" href="<%=request.getContextPath()%>/price/priceInfo">
   				가격정보
  			</a>
  			<a class="item" href="<%=request.getContextPath()%>/user/userLogout">
    			로그아웃하기
  			</a>
 		<%}else{%>
 		<a class="item right" href="<%=request.getContextPath()%>/admin/adminList" style="visibility:hidden;" id="admin-board">
  				 관리자페이지
 			</a>		
 			<a class="item" href="<%=request.getContextPath()%>/user/userView?email=<%=userLoggedIn.getEmail()%>">
   				내 정보 보기
  			</a>
  			<a class="item" href="<%=request.getContextPath()%>/price/priceInfo">
   				가격정보
  			</a>
  			<a class="item" href="<%=request.getContextPath()%>/user/userLogout">
    			로그아웃하기
  			</a>
 		<%}%>
 
</div>
