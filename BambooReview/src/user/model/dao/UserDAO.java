package user.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import user.model.vo.User;

public class UserDAO {
	
	private Properties prop = new Properties();
	
	public UserDAO() {
		String fileName = getClass().getResource("/sql/user/user-query.properties")
				.getPath();
		try {
		prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
	}

	public int loginCheck(Connection conn, User u) {
		int result = 0;
		String sql = prop.getProperty("selectOne");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getEmail());
			rset = pstmt.executeQuery();
			
			String email = "";
			String password = "";
			//리턴된 행이 있을 경우
			if(rset.next()) {
				email = rset.getString("email");
				password = rset.getString("password");
			}
			
			//비교 및 결과 도출
			if(email.equals(u.getEmail()) 
					&& password.equals(u.getPassword())) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public User selectOne(Connection conn, String email) {
		User u = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				u = new User();
				u.setCustomer_no(rset.getInt("customer_no"));
				u.setEmail(rset.getString("email"));
				u.setPassword(rset.getString("password"));
				u.setUserName(rset.getString("name"));
				u.setProfile(rset.getString("profile"));
				u.setPhone(rset.getString("phone"));
				u.setEnrollDate(rset.getDate("enrolldate"));
				u.setQuitDate(rset.getDate("quitdate"));
				u.setStatus(rset.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return u;
	}

	public int insertUser(Connection conn, User u) {
		int result = 0;
		String sql = prop.getProperty("insertUser");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getEmail());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getUserName());
			pstmt.setString(4, u.getPhone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int deleteUser(Connection conn, String email) {
		int result = 0;
		String sql = prop.getProperty("deleteUser");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int updateUser(Connection conn, User u) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateuser"); 

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, u.getUserName());
			pstmt.setString(2, u.getPhone());
			pstmt.setString(3, u.getEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int insertGoogleUser(Connection conn, User u) {
		int result = 0;
		String sql = prop.getProperty("insertGoogleUser");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getEmail());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getUserName());
			pstmt.setString(4, u.getPhone());
			pstmt.setString(5, u.getStatus());
			pstmt.setString(6, u.getProfile());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

}
