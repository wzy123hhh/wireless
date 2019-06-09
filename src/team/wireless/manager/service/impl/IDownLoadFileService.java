package team.wireless.manager.service.impl;

import java.util.List;

import team.wireless.entity.MFile;

public interface IDownLoadFileService {
	
	/**
	 * 获取对应教师有权限查看的文件
	 * @param teacherNum
	 * @return
	 */
	public List<MFile> getFileList(String teacherNum);
	
}
