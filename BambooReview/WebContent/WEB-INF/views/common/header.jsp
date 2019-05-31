<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/header.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.css"/>
</head>
<body style="width:1024px;" align="center" id="listbody">
	<div id="container">
	<% String LoggedIn=null;%>
		<header>
		<% if(LoggedIn == null){ %>
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
					<li class="board" id="logout-button"><a href="<%=request.getContextPath()%>/user/userLogout">로그아웃</a></li>
				</ul>
				</nav>
		</header>
	</div>