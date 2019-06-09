package team.wireless.teacher.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import team.wireless.dao.TeacherDao;
import team.wireless.teacher.service.impl.ITeacherCourseInfoService;
/**
 * .获取本天的课程信息
 * 1.获取第几周 星期几 教师编号
 * 2.根据1中信息查找符合条件的课程编号
 * 3.返回课程信息 上课地点 上课时间 课程名称
 * 4.封装数据为json返回
 * @author 王智源
 *
 */
public class TeacherCourseInfoService implements ITeacherCourseInfoService  {
	
	StudentAttendDataService service = new StudentAttendDataService();
	TeacherDao dao = new TeacherDao();

	@Override
	public String getTeacherCourses(String teacherNo) {
		
		int week = service.getThisWeek();
		SimpleDateFormat weekFormat = new SimpleDateFormat("EEEE");
		Date nowdate = new Date(System.currentTimeMillis());
		QueryRunner queryRunner = dao.getQuneryRunner();
		String w = weekFormat.format(nowdate); //星期
		
		ArrayList<Object[]> lists = new ArrayList<>();
		
		try {
			
			boolean isclass = false;
			int Dsz =queryRunner.query("select Dsz from stucourset where week='"+w+"'  AND teacherNo = '"+teacherNo+"'", new ScalarHandler<Integer>());
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
			
			lists = (ArrayList<Object[]>) queryRunner.query("select classes,courseNo from stucourset where week='"+w+"' AND teacherNo = '"+teacherNo+"' and Jsz >= '"+week+"'", new ArrayListHandler());
			JSONArray array = new JSONArray();
			for (Object[] objects : lists) {
				String classes =  objects[0].toString(); //教室
				String courseNo = objects[1].toString(); //课程编号 （-> 课程名称）
				
				String courseName = queryRunner.query("select courseName from courseinfo where courseNo = '"+courseNo+"'", new ScalarHandler<String>());
				System.out.println(courseName);
				JSONObject jsonObject = new JSONObject();
				
				jsonObject.put("class", classes);
				jsonObject.put("courseName", courseName);
				
				array.add(jsonObject);
			}
			
			return array.toJSONString();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	
	}


	@Override
	public String getTeacherCourse(String teacherNo, String date){
		/**
		 * .日期格式
		 *  1.周：星期
		 *  
		 */
		
		return null;
	}
	
	public static void main(String[] args) {
		new TeacherCourseInfoService().getTeacherCourses("201201");
	}
	
	
	
}
