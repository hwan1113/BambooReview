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
	function myHandler(){
		var data;
		//readyState = 1,2,3,4
		if(xhr.readyState==4){
			//통신연결 완료화, 데이터전송완료된 경우
			if(xhr.status==200)
				console.log("ajax처리완료!!");
				data = JSON.parse(xhr.responseText);
				console.dir(data)
				$.ajax({
					url: "<%=request.getContextPath()%>/jquery/html",
					type:"get",
					success:function(data){
						console.log("ajax처리 성공")
						$(".test").html(data);
					},
					error:function(jqxhr, textStatus, errorThrown){
						console.log("ajax처리실패!")
						console.log(jqxhr);
						console.log(textStatus);
						console.log(errorThrown);
					}
				});
				
				
		}
	}
	
	
	var xhr = new XMLHttpRequest();
	xhr.open("get", "https://maps.googleapis.com/maps/api/place/textsearch/json?query=hotels+in+런던&key=AIzaSyBamfF6Gj9yf1Spt6oL6sX1GB86eMTtI6U", 
			true);
	xhr.onreadystatechange= myHandler;
	xhr.send();
})

</script>
</body>
</html>