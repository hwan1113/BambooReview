<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="review.model.vo.Review, review.model.service.*, java.util.*" %>
<%
	List<Review> list = (List<Review>)request.getAttribute("list");
	String pageBar = (String)request.getAttribute("pageBar");
	String userName = "";
	ReviewService reviewService = new ReviewService();

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
			<td><%= userName = (String)reviewService.getUserName(r.getCustomerNo()) %></td>
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