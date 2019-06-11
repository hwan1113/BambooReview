<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean isUsable = (boolean)request.getAttribute("isUsable");
	String email = request.getParameter("email");
	
	System.out.println("isUsable@jsp="+isUsable);
	System.out.println("email@jsp="+email);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디중복검사</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.0.js"></script>
<style>
div#checkid-container{
	text-align: center;
	padding-top: 50px;
}
span#duplicated{
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div id="checkid-container">
	<%if(isUsable == true){ %>
		[<span><%=email %></span>]는 사용가능합니다.
		<br /><br />
		<button type="button" class="ui button" onclick="setEmail('<%=email%>')"><i class="window close icon"></i>닫기</button>
	<% } else { %>
		[<span id="duplicated"><%=email %></span>]는 이미 사용중입니다.
		<br /><br />
		<form action="<%=request.getContextPath()%>/user/checkIdDuplicate"
			  name="checkIdDuplicateFrm"
			  method="post">
			<input type="text" name="email" id="email"
				   placeholder="아이디를 입력하세요." />
			<input type="button" value="중복검사" 
				   onclick="checkIdDuplicate();"/> 
		</form>
	
	<%} %>
	</div>
<script>
function setEmail(email){
	var frm = opener.document.userEnrollFrm;
	//부모창(memberEnroll.jsp)의 frm에 접근.
	
	frm.email.value = email;
	frm.isValid.value = 1;
	frm.password.focus();//폼의 다음 입력창에 포커싱
	
	//self(checkIdDuplicate.jsp)창 닫기
	self.close();
}


function checkIdDuplicate(){
	var email = $("#email").val().trim();
	if(email.length < 4){
		alert("아이디는 4글자 이상 가능합니다.");
		return;
	}
	
	var frm = document.checkIdDuplicateFrm;
	frm.email.value = email;
	frm.submit();
}


</script>	
</body>
</html>







