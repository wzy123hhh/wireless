package team.wireless.manager.service;

import java.util.ArrayList;

import team.wireless.dao.UserDao;
import team.wireless.entity.User;
import team.wireless.manager.service.impl.ILoginService;

public class LoginService implements ILoginService{
	UserDao dao = new UserDao();

	@Override
	public int getRegisterCode(User user) {
		return dao.getRegisterCode(user);
	}

	@Override
	public int getLoginCode(String uname, String pwd, String identity) {
		return dao.UserLogin(uname, pwd, identity);
	}
	
	
	@Override
	public int getResetPwdCode(String usernum, String newpwd, String tel) {
		User user = dao.getUserInfo(usernum, "userNum");
		if(null == user) {
			//用户名不存在
			return -1;
		}else {
			int code =dao.UpdateUserInfo(new Object[] {newpwd}, new Object[] {"userPwd"}, user);getClass();
			if(code == 1) {
				return 1;
			}
			return 0;
		}
	}

	@Override
	public ArrayList<String> getUserNumList(String sql) {
		
		ArrayList<User> userlist = dao.getUserList(sql);
		if(userlist == null) {
			return null;
		}
		
		ArrayList<String> userNumlist = new ArrayList<>();
		for (User user : userlist) {
			userNumlist.add(user.getUserNum());
		}
		
		return userNumlist;
	}
}
