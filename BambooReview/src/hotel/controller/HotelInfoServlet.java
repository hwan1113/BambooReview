package hotel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HotelInfoServlet
 */
@WebServlet("/hotel/hotelInfo")
public class HotelInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelInfoServlet() {
    	
    	
    	
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String query ="hotels%20in%20"+request.getParameter("keyword");
		String key = "AIzaSyBamfF6Gj9yf1Spt6oL6sX1GB86eMTtI6U";
		String urlStr = "https://maps.googleapis.com/maps/api/place/textsearch/json?"
					  + "query="+query+"&"
					  + "key="+key;
		
		
		URL url = new URL(urlStr);  
		
		String line = ""; 
		StringBuilder jsonStr = new StringBuilder();
		
		//url객체.openStream(): 해당 URL에 접속후 Stream객체로 반환함.
		BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream())); 
		while((line=bf.readLine())!=null){ 
			jsonStr.append(line); 
		}
		
		response.getWriter().append(jsonStr);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
