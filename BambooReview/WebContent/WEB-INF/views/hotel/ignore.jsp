<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String hotelData = (String) request.getAttribute("hotelData");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
  		src="https://code.jquery.com/jquery-3.1.1.min.js"
  		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
 		crossorigin="anonymous"></script>
<title>이페이지는 무시하세요</title>
<style>
div{
border:1px solid;
}

</style>
</head>
<body>
	<ol>
  		<li>List item 1</li>
	</ol>

	<div id="name"></div>
	<div id="info"></div>
	<div id="photo"></div>
	<div id="address"></div>
	<div id="hotelId"></div>
	<div id="rating"></div>
	<img src="https://images.unsplash.com/photo-1556229174-5e42a09e45af?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=343&q=80" alt="" id="hotelPhoto"/>
	
<script>
for(var i=0; i < <%=hotelData%>.length; i++){
	$("ol").append("<li>"+<%=hotelData%>[i].name +"</li>");
	$("ol").append("<li>"+<%=hotelData%>[i].address +"</li>");
	$("ol").append("<li>"+<%=hotelData%>[i].info +"</li>");
	$("ol").append("<li>"+<%=hotelData%>[i].rate +"</li>");
}


$(function(){
	
	
	
	$("#hotelPhoto").attr("src", "https://maps.googleapis.com/maps/api/place/photo?photoreference=CmRaAAAA77mrRjormFMt-MoRZ2WMTUQJGdWSEUXy05izyFHctlvtAZD-TooskWocHA9mVqqAKrzqG_DaPQx-xMYDSgU_BNxmwLIoVo2dnuJQYpZsd_lyJccztH6GfP-ru9M2fNH1EhAPPNRYTynKSDW3R04eMWOTGhSKYDChsxfrf19s9NKtHEt2jfr1yw&key=AIzaSyBamfF6Gj9yf1Spt6oL6sX1GB86eMTtI6U&maxheight=100&maxwidth=100")
	
	
	<%-- for(var i=0; i < <%=hotelData%>.length; i++){
	$("#name").html(<%=hotelData%>[i].name)
	$("#address").html(<%=hotelData%>[i].address)
	$("#info").html(<%=hotelData%>[i].info)
	$("#rating").html(<%=hotelData%>[i].rate)
	} --%>
})

</script>
</body>
</html>