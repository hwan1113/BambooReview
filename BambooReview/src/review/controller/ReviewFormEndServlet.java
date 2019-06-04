package review.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class ReviewFormEndServlet
 */
@WebServlet("/review/reviewFormEnd")
public class ReviewFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터 핸들링
		String reviewTitle = request.getParameter("reviewTitle");
//		int customerNo = Integer.parseInt(request.getParameter("customerNo"));
//		System.out.println("customerNo@serv="+customerNo);
		String reviewWriter = request.getParameter("reviewWriter");
		String reviewContent = request.getParameter("reviewContent");
		
		Review r = new Review();
		r.setReviewTitle(reviewTitle);
//		r.setCustomerNo(customerNo);
		r.setReviewWriter(reviewWriter);
		r.setReviewContent(reviewContent);
		
		/*
		 String uploadPath = "C:/Users/kys03/git/BambooReview/BambooReview/WebContent/upload";
	    int size = 10 * 1024 * 1024;  // 업로드 사이즈 제한 10M 이하
		
		String fileName = ""; // 파일명
		
		try{
	        // 파일업로드 및 업로드 후 파일명 가져옴
			MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();
			String file = (String)files.nextElement(); 
			fileName = multi.getFilesystemName(file); 
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	    // 업로드된 경로와 파일명을 통해 이미지의 경로를 생성
		uploadPath = "/upload/" + fileName;
	    System.out.println(uploadPath);
		
	    // 생성된 경로를 JSON 형식으로 보내주기 위한 설정
		JSONObject json = new JSONObject();
		json.put("url", uploadPath);
		
		response.setContentType("application/json"); // 데이터 타입을 json으로 설정하기 위한 세팅
		PrintWriter out = response.getWriter();
		out.print(json.toJSONString());
		 */
		
		
		
		
		//2. 업무로직
		int result = new ReviewService().insertReview(r);
		
		String msg = "";
		String loc = "/review/reviewList";

		if(result>0) {
			msg = "게시글 등록성공!";
			//성공한 경우, result변수에 새로 등록된 글번호를 가져옴.
			loc = "/review/reviewView?reviewNo="+result;
		}
		else {
			msg = "게시글 등록실패!";
		}
		
		//3.view단 처리
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
			   .forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
