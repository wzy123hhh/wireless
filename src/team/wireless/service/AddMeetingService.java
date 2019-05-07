package team.wireless.service;

import java.io.File;
import java.sql.Date;

import team.wireless.dao.FileDao;
import team.wireless.service.impl.IAddMeetingService;

public class AddMeetingService implements IAddMeetingService{

	private static FileDao dao= new FileDao();
	@Override
	public void SaveFliePath(String upuserNum, String filename, String savepath, String fileSize) {
		//获取上传时间
		Date uploadtime = new Date(System.currentTimeMillis());
		
		dao.SavaFilePath(uploadtime, upuserNum, filename, savepath, fileSize);
	}
	
	
	@Override
	public String produceSavePath(String usernum) {
		String path = "c://wirelessFile//"+usernum;
		
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		return path;
	}
	
//	public static void main(String[] args) {
//		new AddMeetingService().produceSavePath("2017211826");
//	}

}
