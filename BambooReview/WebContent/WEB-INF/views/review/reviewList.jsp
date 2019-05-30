<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="review.model.vo.Review, java.util.*" %>
<%
	List<Review> list = (List<Review>)request.getAttribute("list");
	String pageBar = (String)request.getAttribute("pageBar");
	//header.jsp에 memberLoggedIn변수를 선언했으므로, 이 페이지에서는 선언할 필요 없음.
	//Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>	
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/review.css" />		
<section id="review-container">
	<h2>게시판</h2>
		<input type="button" value="글쓰기" 
			   id="btn-add"
			   onclick="location.href='<%=request.getContextPath()%>/review/reviewForm'"/>
	<table id="tbl-review">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>첨부파일</th>
			<th>조회수</th>
		</tr>
		<% for(Review r : list){ %>
		<tr>
			<td><%= r.getReviewNo() %></td>
			<td>
				<a href="<%=request.getContextPath() %>/review/reviewView?reviewNo=<%= r.getReviewNo() %>">
					<%= r.getReviewTitle() %>
				</a>
			</td>
			<td><%= r.getCustomerNo() %></td>
			<td><%= r.getWrittenDate() %></td>
			
			<td><%=r.getReadCnt() %></td>
		</tr>
		<% } %>
		
	</table>
	
	<div id="pageBar">
		<%=pageBar %>
	</div>




</section>
	
		
<%@ include file="/WEB-INF/views/common/footer.jsp" %>