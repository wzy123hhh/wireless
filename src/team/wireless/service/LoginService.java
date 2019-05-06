package team.wireless.service;

import team.wireless.dao.UserDao;
import team.wireless.entity.User;
import team.wireless.service.impl.ILoginService;

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
	
}
