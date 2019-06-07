<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>	
<%
	String hotelName = (String)request.getAttribute("hotelName");
	String hotelId = (String)request.getAttribute("hotelid");
%>
<title>Review 작성</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/review.css" />
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery-3.4.0.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link href="<%=request.getContextPath()%>/dist/summernote.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/dist/summernote.js"></script>
<script src="<%=request.getContextPath()%>/dist/lang/summernote-ko-KR.js"></script>

<style>
.ui.menu{
top:659px;
}
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
                    console.dir(file)
                    var reader = new FileReader();
                    reader.readAsDataURL(file);
                    
                    reader.onload=function(){
	 	        		$(editor).summernote('editor.insertImage', reader.result);
                    }
               
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

<section id="review-container" style="height:300px;">
	<form action="<%=request.getContextPath()%>/review/reviewFormEnd"
		  method="get"
		  enctype="multipart/form-data">
	   <div class="ui centered grid">  
	제목: <input id="title" type="text" name="reviewTitle" style="height:25px; margin-top:0px;" required />&nbsp;&nbsp;
	 작성자: <input id="writer" type="text" name="reviewWriter" style="width:100px; height:25px; margin-top:0px;"
				 value="<%=service.getUserName(userLoggedIn.getCustomer_no())%>님" readonly/>
	   </div>
		<textarea id="summernote" name="reviewContent"></textarea>

		<div class="ui centered grid">
			<button type="submit" id="submit" name="submit" class="btn btn-success" onclick="validate();">작성</button>
			<button type="button" class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/review/reviewList?hotelname=<%=hotelName %>&hotelid=<%=hotelId%>'">취소</button>
		</div>
		
		<input id="hotelName" type="hidden" name="hotelName" value="<%=hotelName%>" />
	  	<input id="hotelId" type="hidden" name="hotelId" value="<%=hotelId%>" />
		<input id="customerNo" type="hidden" name="customerNo" value="<%=userLoggedIn.getCustomer_no()%>"/>
	</form>
	
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
		

</section>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>