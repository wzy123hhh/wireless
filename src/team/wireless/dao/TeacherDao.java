package team.wireless.dao;

import org.apache.commons.dbutils.QueryRunner;

import team.wireless.dao.impl.ITeacherDao;
import team.wireless.util.SqlUtil;

public class TeacherDao implements ITeacherDao{
	QueryRunner query = SqlUtil.getQuery();
	
	
	@Override
	public QueryRunner getQuneryRunner() {
		return query;
	}
	
	
	
}
