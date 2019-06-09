package team.wireless.teacher.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.NEW;

import team.wireless.dao.TeacherDao;
import team.wireless.entity.stuInfo;
import team.wireless.teacher.service.impl.IStudentAttendDataService;

public class StudentAttendDataService implements IStudentAttendDataService{
	TeacherDao dao = new TeacherDao();

	@Override
	public int getThisWeek() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
		try {
			//学期开始时间
			Date startdate = dateFormat.parse("2019-02-25");
			//当前时间
			Date nowdate = new Date(System.currentTimeMillis());
			//当前周
			int week = (int) ((nowdate.getTime()-startdate.getTime()) / (1000*3600*24*7)) + 1;		
			
			return week;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int getcourseCount() {
		Date date = new Date(System.currentTimeMillis());
		//获取当前时间
		int hour = date.getHours();
		int min =date.getMinutes();
		String hours = hour+"";
		String mins = min+"";
		
		//转换时间格式 hh-mm
		if(hour/10==0) {
			hours = "0"+hour;
		}
		if(min/10==0) {
			mins="0"+min;
		}
		String nowtime = hours+":"+mins;
		
		//第几节
		if(nowtime.compareTo("08:00")>=0&&nowtime.compareTo("09:40")<=0) {
			System.out.println("1-2");
			return 1;
		}else if (nowtime.compareTo("09:40")>=0&&nowtime.compareTo("11:40")<=0) {
			System.out.println("3-4");
			return 3;
		}else if (nowtime.compareTo("14:20")>=0&&nowtime.compareTo("16:00")<=0) {
			System.out.println("5-6");
			return 5;
		}else if (nowtime.compareTo("16:20")>=0&&nowtime.compareTo("18:00")<=0) {
			System.out.println("7-8");
			return 7;
		}else {
			System.out.println("不在上课时间");
			return 0;
		}
	}
	
	
	public static void main(String[] args) {
//		new StudentAttendDataService().getcourseCount();
		new StudentAttendDataService().getAllStudentList("201201");
		
	}
	@Override
	public String getAllStudentList(String TeacherNum) {
		
		SimpleDateFormat weekFormat = new SimpleDateFormat("EEEE");
		Date nowdate = new Date(System.currentTimeMillis());
		QueryRunner queryRunner = dao.getQuneryRunner();
		
		String w = weekFormat.format(nowdate); //星期
		String json = null;
		int week = getThisWeek();
		int jie = getcourseCount();
		
		ArrayList<Object[]> lists = new ArrayList<>();
		ArrayList<stuInfo> stulist = new ArrayList<>();
		
		try {
			
			boolean isclass = false;
			System.out.println("w"+w+"  jie:"+jie+" week:"+week);
			int Dsz =queryRunner.query("select Dsz from stucourset where week='"+w+"' and Djj='"+jie+"' AND teacherNo = '"+TeacherNum+"'", new ScalarHandler<Integer>());
			if(Dsz == 0) {//不分单双周
				isclass = true;
			}else if(Dsz == 1) {
				//单周
				if(week%2==0) {
					isclass = false;
				}else {
					isclass = true;
				}
			}else if (Dsz == 2) {
				//双周
				if(week%2==0) {
					isclass = true;
				}else {
					isclass = false;
				}
			}
			
			if (isclass == false) {
				return null;
			}
			
			lists = (ArrayList<Object[]>) queryRunner.query("select kbNo,classes,courseNo from stucourset where week='"+w+"' and Djj='"+jie+"' AND teacherNo = '"+TeacherNum+"' and Jsz >= '"+week+"'", new ArrayListHandler());
			System.out.println(lists);
			stuInfo info = new stuInfo();
			for (Object[] objects : lists) {
				int kbno = (int) objects[0]; //课程信息编号 （-> 选课学生）
				String classes = (String) objects[1]; //教室
				String courseNo = objects[2].toString(); //课程编号 （-> 课程名称）
				
				//获取所有学生编号
				List<Object> stuNoList = queryRunner.query("select stuNo from courset where kbNo = '"+kbno+"'", new ColumnListHandler<Object>("stuNo"));
				//根据学生编号获取学生头像 姓名等信息
				for (Object obj : stuNoList) {
					ArrayList<Object[]> arrayList= (ArrayList<Object[]>) queryRunner.query("select userName,userImg from user where userNum = '"+obj+"'", new ArrayListHandler());
					for (Object[] objects1 : arrayList) {
						info = new stuInfo(objects1[0].toString(), obj.toString(), objects1[1].toString());
						stulist.add(info);
					}
				}
				
				String courseName = queryRunner.query("select courseName from courseinfo where courseNo = '"+courseNo+"'", new ScalarHandler<String>());
				
				 json = "{\"class\":\""+classes+"\",\"coursename\":\""+courseName+"\",\"stu\":"+JSONObject.toJSONString(stulist)+"}";
			}
			
			System.out.println(json);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			return "{\"class\":\"无\",\"coursename\":\"无\"";
		}catch (Exception e) {
			return "{\"class\":\"无\",\"coursename\":\"无\"";
		}
	}
}
