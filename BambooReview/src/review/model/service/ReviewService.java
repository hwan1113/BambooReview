package review.model.service;

import static common.JDBCTemplate.close;
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
	
	

}
