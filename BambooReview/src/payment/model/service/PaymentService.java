package payment.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import payment.model.dao.PaymentDAO;
import payment.model.vo.Payment;

public class PaymentService {
	
	
	public Payment getPaymentInfo() {
		Connection conn = getConnection();
		Payment p= new PaymentDAO().getPaymentInfo();
		close(conn);
		return p;
	}

}
