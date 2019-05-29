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
import member.model.vo.Member;

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





	public List<Hotel> selectMemberList(Connection conn) {
		List<Hotel> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = prop.getProperty("");
		
        try{
            pstmt = conn.prepareStatement(query);
            
            pstmt.setInt(1, );
            pstmt.setInt(2, );
            
            
            rset = pstmt.executeQuery();
            
            while(rset.next()){
                Hotel h = new Hotel();
                //컬럼명은 대소문자 구분이 없다.
                m.setMemberId(rset.getString("MEMBERID"));
                m.setPassword(rset.getString("PASSWORD"));
                m.setMemberName(rset.getString("MEMBERNAME"));
                m.setGender(rset.getString("GENDER"));
                m.setAge(rset.getInt("AGE"));
                m.setEmail(rset.getString("EMAIL"));
                m.setPhone(rset.getString("PHONE"));
                m.setAddress(rset.getString("ADDRESS"));
                m.setHobby(rset.getString("HOBBY"));
                m.setEnrollDate(rset.getDate("ENROLLDATE"));
                
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
