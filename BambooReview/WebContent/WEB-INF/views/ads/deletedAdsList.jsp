<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ page import="review.model.vo.*, java.util.*, review.model.service.* " %>
<%
    Review r = (Review)request.getAttribute("review");
	List<ReviewComment> commentList = (List<ReviewComment>)request.getAttribute("commentList");
	String hotelName = (String)request.getAttribute("hotelName");
	String hotelId = (String)request.getAttribute("hotelId");
%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/review.css" />
<div class="ui centered grid">
	<div class="area">
		<section id="review-container">

		<%-- <h2><%=hotelName %>의 리뷰 게시판</h2> --%>

        <h3><%=r.getReviewTitle() %></h3>

    	<div class="ui olive segment">
	    	<div class="ui grid">
		  		<div class="four column row">
		    		<div class="left floated column"><%=r.getReviewWriter() %>님
		    		</div>
		    		<div class="right floated column">
			    		<i class="eye icon"></i>
			    		<%=r.getReadCnt() %>
			    		<i class="thumbs up outline icon"></i>
			    		<%=r.getLikeCnt()%>
			    		<i class="thumbs down outline icon"></i>
			    		<%=r.getDisLikeCnt()%>
			    	</div>
		 	 	</div>
  			</div>
	 		 <div class="ui green segment" style="height:355px; overflow:scroll;">
	  			<div class="ui grid">
	  				<div class=reviewContent><%=r.getReviewContent()%></div>
	  			</div>
	  		</div>

</section>
	
		
<%@ include file="/WEB-INF/views/common/footer.jsp" %>