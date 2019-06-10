<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>	
<%@ page import="ads.model.vo.*" %>
<%
	Ads ads = (Ads)request.getAttribute("ads");
%>

<title>Ads 수정</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/ads.css" />
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery-3.4.0.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link href="<%=request.getContextPath()%>/dist/summernote.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/dist/summernote.js"></script>
<script src="<%=request.getContextPath()%>/dist/lang/summernote-ko-KR.js"></script>

<!-- 주소검색 api -->
<script src="<%=request.getContextPath()%>/postcodify-master/api/search.min.js"></script>
 
<!-- "검색" 단추를 누르면 팝업 레이어가 열리도록 설정한다 -->
<!-- <script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script> -->
<script>
    $(function() { $("#postcodify_search_button").postcodifyPopUp({
        insertAddress : "#searchedAddress",
        insertDetails : "#detailedAddress",
        hideOldAddresses : false
    }); });
</script>

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
 	        url : "<%=request.getContextPath()%>/ads/imageUpload",
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
        	height: 400,
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
    	var adsTitle = $("[name=adsTitle]").val();
    	if(adsTitle.trim().length == 0){
    		alert("제목을 입력하세요.");
    		return false;
    	}
    	//내용
    	var adsContent = $("[name=adsContent]").val();
    	if(adsContent.trim().length == 0){
    		alert("내용을 입력하세요.");
    		return false;
    	}
    	
    	return true;
    }

 
</script>

<section id="ads-container">
	<form action="<%=request.getContextPath()%>/ads/adsUpdateEnd"
		  method="get"
		  enctype="multipart/form-data">
		<div class="ui centered grid" style="margin-top:5px;">
		 제목: <input id="title" type="text" name="adsTitle" 
					 value="<%=ads.getAdsTitle() %>"required />&nbsp;&nbsp;&nbsp;
		 작성자: <input id="writer" type="text" name="adsWriter" 
				 	 value="<%=ads.getCustomerNo()%>" readonly/>
		</div>
		<div id="postcodify">
		<input type="button" id="postcodify_search_button" value="주소검색"/>
		검색한 주소: <input type="text" name="searchedAddress" id="searchedAddress" value="<%=ads.getSearchedAddress() %>" style="width: 350px;" required/>
		상세 주소: <input type="text" name="detailedAddress" id="detailedAddress" value="<%=ads.getDetailedAddress() %>" style="width: 350px;"/><br />
		</div>
		<fieldset style="text-align:center;">
                              인터넷<input type="checkbox" name="facilities" value="인터넷" />
                SPA<input type="checkbox" name="facilities" value="SPA" />
                              피트니스<input type="checkbox" name="facilities" value="피트니스" />
               	수영장<input type="checkbox" name="facilities" value="수영장" />
               	조식부페<input type="checkbox" name="facilities" value="조식부페" />
               	기타: <input type="text" name="facilities" value="" />
            </fieldset>
		<textarea id="summernote" name="adsContent" required><%=ads.getAdsContent() %></textarea>
		<div class="ui centered grid">
		<button type="submit" id="submit" name="submit" class="btn btn-success" onclick="validate();">수정</button>
		<button type="button" class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/ads/adsView?adsNo=<%=ads.getAdsNo()%>'">취소</button>
		</div>
		<input id="customerNo" type="hidden" name="customerNo" value="<%=ads.getCustomerNo()%>"/>
		<input id="adsNo" type="hidden" name="adsNo" value="<%=ads.getAdsNo()%>"/>
	</form>
</section>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>