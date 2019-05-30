<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/headerCommon.jsp" %>
 <style>
 #space{
 height:100px;
 type:inline-block;
 }
 </style>

  	<div class="column" id="space"></div>
  	
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
    		<form class="ui form" action="<%=request.getContextPath() %>/user/signup" onsubmit="return passwordCheck();">
			  <div class="field">
			    <label>이메일</label>
			    <input type="email" name="email" placeholder="email" required>
			  </div>
			  
			  <div class="field">
			    <label>이름</label>
			    <input type="text" name="password" placeholder="name" required>
			  </div>
			  
			  <div class="field">
			    <label>비밀번호</label>
			    <input type="password" name="password" placeholder="password" id="password" required>
			  </div>
			  
			  <div class="field">
			    <label>비밀번호 확인</label>
			    <input type="password" name="passwordCfm" placeholder="password" id="passwordCfm" required>
			  </div>
			  
			  <div class="field">
			    <label>전화 번호</label>
			    <input type="number" name="password" placeholder="phone number" required>
			  </div>
  				<button class="ui button" type="submit">수정하기</button>
  				<button class="ui red button" type="submit">뒤로가기 </button>
			</form>
  		</div>
  		<div class="three wide column"></div>
	</div>
	
	<script>
	function passwordCheck(){
		
		 
		 if($("#password").val()!=$("#passwordCfm").val()){
				alert("비밀번호가 일치하지 않습니다");
				$("#password").focus();
				return false;
			}
			return true;
		}
	</script>










<%@ include file="/WEB-INF/views/common/footer.jsp" %>