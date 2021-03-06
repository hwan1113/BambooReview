<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>	
<%@ page import="review.model.vo.*" %>
<%
	Review r = (Review)request.getAttribute("review");
	String hotelName = (String)request.getAttribute("hotelName");
	String srchWord = (String)request.getAttribute("srchWord");
%>

<title>Review 수정</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/review.css" />
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery-3.4.0.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link href="<%=request.getContextPath()%>/dist/summernote.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/dist/summernote.js"></script>
<script src="<%=request.getContextPath()%>/dist/lang/summernote-ko-KR.js"></script>
<style>
body {overflow-y: hidden; overflow-x: hidden;}
footer
</style>
<script type="text/javascript">
    /* summernote에서 이미지 업로드시 실행할 함수 */
 	function sendFile(file, editor) {
 		// 파일 전송을 위한 폼생성
 		data = new FormData();
 	    data.append("uploadFile", file);
 	    $.ajax({ // ajax를 통해 파일 업로드 처리
 	        data : data,
 	        type : "POST",
 	        url : "<%=request.getContextPath()%>/review/imageUpload",
 	        cache : false,
 	        contentType : false,
 	        processData : false,
 	        success : function(data) { // 처리가 성공할 경우
                   // 에디터에 이미지 출력
                    $(editor).summernote('editor.insertImage', data.url);
              	},
 	   		error: function(jqxhr, textStatus, errorThrown){
			console.log("ajax처리 실패!!");
			console.log(jqxhr);
			console.log(textStatus);
			console.log(errorThrown);
			}
 	    });
 	}
</script>

<script>
    $(document).ready(function() {
        $('#summernote').summernote({
        	width: 1024,
        	height: 450,
		    callbacks: {
				onImageUpload: function(files, editor, welEditable) {
		            /* for (var i = files.length - 1; i >= 0; i--) {
		            	sendFile(files[i], this);
		            } */
		            sendFile(files[0], this);
		        }
			}
        });
    });
    
    function validate(){
    	//제목
    	var reviewTitle = $("[name=reviewTitle]").val();
    	if(reviewTitle.trim().length == 0){
    		alert("제목을 입력하세요.");
    		return false;
    	}
    	//내용
    	var reviewContent = $("[name=reviewContent]").val();
    	if(reviewContent.trim().length == 0){
    		alert("내용을 입력하세요.");
    		return false;
    	}
    	
    	return true;
    }
</script>

<section id="review-container">
	<form action="<%=request.getContextPath()%>/review/reviewUpdateEnd"
		  method="get"
		  enctype="multipart/form-data"
		  id="main-form">
		<div class="ui centered grid">  
		
		 <div class="ui labeled input" style="margin:0px 0px 6px 0px;">
			  <div class="ui label" style="height:25px; position:absolute; top:10px; width:50px; left:-40px;" >
			    <p style="position:absolute; top:4px;">제목</p>
			  </div>
			  <input id="title" type="text" name="reviewTitle" value ="<%=r.getReviewTitle()%>" required />
			</div>
		
		<div class="ui labeled input" style="margin:0px 0px 6px 0px; left:60px;">
			  <div class="ui label" style="height:25px; position:absolute; top:10px; width:50px; left:-40px;" >
			    <p style="position:absolute; top:4px; left:4px;">작성자</p>
			  </div>
			 <input id="writer" type="text" name="reviewWriter"
				 value="<%=service.getUserName(userLoggedIn.getCustomer_no())%>" style="width:80px;" readonly/>
			</div>
	   </div>
		<textarea style="margin-top:10px;" id="summernote" name="reviewContent"
		><%=r.getReviewContent() %></textarea>

		<div class="ui centered grid">
			<button type="submit" id="submit" name="submit" class="btn btn-success" onclick="validate();">작성</button>
			<button type="button" class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/review/reviewList?hotelName=<%=hotelName %>&hotelId=<%=r.getHotelId()%>&srchWord=<%=srchWord%>'">취소</button>
		</div>
		
		<input type="hidden" name="srchWord" value="<%=srchWord%>" />
		<input id="hotelName" type="hidden" name="hotelName" value="<%=hotelName%>" />
		<input id="hotelId" type="hidden" name="hotelId" value="<%=r.getHotelId()%>" />
		<input id="customerNo" type="hidden" name="customerNo" value="<%=r.getCustomerNo()%>"/>
		<input id="reviewNo" type="hidden" name="reviewNo" value="<%=r.getReviewNo()%>"/>  
	</form>
</section>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>