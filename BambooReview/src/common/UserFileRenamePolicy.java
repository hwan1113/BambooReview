package common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class UserFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File oldFile) {
		File newFile = null;
		
		do {
			//20190516121450345_234.pdf
			long currentTime = System.currentTimeMillis();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			int rndNum = (int)(Math.random()*1000);
			
			//확장자
			String oldName = oldFile.getName();//사용자가 전송한 파일이름
			String ext = "";
			int dot = oldName.lastIndexOf(".");
			if(dot>-1) {
				ext = oldName.substring(dot);
			}
			
			//새파일명
			String newName = sdf.format(new Date(currentTime))
							+ "_"
							+ rndNum 
							+ ext;
			
			//파일객체생성
			newFile = new File(oldFile.getParent(), newName);
			
		} while(!createNewFile(newFile));
		
		return newFile;
	}

	private boolean createNewFile(File newFile) {
		//파일이 존재하면, 파일을 생성하지 않고 false리턴함.
		//파일이 존재하지않으면, 파일을 생성하고, true를 리턴함.
		try {
			
			return newFile.createNewFile();
			
		} catch (IOException e) {
			return false;
		}
		
		
	}

}
