package team.wireless.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import team.wireless.dao.impl.IUserDao;
import team.wireless.entity.User;
import team.wireless.util.SqlUtil;

public class UserDao implements IUserDao{
	QueryRunner qRunner = SqlUtil.getQuery();

	@Override
	public int getRegisterCode(User user) {
		if(getUserInfo(user.getUserNum(), "userNum") == null) {
			try {
				
				qRunner.insert("insert into User values(?,?,?,?,?,?)", new BeanHandler<>(user.getClass()),new Object[] {user.getId(),user.getUserName(),
				user.getUserNum(),user.getUserPhone(),user.getUserPwd(),user.getUserImg()});
				
				return 1;
			} catch (SQLException e) {
				e.printStackTrace();			
			}
			    return 3;
		}else {
			return 2;
		}
	}

	@Override
	public User getUserInfo(String value, String filedname) {
		User user = null;
		try {
			user =qRunner.query("select * from User where ? = ?",new BeanHandler<User>(User.class), new Object[] {filedname,value});
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int UserLogin(String uname, String pwd, String identity) {
		try {
			Long count = qRunner.query("select count(1) from User where userNum ='"+uname+"' and identity ='"+identity+"'",new ScalarHandler<>());
			if(count == 0) {
				return 3;
			}
			count = qRunner.query("select count(1) from User where userNum ='"+uname+"' and userPwd ='"+pwd+"'",new ScalarHandler<>());
			if(count == 0) {
				return 2;
			}
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 4;
		}
	}
	
	
	
	
	
	
	
	
	
	
//	public void test() {
////		User user = new User();
////		user.setId(1);
////		user.setUserName("wzy");
////		user.setUserNum("2017211826");
////		user.setUserPwd("123454");
////		user.setUserPhone("17856002909");
////		
////		System.out.println(getRegisterCode(user));
//		
//		System.out.println(UserLogin("2017211826", "123454", "student"));
//	}
//	
//	public static void main(String[] args) {
//		new UserDao().test();
//	}
//	
}
