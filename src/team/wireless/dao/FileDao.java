package team.wireless.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import team.wireless.dao.impl.IFileDao;
import team.wireless.entity.MFile;
import team.wireless.entity.Meeting;
import team.wireless.util.SqlUtil;


public class FileDao implements IFileDao{
	QueryRunner qRunner = SqlUtil.getQuery();
	
	@Override
	public void SavaFilePath(Date upDate, String upuserNum, String filename, String savepath, String fileSize,String filetype,String meetingNo) {
		try {
			qRunner.insert("insert into SaveFile (upusernum,filename,savepath,filesize,update,filetype,meetingno) values(?,?,?,?,?,?,?)", new ArrayHandler(), new Object[] {Integer.parseInt(upuserNum),filename,savepath,fileSize,upDate,filetype,meetingNo});
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MFile> getMfileList(String sql) {
		ArrayList<MFile> filelist = new ArrayList<>();
		try {
			filelist = (ArrayList<MFile>) qRunner.query(sql, new BeanListHandler<>(MFile.class));
			return filelist;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public int addFileOwner(String teacherNum,String saveNo) {
		
		try {
			int count = qRunner.insert("insert into fileowner values(?,?)", new ScalarHandler<>(), new Object[] {teacherNum,saveNo});
			if(count < 0)
			{
				return -1;
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}

	@Override
	public List<Object> getSaveNoList(String teacherNo) {
		
		List<Object> savenos = null;
		
		try {
			
			savenos = qRunner.query("select saveno from savefile where userNum = '"+teacherNo+"'",new ColumnListHandler<>());
			return savenos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}


	

	
	public static void main(String[] args) {
//		new FileDao().SavaFilePath(new Date(System.currentTimeMillis()), "2017211826", "test.txt", "d:/test/", "10244");
//		
	}
}
