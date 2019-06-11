<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.regex.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/signup.css" />
 <title>회원가입</title>
 
	 <form name="checkIdDuplicateFrm" method="post">
		<input type="hidden" name="email" />
	</form>
 	<div class="ui two column centered grid">
  		
  		<div class="column">
  		  <form class="ui form" name="userEnrollFrm" action="<%=request.getContextPath() %>/user/signup"  onsubmit="return enrollValidation();">
			  <div class="field">
			    <label>이메일</label>
			    <input type="email" name="email" placeholder="email" id="email" required style="width:370px;" />
			  </div>
			  <input type="button" value="이메일 중복검사" class="ui olive button" 
			  style="position:absolute; height:38px; top:23px; left:366px; font-size:13px;"
						   onclick="checkIdDuplicate();" />
					<!-- 아이디중복검사를 마친후 value는 1이 됨. -->
					<input type="hidden" id="isValid" value="0"/>
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
			    <input type="text" name="phone" placeholder="phone number" required/>
			  </div>
			  
			  <div class="field">
			    <div class="ui checkbox">
			      <input type="checkbox" name="saveId" required>
			      <label>개인정보 약관에 동의합니다.</label>
			    </div>
			  </div>
			  <div class="ui centered grid" style="padding:20px;">
			  	<div class="ui buttons">
				  <button class="ui positive button" type="submit">회원가입</button>
				  <div class="or"></div>
  				<input type="button" class="ui button" value="뒤로가기"
  				onclick="location.href='<%=request.getContextPath()%>/user/userLogin'">
			  </div>
			  </div>
  			
			</form>
  		</div>
  	</div>
 
 <script>
 /* function passwordCheck(){

		
	
		return true;
	} */
 
	 function enrollValidation(){
			//아이디
			var memberId = $("#email");
			if(memberId.val().length < 4){
				alert("아이디는 최소 4자리 이상이어야 합니다.");
				memberId.focus();
				return false;
			}
			//아이디 중복검사여부 
			var isValid = $("#isValid").val();
			if(isValid == "0"){
				alert("아이디 중복검사 해주세요.");
				return false;
			}
			//중복검사 통과하면 입력창 readonly로 설정
			/* else
				$("#email").attr("readonly",true); */
			//패스워드 일치 여부
			if($("#password").val()!=$("#passwordCfrm").val()){
				alert("비밀번호가 일치하지 않습니다");
				$("#password").focus();
				return false;
			}
		
		/////////////////////비밀번호 정규화,   최종버전에서 사용할것
		var password = $("#password").val();
		var check1 = /^(?=.*[a-zA-Z])(?=.*[0-9]).{10,12}$/.test(password);   //영문,숫자
		var check2 = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{10,12}$/.test(password);  //영문,특수문자
		var check3 = /^(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{10,12}$/.test(password);  //특수문자, 숫자
		if(!(check1||check2||check3)){
			alert("비밀번호는 10자~12자리의 영문+숫자+특수문자 중 2종류 이상을 조합하여 사용할 수 있습니다.");
			return false;
				}
			//비밀번호
			
			//이름
			
			
			return true;
		}
	 function checkIdDuplicate(){
			//아이디 검사
			var email = $("#email").val().trim();
			if(email.length < 4){
				alert("아이디는 4글자 이상 가능합니다.");
				return;
			}
			
			//팝업생성
			var url = "<%=request.getContextPath()%>/user/checkIdDuplicate";
			var title = "checkIdDuplicate";
			var specs = "width=300px, height=200px, left=500px, top=100px";
			
			var popup = open("",title,specs);//팝업의 최상위 윈도우객체를 리턴함.
			
			//폼과 팝업 연결
			var frm = document.checkIdDuplicateFrm;
			frm.email.value = email;
			frm.target = title;//팝업 title지정
			frm.action = url;
			frm.submit();
			
		}

 </script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>