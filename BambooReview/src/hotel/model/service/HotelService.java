package hotel.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;


import hotel.model.dao.HotelDAO;
import hotel.model.vo.Hotel;

public class HotelService {

	public List<Hotel> selectHotelList(String region) {
		Connection conn = getConnection();
		List<Hotel> list= new HotelDAO().selectHotelList(conn, region);
		close(conn);
		return list;
	}

}
