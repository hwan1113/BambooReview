<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.model.vo.*" %>
<%@ page import="javax.servlet.*" %>
<%   
	User userLoggedIn = (User)session.getAttribute("userLoggedIn");
	Cookie[] cookies = request.getCookies();
	boolean saveIdFlag = false;
	String userId = "";
	if(cookies != null){
		for(Cookie c: cookies){
			String key = c.getName();
			String value = c.getValue();
			if("saveId".equals(key)){
				saveIdFlag = true;
				userId = value;
			}
		}
	}
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/header.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.css"/>
<meta name="google-signin-client_id" content="401915479611-85lnc5b082en3f07kq9jsd628oshv494.apps.googleusercontent.com">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>
</head>
<body>
	<div id="container">
		<% String LoggedIn=null;%>
		<header style="height:130px">
		<% if(userLoggedIn == null){ %>
			<style>
			.home{display:none;}
			#userinfo{display:none;}
			#logout-button{display:none;}
			</style>
		<% }
		//관리자로 로그인 한 경우
		else if(LoggedIn == "admin"){%>
			<style>
			#login-button{display:none;}
			</style>
		<%}	
		//일반 회원으로 로그인 한 경우
		else{%>
		<style>
		.home{display:none;}
		#login-button{display:none;}
		</style>
		<%}	%>
		<nav>
				<ul class="main-nav">
					<a href="<%=request.getContextPath()%>/" class="home-logo"><!-- <div class="home-logo"></div> --></a>
					<li class="home"><a href="<%=request.getContextPath()%>/admin/adminList">관리자 페이지</a></li>
					<li class="notice"><a href="<%=request.getContextPath()%>/price/priceInfo">가격정보</a></li>
					<li class="board" id="userinfo"><a href="<%=request.getContextPath()%>/user/userInfo">내 정보보기</a></li>
					<li class="board" id="login-button"><a href="<%=request.getContextPath()%>/user/userLogin">로그인/회원가입</a></li>
					<li class="board" id="logout-button"><a href="<%=request.getContextPath()%>/user/logout">로그아웃</a></li>
				</ul>
				</nav>
		
			
		</header>
	</div>
	<script>
	jQuery('#toggle').click(function () {  
	    if($("#id").css("display") == "none"){   
	        jQuery('#id').show();  
	    } else {  
	        jQuery('#id').hide();  
	    }  
	});  
	</script>