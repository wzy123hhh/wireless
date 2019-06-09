package team.wireless.manager.service;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import team.wireless.dao.MeetingDao;
import team.wireless.dao.UserDao;
import team.wireless.entity.User;
import team.wireless.entity.meetingRecord;
import team.wireless.manager.service.impl.IAttendMeetingService;

public class AttendMeetingService implements IAttendMeetingService {
	MeetingDao dao = new MeetingDao();
	UserDao udao = new UserDao();
	@Override
	public String getAttendTeaInfo(String meetingNo) {
		User temp;
		ArrayList<User> userlist = new ArrayList<>();
		//获取签到信息
		ArrayList<meetingRecord> lists = (ArrayList<meetingRecord>) getAllTeaInfo(meetingNo);
		//获取会议信息 -- 要求时间 误差时间
//		Timestamp start = (Timestamp) dao.getoneValue("select startTime from meeting where meetingNo = '"+meetingNo+"'");
//		Timestamp later = new Timestamp((long) dao.getoneValue("select laterTime from meeting where meetingNo = '"+meetingNo+"'")) ;
		//遍历教师签到信息,判断是否签到成功
		for (meetingRecord record : lists) {
			
			if(record.getIsabsent() == 1) {
				temp = udao.getUserInfo(record.getTeacherNo(), "userNum");
				temp.setUserPwd("");
				temp.setMac("");
				temp.setUserPhone("");
				userlist.add(temp);
			}
		}
		
		String json = JSONObject.toJSONString(userlist);
		System.out.println(json);
		
		return json;
	}

	@Override
	public List<User> getAbsentTeaInfo(String meetingNo) {
		
		return null;
	}

	@Override
	public List<meetingRecord> getAllTeaInfo(String meetingNo) {
		//获取所有参会人员名单
		ArrayList<meetingRecord> lists = null;
		lists = (ArrayList<meetingRecord>) dao.getMeetingRecordData("select * from meetingrecord where meetingNo = '"+meetingNo+"'");
		return lists;
	}

	public static void main(String[] args) {
		AttendMeetingService service  = new AttendMeetingService();
		service.getAttendTeaInfo("10001");
	}

}
