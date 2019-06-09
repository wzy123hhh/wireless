package team.wireless.manager.service.impl;

public interface ITeaherScheduleService {
	
	/**
	 * 获取日历信息json数据
	 * time : 00:00:00
	 * date : yyyy-mm-dd
	 * @param sql
	 * @return
	 */
	public String getCalendarJson(String sql);
	
	
	/**
	 * 获取教师日常json
	 * @param sql
	 * @return
	 */
	public String getScheduleJson(String usernum);
	
}
