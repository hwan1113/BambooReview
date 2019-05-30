<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/views/common/headerCommon.jsp" %>
 <style>
 #space{
 height:100px;
 type:inline-block;
 }
 </style>
<title>LoginView</title>
	<div class="ui two column centered grid">
  		<div class="column centered row">
    		<div class="column" id="space">
   			   <span></span>
   			</div>
		</div>
  		<div class="column">
  		  <form class="ui form" action="<%=request.getContextPath() %>/user/login">
			  <div class="field">
			    <label>이메일</label>
			    <input type="text" name="email" placeholder="email">
			  </div>
			  <div class="field">
			    <label>비밀번호</label>
			    <input type="text" name="password" placeholder="password">
			  </div>
			  
			  <div class="field">
			    <div class="ui checkbox">
			      <input type="checkbox" name="saveId">
			      <label>remember me!</label>
			    </div>
			  </div>
			  
  				<button class="ui button" type="submit">Submit</button>
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
<script>

function signOut() {
   var auth2 = gapi.auth2.getAuthInstance();
   auth2.signOut().then(function () {
     console.log('User signed out.');
   });
 }

function onSuccess(googleUser) {
     var profile = googleUser.getBasicProfile();
      console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
      console.log('Name: ' + profile.getName());
      console.log('Image URL: ' + profile.getImageUrl());
      console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
      var id_token = googleUser.getAuthResponse().id_token;
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


</script>



</body>


 <%@ include file="/WEB-INF/views/common/footer.jsp" %>