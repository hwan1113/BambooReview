<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%User user = (User)request.getAttribute("user"); %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/info.css" />
 <style>
 #space{
 height:100px;
 type:inline-block;
 }
 
 </style>
 <script>
 function updateValidation(){
		//비밀번호
		
		//이름
		
		return true;
	}
 
 
	function updateUser(){
		var $frm = $("[name=userUpdateFrm]");
		var url = "<%=request.getContextPath()%>/user/userUpdate";
		$frm.attr("action", url);
		$frm.submit();
	}
	function deleteUser(){
		var bool = confirm("정말로 탈퇴하시겠습니까?");
		if(bool){
			location.href = "<%=request.getContextPath()%>/user/userDelete?email=<%=user.getEmail()%>"
			}
		}
	
	function updatePassword(){
		var url = "<%=request.getContextPath()%>/user/updatePassword?email=<%=user.getEmail()%>";
	    var title = "updatePassword";
	    var status =  "left=500px, top=200px, width=400px, height=210px";
	    
		var popup = window.open(url,title,status);
	}
	function loadImg(f){
	    console.log(f.files); //FileList
	    console.log(f.files[0]); //File 실제 업로드한 파일
	    
	    if(f.files && f.files[0]){
	    	var reader = new FileReader();
	    	//파일 읽기 메소드 호출. 읽기완료하면 onload에 등록된 함수를 호출
	    	reader.readAsDataURL(f.files[0]);
	    	
	    	reader.onload = function(){
	    		//result속성에는 파일 컨텐츠가 담겨있음.
	    		$("#img-viewer").attr("src", reader.result);
	    	}
	    }
	}
	</script>
	<form name="checkIdDuplicateFrm" method="post">
	<input type="hidden" name="email" />
</form>
  	<div class="column" id="space"></div>
  	<form name="userUpdateFrm"
		  method="post"
		  enctype="multipart/form-data"
		  onsubmit="return updateValidation();">
  	<div class="ui grid">
  		<div class="three wide column"></div>
  		<div class="four wide column">
    		<div class="column">
				<div class="ui card">
			  		<a class="image" href="#">
			  		<img id="img-viewer" width=350 />
		 	  			<%-- <img src="<%=request.getContextPath() %>/images/thanos.jpg" > --%>
		 	  			<!-- 회원사진 저장하면 이름을 특정한 형식으로 변경해 저장해 그 경로를 저장
		 	  			ex) 회원번호 1인 회원이 사진을 저장한다면
		 	  				1.(확장자) 등의 형태로 images 폴더에 저장하고 그 경로를 태그에 리턴 -->
			  		</a>
            <td style="position:relative;"  >
					<input type="file" 
						   name="upFile" 
						   value="<%=user.getOriginalFile()%>"/>
					<span id="fname"><%=user.getOriginalFile()!=null?user.getOriginalFile():"" %></span>
					
					<!-- 사용자가 첨부파일관련해서 아무런 수정도 하지 않은경우 -->
					<input type="hidden" name="originalFileNameOld" value="<%=user.getOriginalFile()!=null?user.getOriginalFile():""%>"/>
					<input type="hidden" name="renamedFileNameOld" value="<%=user.getRenamedFile()!=null?user.getRenamedFile():""%>"/>
						
					<!-- 사용자가 업로드한 첨부파일을 삭제하는 경우 -->
					<%if(user.getOriginalFile()!=null) { %>
						<br />
						<input type="checkbox" name="delFile" 
							   id="delFile" />
						<label for="delFile">첨부파일삭제</label>
						   
					<%} %>
				</td>
            
            
					<div class="content">
		   	 			<a class="header" href="#"><%=user.getUserName()%></a>
		  	 			<div class="meta">
		  	 			<%if("U".equals(user.getStatus())) {%>
		     			<a>일반 회원</a>
		     			<%}else{ %>
		     			<a>관리자</a>
		     			<%} %>
		   	 			</div>
		  			</div>
				</div>
			</div>
  		</div>
  		
 		 <div class="five wide column">
    		<%-- <form class="ui form" action="<%=request.getContextPath() %>/user/userUpdate" enctype="multipart/form-data" method="post" onsubmit="return passwordCheck();"> --%>
    		<h2 class="ui icon header" id="topimg">
			  <i class="settings icon"></i>
			  <div class="content">
			    Account Settings
			    <div class="sub header"><%=user.getUserName()%>회원님의 개인정보 수정 및 회원 탈퇴가 가능합니다</div>
			  </div>
			</h2>
				<div class="ui input" id="email-div">
				<label class="email-title">이메일</label>
				  <input type="text" name="email" value="<%=user.getEmail()%>" required readonly class="email-input-bar">
				</div>
			  
			  
			  <div class="ui input" id="name-div">
			    <label class="name-title">이름</label>
			    <!-- <input type="text" name="password" placeholder="name" required> -->
			    <input type="text" name="name" value="<%=user.getUserName()%>" required />
			  </div>
			  
			  <div class="ui input" id="phone-div">
			    <label class="phone-title">전화 번호</label>
			    <!-- <input type="number" name="password" placeholder="phone number" required> -->
			    <input type="tel" name="phone" id="phone" placeholder="전화번호" 
						   value="<%=user.getPhone()%>"
						   required/ class="phone-input-bar">
			  </div>
			  	<div class="blue ui buttons" id="submit-button">
				  <button class="ui button active" onclick="updateUser();" id="update-button">회원정보수정</button>
				  <form action="<%=request.getContextPath() %>/user/passwordUpdate" onsubmit="return passwordCheck();">
				  <button class="ui button" onclick="updatePassword();" id="password-button">비밀번호 변경</button>
				  </form>
				</div>
			  </div>
  		</div>
  		</form>
				  <button class="ui button" onclick="deleteUser();" id="delete-button">회원 탈퇴</button>
				  <!-- button class="ui button" onclick="deleteUser();" id="delete-button">회원 탈퇴</button> -->
	</div>
	<!-- </form> -->






<%@ include file="/WEB-INF/views/common/footer.jsp" %>