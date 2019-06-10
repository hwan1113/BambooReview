<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="review.model.vo.Review, review.model.service.*, java.util.*" %>
<%
	List<Review> list = (List<Review>)request.getAttribute("list");
	String pageBar = (String)request.getAttribute("pageBar");
	String hotelName = (String)request.getAttribute("hotelName");
	String hotelid = (String)request.getAttribute("hotelId");
	String srchWord  = (String)request.getAttribute("srchWord");

%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>	
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/review.css" />		
<section id="review-container">
	<%-- <h2><%=hotelName %>의 리뷰 게시판</h2> --%>
  	<div class="ui three column centered grid">
	  	<div class="three column row">
	  		<div class="column"></div> 
	    	<div class="column"><h2 style="text-align:center;">리뷰 목록</h2></div>
			<div class="right floated column">
			</div>
	  	</div>
	 	<div class="ui breadcrumb">
		  <a href="<%=request.getContextPath()%>" class="section">Home</a>
		  <i class="right chevron icon divider"></i>
		  <a href="javascript:history.back();" class="section"
		  	 onclick=><%=srchWord %></a>
		  <i class="right arrow icon divider"></i>
	  	  <div class="active section"><%=hotelName %></div>
		</div>
	 </div>
	<table class="ui olive table">
		  <thead>
		    <tr>
		    	<th style="text-align:center; width:10%;">번호</th>
			    <th style="text-align:center; width:10%;">작성자</th>
			    <th style="width:40%; text-align:center">제목</th>
				<th style="text-align:center;">작성일</th>
				<th style="text-align:center;">조회수</th>
				<th style="text-align:center;">추천수</th>
				<th style="text-align:center;">신고수</th>
		    </tr>
		  </thead>
		  <tbody>
		    <% for(Review r : list){ %>
			<tr>
				<td><%= r.getReviewNo() %></td>
				<td><%= r.getReviewWriter() %></td>
				<td>
					<a href="<%=request.getContextPath() %>/review/reviewView?reviewNo=<%= r.getReviewNo()%>&hotelName=<%=hotelName%>&hotelId=<%=hotelid%>"><%= r.getReviewTitle() %></a>
				</td>
				<td style="text-align:center;"><%= r.getWrittenDate() %></td>
				<td style="text-align:center;"><%=r.getReadCnt() %></td>
				<td style="text-align:center;"><%=r.getLikeCnt() %></td>
				<td style="text-align:center;"><%=r.getDisLikeCnt() %></td>
			</tr>
			<% } 
				if(list.size() < 1) {%>
				<tr>
				<td style="text-align:center;" colspan="7">등록된 리뷰가 없습니다.
				</td>
				</tr>
				<%}%>
		  </tbody>
	</table>
	<div class="ui grid centered">
	<div class="seven wide column"></div>
	<div class="seven wide column"id="pageBar">
		<%=pageBar %>
	</div>
	<!-- 글쓰기 권한은 일반회원과 관리자만 가능 -->
	<% if(userLoggedIn != null &&
		    		("U".equals(userLoggedIn.getStatus())
		    		|| "G".equals(userLoggedIn.getStatus()))) {%>
	<button  id="btn-add" class="ui olive button" 
		style="float:right; background-color:#68b30d"
		onclick="location.href='<%=request.getContextPath()%>/review/reviewForm?hotelName=<%=hotelName %>&hotelId=<%=hotelid%>'">
		<i class="pencil alternate icon"></i>글쓰기</button>

	</div>
	<%} %>

</section>
	
		
<%@ include file="/WEB-INF/views/common/footer.jsp" %>