<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="member.model.vo.*" %> --%>
<%
	//세션객체로부터 저장된 로그인사용자정보 가져오기
	/* Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn"); */

	//쿠키관련 처리
	Cookie[] cookies = request.getCookies();
	boolean saveIdFlag = false;
	String memberId = "";
	
	if(cookies != null){
		//System.out.println("-----------------------------");
		for(Cookie c: cookies){
			String key = c.getName();
			String value = c.getValue();
			//System.out.println(key+"="+value);
			
			if("saveId".equals(key)){
				saveIdFlag = true;
				memberId = value;
			}
			
		}
		//System.out.println("-----------------------------");		
	}
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" />
<script src="<%=request.getContextPath()%>/js/jquery-3.4.0.js"></script>
<script>
/*
 * 로그인 유효성검사 함수
 */
function loginValidate(){
	if($("#memberId").val().trim().length == 0){
		alert("아이디를 입력하세요.");
		$("#memberId").focus();
		return false;
	}
	
	if($("#password").val().trim().length == 0){
		alert("비밀번호를 입력하세요.");
		$("#password").focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>
	<div id="container">
		<header>
			<nav>
				<ul class="main-nav">
					<li class="home"><a href="<%=request.getContextPath()%>/admin/adminList">관리자 페이지</a></li>
					<li class="notice"><a href="<%=request.getContextPath()%>/price/priceInfo">가격정보</a></li>
					<li class="board"><a href="<%=request.getContextPath()%>/member/memberInfo">내 정보보기</a></li>
					<li class="board"><a href="<%=request.getContextPath()%>/member/memberLoggedIn">로그인</a></li>
					
					<%-- <!-- 관리자인 경우, 관리자메뉴(회원관리)추가 -->
					<%if(memberLoggedIn!=null && "admin".equals(memberLoggedIn.getMemberId())){ %>
					<li class="admin"><a href="<%=request.getContextPath()%>/admin/memberList">회원관리</a></li>					 --%>
					
				<%-- 	<%} %> --%>
				</ul>
			</nav>
			
			<!-- 메인메뉴 끝-->
			
		</header>
		
		<section id="content">