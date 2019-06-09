package team.wireless.service.Ajax;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import team.wireless.dao.MeetingDao;
import team.wireless.entity.collageInfo;

public class FindTeacherService {
	MeetingDao dao = new MeetingDao();
	
	/**
	 * 根据学校编号获取对应院部信息（当前只有一个学校），返回html. 如：
	 * <option value="100">地理信息与旅游学院<\option>
	 * @param schoolNo
	 * @return
	 */
	
	public String getCollageList(int schoolNo) {
		StringBuilder htmls = new StringBuilder();
		try {
			
			ArrayList<collageInfo> list = (ArrayList<collageInfo>) dao.getQuery().query("select * from collageInfo",new BeanListHandler<collageInfo>(collageInfo.class));
			for (collageInfo collageInfo : list) {
				htmls.append("<option value=\""+collageInfo.getCollageNo()+"\">"+collageInfo.getCollageName()+"<\\option>").append("\n");
			}
			
			System.out.println(htmls.toString());
			return htmls.toString();
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 根据院部编号获取对应的教师信息
	 * <li>XX老师<button type="button" class="btn btn-add">添加</button></li>
	 * @param collageNo
	 * @return
	 */
	
	public String getTeacherList(String collageNo) {
		
		StringBuilder builder = new StringBuilder();
		ArrayList<Object[]> lists = null;
		try {
			
			//返回教师编号，教师姓名
			lists=	(ArrayList<Object[]>) dao.getQuery().query("SELECT teacherNo , teacherName from \r\n" + 
					"	(SELECT * from teachert where teacherNo = (SELECT teacherNo from teacher_collage where collageNo = '"+collageNo+"')) AS A",new ArrayListHandler());
			
			for (Object[] objects : lists) {
				builder.append("<li>"+ objects[1]+"<button type=\"button\" class=\"btn btn-add\">添加</button></li>").append("\n");
			}
			
//			System.out.println(builder.toString());
			
			return builder.toString();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
			
		}
	}
	
	
	public static void main(String[] args) {
//		new FindTeacherService().getCollageList(100);
		new FindTeacherService().getTeacherList("109");
	}
}
