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
    		<form class="ui form" action="<%=request.getContextPath() %>/user/signup">
			  <div class="field">
			    <label>이메일</label>
			    <input type="text" name="email" placeholder="email">
			  </div>
			  
			  <div class="field">
			    <label>이름</label>
			    <input type="text" name="password" placeholder="password">
			  </div>
			  
			  <div class="field">
			    <label>비밀번호</label>
			    <input type="text" name="password" placeholder="password">
			  </div>
			  
			  <div class="field">
			    <label>전화 번호</label>
			    <input type="text" name="password" placeholder="password">
			  </div>
  				<button class="ui button" type="submit">수정하기</button>
  				<button class="ui red button" type="submit">뒤로가기 </button>
			</form>
  		</div>
  		<div class="three wide column"></div>
	</div>










<%@ include file="/WEB-INF/views/common/footer.jsp" %>