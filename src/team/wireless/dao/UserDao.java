package team.wireless.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

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
			user =qRunner.query("select * from User where "+filedname+" = '"+value+"'",new BeanHandler<User>(User.class));
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

	@Override
	public int UpdateUserInfo(Object[] values, Object[] filednames, User user) {
		String userNum = user.getUserNum();
		StringBuilder sql = new StringBuilder();
		 
		//拼接SQL语句
		sql.append("update User set "); //
		for (int i = 0; i < filednames.length; i++) {
			sql.append(filednames[i]+"= '"+values[i]+"' ");
			if(i+1<filednames.length) {
				sql.append(',');
			}
		}
		sql.append("where userNum='"+userNum+"'");
//		System.out.println(sql.toString());
		
		try {
			int code = qRunner.update(sql.toString());
			if(code !=0) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	@Override
	public ArrayList<User> getUserList(String sql) {
		
		ArrayList<User> userlist = null;
		try {
			userlist = (ArrayList<User>) qRunner.query(sql, new BeanListHandler<User>(User.class));
			return userlist;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
//	public void test() {
//		User user = new User();
//		user.setId(1);
//		user.setUserName("wzy");
//		user.setUserNum("2017211826");
//		user.setUserPwd("123454");
//		user.setUserPhone("17856002909");
//		
//		int code = UpdateUserInfo(new Object[] {"王智源","11111"},new Object[] {"userName","userPwd"},user);
//		System.out.println(code);
//		
//		
//	}
//	
//	public static void main(String[] args) {
//		
//		User user =new UserDao().getUserInfo("2017211826", "userNum");
//		System.out.println(user==null);
//		
//	}
//
}
