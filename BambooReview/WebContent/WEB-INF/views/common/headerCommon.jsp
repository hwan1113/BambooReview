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
		<header style="height:130px">
			<nav>
				<ul class="main-nav">
					<li class="home"><a href="<%=request.getContextPath()%>/admin/adminList">관리자 페이지</a></li>
					<li class="notice"><a href="<%=request.getContextPath()%>/price/priceInfo">가격정보</a></li>
					<li class="board"><a href="<%=request.getContextPath()%>/user/userInfo">내 정보보기</a></li>
					<li class="board"><a href="<%=request.getContextPath()%>/user/userLogin">로그인</a></li>
				</ul>
				</nav>
		</header>
	</div>