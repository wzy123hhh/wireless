package team.wireless.teacher.service.impl;

public interface ITeacherCourseInfoService {
	
	/**
	 *.获取教师本日上课安排
	 * @param teacherNo
	 * @return
	 */
	public String getTeacherCourses(String teacherNo);
	
	/**
	 * .获取教师指定时间上课安排
	 * @param teacherNo
	 * @param date
	 * @return
	 */
	public String getTeacherCourse(String teacherNo,String date);

}
