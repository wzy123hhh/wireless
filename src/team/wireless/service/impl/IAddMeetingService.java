package team.wireless.service.impl;

import java.util.ArrayList;

public interface IAddMeetingService {
	/**
	 * 保存文件信息到数据库
	 * @param upuserNum 上传者的用户账号
	 * @param filename 保存的文件名
	 * @param savepath 保存的路径
	 * @param fileSize 文件大小
	 */
	public void SaveFliePath(String upuserNum,String filename,String savepath,String fileSize);
	
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
	public void addFileOwner(ArrayList<String> teacherNos);
}
