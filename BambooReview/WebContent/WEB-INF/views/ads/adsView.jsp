<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ page import="ads.model.vo.*, java.util.*, ads.model.service.* " %>
<%
    Ads ads = (Ads)request.getAttribute("ads");
	List<AdsComment> adsCommentList = (List<AdsComment>)request.getAttribute("adsCommentList");
	double avgRate = 1.5;
%>
<style>
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
#btn-insert{
	position:relative;
	top:-19px;
	width:70px;
	height:48px;
	right:4px;
	background-color:#02b502;
	border:1px solid black;
	color:white;
}
.btn-delete{
	width:50px;
	height:32px;
	background-color:red;
	color:white;
	border:1px solid gray;
	
}

</style>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/ads.css" />
<div class="ui centered grid">
	<div class="area" style="width:750px; margin:0px 0px 14px 0px;">
		<section id="ads-container">

        <h3><%=ads.getAdsTitle() %></h3>

    	<div class="ui olive segment">
	    	<div class="ui grid">
		  		<div class="four column row">
		    		<div class="left floated column"><%=ads.getAdsWriter() %>님
		    		</div>
		    		평가 : <span class="star-prototype"><%=avgRate%></span>(<%= avgRate%>)
		    		<div class="right floated column">
			    		<i class="eye icon"></i>
			    		<%=ads.getReadCnt() %>
			    		<i class="thumbs up outline icon"></i>
			    		<%=ads.getLikeCnt()%>
			    		<i class="thumbs down outline icon"></i>
			    		<%=ads.getDisLikeCnt()%>
			    	</div>
		 	 	</div>
  			</div>
  			<div>
  				주소: <span><%=ads.getSearchedAddress()+ " " +ads.getDetailedAddress() %></span>
  				편의시설: <span><%=ads.getFacilities() %></span>
  			</div>
	 		 <div class="ui green segment" style="height:100%; min-height:505px;  text-align:center;">
	  			<div class="ui grid">
	  				<div class=adsContent><%=ads.getAdsContent()%></div>
	  			</div>
	  		</div>
	  		<!-- 댓글 부분 -->
<hr style="margin-top:30px;" />

<div id="comment-container">
	<div class="comment-editor">
		<form action="<%=request.getContextPath()%>/ads/adsCommentInsert"
			  name="adsCommentFrm"
			  method="post">
			<textarea name="adsCommentContent"  style="resize: none;"
					  cols="60" rows="2"></textarea>
			<button type="submit" id="btn-insert">댓글쓰기</button>	  
			<input type="hidden" name="adsNo" value="<%=ads.getAdsNo() %>" />  
			<input type="hidden" name="customerNo" value="<%=userLoggedIn.getCustomer_no() %>" />
			<input type="hidden" name="adsCommentWriter" value="<%=userLoggedIn!=null?userLoggedIn.getUserName():""%>" />
		</form>
	</div>
	
	<!-- 댓글목록 테이블 -->
	<div class="ui centered grid">
	<table id="tbl-comment">
	<%if(!adsCommentList.isEmpty()) {
		for(AdsComment ac: adsCommentList){
	%>
			<tr class="level1">
				<td>
					<sub class="comment-writer"><%=userLoggedIn.getUserName() %></sub>
					<sub class="comment-date"><%=ac.getWrittenDate() %></sub>
					<br />
					<%=ac.getAdsCommentContent() %>
					
				</td>
				<td>
					<%-- 삭제버튼 추가 --%>
					<% if(userLoggedIn != null &&
						((userLoggedIn.getCustomer_no() == ac.getCustomerNo())
						|| "A".equals(userLoggedIn.getStatus()))) {%>
					<button class="btn-delete" value="<%=ac.getAdsCommentNo()%>">삭제</button>
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
          
	     </section>
	     <div class="ui centered grid">
	  
		  <div class="ui buttons" style="margin:25px;">
		 		<form id="like_form" action="<%=request.getContextPath()%>/ads/adsLikeCnt?adsNo=<%=ads.getAdsNo()%>">  
    				<input type="hidden" name="command" value="likeCnt"> 
    				<input type="hidden" name="adsNo" value="<%=ads.getAdsNo()%>">
    				<input type="hidden" name="customerNo" value="<%=userLoggedIn.getCustomer_no()%>"> 
    				<button type="button" class="btn btn-primary" onclick="return like()" style="height:100%;"><i class="thumbs up outline icon"></i>좋아요!</button>
	    		</form>
				 <div class="or"></div>
				 <form id="disLike_form" action="<%=request.getContextPath()%>/ads/adsDisLikeCnt?adsNo=<%=ads.getAdsNo()%>">  
    				<input type="hidden" name="command" value="disLikeCnt"> 
    				<input type="hidden" name="adsNo" value="<%=ads.getAdsNo()%>">
    				<input type="hidden" name="customerNo" value="<%=userLoggedIn.getCustomer_no()%>"> 
    				<button type="button" class="btn btn-danger" onclick="return disLike()" style="height:100%;"><i class="thumbs down outline icon"></i>신고하기</button>
	    		</form>
		  </div>
	      
       </div>
       
       
       
        	     <%--글작성자/관리자인경우 수정삭제 가능 --%>
		   <% if(userLoggedIn != null &&
		    		((userLoggedIn.getCustomer_no() == ads.getCustomerNo())
		    		|| "A".equals(userLoggedIn.getStatus()))) {%>
		    <tr>
		        <th colspan="2">
		            <input type="button" value="수정하기" class="btn btn-success"
		            	   onclick="location.href='<%=request.getContextPath()%>/ads/adsUpdate?adsNo=<%=ads.getAdsNo()%>'"/>
		            <input type="button" value="삭제하기" class="btn btn-warning" onclick="deleteAds();"/>
		        </th>
		    </tr>
		    <%} %>
		    <input type="button" value="목록으로" class="btn btn-success" style="background-color:#aacc19; border:1px solid #aacc19"
		           onclick="location.href='<%=request.getContextPath()%>/ads/adsList'"/>
		    
		    <%  //글작성자와 관리자가 아닌 사람만 평가가 가능
			if(userLoggedIn != null &&
				((userLoggedIn.getCustomer_no() != ads.getCustomerNo())
					&& !"A".equals(userLoggedIn.getStatus()))) {%>
		    <form id="rate_form" action="<%=request.getContextPath()%>/ads/adsRate?adsNo=<%=ads.getAdsNo()%>">
				<input type="hidden" name="command" value="rateCnt">
				<input type="hidden" name="command" value="rateTotal">
				<input type="hidden" name="adsNo" value="<%=ads.getAdsNo()%>">
   				<input type="hidden" name="customerNo" value="<%=userLoggedIn.getCustomer_no()%>"> 
   				<select name="adsRate">
				    <option value="" disabled selected>점수선택</option>
				    <option value="5">아주 만족해요(5)</option>
				    <option value="4">만족해요(4)</option>
				    <option value="3">보통이에요(3)</option>
				    <option value="2">그냥 그래요(2)</option>
				    <option value="1">별로에요(1)</option>
				</select>
				<button onclick="return rate()" >평가</button>
			</form>
			<%} %>
       
       
	</div>
</div>


	
	
</div>
<div class="ui menu" style="background-color:#68b30d; height:2.5rem; bottom:0; width:1024px; margin:0; text-align:center;">
		  <div style="left:34%; top:6px; width:1024px;">
		    <p style="font-size:17px;">&lt;Copyright 2019. Team Thanos. All rights reserved.&gt;</p>
  	</div>
<script>
$(function(){
	//댓글 textarea focus시에 로그인여부확인
	$("[name=adsCommentContent]").focus(function(){
		if(<%=userLoggedIn==null%>){
			loginAlert();
		}
	});
	
	//댓글폼 submit이벤트처리
	$("[name=adsCommentFrm]").submit(function(e){
		//로그인여부검사
		if(<%=userLoggedIn==null%>){
			loginAlert();
			e.preventDefault();//기본행위인 submit을 하지 않는다.
			return;
		}
		
		//댓글작성여부 검사
		var content = $("[name=adsCommentContent]").val().trim();
		if(content.length == 0){
			alert("댓글을 작성해 주세요.");
			e.preventDefault();
		}
		
	});

	
	//삭제버튼 클릭시
	$(".btn-delete").click(function(){
		if(!confirm("정말 삭제하시겠습니까?")) return;
		//삭제처리후 돌아올 현재게시판번호도 함께 전송함.
		location.href="<%=request.getContextPath()%>/ads/adsCommentDelete?adsNo=<%=ads.getAdsNo() %>&del="+$(this).val();
	});
	
	
});

function loginAlert(){
	alert("로그인 후 이용할 수 있습니다.");
}

</script>

<% if(userLoggedIn != null &&
		((userLoggedIn.getCustomer_no() == ads.getCustomerNo())
		|| "A".equals(userLoggedIn.getStatus()))) {%>
	<form action="<%=request.getContextPath()%>/ads/adsDelete"
		id="adsDelFrm"
  		method="post">
		<input type="hidden" name="adsNo" value="<%=ads.getAdsNo()%>"/>
	</form>
<%} %>

<script>

function deleteAds(){
	if(!confirm("이 게시글을 정말 삭제 하시겠습니까?")){
		return;
	}
	//폼을 사용해서 삭제요청
	$("#adsDelFrm").submit();
}
</script>
<script>
function like(){ 
	$.ajax({ 
		url: "<%=request.getContextPath()%>/ads/adsLikeCnt", 
		type: "POST",
		data: $('#like_form').serialize(), //아이디가 like_form인 곳의 모든 정보를 가져와 파라미터 전송 형태(표준 쿼리형태)로 만들어줌 
		success: 
			function(data){ //ajax통신 성공시 넘어오는 데이터 통째 이름 =data 
				if (data.result == "0"){
					alert("이미 좋아요를 누르셨어요.");
				}
				else{
					alert("이 글에 좋아요를 눌렀습니다.");
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
		url: "<%=request.getContextPath()%>/ads/adsDisLikeCnt", 
		type: "POST",
		data: $('#disLike_form').serialize(), 
		success: 
			function(data){ //ajax통신 성공시 넘어오는 데이터 통째 이름 =data 
				if (data.result == "0"){
					alert("이미 신고하기를 누르셨어요.");
				}
				else{
					alert("이 글을 신고 하셨어요.");
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
</script>

<%  //글작성자와 관리자가 아닌 사람만 평가가 가능
	if(userLoggedIn != null &&
		((userLoggedIn.getCustomer_no() != ads.getCustomerNo())
		&& !"A".equals(userLoggedIn.getStatus()))) {%>
<script>
function rate(){ 
	$.ajax({ 
		url: "<%=request.getContextPath()%>/ads/adsRate", 
		type: "POST",
		data: $('#rate_form').serialize(), 
		success: 
			function(data){ //ajax통신 성공시 넘어오는 데이터 통째 이름 =data 
				if (data.result == "0"){
					alert("이미 평가를 하셨어요.");
				}
				else{
					alert("평가해 주셔서 감사합니다.");
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
<% }%>
</script>
<script>
$.fn.generateStars = function() {
return this.each(function(i,e){$(e).html($('<span/>').width($(e).text()*16));});
};

// 숫자 평점을 별로 변환하도록 호출하는 함수
$('.star-prototype').generateStars();
</script>