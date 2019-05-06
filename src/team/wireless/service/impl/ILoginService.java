package team.wireless.service.impl;

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
	
}
