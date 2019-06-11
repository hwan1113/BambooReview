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
import ads.model.vo.AdsComment;

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
		List<Ads> adsList = new ArrayList<>();
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
				
				adsList.add(ads);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return adsList;
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

	public int insertAds(Connection conn, Ads ads) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAds"); 
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ads.getAdsTitle());
			pstmt.setString(2, ads.getSearchedAddress());
			pstmt.setString(3, ads.getDetailedAddress());
			pstmt.setString(4, ads.getFacilities());
			pstmt.setString(5, ads.getAdsContent());
			pstmt.setInt(6, ads.getCustomerNo());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectLastSeq(Connection conn) {
		int adsNo = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectLastSeq");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				adsNo = rset.getInt("adsno");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return adsNo;
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

	public Ads selectOne(Connection conn, int adsNo) {
		Ads ads = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOne");
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adsNo);

			rset = pstmt.executeQuery();
			
			if(rset.next()){
				ads = new Ads();
				ads.setAdsNo(rset.getInt("ads_no"));
				ads.setCustomerNo(rset.getInt("customer_no"));
				ads.setAdsTitle(rset.getString("ads_title"));
				ads.setSearchedAddress(rset.getString("searched_address"));
				ads.setDetailedAddress(rset.getString("detailed_address"));
				ads.setFacilities(rset.getString("facilities"));
				ads.setAdsWriter(getUserName(conn, rset.getInt("customer_no")));
				ads.setAdsContent(rset.getString("ads_content"));
				ads.setWrittenDate(rset.getDate("written_date"));
				ads.setReadCnt(rset.getInt("read_cnt"));
				ads.setLikeCnt(rset.getInt("like_cnt"));
				ads.setDisLikeCnt(rset.getInt("dislike_cnt"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return ads;
	}

	public int updateAds(Connection conn, Ads ads) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateAds"); 
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, ads.getAdsTitle());
			pstmt.setString(2, ads.getSearchedAddress());
			pstmt.setString(3, ads.getDetailedAddress());
			pstmt.setString(4, ads.getFacilities());
			pstmt.setString(5, ads.getAdsContent());
			pstmt.setInt(6, ads.getAdsNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int increaseReadCount(Connection conn, int adsNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseReadCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adsNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteAds(Connection conn, int adsNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteAds");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adsNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int likeCheck(Connection conn, int adsNo, int customerNo) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("likeCheck");
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adsNo);
			pstmt.setInt(2, customerNo);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int disLikeCheck(Connection conn, int adsNo, int customerNo) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("disLikeCheck");
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adsNo);
			pstmt.setInt(2, customerNo);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int rateCheck(Connection conn, int adsNo, int customerNo) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("rateCheck");
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adsNo);
			pstmt.setInt(2, customerNo);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public void increaseLikeCount(Connection conn, int adsNo) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseLikeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adsNo);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	}
	
	public void increaseDisLikeCount(Connection conn, int adsNo) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseDisLikeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adsNo);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	}
	
	public void increaseRateCount(Connection conn, int adsNo) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseRateCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adsNo);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	}
	
	public void updateRateTotal(Connection conn, int adsNo, int adsRate) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateRateTotal");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adsRate);
			pstmt.setInt(2, adsNo);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	}
	
	public Ads selectLikeCount(Connection conn, int adsNo) {
		Ads ads = new Ads();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectLikeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adsNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
				ads.setLikeCnt(rset.getInt("like_cnt"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return ads;
	}
	
	public Ads selectDisLikeCount(Connection conn, int adsNo) {
		Ads ads = new Ads();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDisLikeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adsNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
				ads.setDisLikeCnt(rset.getInt("dislike_cnt"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return ads;
	}
	

	public Ads selectRateCount(Connection conn, int adsNo) {
		Ads ads = new Ads();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRateCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adsNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
				ads.setRateCnt(rset.getInt("rate_cnt"));
				ads.setRateTotal(rset.getInt("rate_total"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return ads;
	}
	

//	public int getTotalRate(Connection conn, int adsNo) {
//		Ads ads = new Ads();
//		int result = 0;
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		String sql = prop.getProperty("getTotalRate");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, adsNo);
//			
//			rset = pstmt.executeQuery();
//			
//			if(rset.next())
//				ads.setRateTotal(rset.getInt("rate_total"));
//				result = ads.getRateTotal();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(pstmt);
//		}
//
//		return result;
//		
//	}
	
	public List<Ads> selectDeletedAdsList(Connection conn, int cPage, int numPerPage) {
		List<Ads> adsList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectDeletedAdsList");
		
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
				
				adsList.add(ads);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return adsList;
	}

	public int insertAdsComment(Connection conn, AdsComment ac) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAdsComment");
		
		try {
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, ac.getCustomerNo());
			pstmt.setInt(2, ac.getAdsNo());
			pstmt.setString(3, ac.getAdsCommentContent());
			
			//쿼리실행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally  {
			close(pstmt);
		}
		return result;
	}

	public List<AdsComment> selectAdsComment(Connection conn, int adsNo) {
		List<AdsComment> adsCommentList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAdsCommentList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adsNo);
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				AdsComment ac = new AdsComment();
				ac.setAdsCommentNo(rset.getInt("ads_comment_no"));
				ac.setCustomerNo(rset.getInt("customer_no"));
				ac.setAdsNo(rset.getInt("ads_no"));
				ac.setWrittenDate(rset.getDate("written_date"));
				ac.setAdsCommentContent(rset.getString("ads_comment_content"));

				adsCommentList.add(ac);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return adsCommentList;
	}

	public int deleteAdsComment(Connection conn, int adsCommentNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteAdsComment"); 
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, adsCommentNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


}
