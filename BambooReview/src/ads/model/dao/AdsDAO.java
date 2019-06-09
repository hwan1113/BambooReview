package ads.model.dao;

import static common.JDBCTemplate.close;

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

import ads.model.vo.Ads;
import review.model.vo.Review;
import review.model.vo.ReviewComment;

public class AdsDAO {
	
	private Properties prop = new Properties();
	
	public AdsDAO() {
		try {
			String fileName = AdsDAO.class.getResource("/sql/ads/ads-query.properties").getPath();
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public List<Ads> selectAdsList(Connection conn, int cPage, int numPerPage) {
		List<Ads> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAdsList");
		
		try{
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);

			rset = pstmt.executeQuery();
			
			while(rset.next()){
				Ads ads = new Ads();
				ads.setAdsNo(rset.getInt("ads_no"));
				ads.setAdsTitle(rset.getString("ads_title"));
				ads.setAdsWriter(getUserName(conn, rset.getInt("customer_no")));
				ads.setAdsContent(rset.getString("ads_content"));
				ads.setWrittenDate(rset.getDate("written_date"));
				ads.setReadCnt(rset.getInt("read_cnt"));
				ads.setLikeCnt(rset.getInt("like_cnt"));
				ads.setDisLikeCnt(rset.getInt("dislike_cnt"));
				
				list.add(ads);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int selectAdsCount(Connection conn) {
		PreparedStatement pstmt = null;
		int totalAdsCount = 0;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAdsCount");
		
		try{
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				totalAdsCount = rset.getInt("cnt");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return totalAdsCount;
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
				r.setHotelId(rset.getString("hotel_id"));
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

	public int likeCheck(Connection conn, int reviewNo, int customerNo) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("likeCheck");
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			pstmt.setInt(2, customerNo);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int disLikeCheck(Connection conn, int reviewNo, int customerNo) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("disLikeCheck");
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			pstmt.setInt(2, customerNo);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int rateCheck(Connection conn, int reviewNo, int customerNo) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("rateCheck");
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			pstmt.setInt(2, customerNo);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public void increaseLikeCount(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseLikeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	}
	
	public void increaseDisLikeCount(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseDisLikeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	}
	
	public void increaseRateCount(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseRateCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	}
	
	public void updateRateTotal(Connection conn, int reviewNo, int reviewRate) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateRateTotal");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewRate);
			pstmt.setInt(2, reviewNo);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	}
	
	public Review selectLikeCount(Connection conn, int reviewNo) {
		Review r = new Review();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectLikeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
				r.setLikeCnt(rset.getInt("like_cnt"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return r;
	}
	
	public Review selectDisLikeCount(Connection conn, int reviewNo) {
		Review r = new Review();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDisLikeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
				r.setDisLikeCnt(rset.getInt("dislike_cnt"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return r;
	}
	

	public Review selectRateCount(Connection conn, int reviewNo) {
		Review r = new Review();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRateCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
				r.setRateCnt(rset.getInt("rate_cnt"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return r;
	}
	

	public int getTotalRate(Connection conn, int reviewNo) {
		Review r = new Review();
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("getTotalRate");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
				r.setRateTotal(rset.getInt("rate_total"));
				result = r.getRateTotal();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
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

	public int insertReviewComment(Connection conn, ReviewComment rc) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReviewComment");
		
		try {
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, rc.getCustomerNo());
			pstmt.setInt(2, rc.getReviewNo());
			pstmt.setString(3, rc.getCommentContent());
			
			//쿼리실행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally  {
			close(pstmt);
		}
		return result;
	}

	public List<ReviewComment> selectReviewComment(Connection conn, int reviewNo) {
		List<ReviewComment> commentList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCommentList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				ReviewComment rc = new ReviewComment();
				rc.setCommentNo(rset.getInt("comment_no"));
				rc.setCustomerNo(rset.getInt("customer_no"));
				rc.setReviewNo(rset.getInt("review_no"));
				rc.setWrittenDate(rset.getDate("written_date"));
				rc.setCommentContent(rset.getString("comment_content"));

				commentList.add(rc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return commentList;
	}

	public int deleteReviewComment(Connection conn, int commentNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteReviewComment"); 
		
		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setInt(1, commentNo);
			
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


}
