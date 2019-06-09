package team.wireless.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import team.wireless.dao.impl.IMeetingDao;
import team.wireless.entity.Meeting;
import team.wireless.entity.meetingRecord;
import team.wireless.util.SqlUtil;

public class MeetingDao implements IMeetingDao{
	
	QueryRunner queryRunner = SqlUtil.getQuery();

	@Override
	public List<Map<String, Object>> getMeetingInfo(String sql) {
		
		List<Map<String, Object>> meetlist = new ArrayList<>();
		
		try {
			meetlist =  queryRunner.query(sql, new MapListHandler());
			return meetlist;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	@Override
	public List<Object> getMeetingNoList(String userNo) {
		
		List<Object> meetnos = new ArrayList<>();
		
		try {
			meetnos = queryRunner.query("select meetingNo from meetingrecord where teacherNo = '"+userNo+"'", new ColumnListHandler<>("meetingNo"));
			
			return meetnos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public String addMeetingInfo(Meeting meeting) {
		
		Long meetingNo = null;
		String sql1 = "insert into meeting(Address,startTime,meetingName,meetingIntroduce) values(?,?,?,?)";
		String sql2 = "SELECT LAST_INSERT_ID()";
		try {
			
		queryRunner.insert(sql1, new BeanHandler<>(Meeting.class), 
								new Object[] {meeting.getAddress(),meeting.getStartTime(),meeting.getMeetingName(),meeting.getMeetingIntroduce()});
		meetingNo = queryRunner.query(sql2,new ScalarHandler<Long>());
		
//		System.out.println(meetingNo.toString());
		return meetingNo.toString();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	public static void main(String[] args) {
		
//		new MeetingDao().getMeetingNoList("2017211826");
//		new MeetingDao().addMeetingInfo(new Meeting("yf3", new Timestamp(System.currentTimeMillis()), "test", "testmeeting"));
//		new MeetingDao().getMeetingRecordData("select teacherNo from meetingrecord where meetingNo = '10001'");
//		new MeetingDao().getoneValue("select startTime from meeting where meetingNo='10001'");
		
	}


	@Override
	public List<meetingRecord> getMeetingRecordData(String sql) {
		List<meetingRecord> lists = null;
		try {
			lists= queryRunner.query(sql, new BeanListHandler<>(meetingRecord.class));
			
			return lists;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public Object getoneValue(String sql) {
		Object obj = null;
		try {
			obj=queryRunner.query(sql, new ScalarHandler<Object>() );
//			System.out.println(obj);
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public QueryRunner getQuery() {
		
		return queryRunner;
	}

}
