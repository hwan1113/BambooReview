package review.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
/**
 * Servlet implementation class ImageUploadServlet
 */
@WebServlet("/review/imageUpload")
public class ImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이미지 파일이 저장될 실제 주소
		String uploadPath = request.getSession().getServletContext().getRealPath("upload");
		
	    int size = 10 * 1024 * 1024;  // 업로드 사이즈 제한 10M 이하
		
		String fileName = ""; // 파일명
		
		try {
	        // 파일업로드 및 업로드 후 파일명 가져옴
			MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();
			String file = (String)files.nextElement(); 
			fileName = multi.getFilesystemName(file); 

			//이미지 크기를 view창에 맞추기 위해 썸네일 이미지 생성해서 파일이름으로 가져옴
			fileName = makeThumbnail(uploadPath, fileName);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	    // 업로드된 경로와 파일명을 통해 이미지의 경로를 생성
		uploadPath = request.getContextPath()+ "/upload/" + fileName;		

	    // 생성된 경로를 JSON 형식으로 보내주기 위한 설정
		JSONObject json = new JSONObject();
		json.put("url", uploadPath);
		
		response.setContentType("application/json"); // 데이터 타입을 json으로 설정하기 위한 세팅
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

	
    private String makeThumbnail(String filePath, String fileName) throws Exception { 
    	try {
            //썸네일 가로, 세로사이즈 설정
            int thumbnailWidth = 480;
            int thumbnailHeight = 320;
            
            //썸네일 파일명 설정(원본파일 기준으로 .앞에 _thumb추가, 확장자 구분위해)
            String tgtFileName = fileName.replace(".", "_thumb.");
            
            //원본이미지파일의 경로+파일명
            File originalFileName = new File(filePath+"/"+fileName);
            
            //생성할 썸네일파일의 경로+썸네일파일명
            File thumbFileName = new File(filePath + "/" + tgtFileName);
            
            //버퍼에 오리지널 파일이름 읽어오기
            BufferedImage bufferedOriginal_Image = ImageIO.read(originalFileName);
            
            //오리지널 파일의 가로, 세로값 가져오기
            int originalWidth = bufferedOriginal_Image.getWidth();
            int originalHeight = bufferedOriginal_Image.getHeight();
            
            //크기 비교 후, 비율 설정하기
            if((originalWidth <= thumbnailWidth) && (originalHeight <= thumbnailHeight)){
            	return fileName;
            }else {
            	if (originalWidth/thumbnailWidth > originalHeight/thumbnailHeight) {
            		thumbnailHeight = originalHeight / (originalWidth/thumbnailWidth);
            	}else {
            		thumbnailWidth = originalWidth / (originalHeight/thumbnailHeight);
            	}
            	
            BufferedImage buffer_thumbnail_image = new BufferedImage(thumbnailWidth, thumbnailHeight, BufferedImage.TYPE_3BYTE_BGR);
            Graphics2D graphic = buffer_thumbnail_image.createGraphics();
            graphic.drawImage(bufferedOriginal_Image, 0, 0, thumbnailWidth, thumbnailHeight, null);
            ImageIO.write(buffer_thumbnail_image, "jpg", thumbFileName);   	
            
            return tgtFileName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return fileName;

    }
}
