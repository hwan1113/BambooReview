<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ page import="review.model.vo.*, java.util.*, review.model.service.* " %>
<%
    Review r = (Review)request.getAttribute("review");
	List<ReviewComment> commentList = (List<ReviewComment>)request.getAttribute("commentList");
	String hotelName = (String)request.getAttribute("hotelName");
	String hotelId = (String)request.getAttribute("hotelId");
	double avg = (double)r.getRateTotal() / r.getRateCnt();
	if(Double.isNaN(avg)){
		avg=0;
	}
	String srchWord = (String)request.getAttribute("srchWord");
%>
<style>
.reviewContent img{
	max-width: 100%;
}

span.star-prototype, span.star-prototype > * {
    height: 16px; 
    background: url(<%=request.getContextPath()%>/images/starImage.png) 0 -16px repeat-x;
    width: 80px;
    display: inline-block;
}
 
span.star-prototype > * {
	float: left;
    background-position: 0 0;
    width:80px; 
}

</style>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/review.css" />
<div class="ui centered grid">
	<div class="area" style="width:750px; margin:0px 0px 14px 0px;">
		<section id="review-container">

		<%-- <h2><%=hotelName %>의 리뷰 게시판</h2> --%>

        <h3><%=r.getReviewTitle() %></h3>

    	<div class="ui olive segment">
	    	<div class="ui grid">
		  		<div class="four column row" id="wwww">
		    		<div class="left floated column"><%=r.getReviewWriter() %>님
		    		</div>
		    		평가 : <span class="star-prototype"><%=avg %></span>(<%=String.format("%.2f", avg)%>)
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
	 		 <div class="ui green segment" style="height:1oo%; min-height:505px; text-align:center; ">
	  			<div class="ui grid">
	  				<div class=reviewContent><%=r.getReviewContent()%></div>
	  			</div>
	  		</div>
	  		  <%  //글작성자와 관리자가 아닌 사람만 평가가 가능
			if(userLoggedIn != null &&
				((userLoggedIn.getCustomer_no() != r.getCustomerNo())
					&& !"A".equals(userLoggedIn.getStatus()))) {%>
		    <form id="rate_form" action="<%=request.getContextPath()%>/review/reviewRate?reviewNo=<%=r.getReviewNo()%>">
				<input type="hidden" name="command" value="rateCnt">
				<input type="hidden" name="command" value="rateTotal">
				<input type="hidden" name="reviewNo" value="<%=r.getReviewNo()%>">
   				<input type="hidden" name="customerNo" value="<%=userLoggedIn.getCustomer_no()%>"> 
   				<select name="reviewRate">
				    <option value="" disabled selected>점수선택</option>
				    <option value="5">아주 만족해요(5)</option>
				    <option value="4">만족해요(4)</option>
				    <option value="3">보통이에요(3)</option>
				    <option value="2">그냥 그래요(2)</option>
				    <option value="1">별로에요(1)</option>	
				</select>
				<button class="ui button" onclick="return rate()" style="width:90px; height:30px; background-color:#d2ea1a;"><i class="star icon"></i>평가</button>
			</form>
			<%} %>
	      	         <!-- 댓글 부분 -->
<hr style="margin-top:10px;" />

<div id="comment-container">
	<div class="comment-editor">
		<form action="<%=request.getContextPath()%>/review/reviewCommentInsert"
			  name="reviewCommentFrm"
			  method="post">
			<textarea name="commentContent" style="resize: none;"
					  cols="60" rows="2"></textarea>
			<button type="submit" id="btn-insert">댓글쓰기</button>
			<input type="hidden" name="hotelId" value="<%=hotelId%>"/>
			<input type="hidden" name="hotelName" value="<%=hotelName%>"/>
			<input type="hidden" name="reviewNo" value="<%=r.getReviewNo() %>" />  
			<input type="hidden" name="customerNo" value="<%=userLoggedIn.getCustomer_no() %>" />
			<input type="hidden" name="reviewCommentWriter" value="<%=userLoggedIn!=null?userLoggedIn.getUserName():""%>" />
			<!-- <input type="hidden" name="reviewCommentLevel" value="1" /> -->
			<!-- <input type="hidden" name="reviewCommentRef" value="0" /> -->
		
		</form>
	</div>
	
	<!-- 댓글목록 테이블 -->
	<div class="ui centered grid">
	<table id="tbl-comment">
	<%if(!commentList.isEmpty()) {
		for(ReviewComment bc: commentList){
	%>
			<tr class="level1">
				<td>
					<sub class="comment-writer"><%=userLoggedIn.getUserName() %></sub>
					<sub class="comment-date"><%=bc.getWrittenDate() %></sub>
					<br />
					<%=bc.getCommentContent() %>
					
				</td>
				<td>
					<%-- 삭제버튼 추가 --%>
					<% if(userLoggedIn != null &&
						((userLoggedIn.getCustomer_no() == bc.getCustomerNo())
						|| "A".equals(userLoggedIn.getStatus()))) {%>
					<button class="btn-delete" value="<%=bc.getCommentNo()%>">삭제</button>
					<%} %>
				</td>
			</tr>
	<%			
			}	
		}
	%>
	</table>
	</div>
</div>
       </div>

           
           	     <div class="ui centered grid">
	  
					  <div class="ui buttons" id="like-form" style="margin-top:10px;">
					 		<form id="like_form" action="<%=request.getContextPath()%>/review/reviewLikeCnt?reviewNo=<%=r.getReviewNo()%>">  
			    				<input type="hidden" name="command" value="likeCnt"> 
			    				<input type="hidden" name="reviewNo" value="<%=r.getReviewNo()%>">
			    				<input type="hidden" name="customerNo" value="<%=userLoggedIn.getCustomer_no()%>"> 
			    				<button type="button" class="btn btn-primary" onclick="return like()" style="height:100%;"><i class="thumbs up outline icon"></i>좋아요!</button>
				    		</form>
							 <div class="or"></div>
							 <form id="disLike_form" action="<%=request.getContextPath()%>/review/reviewDisLikeCnt?reviewNo=<%=r.getReviewNo()%>">  
			    				<input type="hidden" name="command" value="disLikeCnt"> 
			    				<input type="hidden" name="reviewNo" value="<%=r.getReviewNo()%>">
			    				<input type="hidden" name="customerNo" value="<%=userLoggedIn.getCustomer_no()%>"> 
			    				<button type="button" class="btn btn-danger" onclick="return disLike()" style="height:100%;"><i class="thumbs down outline icon"></i>신고하기</button>
				    		</form>
			
					  </div>
	      
       			</div>
       			<% if(userLoggedIn != null &&
		    		((userLoggedIn.getCustomer_no() == r.getCustomerNo())
		    		|| "A".equals(userLoggedIn.getStatus()))) {%>
		    <div class="listbtn" style="position:relative; left:30px;">
		    <tr>
		        <th colspan="2">
		            <button class="btn btn-success" 
		            	   onclick="location.href='<%=request.getContextPath()%>/review/reviewUpdate?reviewNo=<%=r.getReviewNo()%>&hotelName=<%=hotelName%>&srchWord=<%=srchWord%>'"/>
		            	   <i class="edit icon"></i>수정하기</button>
		            <button class="btn btn-warning" onclick="deleteReview();"><i class="trash icon"></i>삭제하기</button>
		        </th>
		    </tr>
		    <%} %>
		 

		    
		    <button class="btn btn-success" style="background-color:#aacc19; position:relative; float:right; border:1px solid #aacc19; margin-bottom:15px;" 
		    onclick="location.href='<%=request.getContextPath()%>/review/reviewList?hotelName=<%=hotelName %>&hotelId=<%=hotelId%>&srchWord=<%=srchWord%>'"><i class="list icon"></i>목록</button>
		    
		  
		    </div>

	     </section>
	</div>
	
	
</div>
  
	<div class="ui menu" style=" background-color:#68b30d; height:2.5rem; bottom:0; width:1024px; margin:0;" id="footer">
  <div style=" left:34%; top:6px; width:1024px;text-align:center;">
    <p style="font-size:17px;">&lt;Copyright 2019. Team Thanos. All rights reserved.&gt;</p>
  </div>
	</div>
 
<% if(userLoggedIn != null &&
		((userLoggedIn.getCustomer_no() == r.getCustomerNo())
		|| "A".equals(userLoggedIn.getStatus()))) {%>
	<form action="<%=request.getContextPath()%>/review/reviewDelete"
		id="reviewDelFrm"
  		method="post">
		<input type="hidden" name="reviewNo" value="<%=r.getReviewNo()%>"/>
		<input type="hidden" name="hotelId" value="<%=hotelId%>"/>
		<input type="hidden" name="hotelName" value="<%=hotelName%>"/>
	</form>
<%} %>


<script>
$(function(){
	//댓글 textarea focus시에 로그인여부확인
	$("[name=boardCommentContent]").focus(function(){
		if(<%=userLoggedIn==null%>){
			loginAlert();
		}
	});
	
	//댓글폼 submit이벤트처리
	$("[name=boardCommentFrm]").submit(function(e){
		//로그인여부검사
		if(<%=userLoggedIn==null%>){
			loginAlert();
			e.preventDefault();//기본행위인 submit을 하지 않는다.
			return;
		}
		//댓글작성여부 검사
		var content = $("[name=reviewCommentContent]").val().trim();
		if(content.length == 0){
			alert("댓글을 작성해 주세요.");
			e.preventDefault();
		}
		
	});

	
	//삭제버튼 클릭시
	$(".btn-delete").click(function(){
		if(!confirm("정말 삭제하시겠습니까?")) return;
		//삭제처리후 돌아올 현재게시판번호도 함께 전송함.
		location.href="<%=request.getContextPath()%>/review/reviewCommentDelete?reviewNo=<%=r.getReviewNo()%>&del="+$(this).val()+"&hotelName=<%=hotelName%>&hotelId=<%=hotelId%>";
	});
	
	
});

function loginAlert(){
	alert("로그인 후 이용할 수 있습니다.");
	$("#memberId").focus();
}
function deleteReview(){
	if(!confirm("이 게시글을 정말 삭제 하시겠습니까?")){
		return;
	}
	//폼을 사용해서 삭제요청
	$("#reviewDelFrm").submit();
}
function like(){ 
	$.ajax({ 
		url: "<%=request.getContextPath()%>/review/reviewLikeCnt", 
		type: "POST",
		data: $('#like_form').serialize(), //아이디가 like_form인 곳의 모든 정보를 가져와 파라미터 전송 형태(표준 쿼리형태)로 만들어줌 
		success: 
			function(data){ //ajax통신 성공시 넘어오는 데이터 통째 이름 =data 
				if (data.result == "0"){
					alert("이미 좋아요를 누르셨어요.");
					location.reload();
				}
				else{
					alert("이 글에 좋아요를 눌렀습니다.");
					location.reload();
				} 
			}, 
		error: 
			function (request, status, error){ 
			alert("ajax실패");
			console.log(request);
			console.log(status);
			console.log(error);
		} 
	});
}

function disLike(){ 
	if(!confirm("이 게시글을 정말 신고 하시겠습니까?")){
		return;
	}
	$.ajax({ 
		url: "<%=request.getContextPath()%>/review/reviewDisLikeCnt", 
		type: "POST",
		data: $('#disLike_form').serialize(), 
		success: 
			function(data){ //ajax통신 성공시 넘어오는 데이터 통째 이름 =data 
				if (data.result == "0"){
					alert("이미 신고하기를 누르셨어요.");
					location.reload();
				}
				else{
					alert("이 글을 신고 하셨어요.");
					location.reload();
				} 
			}, 
		error: 
			function (request, status, error){ 
			alert("ajax실패");
			console.log(request);
			console.log(status);
			console.log(error);
		} 
	});
}
function rate(){
	$.ajax({ 
		url: "<%=request.getContextPath()%>/review/reviewRate", 
		type: "POST",
		data: $('#rate_form').serialize(), 
		success: 
			function(data){ //ajax통신 성공시 넘어오는 데이터 통째 이름 =data 
				if (data.result == "0"){
					alert("이미 평가를 하셨어요.");
					location.reload();
				}
				else{
					alert("평가해 주셔서 감사합니다.");
					location.reload();
				} 
			}, 
		error: 
			function (request, status, error){ 
			alert("ajax실패");
			console.log(request);
			console.log(status);
			console.log(error);
		} 
	});
}

$.fn.generateStars = function() {
return this.each(function(i,e){$(e).html($('<span/>').width($(e).text()*16));});
};

// 숫자 평점을 별로 변환하도록 호출하는 함수
$('.star-prototype').generateStars();
</script>

