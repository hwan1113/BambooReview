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
		<header>
			<nav>
				<ul class="main-nav">
					<li class="home"><a href="<%=request.getContextPath()%>/admin/adminList">관리자 페이지</a></li>
					<li class="notice"><a href="<%=request.getContextPath()%>/price/priceInfo">가격정보</a></li>
					<li class="board"><a href="<%=request.getContextPath()%>/member/memberInfo">내 정보보기</a></li>
					<li class="board"><a href="<%=request.getContextPath()%>/user/userLogin">로그인</a></li>
				</ul>
				</nav>
		</header>
	</div>