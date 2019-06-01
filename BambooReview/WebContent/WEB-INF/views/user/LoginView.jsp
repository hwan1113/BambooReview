<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <style>
 #space{
 height:100px;
 type:inline-block;
 }
 </style>
 <%@ include file="/WEB-INF/views/common/header.jsp" %>
 <meta name="google-signin-client_id" content="401915479611-85lnc5b082en3f07kq9jsd628oshv494.apps.googleusercontent.com">
 <script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>
 
 <form name="checkIdDuplicateFrm" method="post">
	<input type="hidden" name="email" />

</form>
<title>LoginView</title>
	<div class="ui two column centered grid">
  		<div class="column centered row">
    		<div class="column" id="space">
   			   <span></span>
   			</div>
		</div>
  		<div class="column">
  		  <form class="ui form" action="<%=request.getContextPath() %>/user/login" onsubmit="return loginValidate();">
			  <div class="field" >
			    <label>이메일</label>
			    <input type="email" name="email" placeholder="email" id="memberId"/>
			    
			  </div>
			  <div class="field" >
			    <label>비밀번호</label>
			    <input type="password" name="password" placeholder="password" id="password"/>
			  </div>
			  
			  <div class="field">
			    <div class="ui checkbox">
			      <input type="checkbox" name="saveId">
			      <label>remember me!</label>
			    </div>
			  </div>
			  
  				<button class="ui button" type="submit">로그인</button>
			</form>
			 <div class="ui message">
 				 <div class="header">
  					  아직도 회원이 아니세요?
 				 </div>
 				 <p><a href="<%=request.getContextPath()%>/user/userSignup">회원 가입하러가기!</a></p>
			</div>
				<div id="my-signin2"></div>
			<a href="#" onclick="signOut();">Sign out</a>
			
			
  		</div>
  	</div>
  	<form action="<%=request.getContextPath()%>/user/googleUser"
      				name="googleUserFrm" id="googleUserFrm" method="post">
       			<input type="hidden" name="userName" id="userName"/>
    			<input type="hidden" name="email" id="email">
    			<input type="hidden" name="picture" id="picture">
   	</form>
<script>

function signOut() {
   var auth2 = gapi.auth2.getAuthInstance();
   auth2.signOut().then(function () {
     console.log('User signed out.');
   });
 }

function onSuccess(googleUser) {
     var profile = googleUser.getBasicProfile();
      console.log('ID: ' + profile.getId());
      console.log('Name: ' + profile.getName());
      console.log('Image URL: ' + profile.getImageUrl());
      console.log('Email: ' + profile.getEmail());
      var id_token = googleUser.getAuthResponse().id_token;
      
      $("#userName").val(profile.getName())
      $("#email").val(profile.getEmail())
      $("#picture").val(profile.getImageUrl())
      $("#googleUserFrm").submit()
      
      
      
      var param={
          id_token:id_token
      }
      $.ajax({
        url:'https://oauth2.googleapis.com/tokeninfo',
        data:param,
        success: function(data){
            console.dir(data)
            
        },
        error:function(){
            
        }
        })
}

function onFailure(error) {
   console.log(error);
}

function renderButton() {
   gapi.signin2.render('my-signin2', {
     'scope': 'profile email',
     'width': 240,
     'height': 50,
     'longtitle': true,
     'theme': 'dark',
     'onsuccess': onSuccess,
     'onfailure': onFailure
   });
}

function loginValidate(){
	if($("#memberId").val().trim().length == 0){
		alert("아이디를 입력하세요.");
		$("#memberId").focus();
		return false;
	}
	
	if($("#password").val().trim().length == 0){
		alert("비밀번호를 입력하세요.");
		$("#password").focus();
		return false;
	}
	return true;
}
</script>



</body>


 <%@ include file="/WEB-INF/views/common/footer.jsp" %>