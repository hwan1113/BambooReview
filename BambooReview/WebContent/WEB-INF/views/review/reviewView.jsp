<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ page import="review.model.vo.*, java.util.* " %>
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
    <%--글작성자/관리자인경우 수정삭제 가능 --%>
    <% if(userLoggedIn!=null && 
        (r.getCustomerNo().equals(userLoggedIn.getCustomerNo())
        || "A".equals(userLoggedIn.getStatus())) ){ %>
    <tr>
        <th colspan="2">
            <input type="button" value="수정하기" 
            	   onclick="location.href='<%=request.getContextPath()%>/review/reviewUpdate?reviewNo=<%=r.getReviewNo()%>';"/>
            <input type="button" value="삭제하기" onclick="deletereview();"/>
        </th>
    </tr>
    
    <%} %>	
</table>
<%-- 
<hr style="margin-top:30px;" />

<div id="comment-container">
	<div class="comment-editor">
		<form action="<%=request.getContextPath()%>/review/reviewCommentInsert"
			  name="reviewCommentFrm"
			  method="post">
			<textarea name="reviewCommentContent" 
					  cols="60" rows="3"></textarea>
			<button type="submit" id="btn-insert">등록</button>	  
			<input type="hidden" name="reviewRef" value="<%=b.getreviewNo() %>" />  
			<input type="hidden" name="reviewCommentWriter" value="<%=userLoggedIn!=null?userLoggedIn.getCustomerNo():""%>" />
			<input type="hidden" name="reviewCommentLevel" value="1" />
			<input type="hidden" name="reviewCommentRef" value="0" />
		
		</form>
	</div>
	
	<!-- 댓글목록 테이블 -->
	<table id="tbl-comment">
	<%if(!commentList.isEmpty()) {
		for(reviewComment bc: commentList){
			if(bc.getreviewCommentLevel()==1){
	%>
			<!-- 댓글인경우 -->
			<tr class="level1">
				<td>
					<sub class="comment-writer"><%=bc.getreviewCommentWriter() %></sub>
					<sub class="comment-date"><%=bc.getreviewCommentDate() %></sub>
					<br />
					<%=bc.getreviewCommentContent() %>
					
				</td>
				<td>
					<button class="btn-reply" value="<%=bc.getreviewCommentNo() %>" >답글</button>
					삭제버튼 추가
					<%if(memberLoggedIn!=null 
						&& ("admin".equals(memberLoggedIn.getMemberId()) 
								|| bc.getreviewCommentWriter().equals(memberLoggedIn.getMemberId()) )){%>
					<button class="btn-delete" value="<%=bc.getreviewCommentNo()%>">삭제</button>
					<%} %>
				</td>
			</tr>
	
	<%			
			}
			else{
	%>			
			<!-- 대댓글인경우 -->	
			<tr class="level2">
				<td>
					<sub class="comment-writer"><%=bc.getreviewCommentWriter() %></sub>
					<sub class="comment-date"><%=bc.getreviewCommentDate() %></sub>
					<br />
					<%=bc.getreviewCommentContent() %>
					
				</td>
				<td>
				삭제버튼 추가
				<%if(memberLoggedIn!=null 
					&& ("admin".equals(memberLoggedIn.getMemberId()) 
							|| bc.getreviewCommentWriter().equals(memberLoggedIn.getMemberId()) )){%>
				<button class="btn-delete" value="<%=bc.getreviewCommentNo()%>">삭제</button>
				<%} %>
				</td>
			</tr>
	<%			
			}//end of if(bc.getreviewCommentLevel()==1)
		
		}//end of for
		
	}//end of if(!commentList.isEmpty())
	%>
	</table> 
	
	
</div>
<script>
$(function(){
	//댓글 textarea focus시에 로그인여부확인
	$("[name=reviewCommentContent]").focus(function(){
		if(<%=userLoggedIn==null%>){
			loginAlert();
		}
	});
	
	//댓글폼 submit이벤트처리
	$("[name=reviewCommentFrm]").submit(function(e){
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
	
	//대댓글입력
	$(".btn-reply").click(function(){
		/* 로그인여부확인 */
		<% if(userLoggedIn == null){ %>
			loginAlert();
		<% } else {%>
			var tr = $("<tr></tr>");
			var html = '<td style="display:none; text-align:left;" colspan="2">';
			html += '<form action="<%=request.getContextPath()%>/review/reviewCommentInsert" method="post">';
			html += '<textarea name="reviewCommentContent" cols="60" rows="3"></textarea>';
			html += '<button type="submit" class="btn-insert2">등록</button>';	  
			html += '<input type="hidden" name="reviewRef" value="<%=b.getreviewNo() %>" />';  
			html += '<input type="hidden" name="reviewCommentWriter" value="<%=userLoggedIn!=null?userLoggedIn.getCustomerNo():""%>" />';
			html += '<input type="hidden" name="reviewCommentLevel" value="2" />';
			html += '<input type="hidden" name="reviewCommentRef" value="'+$(this).val()+'" />';
			html += '</form></td>';
			
			tr.html(html);
			tr.insertAfter($(this).parent().parent()).children("td").slideDown(800);
		
			//답글버튼을 연속적으로 누르지 않도록 핸들러제거
			$(this).off('click');
			
			//새로생성한 요소에 대해 submit이벤트 핸들러 작성
			tr.find("form").submit(function(e){
				//댓글 textarea 유효성검사
				var content = $(this).children("textarea").val().trim();
				if(content.length == 0){
					e.preventDefault();
				}
				
			});
			
			
		<% } %>
		
		
	});
	
	//삭제버튼 클릭시
	$(".btn-delete").click(function(){
		if(!confirm("정말 삭제하시겠습니까?")) return;
		//삭제처리후 돌아올 현재게시판번호도 함께 전송함.
		location.href="<%=request.getContextPath()%>/review/reviewCommentDelete?reviewNo=<%=r.getReviewNo() %>&del="+$(this).val();
	});
	
	
});

function loginAlert(){
	alert("로그인 후 이용할 수 있습니다.");
	$("#memberId").focus();
}




</script> --%>




</section>

<% if(userLoggedIn!=null && 
        (r.getCustomerNo().equals(userLoggedIn.getCustomerNo())
        || "A".equals(userLoggedIn.getStatus())) ){ %>
<form action="<%=request.getContextPath()%>/review/reviewDelete"
	  id="reviewDelFrm"
	  method="post">
	<input type="hidden" name="reviewNo" value="<%=r.getReviewNo()%>"/>
</form>

<script>
function deletereview(){
	if(!confirm("이 게시글을 정말 삭제 하시겠습니까?")){
		return;
	}
	//폼을 사용해서 삭제요청
	$("#reviewDelFrm").submit();
}

</script>

<%} %>