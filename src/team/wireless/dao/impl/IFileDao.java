package team.wireless.dao.impl;

import java.sql.Date;

public interface IFileDao {
	/***
	 * 保存上传文件信息到数据库
	 * @param upuserNum
	 * @param filename
	 * @param savepath
	 * @param fileSize
	 */
	public void SavaFilePath(Date upDate,String upuserNum, String filename, String savepath, String fileSize);
}
