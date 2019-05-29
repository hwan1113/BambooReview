package hotel.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import hotel.model.vo.Hotel;


public class HotelDAO {
	private Properties prop = new Properties();
	
	
	
	

	public HotelDAO() {
		try {
            String fileName = HotelDAO.class.getResource("/sql/hotel/hotel-query.properties").getPath();
            prop.load(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}





	public List<Hotel> selectHotelList(Connection conn, String region) {
		List<Hotel> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = prop.getProperty("selectHotelByCity");
		
        try{
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%"+region+"%");
            
            rset = pstmt.executeQuery();
            
            while(rset.next()){
                Hotel h = new Hotel();
                h.setHotelId(rset.getString("hotel_id"));
                h.sethotelRate(rset.getInt("hotel_rate"));
                h.setInfo(rset.getString("info"));
                h.setpictureRef(rset.getString("picture_ref"));
                h.setRegion(rset.getString("region"));
                
                list.add(h);
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
