  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/payment.css" />
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic+Coding&display=swap" rel="stylesheet">


<div class="all"></div>
<div class="ui centered grid">
<div class="all-content">
<div class="ui small message" style="text-align:center; font-size:14px; font-family:sans-serif; font-weight:bold">이용권 안내</div>
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
<div class="ui buttons" style="position:absolute; left:41%; top:510px; ">
  <button class="ui button" onclick="location.href='<%=request.getContextPath()%>/index.jsp'">뒤로가기</button>
  <div class="or"></div>
  <%if(userLoggedIn==null) {%>
  <button class="ui positive button" onclick="sendBack()">결제하기</button>
  <%}else{ %>
  <button class="ui positive button" onclick="requestPay()">결제하기</button>
  <input type="hidden" value="<%=userLoggedIn.getCustomer_no()%>" id="pay_cust_no"/>
  <input type="hidden" value="<%=userLoggedIn.getEmail()%>" id="pay_eamil"/>
  <input type="hidden" value="<%=userLoggedIn.getUserName()%>" id="pay_name"/>
  <%} %>
</div>
<form action="<%=request.getContextPath()%>/payment/paid" id="paidFrm">
<input type="hidden" name="merchantid" id="merchantid">
</form>
</div>
</div>
<script>
IMP.init("imp28947597");

function sendBack() {
	alert("로그인 후 이용가능합니다.")
	return location.href='<%=request.getContextPath()%>/user/userLogin'
}


function requestPay() {
	const email = $("#pay_email").val()
	const name = $("#pay_name").val()
	param={ customer_no: $("#pay_cust_no").val(),
			amount: 1000}
	var merchant_uid;
	$.ajax({
		url: '<%=request.getContextPath()%>/payment/paymentInfo',
		type: "get",
		data:param,
		success: function(data){
			if(data==null){
				alert("현재 거래가 불가능합니다.")
			}
			$("#merchantid").val(data.payment_no)
			IMP.request_pay({ // param
			    pg: "html5_inicis",
			    pay_method: "card",
			    merchant_uid: data.payment_no,
			    name: "베이직(한달 이용권)",
			    amount: data.amount,
			    buyer_email: email,
			    buyer_name: name,
			    buyer_tel: "010-4242-4242",
			    buyer_addr: "서울특별시 강남구 신사동",
			    buyer_postcode: "01181"
			}, function (rsp) { // callback
			    if (rsp.success) {
			    	
			    } else {
			    	$("#paidFrm").submit()
			    }
			});
			
			
		},
		error:function(jqxhr,textStatus,errorThrown){
			console.log("ajax처리 실패!")
			console.log(jqxhr);
			console.log(textStatus);
			console.log(errorThrown);
		}
	})
	
}

</script>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>