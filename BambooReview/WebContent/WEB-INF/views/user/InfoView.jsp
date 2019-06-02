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
	
	function passwordCheck(){
		/* if($("#password").val()!=$("#passwordCfrm").val()){
			alert("비밀번호가 일치하지 않습니다");
			$("#password").focus();
			return false;
			} */
		
		//////////////비밀번호 정규화, 최종버전에서 사용할것
		/* var password = $("#password").val();
		var check1 = /^(?=.*[a-zA-Z])(?=.*[0-9]).{10,12}$/.test(password);   //영문,숫자
		var check2 = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{10,12}$/.test(password);  //영문,특수문자
		var check3 = /^(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{10,12}$/.test(password);  //특수문자, 숫자
		if(!(check1||check2||check3)){
			alert("10자~12자리의 영문+숫자+특수문자 중 2종류 이상을 조합하여 사용할 수 있습니다.");
			return false;
				} */
			return true;
				
	}
	
	function updatePassword(){
		var url = "<%=request.getContextPath()%>/user/updatePassword?email=<%=user.getEmail()%>";
	    var title = "updatePassword";
	    var status =  "left=500px, top=200px, width=400px, height=210px";
	    
		var popup = window.open(url,title,status);
	}
	</script>
	<form name="checkIdDuplicateFrm" method="post">
	<input type="hidden" name="email" />
</form>
  	<div class="column" id="space"></div>
  	<form name="userUpdateFrm"
		  method="post"
		  onsubmit="return updateValidation();">
  	<div class="ui grid">
  		<div class="three wide column"></div>
  		<div class="four wide column">
    		<div class="column">
				<div class="ui card">
			  		<a class="image" href="#">
		 	  			<img src="<%=request.getContextPath() %>/images/thanos.jpg">
			  		</a>
					<div class="content">
		   	 			<a class="header" href="#"><%=user.getUserName()%></a>
		  	 			<div class="meta">
		     			<a>일반 회원</a>
		   	 			</div>
		  			</div>
				</div>
			</div>
  		</div>
 		 <div class="five wide column">
    		<form class="ui form" action="<%=request.getContextPath() %>/user/update" onsubmit="return passwordCheck();">
    		<h2 class="ui icon header" id="topimg">
			  <i class="settings icon"></i>
			  <div class="content">
			    Account Settings
			    <div class="sub header"><%=user.getUserName()%>회원님의 개인정보 수정 및 회원 탈퇴가 가능합니다</div>
			  </div>
			</h2>
				<div class="ui input" id="email-div">
				<label class="email-title">이메일</label>
				  <input type="text" name="email" value="<%=user.getEmail()%>" required/ class="email-input-bar">
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
				  <button class="ui button" onclick="deleteUser();" id="delete-button">회원 탈퇴</button>
				  <!-- button class="ui button" onclick="deleteUser();" id="delete-button">회원 탈퇴</button> -->
	</div>
	</form>






<%@ include file="/WEB-INF/views/common/footer.jsp" %>