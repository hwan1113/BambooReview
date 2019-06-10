<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>	
<title>광고게시판 글 작성</title>
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
#footer{
position:relative;
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

<section id="ads-container" style="height:300px;">
	<form action="<%=request.getContextPath()%>/ads/adsFormEnd"
		  method="get"
		  enctype="multipart/form-data">
	   <div class="ui centered grid" style="margin-top:5px;">  
			<div class="ui labeled input" style="height:49px; top:-3px;">
			  <div class="ui label" style="font-size:11px; height:33px; margin:0 auto;">
			     <p>작성자</p>
			  </div>
			  <input id="writer" type="text" name="adsWriter" style="margin:0px 0px 16px 0px; width:100px; text-align:center;"
					 value="<%=adsService.getUserName(userLoggedIn.getCustomer_no())%>" readonly/>
			</div>
				 
				 
			<div class="ui labeled input" style="height:49px; top:-3px;">
			  <div class="ui label" style="font-size:11px; height:33px; margin:0 auto;">
			     <p>제목</p>
			  </div>
			  <input id="title" type="text" name="adsTitle" required style="margin:0px 0px 16px 0px; width:780px;
				"/>&nbsp;&nbsp;
			</div>	 
				 
		
		
		<div class="ui grid">
		
	    <!-- 검색 기능을 표시할 <div>를 생성한다 -->
		<div id="postcodify" style="margin-bottom:15px;">
 		
 		<div class="ui labeled input" style="height:80%; top:-3px; right:-10px;">
		  <div class="ui label" style="font-size:11px; margin:0 auto;">
		     <p>주소</p>
		  </div>
		  <input type="text" placeholder="주소를 검색하세요" name="searchedAddress" id="searchedAddress" value="" style="width: 430px;" required/>
		</div>
		</div>
		
			<fieldset style="text-align:center; position:relative;left:150px; top:-10px; width:370px;">
				<div class="ui centered grid" style="margin-top:5px; position:absolute; right:100px;">  
	        		<div class="ui centered grid">            
	        		<div class="ui steps">
  					<div class="step" style=" width: 240px;height:70px; padding:0px;">
			                              인터넷<input type="checkbox" name="facilities" value="인터넷" />
			              SPA<input type="checkbox" name="facilities" value="SPA" />
			                              피트니스<input type="checkbox" name="facilities" value="피트니스" />
			                              수영장<input type="checkbox" name="facilities" value="수영장" />
			               	<div class="row">
			               	조식부페<input type="checkbox" name="facilities" value="조식부페" />
			               	조식부페<input type="checkbox" name="facilities" value="조식부페" />
			               	조식부페<input type="checkbox" name="facilities" value="조식부페" />
			               	조식부페<input type="checkbox" name="facilities" value="조식부페" />
	               			</div>
	               			<div class="row">
	               				<div class="ui labeled input" style="height:26px;  position:relative; top:-1px;">
					  				<div class="ui label" style="font-size:11px; height:26px;">
					     				<p>기타</p>
					  				</div>
					  				<input type="text" name="facilities" value="" style="width:80px;"/>
					  			</div>
						   </div>
					</div>
					</div>
					</div>
				</div> 
	            </fieldset>
		<!-- <div class="row"> -->
		<div class="ui labeled input" style="height:33px; top:-20px; left:10px;">
		  <div class="ui label" style="font-size:11px; margin:0 auto;">
		     <p>상세주소</p>
		  </div>
		  <input type="text" placeholder="상세 주소를 입력하세요" name="detailedAddress" id="detailedAddress" value="" 
		  style="width: 335px; ">
		</div>
  			<button class="ui button" id="postcodify_search_button" style="height:33px; width:72px; position:relative;top:-20px;">주소 검색</button>
		</div>
		</div>
		</div>
		
		<textarea id="summernote" name="adsContent" required style="height:2px;"></textarea>

		<div class="ui centered grid" ">
			<button type="submit" id="submit" name="submit" class="btn btn-success" onclick="validate();">작성</button>
			<button type="button" class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/ads/adsList'">취소</button>
		</div>
		<input id="customerNo" type="hidden" name="customerNo" value="<%=userLoggedIn.getCustomer_no()%>"/>
	</form>	
	<div class="ui menu" style="background-color:#68b30d; height:2.5rem; bottom:0; width:1024px; margin-top:14px;" id="footer">
  <div style="position:absolute; left:34%; top:6px; width:1024px;">
    <p style="font-size:17px;">&lt;Copyright 2019. Team Thanos. All rights reserved.&gt;</p>
  </div>
	
</section>