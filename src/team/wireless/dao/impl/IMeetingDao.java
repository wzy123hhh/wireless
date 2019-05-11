package team.wireless.dao.impl;

import java.util.List;
import java.util.Map;

public interface IMeetingDao {

	/**
	 * 获取会议信息集合
	 * @param sql
	 * @return
	 */
	public List<Map<String, Object>> getMeetingInfo(String sql);
	
	/**
	 * 根据教师工号获取会议列表
	 * @param userNo
	 * @return
	 */
	public List<Object> getMeetingNoList(String userNo);
	

	
}
