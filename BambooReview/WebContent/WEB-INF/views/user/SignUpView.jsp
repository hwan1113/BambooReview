<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/headerCommon.jsp" %>
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
			  
  				<button class="ui button" type="submit">Submit</button>
  				<button class="ui red button" type="submit">뒤로가기 </button>
			</form>
  		</div>
  	</div>
 
 <script>
 function passwordCheck(){
		
	 
	 if($("#password").val()!=$("#passwordCfrm").val()){
			alert("비밀번호가 일치하지 않습니다");
			$("#memberId").focus();
			return false;
		}
		return true;
	}
 </script>
 
<%@ include file="/WEB-INF/views/common/footer.jsp" %>