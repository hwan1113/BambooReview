<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <html>
 <head>
 <script>
(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
})(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
ga('create', 'UA-128561305-2', 'auto');
ga('send', 'pageview');
</script>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Welcome, BambooReview</title>

  <!--------------------Full page--------------------------->
  <script src="<%=request.getContextPath()%>/js/slider.js"></script>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/slider.css" />
  <!----------------------------------------------->

  <link rel="stylesheet" type="text/css" href="css/backgroundTransition.css" />
  
 </head>
 
  <body>
    <div class="slides">
      <section id="first">
      	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<!--------------------Scroll page--------------------------->
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="js/backgroundTransition.js"></script>
	<!----------------------------------------------->
	
		<div class="div1"></div>
		<div class="backgroundTransition"></div>
		
		<img src="/BambooReview/images/bamboo.png" id="page1-logo" />
      	<span id="page1-intro">전세계 모든 숙박 시설에  <br>대해 솔직하고 믿을 수 있는 <br> 후기를 남길 수 있는 리뷰 커뮤니티</span>
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
 		<button class="ui green button" id="searh-button"><i class="search icon"></i>search</button>
 		 <form action="<%=request.getContextPath()%>/hotel/hotelList?srchword=london"
      				name="hotelDataFrm" id="hotelDataFrm" method="get">
    			<input type="hidden" name="srchword" id="srchword">
      			<input type="hidden" name="userId" id="userId" value="<%=userLoggedIn %>"/>
       			<input type="hidden" name="hotelData" id="hotelData"/>
   		</form>
 		
      </section>
      
      <section id="third" class="animated">
    	 <!--1번-->
      	<div class="card mb-3" id="main-card1">
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
		<div class="card mb-3"  id="main-card2">
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
		<div class="card mb-3" id="main-card3">
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
		<span>유저 후기로 인증된 <br>신뢰 1위 커뮤니티</span>
      </section>
      
      <section id="fourth">
		<div class="div4"></div>
      	<span class="adver1">숙박 광고를 위한<br> 최고의 파트너  </span>
      	<span class="adver2">여행을 계획하고있는 수많은 고객이 방문하는 <br>BamBooReview에서 최상의 광고효과를 얻을 수 있습니다!  </span>
      	<div class="card" id="thanos">
	  		<img src="/BambooReview/images/thanos.jpg" class="card-img-top">
	  		<div class="card-body">
	    	<p class="card-text">Team Thanos. contact:ageg123@naver.com</p>
	  		</div>
		</div>
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
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

$("#searh-button").click(function(){
	if($("#userId").val()=="null"){
		return alert("로그인후 사용해주세요.")
	}
	if($("#srch-input").val()==''){
		$("#srch-input").val("london")
	}
	param = {keyword:$("#srch-input").val()}
	
	$.ajax({
	url: "<%=request.getContextPath()%>/hotel/hotelInfo",
	dataType: "json",
	data:param,
	success: function(data){
	    Arr =[];
        for(var i=0; i<5; i++){
            hotel = {};
            hotel.id = data.results[i].place_id
            hotel.name = data.results[i].name
            if(data.results[i].photos){
            hotel.photo = data.results[i].photos[0].photo_reference}
            hotel.address = data.results[i].formatted_address
            hotel.rate = data.results[i].rating
            hotel.info = data.results[i].types
            Arr.push(hotel)
             var json = JSON.stringify(Arr);
              $("#hotelData").val(json)
       		$("#srchword").val($("#srch-input").val())
              $("#hotelDataFrm").submit()
        }
	},
	error:function(jqxhr, textStatus, errorThrown){
        console.log("ajax처리실패!")
        console.log(jqxhr);
         console.log(textStatus);
         console.log(errorThrown);
    }
	});
})
	
	
	
    </script>
  </body>
</html>
