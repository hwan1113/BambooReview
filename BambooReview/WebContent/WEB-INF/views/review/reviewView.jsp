<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ page import="review.model.vo.*, java.util.*, review.model.service.* " %>
<%
    Review r = (Review)request.getAttribute("review");
	
	/* List<reviewComment> commentList = (List<reviewComment>)request.getAttribute("commentList"); */
	//System.out.println("commentList@jsp="+commentList);
%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/review.css" />
<section id="review-container">
<h2>리뷰 게시판</h2>
<table id="tbl-review-view">
    <tr>
        <th>글번호</th>
        <td><%=r.getReviewNo() %></td>
    </tr>
    <tr>
        <th>제 목</th>
        <td><%=r.getReviewTitle() %></td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><%=r.getReviewWriter() %></td>
    </tr>
    <tr>
        <th>조회수</th>
        <td><%=r.getReadCnt() %></td>
    </tr>
    <tr>
        <th>내 용</th>
        <td><%=r.getReviewContent()%></td>
    </tr>
    <tr>
        <th>좋아요</th>
        <td><%=r.getLikeCnt()%></td>
    </tr>
    <tr>
        <th>신고수</th>
        <td><%=r.getDisLikeCnt()%></td>
    </tr>
  	<tr>
        <th colspan="2">
            <input type="button" id="like" value="좋아요" class="btn btn-primary"
            	   onclick="likeCnt();"/> 
            	   <%-- onclick="location.href='<%=request.getContextPath()%>/review/reviewLike?reviewNo=<%=r.getReviewNo()%>';"/> --%>
            <input type="button" id="disLike" value="신고하기" class="btn btn-danger"
            	   onclick="location.href='<%=request.getContextPath()%>/review/reviewDisLike?reviewNo=<%=r.getReviewNo()%>';"/>
        </th>
    </tr>
    
    <%--글작성자/관리자인경우 수정삭제 가능 --%>
    <% if(userLoggedIn != null &&
    		((userLoggedIn.getCustomer_no() == r.getCustomerNo())
    		|| "A".equals(userLoggedIn.getStatus()))) {%>
    <tr>
        <th colspan="2">
            <input type="button" value="수정하기" class="btn btn-success"
            	   onclick="location.href='<%=request.getContextPath()%>/review/reviewUpdate?reviewNo=<%=r.getReviewNo()%>';"/>
            <input type="button" value="삭제하기" class="btn btn-warning" onclick="deleteReview();"/>
        </th>
    </tr>
    
    <%} %>	
</table>
</section>

<% if(userLoggedIn!=null && 
        (r.getCustomerNo() == (userLoggedIn.getCustomer_no())
        || "A".equals(userLoggedIn.getStatus())) ){ %>
<form action="<%=request.getContextPath()%>/review/reviewDelete"
	  id="reviewDelFrm"
	  method="post">
	<input type="hidden" name="reviewNo" value="<%=r.getReviewNo()%>"/>
</form>

<script>
function deleteReview(){
	if(!confirm("이 게시글을 정말 삭제 하시겠습니까?")){
		return;
	}
	//폼을 사용해서 삭제요청
	$("#reviewDelFrm").submit();
}

function likeCnt(){
	return <%=r.getLikeCnt()%>+1;
}

function disLikeCnt(){
	service.increaseDisLikeCount(r.getReviewNo());
}

</script>

<%} %>