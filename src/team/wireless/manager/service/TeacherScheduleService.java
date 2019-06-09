package team.wireless.manager.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import team.wireless.dao.MeetingDao;
import team.wireless.entity.meetingTime;
import team.wireless.manager.service.impl.ITeaherScheduleService;

public class TeacherScheduleService implements ITeaherScheduleService{
	MeetingDao dao = new MeetingDao();
	ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public String getCalendarJson(String sql) {
		/**
		 * {"time":"00:05:06","date":"2017-08-09"}
		 */
		ArrayList<Map<String, Object>> meetlist = (ArrayList<Map<String, Object>>) dao.getMeetingInfo(sql);
		ArrayList<meetingTime> timelist = new ArrayList<>();
		meetingTime time = null;
		ObjectMapper mapper = new ObjectMapper();
		
		for (Map<String, Object> map : meetlist) {
			
			Timestamp date = (Timestamp) map.get("startTime");
			System.out.println(date);
			String[] dates = date.toString().split(" ");
			
			time =new meetingTime(dates[1].substring(0, dates[1].lastIndexOf('.')), dates[0]);
				
			timelist.add(time);
		}
		
		try {
			return mapper.writeValueAsString(timelist);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	
	@Override
	public String getScheduleJson(String num) {
//		ArrayList<Map<String, Object>> meetlist = (ArrayList<Map<String, Object>>) dao.getMeetingInfo();
		String result = null;
		/**
		 * 1.根据教师工号，查询会议记录表中对应的会议编号
		 * 2.查询所有会议编号对应的会议数据
		 * {"meetingNo":10001,"Address":"逸夫3405","startTime":1502208306000,"laterTime":30,"saveno":null,"meetingName":"test","meetingIntroduce":"test","createrNo":"2017211826"}
		 */
		try {
			// ---1
			ArrayList<Object> meetNos = (ArrayList<Object>) dao.getMeetingNoList(num);
			// ---2
			ArrayList<Map<String, Object>> meetlist = new ArrayList<>();
			ArrayList<Map<String, Object>> teMaps = new ArrayList<>();
			for (Object object : meetNos) {
				
				teMaps =(ArrayList<Map<String, Object>>) dao.getMeetingInfo("select * from Meeting where meetingNo ='"+object+"'"); 
				meetlist.addAll(teMaps);
			}
			
			
			result = mapper.writeValueAsString(meetlist);
			return result;
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
		
	}


	
//	public static void main(String[] args) {
//		TeacherScheduleService scheduleService = new TeacherScheduleService();
//		scheduleService.getCalendarJson("select * from Meeting");
//		scheduleService.getScheduleJson("2017211826");
//	}
	
	
}
