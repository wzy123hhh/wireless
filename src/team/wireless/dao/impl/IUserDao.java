package team.wireless.dao.impl;

import java.util.ArrayList;

import team.wireless.entity.User;

public interface IUserDao {
	/**
	 * 获取注册状态
	 * @param user
	 * @return 
	 * 1 > 注册成功
	 * 2 > 用户名存在
	 * 3 > 数据库连接失败 --- 服务器忙
	 */
	public int getRegisterCode(User user);
	
	/**
	 * 根据指定值获取某个用户信息
	 * @param value 查询的值
	 * @param filedname 查询值的类型（与数据库中列名一致）
	 * @return
	 * 查询的结果封装到User中
	 */
	public User getUserInfo(String value,String filedname);
	
	/**
	 * 获取登录结果
	 * @param uname 用户名
	 * @param pwd 密码
	 * @param identity 身份
	 * @return 
	 * 1 > 登录成功
	 * 2 > 密码错误
	 * 3 > 用户名不存在
	 * 4 > 服务器忙
	 */
	public int UserLogin(String uname,String pwd,String identity);
	
	
	/**
	 * 更新用户信息 
	 * @param values  更新的值
	 * @param filednames 更新名称
	 * @param user 用户
	 * @return
	 * 1 成功
	 * -1 失败
	 */
	public int UpdateUserInfo(Object[] values,Object[] filednames,User user);
	
	/**
	 * 获取用户列表
	 * @param sql 查询sql语句
	 * @return
	 */
	public ArrayList<User> getUserList(String sql);
	
}
