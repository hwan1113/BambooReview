package ads.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import common.UserFileRenamePolicy;
/**
 * Servlet implementation class ImageUploadServlet
 */
@WebServlet("/ads/imageUpload")
public class ImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
				
		//이미지 파일이 저장될 실제 주소
		String uploadPath = request.getSession().getServletContext().getRealPath("upload_ads");
		
	    int size = 10 * 1024 * 1024;
		
		String fileName = "";
		
		FileRenamePolicy policy	= new UserFileRenamePolicy();
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", policy);
			Enumeration files = multi.getFileNames();
			String file = (String) files.nextElement();
			
			fileName = multi.getFilesystemName(file); 

		}catch(Exception e){
			e.printStackTrace();
		}
		
		uploadPath = request.getContextPath() + "/upload_ads/" + fileName;
		System.out.println("path@serv="+uploadPath);

		JSONObject json = new JSONObject();
		json.put("url", uploadPath);
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(json.toJSONString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
