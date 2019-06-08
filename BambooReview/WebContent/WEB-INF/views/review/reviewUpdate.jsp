<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>	
<%@ page import="review.model.vo.*" %>
<%
	Review r = (Review)request.getAttribute("review");
	String hotelName = (String)request.getAttribute("hotelName");
	System.out.println("r@review Update= "+r);
%>

<title>Review 수정</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/review.css" />
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery-3.4.0.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link href="<%=request.getContextPath()%>/dist/summernote.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/dist/summernote.js"></script>
<script src="<%=request.getContextPath()%>/dist/lang/summernote-ko-KR.js"></script>

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
		  enctype="multipart/form-data">
	제목: <input id="title" type="text" name="reviewTitle" 
				value="<%=r.getReviewTitle() %>"required />&nbsp;&nbsp;&nbsp;
	작성자: <input id="writer" type="text" name="reviewWriter" 
				 value="<%=service.getUserName(userLoggedIn.getCustomer_no())%>" readonly/>
		<textarea id="summernote" name="reviewContent"><%=r.getReviewContent() %></textarea>

		<input id="hotelName" type="hidden" name="hotelName" value="<%=hotelName%>" />
		<input id="hotelId" type="hidden" name="hotelId" value="<%=r.getHotelId()%>" />
		<input id="customerNo" type="hidden" name="customerNo" value="<%=userLoggedIn.getCustomer_no()%>"/>
		<input id="reviewNo" type="hidden" name="reviewNo" value="<%=r.getReviewNo()%>"/>
		
		<button type="submit" id="submit" name="submit" class="btn btn-success" onclick="validate();">수정</button>
		<button type="button" class="btn btn-warning">취소</button>
			  
	</form>

		

</section>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>