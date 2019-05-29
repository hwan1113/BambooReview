<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이페이지는 무시하세요</title>
</head>
<body>
	
<script>
$(function(){
$.ajax({
	url:"https://maps.googleapis.com/maps/api/place/textsearch/json?query=hotels+in+seoul&key=AIzaSyBamfF6Gj9yf1Spt6oL6sX1GB86eMTtI6U&type=lodging",
	type:"get",
	dataType:"json",
	success: function(data){
		console.log(data)
		
		}
	})
})

</script>
</body>
</html>