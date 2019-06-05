package review.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import review.model.vo.Review;

import static common.JDBCTemplate.close;

public class ReviewDAO {
	
	private Properties prop = new Properties();
	
	public ReviewDAO() {
		try {
			String fileName = ReviewDAO.class.getResource("/sql/review/review-query.properties").getPath();
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public List<Review> selectReviewList(Connection conn, String hotelId, int cPage, int numPerPage) {
		List<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewList");
		
		try{
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, hotelId);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);

			rset = pstmt.executeQuery();
			
			while(rset.next()){
				Review r = new Review();
				r.setReviewNo(rset.getInt("review_no"));
				r.setReviewTitle(rset.getString("review_title"));
				r.setReviewWriter(getUserName(conn, rset.getInt("customer_no")));
				r.setReviewContent(rset.getString("review_content"));
				r.setWrittenDate(rset.getDate("written_date"));
				r.setReadCnt(rset.getInt("read_cnt"));
				r.setLikeCnt(rset.getInt("like_cnt"));
				r.setDisLikeCnt(rset.getInt("dislike_cnt"));
				
				list.add(r);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int selectReviewCount(Connection conn, String hotelId) {
		PreparedStatement pstmt = null;
		int totalMember = 0;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReviewCount");
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotelId);

			rset = pstmt.executeQuery();
			
			while(rset.next()){
				totalMember = rset.getInt("cnt");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return totalMember;
	}

	public int insertReview(Connection conn, Review r) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReview"); 
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, r.getCustomerNo());
			pstmt.setString(2, r.getHotelId());
			pstmt.setString(3, r.getReviewTitle());
			pstmt.setString(4, r.getReviewContent());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectLastSeq(Connection conn) {
		int reviewNo = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectLastSeq");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				reviewNo = rset.getInt("reviewno");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return reviewNo;
	}
	
	public String getUserName(Connection conn, int customerNo) {
		String userName = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("getUserName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customerNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				userName = rset.getString("username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return userName;
		
	}

	public Review selectOne(Connection conn, int reviewNo) {
		Review r = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOne");
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);

			rset = pstmt.executeQuery();
			
			if(rset.next()){
				r = new Review();
				r.setReviewNo(rset.getInt("review_no"));
				r.setCustomerNo(rset.getInt("customer_no"));
				r.setReviewTitle(rset.getString("review_title"));
				r.setReviewWriter(getUserName(conn, rset.getInt("customer_no")));
				r.setReviewContent(rset.getString("review_content"));
				r.setWrittenDate(rset.getDate("written_date"));
				r.setReadCnt(rset.getInt("read_cnt"));
				r.setLikeCnt(rset.getInt("like_cnt"));
				r.setDisLikeCnt(rset.getInt("dislike_cnt"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return r;
	}

	public int updateReview(Connection conn, Review r) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateReview"); 
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, r.getReviewTitle());
			pstmt.setString(2, r.getReviewContent());
			pstmt.setInt(3, r.getReviewNo());
			
			result = pstmt.executeUpdate();
			System.out.println("result@dao= "+result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int increaseReadCount(Connection conn, int reviewNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseReadCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteReview(Connection conn, int reviewNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int increaseLikeCount(Connection conn, int reviewNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseLikeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int selectLikeCount(Connection conn, int reviewNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectLikeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
				result = rset.getInt("like_cnt");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int increaseDisLikeCount(Connection conn, int reviewNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseDisLikeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List<Review> selectDeletedReviewList(Connection conn, int cPage, int numPerPage) {
		List<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectDeletedReviewList");
		
		try{
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);

			rset = pstmt.executeQuery();
			
			while(rset.next()){
				Review r = new Review();
				r.setReviewNo(rset.getInt("review_no"));
				r.setReviewTitle(rset.getString("review_title"));
				r.setReviewWriter(getUserName(conn, rset.getInt("customer_no")));
				r.setReviewContent(rset.getString("review_content"));
				r.setWrittenDate(rset.getDate("written_date"));
				r.setReadCnt(rset.getInt("read_cnt"));
				r.setLikeCnt(rset.getInt("like_cnt"));
				r.setDisLikeCnt(rset.getInt("dislike_cnt"));
				
				list.add(r);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	

}
