<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="review.model.vo.Review, review.model.service.*, java.util.*" %>
<%
	List<Review> list = (List<Review>)request.getAttribute("list");
	String pageBar = (String)request.getAttribute("pageBar");
	String hotelName = (String)request.getAttribute("hotelName");

%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>	
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/review.css" />		
<section id="review-container">
	<h2><%=hotelName %>의 리뷰 게시판</h2>
		<input type="button" value="글쓰기" 
			   id="btn-add"
			   onclick="location.href='<%=request.getContextPath()%>/review/reviewForm'"/>
	<table id="tbl-review">
		<tr>
			<!-- <th>번호</th> -->
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>추천수</th>
			<th>신고수</th>
		</tr>
		<% for(Review r : list){ %>
		<tr>
			<%-- <td><%= r.getReviewNo() %></td> --%>
			<td>
				<a href="<%=request.getContextPath() %>/review/reviewView?reviewNo=<%= r.getReviewNo() %>">
					<%= r.getReviewTitle() %>
				</a>
			</td>
			<td><%= r.getReviewWriter() %></td>
			<td><%= r.getWrittenDate() %></td>
			
			<td><%=r.getReadCnt() %></td>
			<td><%=r.getLikeCnt() %></td>
			<td><%=r.getDisLikeCnt() %></td>
		</tr>
		<% } %>
		
	</table>
	
	<div id="pageBar">
		<%=pageBar %>
	</div>

<%-- ?hotelid=<%=HotelArr.getJSONObject(i).getString("id")%>"><%=HotelArr.getJSONObject(i).getString("name")%> --%>


</section>
	
		
<%@ include file="/WEB-INF/views/common/footer.jsp" %>