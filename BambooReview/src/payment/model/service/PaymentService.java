package payment.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import payment.model.dao.PaymentDAO;
import payment.model.vo.Payment;
import user.model.vo.User;

public class PaymentService {
	
	
	public Payment getPaymentInfo(String customer_no) {
		Connection conn = getConnection();
		Payment p= new PaymentDAO().getPaymentInfo(conn, customer_no);
		close(conn);
		return p;
	}

}
