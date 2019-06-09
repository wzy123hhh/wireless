package team.wireless.dao.impl;

import org.apache.commons.dbutils.QueryRunner;

public interface ITeacherDao {
	/**
	 * 获取数据库查询对象
	 * @return
	 */
	public QueryRunner getQuneryRunner();
}
