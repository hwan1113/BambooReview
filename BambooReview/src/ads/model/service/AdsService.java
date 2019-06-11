package ads.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import ads.model.dao.AdsDAO;
import ads.model.vo.Ads;
import ads.model.vo.AdsComment;

public class AdsService {

	public List<Ads> selectAdsList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Ads> list = new AdsDAO().selectAdsList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}

	public int selectAdsCount() {
		Connection conn = getConnection();
		int totalAdsCount = new AdsDAO().selectAdsCount(conn);
		close(conn);
		return totalAdsCount;
	}

	public int insertAds(Ads ads) {
		Connection conn = getConnection();
		int result = new AdsDAO().insertAds(conn, ads);
		if(result>0) {
			commit(conn);
			result = new AdsDAO().selectLastSeq(conn);
		}	
		else 
			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public Ads selectOne(int adsNo) {
		Connection conn = getConnection();
		Ads ads = new AdsDAO().selectOne(conn, adsNo);
		close(conn);
		return ads;
	}

	public int updateAds(Ads ads) {
			Connection conn = getConnection();
			int result = new AdsDAO().updateAds(conn, ads);
			if(result>0){
				commit(conn);
			}
			else 
				rollback(conn);
			
			close(conn);
			
			return result;
	}

	public int increaseReadCount(int adsNo) {
		Connection conn = getConnection();
		int result = new AdsDAO().increaseReadCount(conn, adsNo);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		return result;
		
	}
	
	public int increaseLikeCount(int adsNo, int customerNo) {
		int result = 0;
		Connection conn = getConnection();
		if (new AdsDAO().likeCheck(conn, adsNo, customerNo) > 0) {
			new AdsDAO().increaseLikeCount(conn, adsNo);
			result = 1;
			commit(conn);
		}
		else {
			result = 0;
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	public int increaseDisLikeCount(int adsNo, int customerNo) {
		int result = 0;
		Connection conn = getConnection();
		if(new AdsDAO().disLikeCheck(conn, adsNo, customerNo) > 0) {
			new AdsDAO().increaseDisLikeCount(conn, adsNo);
			result = 1;
			commit(conn);
		}
		else {
			result = 0;
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int updateRateTotal(int adsNo, int customerNo, int adsRate) {
		int result = 0;
		Connection conn = getConnection();
		if(new AdsDAO().rateCheck(conn, adsNo, customerNo) > 0) {
			new AdsDAO().updateRateTotal(conn, adsNo, adsRate);
			
			result = 1;
			commit(conn);
		}
		else {
			result = 0;
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	public Ads selectLikeCount(int adsNo) {
		Connection conn = getConnection();
		Ads r = new AdsDAO().selectLikeCount(conn, adsNo);
		close(conn);
		return r;
	}

	public Ads selectDisLikeCount(int adsNo) {
		Connection conn = getConnection();
		Ads r = new AdsDAO().selectDisLikeCount(conn, adsNo);
		close(conn);
		return r;
	}
	
	public Ads selectRateCount(int adsNo) {
		Connection conn = getConnection();
		Ads r = new AdsDAO().selectRateCount(conn, adsNo);
		close(conn);
		return r;
	}
	

//	public int getTotalRate(int adsNo) {
//		Connection conn = getConnection();
//		int result = new AdsDAO().getTotalRate(conn, adsNo);
//		close(conn);
//		return result;
//	}

	public int deleteAds(int adsNo) {
		Connection conn = getConnection();
		int result = new AdsDAO().deleteAds(conn, adsNo);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		return result;
	}
	
	public String getUserName(int customerNo) {
		Connection conn = getConnection();
		String userName = new AdsDAO().getUserName(conn, customerNo);
		return userName;
	}

	public List<Ads> selectDeletedAdsList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Ads> list = new AdsDAO().selectDeletedAdsList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}

	public int insertAdsComment(AdsComment ac) {
		Connection conn = getConnection();
		int result = new AdsDAO().insertAdsComment(conn, ac);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		return result;
	}
	
	public List<AdsComment> selectAdsComment(int adsNo) {
		Connection conn = getConnection();
		List<AdsComment> adsCommentList 
			= new AdsDAO().selectAdsComment(conn, adsNo);
		close(conn);
		return adsCommentList;
	}

	public int deleteadsComment(int adsCommentNo) {
		Connection conn = getConnection();
		int result = new AdsDAO().deleteAdsComment(conn, adsCommentNo);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		
		return result;
	}
}
