package user.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import common.UserFileRenamePolicy;
import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet(name="UserUpdateServlet", 
urlPatterns="/user/userUpdate")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "게시판 파일 업로드 오류:관리자에게 문의하세요");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
				   .forward(request, response);
			return;
		}
		
		
		//a.파일저장경로
		String saveDirectory = getServletContext().getRealPath("/")+"upload/profile";
		
		//b.파일최대용량: 10mb
		//파일최대용량을 넘어서면, IOException을 던진다.
		int maxPostSize = 1024*1024*10;
		
		//c.FileRenamePolicy객체 생성
		FileRenamePolicy policy
			= new UserFileRenamePolicy();
		
		//MultipartRequest객체 생성
		MultipartRequest multiReq = new MultipartRequest(request, 
														 saveDirectory, 
														 maxPostSize, 
														 "UTF-8", 
														 policy);

		
		
		String email= multiReq.getParameter("email");
		String userName = multiReq.getParameter("name");
		String phone = multiReq.getParameter("phone");
		String renamedFile = multiReq.getFilesystemName("upFile");
		String originalFile = multiReq.getOriginalFileName("upFile");
		
		String renamedFileNameOld = multiReq.getParameter("renamedFileNameOld");
		String originalFileNameOld = multiReq.getParameter("originalFileNameOld");
		
		
		//기존 첨부파일 삭제여부
		String delFile = multiReq.getParameter("delFile");
				
		//2.1 수정파일 관련처리
		//업로드한 파일이 있는지 없는지 여부를 어떻게 알것인가?
		//업로드한 파일을 실제 파일객체에 담아서 확인함.
		File f = multiReq.getFile("upFile");
		
		System.out.println(f);
		//f의 null여부와 파일사이즈로 실제 파일 첨부여부를 판단함.
		//첨부한 파일이 없을경우, f = null;
		//첨부한 파일이 있을경우, f는 null이 아님. 혹은 f.length()>0 로 검사가능(빈파일일경우, 길이는 0이므로 주의)
		//1.새로 업로드한 파일이 있는 경우
		if(f!=null) {
			//새로 전송 한 파일이 있다면, 기존에 기록된 파일을 삭제해야 함
			File deleteFile = new File(saveDirectory+"/"+ renamedFileNameOld);
			boolean bool = deleteFile.delete();
			System.out.println(bool?"파일삭제성공!":"파일삭제실패!");
		}
		else if(delFile != null){
			//기존첨부파일만 삭제
			boolean bool = new File(saveDirectory+"/"+renamedFileNameOld).delete();
			System.out.println(bool?"파일삭제성공!":"파일삭제실패!");
			originalFile=null;
			renamedFile=null;
		}
		//업로드한 파일이 없는 경우
		else {
			//첨부한 파일이 없는 경우, 기존파일명으로 대체
			originalFile = originalFileNameOld;
			renamedFile = renamedFileNameOld;
		}

		
		User u = new User();
    	u.setEmail(email);
    	u.setUserName(userName);
    	u.setPhone(phone);
    	u.setOriginalFile(originalFile);
		u.setRenamedFile(renamedFile);
    	
    	int result = new UserService().updateUser(u);
    
    	String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/";
		
		if(result>0) {
			msg = "성공적으로 회원정보를 수정했습니다.";
			loc = "/user/userView?email="+u.getEmail();
			HttpSession session = request.getSession();
			session.setAttribute("userLoggedIn", new UserService().selectOne(u.getEmail()));
		}
		else {
			msg = "회원정보수정에 실패했습니다.";	
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher(view).forward(request, response);
    	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
