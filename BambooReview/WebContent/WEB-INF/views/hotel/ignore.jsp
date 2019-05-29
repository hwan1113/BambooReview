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
	<div id="name"></div>
	<div id="info"></div>
	<div id="photo"></div>
	<div id="address"></div>
	<div id="hotelId"></div>
	<div id="rating"></div>
	<img src="" alt="" id="hotelPhoto"/>
	
<script>
$(function(){
	
/* 	 $.ajax({
		url:"https://maps.googleapis.com/maps/api/place/photo?photoreference=CmRaAAAA77mrRjormFMt-MoRZ2WMTUQJGdWSEUXy05izyFHctlvtAZD-TooskWocHA9mVqqAKrzqG_DaPQx-xMYDSgU_BNxmwLIoVo2dnuJQYpZsd_lyJccztH6GfP-ru9M2fNH1EhAPPNRYTynKSDW3R04eMWOTGhSKYDChsxfrf19s9NKtHEt2jfr1yw&key=AIzaSyBamfF6Gj9yf1Spt6oL6sX1GB86eMTtI6U&maxheight=100&maxwidth=100",
		type:"get",
		success: function(data){
			$("#photo").()
			$("#hotelPhoto").attr("src", "data:image/gif;base64,"+data)
			console.dir($("#hotelPhoto"))
			
		},
		error:function(jqxhr, textStatus, errorThrown){
			console.log("ajax처리실패!")
			console.log(jqxhr);
			console.log(textStatus);
			console.log(errorThrown);
>>>>>>> refs/remotes/origin/khkim
		}
	}) */
	
	for(var i=0; i<<%=hotelData%>.length; i++){
	$("#name").html(<%=hotelData%>[i].name)
	$("#address").html(<%=hotelData%>[i].address)
	$("#info").html(<%=hotelData%>[i].info)
	$("#rating").html(<%=hotelData%>[i].rate)
	}

	
	
>>>>>>> refs/remotes/origin/khkim
})

</script>
</body>
</html>