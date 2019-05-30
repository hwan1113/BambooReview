<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/header.css" />
<!-- <link rel="stylesheet" href="slider.css"> -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.css"/>
</head>
<body>
	<div id="container">
		<header>
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

	<!-- 	<nav class="navbar navbar-expand-lg navbar-light bg-light" >
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="#">Features</a>
      <a class="nav-item nav-link" href="#">Pricing</a>
      <a class="nav-item nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
    </div>
  </div>
</nav> -->
</body>