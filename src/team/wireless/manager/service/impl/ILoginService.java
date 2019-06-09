package team.wireless.manager.service.impl;

import java.util.ArrayList;

import team.wireless.entity.User;

public interface ILoginService {
	/**
	 * 获取注册返回结果
	 * @param user
	 * @return
	 * 1 > 注册成功
	 * 2 > 用户名存在
	 * 3 > 数据库连接失败 --- 服务器忙
	 */
	public int getRegisterCode(User user);
	
	/**
	 * 获取登录结果
	 * @param uname 用户名
 	 * @param pwd 密码
	 * @param identity 登录身份
 	 * @return
 	 * 1 > 登录成功
	 * 2 > 密码错误
	 * 3 > 用户名不存在
	 * 4 > 服务器忙
	 */
	public int getLoginCode(String uname,String pwd,String identity);
	
	/**
	 * 获取重置密码结果
	 * @param usernum
	 * @param newpwd
	 * @param tel
	 * @return
	 * 1 》 成功
	 * 0 》 错误（服务器异常）
	 * -1 》用户名不存在
	 */
	public int getResetPwdCode(String usernum,String newpwd,String tel);
	
	
	/**
	 * 获取用户名列表
	 * @param sql 查询语句
	 * @return
	 */
	public ArrayList<String> getUserNumList(String sql);
	
	
}
