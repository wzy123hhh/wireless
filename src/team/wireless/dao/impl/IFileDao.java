package team.wireless.dao.impl;

import java.sql.Date;
import java.util.List;

import team.wireless.entity.MFile;
import team.wireless.entity.Meeting;

public interface IFileDao {
	
	/***
	 * 保存上传文件信息到数据库	
	 * @param upuserNum
	 * @param filename
	 * @param savepath
	 * @param fileSize
	 */
	public void SavaFilePath(Date upDate,String upuserNum, String filename, String savepath, String fileSize,String filetype,String meetingNo);
	
	
	/**
	 * 获取文件信息列表
	 * @param sql
	 * @return
	 */
	public List<MFile> getMfileList(String sql);
	
	
	/**
	 * 教师添加文件权限
	 * @param teacherNum
	 */
	public int addFileOwner(String teacherNum,String saveNo);
	
	/**
	 * 根据教师编号获取其对应的文件编号
	 * @param teacherNo
	 * @return
	 */
	public List<Object> getSaveNoList(String teacherNo);
	

}
