package payment.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import payment.model.dao.PaymentDAO;
import payment.model.vo.Payment;
import user.model.vo.User;

public class PaymentService {
	
	
	public int insertPaymentInfo(int customer_no) {
		int result = 0;
		Connection conn = getConnection();
		result= new PaymentDAO().insertPaymentInfo(conn, customer_no);
		close(conn);
		return result;
	}

	public Payment selectPaymentInfo(int customer_no) {
		Payment p =null;
		Connection conn = getConnection();
		p= new PaymentDAO().selectPaymentInfo(conn, customer_no);
		close(conn);
		return p;
	}

}
