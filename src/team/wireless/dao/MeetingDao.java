package team.wireless.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import team.wireless.dao.impl.IMeetingDao;
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
	
//	public static void main(String[] args) {
//		
//		new MeetingDao().getMeetingNoList("2017211826");
//		
//	}

}
