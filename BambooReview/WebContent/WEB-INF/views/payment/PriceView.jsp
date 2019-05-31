<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/payment.css" />
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic+Coding&display=swap" rel="stylesheet">
<div class="all"></div>
<div class="ui small message">이용권 안내</div>
<div class="ui placeholder segment">
<div class="ui green message" id="month">베이직(한달 이용권)</div>
<div class="ui teal message" id="year">프리미엄(1년 이용권)</div>
  <div class="ui two column very relaxed stackable grid">
          <p class="month-detail">한달간 커뮤니티 모든 글 열람,등록, 수정, 삭제가능</p>
    <div class="column">
      <div class="ui form">
        <div class="field">
        </div>
        <div class="field">
        </div>
      </div>
    </div>
    <div class="middle aligned column">
  	<p class="year-detail">일년간 커뮤니티 모든 글 열람,등록, 수정, 삭제가능</p>
    </div>
  </div>
  <div class="ui vertical divider">
    Or
  </div>
</div>
<div class="ui buttons">
  <button class="ui button" onclick="location.href='index.jsp' ">뒤로가기</button>
  <div class="or"></div>
  <button class="ui positive button">결제하기</button>
</div>



<%@ include file="/WEB-INF/views/common/footer.jsp" %>