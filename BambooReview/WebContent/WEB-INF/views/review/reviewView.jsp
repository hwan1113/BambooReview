<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ page import="review.model.vo.*, java.util.*, review.model.service.* " %>
<%
    Review r = (Review)request.getAttribute("review");
	String hotelName = (String)request.getAttribute("hotelName");
	String hotelId = (String)request.getAttribute("hotelId");
%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/review.css" />
<section id="review-container">
<h2><%=hotelName %>의 리뷰 게시판</h2>
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
            <!-- <input type="button" id="like" value="좋아요" class="btn btn-primary"
            	   onclick="likeCnt();"/> --> 
            	   <%-- onclick="location.href='<%=request.getContextPath()%>/review/reviewLike?reviewNo=<%=r.getReviewNo()%>';"/> --%>
            <form id="like_form" action="<%=request.getContextPath()%>/review/reviewLikeCnt"/> 
    			<table id="list"> 
    				<input type="hidden" name="command" value="likeCnt">
    				<input type="hidden" name="customerNo" value="<%=userLoggedIn.getCustomer_no()%>">  
    				<input type="hidden" name="reviewNo" value="<%=r.getReviewNo()%>"> 
    				<tr><input type="button" value="좋아요!" class="btn btn-primary" onclick="return like()" > </tr> 
    				<tr><div id="like_result"><%=r.getLikeCnt() %></div> </tr> 
    			</table> 
    		</form>
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
            	   onclick="location.href='<%=request.getContextPath()%>/review/reviewUpdate?reviewNo=<%=r.getReviewNo()%>&hotelName=<%=hotelName%>'"/>
            <input type="button" value="삭제하기" class="btn btn-warning" onclick="deleteReview();"/>
        </th>
    </tr>
    <tr>
    	<th>
    		<button type="button" class="btn btn-link"
    				onclick="location.href='<%=request.getContextPath()%>/review/reviewList?hotelname=<%=hotelName %>&hotelid=<%=hotelId%>'">목록으로</button>
    	</th>
    </tr>
    
    <%} %>	
</table>
</section>

<% if(userLoggedIn != null &&
    		((userLoggedIn.getCustomer_no() == r.getCustomerNo())
    		|| "A".equals(userLoggedIn.getStatus()))) {%>
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
</script>

<%} %>

<script>

function like(){ 
		$.ajax({ 
			url: "<%=request.getContextPath()%>/review/reviewLikeCnt", 
			type: "POST", 
			cache: false, 
			dataType: "json", 
			data: $('#like_form').serialize(), //아이디가 like_form인 곳의 모든 정보를 가져와 파라미터 전송 형태(표준 쿼리형태)로 만들어줌 
			success: 
				function(data){ //ajax통신 성공시 넘어오는 데이터 통째 이름 =data 
					if (data.result == "0"){
						alert("이미 좋아요를 누르셨어요");
					}
					else{
						alert("좋아요");
					}
					$("#like_result").html(data.like); //id값이 like_result인 html을 찾아서 data.like값으로 바꿔준다. 
				}, 
			error: 
				function (request, status, error){ 
				alert("ajax실패");
				console.log(request);
				console.log(status);
				console.log(error);
			} 
		}
	}); 
}
</script>

