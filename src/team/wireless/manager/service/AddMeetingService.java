package team.wireless.manager.service;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

import team.wireless.dao.FileDao;
import team.wireless.dao.MeetingDao;
import team.wireless.entity.MFile;
import team.wireless.entity.Meeting;
import team.wireless.manager.service.impl.IAddMeetingService;

public class AddMeetingService implements IAddMeetingService{

	private static FileDao dao= new FileDao();
	private static MeetingDao mdao = new MeetingDao();
	@Override
	public void SaveFliePath(MFile file,String meetingno) {
		//获取上传时间
		Date uploadtime = new Date(System.currentTimeMillis());
		file.setUptime(uploadtime);
		
		dao.SavaFilePath(file.getUptime(), file.getUpusernum(), file.getFilename(), file.getSavepath(), file.getFilesize(),file.getFiletype(),meetingno);
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
	

	@Override
	public void addFileOwner(ArrayList<String> teacherNos,ArrayList<String> saveNo) {
		
		for (String string : teacherNos) {
			for (String string2 : saveNo) {
				dao.addFileOwner(string, string2);
			}
		}
		
	}

	@Override
	public String addMeetingInfo(Meeting meeting) {
		
		String meetingno = mdao.addMeetingInfo(meeting);
		
		return meetingno;
	}
	
//	public static void main(String[] args) {
//		new AddMeetingService().produceSavePath("2017211826");
//	}

}
