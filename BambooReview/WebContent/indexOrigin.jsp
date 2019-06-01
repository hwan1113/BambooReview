<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset=UTF-8">
<title>BambooReview</title>
</head>
<body>
<!DOCTYPE html>
<html onresize="parent.resizeTo(1024,768)" onload="parent.resizeTo(1024,768)">
  <head>
    <meta charset="utf-8">
    <title>BambooReview</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="slider.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/slider.css" />
    
    <!-- 시맨틱 UI -->
    <link rel="stylesheet" type="text/css" href="Semantic/semantic.css">
	<script
  		src="https://code.jquery.com/jquery-3.1.1.min.js"
  		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
 		crossorigin="anonymous"></script>
	<script src="Semantic/semantic.js"></script>
	<!----------------------------------------------->
	
	<!--bootstrap-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <!----------------------------------------------->
    
    <!--------------------Scroll page--------------------------->
    <link rel="stylesheet" type="text/css" href="css/demo.css" />
     <link rel="stylesheet" type="text/css" href="css/backgroundTransition.css" />
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="backgroundTransition.js"></script>
	 <!----------------------------------------------->
	
  </head>

  <body>
  <div style="width:1024px;" align="center">

  
  
    <div class="slides">
	<section id="norwegian">
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="div1"></div>
		<div class="backgroundTransition"></div>
		<script type="text/javascript">
		  $(document).ready(function(){
			  $('.backgroundTransition').backgroundTransition({
				  backgrounds:[
					  { src: "/BambooReview/images/main-back1.jpg" },
					  { src: "/BambooReview/images/main-back2.jpg" },
					  { src: "/BambooReview/images/main-back3.jpg" },
					  { src: "/BambooReview/images/main-back4.jpg" },
					  { src: "/BambooReview/images/main-back5.jpg" },
					  { src: "/BambooReview/images/main-back6.jpg" },
					  { src: "/BambooReview/images/main-back7.jpg" }
				  ],
				  transitionDelay: 2,
				  animationSpeed: 400
			  });
		  });
		</script>
      		<img src="/BambooReview/images/bamboo.png" id="page1-logo" />
      		<span id="page1-intro">전세계 모든 숙박 시설에 대해 솔직하고 믿을 수 있는 후기를 남길 수 있는 리뷰 커뮤니티</span>
      		
      </section>
      
      <section id="french">
      	<div class="div2"></div>
      	<span>숙박후기, 여기서 보세요!</span>
      		<div class="ui category search" id="search-location">
 			 	<div class="ui icon input">
 			 	
    				<input id="srch-input" class="prompt" type="text" placeholder="Search location..." name="srch-input">
    			<i class="search icon"></i>
 				</div>
 			 	<div class="results"></div>
 			 </div>
 			 <button class="ui green button" id="searh-button">search</button>


      </section>
      <section id="spanish" class="animated">
      
      <!--1번-->
      	<div class="card mb-3" style="max-width: 540px;" id="main-card1">
  				<div class="row no-gutters">
    				<div class="col-md-4">
      					<img src="/BambooReview/images/main-review1.jpg" class="main-review">
    				</div>
    			<div class="col-md-8">
      				<div class="card-body">
        				<h5 class="card-title">깨끗하고 좋았습니다</h5>
        				<p class="card-text">가격도 저렴하고 시설도 깨끗했습니다. 위치도 좋아서 대중교통 이용하기도 편합니다!</p>
        				<p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
      				</div>
    			</div>
  			</div>
		</div>
		<!--2번-->
		<div class="card mb-3" style="max-width: 540px;" id="main-card2">
  				<div class="row no-gutters">
    				<div class="col-md-4">
      					<img src="/BambooReview/images/main-review2.jpg" class="main-review">
    				</div>
    			<div class="col-md-8">
      				<div class="card-body">
        				<h5 class="card-title">전망이 좋아요!</h5>
        				<p class="card-text">조식도 맛있고, 직원분들도 친절하십니다. 또 가고 싶네요</p>
        				<p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
      				</div>
    			</div>
  			</div>
		</div>
		<!--3번-->
		<div class="card mb-3" style="max-width: 540px;" id="main-card3">
  				<div class="row no-gutters">
    				<div class="col-md-4">
      					<img src="/BambooReview/images/main-review3.jpg" class="main-review">
    				</div>
    			<div class="col-md-8">
      				<div class="card-body">
        				<h5 class="card-title">깨끗하고 좋았습니다</h5>
        				<p class="card-text">가격도 저렴하고 시설도 깨끗했습니다. 위치도 좋아서 대중교통 이용하기도 편합니다!</p>
        				<p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
      				</div>
    			</div>
  			</div>
		</div>
		<div class="div3"></div>
      <span>유저 후기로 인증된 신뢰 1위 커뮤니티</span>
      
      </section>
      <section id="hindi">
      <div class="div4"></div>
      <span class="adver1">숙박 광고를 위한 최고의 파트너  </span>
      <span class="adver2">여행을 계획하고있는 수많은 고객이 방문하는 BamBooReview에서 최상의 광고효과를 얻을 수 있습니다!  </span>
      <%@ include file="/WEB-INF/views/common/footer.jsp" %>
      
      <div class="card" style="width: 15rem;" id="thanos">
	  <img src="/BambooReview/images/thanos.jpg" class="card-img-top" alt="...">
	  <div class="card-body">
	    <p class="card-text">Team Thanos. contact:ageg123@naver.com</p>
	  </div>
	</div>
		<form action="<%=request.getContextPath()%>/hotel/hotelList"
      				name="hotelDataFrm" id="hotelDataFrm" method="post">
       			<input type="hidden" name="hotelData" id="hotelData"/>
    			<input type="hidden" name="srchword" id="srchword">
   		</form>
	
     	 
      </section>
    </div>

    <script>
      slider('.slides');
      /* function callAjax(url, callback){
    	    var xmlhttp;
    	    xmlhttp = new XMLHttpRequest();
    	    xmlhttp.onreadystatechange = function(){
    	        if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
    	            console.log(xmlhttp);
    	        }
    	    }
    	    xmlhttp.open("GET", 'https://maps.googleapis.com/maps/api/place/textsearch/json?query=hotels+in+'+
            		$("#srch-input").val()+
            		'&key=AIzaSyBamfF6Gj9yf1Spt6oL6sX1GB86eMTtI6U', true);
    	    xmlhttp.send();
    	} */
      
       $("#searh-button").click(function(){
    	  if($("#srch-input").val()==''){
    		  $("#srch-input").val("london")
    	  }
          		$.ajax({
                url:'https://maps.googleapis.com/maps/api/place/textsearch/json?query=hotels+in+'+
                		$("#srch-input").val()+
                		'&key=AIzaSyBamfF6Gj9yf1Spt6oL6sX1GB86eMTtI6U',
                type:'GET',
                success: function(data){
                	console.dir(data.results)
                    Arr =[];
                    for(var i=0; i<3; i++){
                        hotel = {};
                        hotel.id = data.results[i].place_id
                        hotel.name = data.results[i].name
                        if(data.results[i].photos){
                        hotel.photo = data.results[i].photos[0].photo_reference}
                        hotel.address = data.results[i].formatted_address
                        hotel.rate = data.results[i].rating
                        hotel.info = data.results[i].types
                        Arr.push(hotel)
                    }
                    var json = JSON.stringify(Arr);
                    $("#hotelData").val(json)
             		$("#srchword").val($("#srch-input").val())
                    $("#hotelDataFrm").submit()
                },
                error:function(jqxhr, textStatus, errorThrown){
                    console.log("ajax처리실패!")
                    console.log(jqxhr);
                     console.log(textStatus);
                     console.log(errorThrown);
                }
            })
      })
      
    </script>
    </div>
  </body>
</html>

</body>
</html>
 
 
 
 