package payment.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import payment.model.vo.Payment;
import user.model.vo.User;

public class PaymentDAO {
	
	private Properties prop = new Properties();
	
	public PaymentDAO() {
		String fileName = getClass().getResource("/sql/payment/payment-query.properties")
				.getPath();
		try {
		prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
	}

	public int insertPaymentInfo(Connection conn, int customer_no, int amount) {
		int result = 0;
		String sql = prop.getProperty("insertPaymentInfo");
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customer_no);
			pstmt.setInt(2, amount);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}

	public payment.model.vo.Payment selectPaymentInfo(Connection conn, int customer_no) {
		Payment p  = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customer_no);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				p = new Payment();
				p.setCustomer_no(rset.getInt("customer_no"));
				p.setPayment_no(rset.getInt("payment_no"));
				p.setAmount(rset.getInt("amount"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return p;
	}

	public int updatePaymentInfo(Connection conn, int payment_no) {
		int result = 0;
		String sql = prop.getProperty("updatePaymentInfo");
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, payment_no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
}
