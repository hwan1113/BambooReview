package review.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.rollback;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import review.model.dao.ReviewDAO;
import review.model.vo.Review;

public class ReviewService {

	public List<Review> selectReviewList(String hotelId, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Review> list = new ReviewDAO().selectReviewList(conn, hotelId, cPage, numPerPage);
		close(conn);
		return list;
	}

	public int selectReviewCount(String hotelId) {
		Connection conn = getConnection();
		int totalReviewCount = new ReviewDAO().selectReviewCount(conn, hotelId);
		close(conn);
		return totalReviewCount;
	}

	public int insertReview(Review r) {
		Connection conn = getConnection();
		int result = new ReviewDAO().insertReview(conn, r);
		System.out.println(result);
		if(result>0) {
			commit(conn);
			result = new ReviewDAO().selectLastSeq(conn);
			System.out.println(result);
		}	
		else 
			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public Review selectOne(int reviewNo) {
		Connection conn = getConnection();
		Review review = new ReviewDAO().selectOne(conn, reviewNo);
		close(conn);
		return review;
	}

	public int updateReview(Review r) {
			Connection conn = getConnection();
			int result = new ReviewDAO().updateReview(conn, r);
			if(result>0){
				commit(conn);
			}
			else 
				rollback(conn);
			
			close(conn);
			
			return result;
	}

	public int increaseReadCount(int reviewNo) {
		Connection conn = getConnection();
		int result = new ReviewDAO().increaseReadCount(conn, reviewNo);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		return result;
		
	}
	
	public int increaseLikeCount(int reviewNo) {
		Connection conn = getConnection();
		int result = new ReviewDAO().increaseLikeCount(conn, reviewNo);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		return result;
		
	}

	public int selectLikeCount(int reviewNo) {
		Connection conn = getConnection();
		int result = new ReviewDAO().selectLikeCount(conn, reviewNo);
		close(conn);
		return result;
		
	}
	
	public int increaseDisLikeCount(int reviewNo) {
		Connection conn = getConnection();
		int result = new ReviewDAO().increaseDisLikeCount(conn, reviewNo);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		return result;
		
	}

	public int deleteReview(int reviewNo) {
		Connection conn = getConnection();
		int result = new ReviewDAO().deleteReview(conn, reviewNo);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		return result;
	}
	
	public String getUserName(int customerNo) {
		Connection conn = getConnection();
		String userName = new ReviewDAO().getUserName(conn, customerNo);
		return userName;
	}

	public List<Review> selectDeletedReviewList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Review> list = new ReviewDAO().selectDeletedReviewList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}

	
}
