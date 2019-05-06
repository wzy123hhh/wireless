package team.wireless.service.impl;

import team.wireless.entity.User;

public interface IAddMeetingService {
	/**
	 * 保存文件信息到数据库
	 * @param upuserNum 上传者的用户账号
	 * @param filename 保存的文件名
	 * @param savepath 保存的路径
	 * @param fileSize 文件大小
	 */
	public void SaveFliePath(String upuserNum,String filename,String savepath,String fileSize);
}
