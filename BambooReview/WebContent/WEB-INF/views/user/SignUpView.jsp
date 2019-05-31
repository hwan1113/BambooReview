<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.regex.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
 <style>
 #space{
 height:100px;
 type:inline-block;
 }
 </style>
 <title>SignUpView</title>
 
 	<div class="ui two column centered grid">
  		<div class="column centered row">
    		<div class="column" id="space">
   			</div>
		</div>
  		<div class="column">
  		  <form class="ui form" action="<%=request.getContextPath() %>/user/signup" onsubmit="return passwordCheck();">
			  <div class="field">
			    <label>이메일</label>
			    <input type="email" name="email" placeholder="email" required/>
			  </div>
			  
			  <div class="field">
			    <label>이름</label>
			    <input type="text" name="name" placeholder="name" required/>
			  </div>
			  
			  <div class="field">
			    <label>비밀번호</label>
			    <input type="password" name="password" placeholder="password" id="password" required/>
			  </div>
			  
			  <div class="field">
			    <label>비밀번호 확인</label>
			    <input type="password" name="passwordCfrm" placeholder="password" id="passwordCfrm" required/> 
			  </div>
			  
			  <div class="field">
			    <label>전화 번호</label>
			    <input type="number" name="phone" placeholder="phone number" required/>
			  </div>
			  
			  <div class="field">
			    <div class="ui checkbox">
			      <input type="checkbox" name="saveId" required>
			      <label>개인정보 약관에 동의합니다.</label>
			    </div>
			  </div>
  				<button class="ui button" type="submit">회원가입</button>
  				<input type="button" class="ui red button" value="뒤로가기"
  				onclick="location.href='<%=request.getContextPath()%>/user/userLogin'">
  			
			</form>
  		</div>
  	</div>
 
 <script>
 function passwordCheck(){

		
	if($("#password").val()!=$("#passwordCfrm").val()){
			alert("비밀번호가 일치하지 않습니다");
			$("#password").focus();
			return false;
		}
	
	/////////////////////비밀번호 정규화,   최종버전에서 사용할것
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
 </script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>