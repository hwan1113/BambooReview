<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="user.model.vo.*" %>
<%User u = (User)request.getAttribute("user");%>
<%@ include file="/WEB-INF/views/common/headerCommon.jsp" %>
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
			location.href = "<%=request.getContextPath()%>/user/userDelete?email=<%=u.getEmail()%>"
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
		   	 			<a class="header" href="#">Thanos</a>
		  	 			<div class="meta">
		     			<a>일반 회원</a>
		   	 			</div>
		  			</div>
				</div>
			</div>
  		</div>
 		 <div class="five wide column">
    		<form class="ui form" action="<%=request.getContextPath() %>/user/update" onsubmit="return passwordCheck();">
			  <div class="field">
			    <label>이메일</label>
			   <!--  <input type="email" name="email" placeholder="email" required> -->
						   <!-- readonly  -->
			  <input type="text" name="memberId" id="memberId_" value="<%=u.getEmail()%>"
						   required/>
				</td>
			  </div>
			  
			  <div class="field">
			    <label>이름</label>
			    <!-- <input type="text" name="password" placeholder="name" required> -->
			    <input type="text" name="memberName" id="memberName" value="<%=u.getUserName()%>"
						   required/>
			  </div>
			  
			  <!-- <div class="field">
			    <label>비밀번호</label>
			    <input type="password" name="password" placeholder="password" id="password" required>
			  </div>
			  
			  <div class="field">
			    <label>비밀번호 확인</label>
			    <input type="password" name="passwordCfm" placeholder="password" id="passwordCfm" required>
			  </div> -->
			  
			  <div class="field">
			    <label>전화 번호</label>
			    <!-- <input type="number" name="password" placeholder="phone number" required> -->
			    <input type="tel" name="phone" id="phone" placeholder="(-없이)01012345678" 
						   value="<%=u.getPhone()%>"
						   required/>
			  </div>
				<input type="button" onclick="updateUser();" value="회원정보수정" />
				<input type="button" onclick="deleteUser();" value="회원탈퇴" />
  				<!-- <button class="ui button2" type="submit">수정하기</button>
  				<button class="ui red button" type="submit">뒤로가기 </button> -->
			</form>
  		</div>
  		<div class="three wide column"></div>
	</div>
	</form>
	
	





<%@ include file="/WEB-INF/views/common/footer.jsp" %>