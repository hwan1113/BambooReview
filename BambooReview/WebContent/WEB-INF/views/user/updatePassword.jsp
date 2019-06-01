<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.model.vo.User" %>
<%
	//이후 관리자가 회원관리할 경우에 대비해서 session객체에서 값을 꺼내오지 않도록 함.
	String email = (String)request.getParameter("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.4.0.js"></script>
<!-- 시맨틱 UI -->
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.css"/>
 <!----------------------------------------------->  
<style>
div#updatePassword-container table {margin:0 auto; border-spacing: 20px;}
div#updatePassword-container table tr:last-of-type td {text-align:center;}
</style>
<script>
function fn_password_validate(){
	var pwd_new = $("#password_new").val().trim();
	var pwd_chk = $("#password_chk").val().trim();
	
	if(pwd_new!=pwd_chk){
		alert("입력한 비밀번호가 일치하지 않습니다.");
		$("#password_new").select();
		return false;
	}
	
	return true;	
}
</script>
</head>
<body>
	<div id="updatePassword-container">
		<form name="updatePwdFrm" action="<%=request.getContextPath()%>/user/updatePasswordEnd" method="post" >
			<table>
				<tr>
					<th>현재 비밀번호</th>
					<td><input type="password" name="password" id="password" ></td>
				</tr>
				<tr>
					<th>변경할 비밀번호</th>
					<td>
						<input type="password" name="password_new" id="password_new" >
					</td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td>	
						<input type="password" id="password_chk" ><br>
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<div class="ui buttons">
					  <button class="ui button" onclick="self.close();">Cancel</button>
					  <div class="or"></div>
					  <button class="ui positive button" onclick="return fn_password_validate();">Save</button>
					</div>				
					</td>
				</tr>
			</table>
			<input type="hidden" name="email" value="<%=email %>" />
		</form>
	</div>
</body>
</html>