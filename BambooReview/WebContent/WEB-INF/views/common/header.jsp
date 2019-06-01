<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.model.vo.*" %>
<%@ page import="javax.servlet.http.*" %>
<%
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
%>
<!DOCTYPE html>
<html>
<head>
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
 		<a class="item right" href="<%=request.getContextPath()%>/price/priceInfo">
   			가격정보
  		</a>
  		<a class="item" href="<%=request.getContextPath()%>/user/userLogin">
    		로그인
  		</a>
 		<%} else{%>
 			<a class="item right" href="<%=request.getContextPath()%>/admin/adminList">
  				 관리자페이지
 			</a>	
 			<a class="item" href="<%=request.getContextPath()%>/user/userInfo">
   				내 정보 보기
  			</a>
  			<a class="item" href="<%=request.getContextPath()%>/price/priceInfo">
   				가격정보
  			</a>
  			<a class="item" href="<%=request.getContextPath()%>/user/userLogout">
    			로그아웃하기
  			</a>
 		<%} %>
</div>
