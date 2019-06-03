<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script>
IMP.init("imp28947597");
IMP.request_pay({ // param
    pg: "html5_inicis",
    pay_method: "card",
    merchant_uid: "ORD20180131-0000011",
    name: "노르웨이 회전 의자",
    amount: 64900,
    buyer_email: "gildong@gmail.com",
    buyer_name: "홍길동",
    buyer_tel: "010-4242-4242",
    buyer_addr: "서울특별시 강남구 신사동",
    buyer_postcode: "01181"
}, function (rsp) { // callback
    if (rsp.success) {
        console.log(rsp.success)
        // 결제 성공 시 로직,
    } else {
    	console.log("fail")
    }
});

</script>
<body>


</body>
</html>