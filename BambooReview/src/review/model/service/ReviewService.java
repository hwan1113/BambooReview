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

	public List<Review> selectReviewList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Review> list = new ReviewDAO().selectReviewList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}

	public int selectReviewCount() {
		Connection conn = getConnection();
		int totalReviewCount = new ReviewDAO().selectReviewCount(conn);
		close(conn);
		return totalReviewCount;
	}

	public int insertReview(Review r) {
		Connection conn = getConnection();
		int result = new ReviewDAO().insertReview(conn, r);
		if(result>0) {
			commit(conn);
			result = new ReviewDAO().selectLastSeq(conn);
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

}
