package team.wireless.manager.service.impl;

import java.util.List;

import team.wireless.entity.User;
import team.wireless.entity.meetingRecord;

public interface IAttendMeetingService {

	/**
	 * .获取成功参会人员信息
	 * 1.根据会议编号获取参会人员
	 * 2.根据参会人员编号查询签到信息
	 * 3.根据签到信息判断是否签到
	 * @param meetingNo 会议编号
	 * @return
	 */
	public String getAttendTeaInfo(String meetingNo);
	
	/**
	 * .获取缺席人员信息
	 * 1.根据会议编号获取参会人员
	 * 2.根据参会人员编号查询签到信息
	 * 3.根据签到信息判断是否缺席
	 * 4.获取缺席原因
	 * 5.封装json数据
	 *  {'缺席原因':'XXXX','缺席姓名':'XXXX','头像地址':'XXXX'} 
	 * @param meetingNo
	 * @return
	 */
	public List<User> getAbsentTeaInfo(String meetingNo);
	
	/**
	 * .获取所有参会人员编号
	 * @param meetingNo
	 * @return
	 */
	public List<meetingRecord> getAllTeaInfo(String meetingNo);
}
