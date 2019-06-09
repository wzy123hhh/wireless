package team.wireless.manager.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.wireless.entity.User;
import team.wireless.manager.service.LoginService;

/**
 * 注册页面Servlet
 * @author 王智源
 *
 */
@WebServlet("/wireless/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name").trim();
		String account = request.getParameter("account").trim();
		String passwd = request.getParameter("passwd").trim();
		String tel = request.getParameter("tel").trim();
		
		User user = new User();
		
		user.setUserName(name);
		user.setUserPhone(tel);
		user.setUserName(name);
		user.setUserPwd(passwd);
		user.setUserNum(account);
		
		LoginService service = new LoginService();
		int code = service.getRegisterCode(user);
		
		if(code == 1) {
			
		}else if(code == 2) {
			
		}else {
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
