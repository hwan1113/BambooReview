<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!DOCTYPE html>
<html onresize="parent.resizeTo(1024,768)" onload="parent.resizeTo(1024,768)">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BamBoo Review</title>
    <script src="slider.js"></script>
    <link rel="stylesheet" href="slider.css">
    <link rel="stylesheet" type="text/css" href="semantic/dist/semantic.min.css">
	<script
  		src="https://code.jquery.com/jquery-3.1.1.min.js"
  		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
 		crossorigin="anonymous"></script>
	<script src="semantic/dist/semantic.min.js"></script>
  </head>

  <body>
    <div class="slides">
      <section id="norwegian">
      		<img src="/semi/images/main1.jpg" id="page1-img" />
      		<img src="/semi/images/bamboo.png" id="page1-logo" />
      		<span id="page1-intro">전세계 모든 숙박 시설에 대해 솔직하고 믿을 수 있는 후기를 남길 수 있는 리뷰 커뮤니티</span>
      </section>
      <section id="french"><span>숙박후기, 여기서 보세요!</span></section>
      <section id="spanish"><span>Hola</span></section>
      <section id="hindi"><span>Namaste</span></section>
      <section id="mandarin"><span>你好</span></section>
    </div>

    <script>
      slider('.slides');
    </script>
  </body>
</html>

</body>
</html>