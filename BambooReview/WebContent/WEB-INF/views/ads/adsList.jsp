<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ads.model.vo.Ads, ads.model.service.*, java.util.*" %>
<%
	List<Ads> list = (List<Ads>)request.getAttribute("list");
	String pageBar = (String)request.getAttribute("pageBar");
%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>	
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/review.css" />		
<section id="review-container">
  	<div class="ui three column centered grid">
	  	<div class="three column row">
	  		<div class="column"></div> 
	    	<div class="column"><h2 style="text-align:center;">광고 목록</h2></div>
			<div class="right floated column">
			</div>
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
		    <% for(Ads r : list){ %>
			<tr>
				<td><%= r.getAdsNo() %></td>
				<td><%= r.getAdsWriter() %></td>
				<td>
					<a href="<%=request.getContextPath() %>/review/reviewView?reviewNo=<%= r.getAdsNo()%>"><%= r.getAdsTitle() %></a>
				</td>
				<td style="text-align:center;"><%= r.getWrittenDate() %></td>
				<td style="text-align:center;"><%=r.getReadCnt() %></td>
				<td style="text-align:center;"><%=r.getLikeCnt() %></td>
				<td style="text-align:center;"><%=r.getDisLikeCnt() %></td>
			</tr>
			<% } 
				if(list.size() < 1) {%>
				<tr>
				<td style="text-align:center;" colspan="7">등록된 광고가 없습니다.
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
	<!-- 글쓰기 권한은 사업자회원과 관리자만 가능 -->
	<% if(userLoggedIn != null &&
		    		("B".equals(userLoggedIn.getStatus())
		    		|| "A".equals(userLoggedIn.getStatus()))) {%>
	<button  id="btn-add" class="ui olive button" 
		style="float:right; background-color:#68b30d"onclick="location.href='<%=request.getContextPath()%>/review/reviewForm?hotelName=<%=hotelName %>&hotelid=<%=hotelid%>'"/><i class="pencil alternate icon"></i>글쓰기</button>
	
	</div>

</section>
	
		
<%@ include file="/WEB-INF/views/common/footer.jsp" %>