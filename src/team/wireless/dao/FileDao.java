package team.wireless.dao;

import java.sql.Date;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import team.wireless.dao.impl.IFileDao;
import team.wireless.util.SqlUtil;


public class FileDao implements IFileDao{
	QueryRunner qRunner = SqlUtil.getQuery();
	
	@Override
	public void SavaFilePath(Date upDate, String upuserNum, String filename, String savepath, String fileSize) {
		try {
			qRunner.insert("insert into SaveFile (upusernum,filename,savepath,filesize,uptime) values(?,?,?,?,?)", new ArrayHandler(), new Object[] {Integer.parseInt(upuserNum),filename,savepath,fileSize,upDate});
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
//	public static void main(String[] args) {
//		new FileDao().SavaFilePath(new Date(System.currentTimeMillis()), "2017211826", "test.txt", "d:/test/", "10244");
//	}
}
