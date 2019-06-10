<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.json.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	String hotelData = (String)request.getAttribute("hotelData");
	String srchWord  = (String)request.getAttribute("srchWord");
	if(srchWord==null){srchWord="London";}
	hotelData = "{\"results\":"+hotelData+"}";
	JSONObject obj = new JSONObject(hotelData);
	JSONArray HotelArr = obj.getJSONArray("results");	
	
%>
<title>Hotel List</title>

<%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/css/HotelList.css" /> --%>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic+Coding&display=swap" rel="stylesheet">
<!-- 시맨틱 UI -->
<script
  	src="https://code.jquery.com/jquery-3.1.1.min.js"
  	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
 	crossorigin="anonymous"></script>
<!----------------------------------------------->
	<h3 class="ui block header centered">
 	 	<%=srchWord%>지역의 호텔 리스트 입니다.
	</h3>
	<input id="srchedWord" name="srchedWord" type="hidden" value="<%=srchWord%>">
	
	<% if(HotelArr.length()==0){ %>
			<div>검색결과가 없습니다.</div>
	<% }else {
			for (int i = 0; i < HotelArr.length(); i++){
	%>
	<div class="ui grid">
		<div class="two wide column"></div>
		<div class="ui items eleven wide column raised very padded text container segment">
  			<div class="item">
    			<div class="image" >
      				<img src="https://maps.googleapis.com/maps/api/place/photo?photoreference=<%=HotelArr.getJSONObject(i).getString("photo")%>&key=AIzaSyBamfF6Gj9yf1Spt6oL6sX1GB86eMTtI6U&maxheight=70&maxwidth=100" style="border:3px solid black; height:150px;">
    			</div>
    			<div class="content">
     			 	<a class="header" href="<%=request.getContextPath()%>/review/reviewList?hotelId=<%=HotelArr.getJSONObject(i).getString("id")%>&hotelName=<%=HotelArr.getJSONObject(i).getString("name")%>&srchWord=<%=srchWord%>"><%=HotelArr.getJSONObject(i).getString("name")%></a>
     				 <div class="meta">
        			<span><%=HotelArr.getJSONObject(i).getString("address") %></span>
      				</div>
      				<div class="description">
        			<p>편의시설: <%=HotelArr.getJSONObject(i).getJSONArray("info").toString()%></p>
      				</div>
      				<div class="extra"> 평점: 
        			<%=HotelArr.getJSONObject(i).getDouble("rate")%>
      				</div>
    			</div>
  			</div>
  		</div>
  		<div class="three wide column"></div>
	</div>
	
	
	
	
	

	    		
	<%		} 
		}
	%>
	



<script>

</script>

