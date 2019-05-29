package team.wireless.dao.impl;

import java.util.List;
import java.util.Map;

import team.wireless.entity.Meeting;

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
	
	/**
	 * 添加会议信息
	 * @param meeting
	 * @return 返回自增编号
	 */
	public String addMeetingInfo(Meeting meeting);
	
}
