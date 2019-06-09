package team.wireless.teacher.service.impl;

public interface IStudentAttendDataService {
	/**
	 * 获取当前为本学期的第几周
	 * @return
	 */
	public int getThisWeek();
	
	/**
	 * 获取当前时间为第几节课
	 * @return
	 */
	public int getcourseCount();
	
	/**
	 * 获取所有应参加课程的学生信息
	 * @return
	 */
	public String getAllStudentList(String teacherNum);
}
