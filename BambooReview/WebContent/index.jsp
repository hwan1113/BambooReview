<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <html>
 <head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Landing</title>
 
 <script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
  
  <link rel="stylesheet" type="text/css" href="css/backgroundTransition.css" />
  <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
  <script type="text/javascript" src="backgroundTransition.js"></script>
   
   <script src="<%=request.getContextPath()%>/slider.js"></script>
   <link rel="stylesheet" href="<%=request.getContextPath()%>/css/slider.css" />

 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.css"/>
 </head>
  <body>
    <div class="slides">
      <section id="first">
      	<div class="ui menu" style="background-color:#68b30d; opacity: 0.8;">
  			<div class="header item">
    			<a href="<%=request.getContextPath()%>" class="home-logo"><img style= "height:85px"src="<%=request.getContextPath()%>/images/bambooHeader.png"></a>
 			 </div>
			  <a class="item right">
  			  About Us
 			 </a>
 			 <a class="item">
   			 Jobs
  			</a>
  			<a class="item">
    		Locations
  			</a>
		</div>
		<div class="div1"></div>
		<div class="backgroundTransition"></div>
		
		<img src="/BambooReview/images/bamboo.png" id="page1-logo" />
      	<span id="page1-intro">전세계 모든 숙박 시설에 대해 솔직하고 믿을 수 있는 <br><br> 후기를 남길 수 있는 리뷰 커뮤니티</span>
      </section>
      
      <section id="second">
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
      
      <section id="third" class="animated">
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
      
      <section id="fourth">

      </section>
      
      <section id="mandarin">
   
      
      </section>
    </div>

   <script>
      slider('.slides');
      $(document).ready(function(){
		  $('.backgroundTransition').backgroundTransition({
			  backgrounds:[
				  { src: "<%=request.getContextPath()%>/images/main-back1.jpg" },
				  { src: "<%=request.getContextPath()%>/images/main-back2.jpg" },
				  { src: "<%=request.getContextPath()%>/images/main-back3.jpg" },
				  { src: "<%=request.getContextPath()%>/images/main-back4.jpg" },
				  { src: "<%=request.getContextPath()%>/images/main-back5.jpg" },
				  { src: "<%=request.getContextPath()%>/images/main-back6.jpg" },
				  { src: "<%=request.getContextPath()%>/images/main-back7.jpg" }
			  ],
			  transitionDelay: 2,
			  animationSpeed: 400
		  });
	  });
    </script>
  </body>
</html>
