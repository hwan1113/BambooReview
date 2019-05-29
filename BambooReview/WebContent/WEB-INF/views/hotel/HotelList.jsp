<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%@ include file="/WEB-INF/views/common/header.jsp" %>
 <%@ include file="/WEB-INF/views/common/footer.jsp" %>
<html>
<head>
<meta charset=UTF-8">
<title>Hotel List</title>
<link rel="stylesheet" type="text/css" href="css/HotelList.css" />
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic+Coding&display=swap" rel="stylesheet">
<!--bootstrap-->
	<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script> -->
<!----------------------------------------------->
<!-- 시맨틱 UI -->
    <link rel="stylesheet" type="text/css" href="Semantic/semantic.css">
	<script
  		src="https://code.jquery.com/jquery-3.1.1.min.js"
  		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
 		crossorigin="anonymous"></script>
	<script src="Semantic/semantic.js"></script>
	<!----------------------------------------------->
</head>
<body style="width:1024px;" align="center" id="listbody">
<div class="backbox"></div>
<br />
	<h2 id="re">???지역의 호텔 리스트 입니다.</h2>
	<div>정렬조건</div>
<div class="ui mini star rating"></div>
<div class="ui rating" data-max-rating="1"></div>
<div class="ui card" id="cardlist">
		<div class="slideshow-container">
		
		<div class="listSlides fade">
		  <img src="/BambooReview/images/main-back1.jpg" >
		</div>
		
		<div class="listSlides fade">
		  <img src="/BambooReview/images/thanos2.jpg" >
		</div>
		
		<div class="listSlides fade">
		  <img src="/BambooReview/images/main-back3.jpg" >
		</div>
		
		
		
		</div>
<!-- <br> -->

<div style="height:20px;" class="hoteldot" >
  <span class="dot" onclick="currentSlide(1)"></span> 
  <span class="dot" onclick="currentSlide(2)"></span> 
  <span class="dot" onclick="currentSlide(3)"></span> 
</div>

  <div class="content">
  <div class="textarea">위치:어딘가, 시설:ㄱㅊㄱㅊ, 교통:별로임, 가격:짱비쌈</div>
    
    <div class="header">sd
    <i class="right floated like icon"></i>
    </div>
  
  </div>
</div>
</div>



<script>
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("listSlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}
</script>

	
</body>
</html>
