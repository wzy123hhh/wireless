package team.wireless.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

public class SqlUtil {
	private static BasicDataSource bSource = new BasicDataSource();
	private static QueryRunner qRunner = new QueryRunner(bSource);
	static {
		
		//连接数据库
		bSource.setDriverClassName("com.mysql.jdbc.Driver");
		bSource.setUrl("jdbc:mysql://120.78.124.27:3306/wireless");
		bSource.setUsername("root");
		bSource.setPassword("wzy159357");
		
		//最大连接数
		bSource.setMaxActive(10);
		//最小空闲连接数
		bSource.setMinIdle(5);
		//最大空闲连接
		bSource.setMaxIdle(10);
		//初始化连接数
		bSource.setInitialSize(2);
		
		
	}
	/**
	 * 
	 * @return
	 */
	private static DataSource getConnection() {
		return bSource;
	}
	
	/**
	 * 获取查询
	 * @return QueryRunner
	 */
	public static QueryRunner  getQuery() {
		return qRunner;
	}
}