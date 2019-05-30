<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.json.*" %>
<%@ include file="/WEB-INF/views/common/headerCommon.jsp" %>
<%
	String hotelData = (String)request.getAttribute("hotelData");
	String srchWord  = (String)request.getAttribute("srchWord");
	hotelData = "{\"results\":"+hotelData+"}";
	JSONObject obj = new JSONObject(hotelData);
	JSONArray HotelArr = obj.getJSONArray("results");	
%>
<head>
<title>Hotel List</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/HotelList.css" />
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic+Coding&display=swap" rel="stylesheet">
<!-- 시맨틱 UI -->
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/Semantic/semantic.css">
	<script
  		src="https://code.jquery.com/jquery-3.1.1.min.js"
  		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
 		crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath() %>/Semantic/semantic.js"></script>
<!----------------------------------------------->
</head>
<body style= "width:100%;" align="center" id="listbody">
<div class="backbox">
<p></p>
	<h2 id="re"><%=srchWord %>지역의 호텔 리스트 입니다.</h2>
	<div class="ui visible message"><p>정렬 방식</p>
		<div class="ui text menu">
			  <div class="header item">Sort By</div>
			  <a class="active item">
			    Closest
			  </a>
			  <a class="item">
			    Most Comments
			  </a>
			  <a class="item">
			    Most Popular
			  </a>
		</div>	
	</div>
	<% if(HotelArr.length()==0){ %>
			<div>검색결과가 없습니다.</div>
	<% }else {
			for (int i = 0; i < HotelArr.length(); i++){
	%>
		<div class="ui card" id="cardlist">
			<div class="slideshow-container">
				<div class="listSlides fade">
			 		<img src="https://maps.googleapis.com/maps/api/place/photo?photoreference=<%=HotelArr.getJSONObject(i).getString("photo")%>&key=AIzaSyBamfF6Gj9yf1Spt6oL6sX1GB86eMTtI6U&maxheight=100&maxwidth=100" >
				</div>
			</div>
	
	  		<div class="content">
	    		<div class="header"><%=HotelArr.getJSONObject(i).getString("name")%><i class="right floated like icon"></i></div>
	  			<div class="textarea"><%=HotelArr.getJSONObject(i).getString("address") %></div>
	  			<div class="textarea"><%=HotelArr.getJSONObject(i).getJSONArray("info").toString()%></div>
	    		<div class="ui rating" data-rating=<%=HotelArr.getJSONObject(i).getDouble("rate")%> data-max-rating="5"><%=HotelArr.getJSONObject(i).getDouble("rate")%></div>
	  		</div>
		</div>
	<%		} 
		}
	%>
	
	
	
	<!-- <div class="ui card" id="cardlist">
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
	<br>
	
	<div style="height:20px;" class="hoteldot" >
	  <span class="dot" onclick="currentSlide(1)"></span> 
	  <span class="dot" onclick="currentSlide(2)"></span> 
	  <span class="dot" onclick="currentSlide(3)"></span> 
	</div>
	</div> -->
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
  //dots[slideIndex-1].className += " active";
}


$('.ui.rating')
.rating({
  initialRating: 3,
  maxRating: 5
})
;
</script>

