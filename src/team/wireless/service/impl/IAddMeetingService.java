package team.wireless.service.impl;

import java.util.ArrayList;

import team.wireless.entity.MFile;
import team.wireless.entity.Meeting;

public interface IAddMeetingService {

	/**
	 * 保存文件信息到数据库
	 * @param file
	 */
	public void SaveFliePath(MFile file,String meetingno);
	
	/**
	 * 根据上传者用户账号生成文件保存路径
	 * @param usernum 用户账号
	 * @return 文件保存路径
	 */
	public String produceSavePath(String usernum);
	
	/**
	 *  根据选择的教师编号，将文件的使用权传递给教师
	 * @param teacherNos
	 */
	public void addFileOwner(ArrayList<String> teacherNos,ArrayList<String> saveNo);
	
	/**
	 * 添加会议信息
	 * @param meeting
	 * @return
	 */
	public String addMeetingInfo(Meeting meeting);
}
