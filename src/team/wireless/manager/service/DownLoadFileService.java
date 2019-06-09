package team.wireless.manager.service;

import java.util.ArrayList;
import java.util.List;

import team.wireless.dao.FileDao;
import team.wireless.entity.MFile;
import team.wireless.manager.service.impl.IDownLoadFileService;

public class DownLoadFileService implements IDownLoadFileService{

	FileDao dao = new FileDao();
	@Override
	public List<MFile> getFileList(String teacherNum) {
		
		ArrayList<Object> savenos = (ArrayList<Object>) dao.getSaveNoList(teacherNum);
		ArrayList<MFile> temps = null;
		ArrayList<MFile> filelist = new ArrayList<>();
		String sql = null;
		
		for (Object object : savenos) {
			
			sql = "select * from savefile where saveno = '"+object+"'";
			temps = (ArrayList<MFile>) dao.getMfileList(sql);
			filelist.addAll(temps);
		}
		
		return filelist;
		
	}
	
}
