<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/views/common/header.jsp" %>
 
<title>LoginView</title>
<body>
	<div class="ui two column centered grid">
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
  		</div>
  	</div>



</body>


 <%@ include file="/WEB-INF/views/common/footer.jsp" %>