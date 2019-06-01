package user.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import user.model.dao.UserDAO;
import user.model.vo.User;

public class UserService {

	public int loginCheck(User u) {
		Connection conn = getConnection();
		int result = new UserDAO().loginCheck(conn, u);
		close(conn);
		return result;
		
		
	}

	public User selectOne(String email) {
		Connection conn = getConnection();
		User u = new UserDAO().selectOne(conn, email);
		close(conn);
		return u;
	}

	public int insertUser(User u) {
		Connection conn = getConnection();
		int result = new UserDAO().insertUser(conn, u);
		close(conn);
		return result;
	}

	public int deleteUser(String email) {
		Connection conn = getConnection();
		int result = new UserDAO().deleteUser(conn, email);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		return result;
	}

	public int updateUser(User u) {
		Connection conn = getConnection();
		int result = new UserDAO().updateUser(conn, u);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		return result;
	}

}
