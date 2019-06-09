package team.wireless.manager.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import team.wireless.manager.service.LoginService;
/**
 * 用户登录
 * @author 王智源
 *
 */
@WebServlet("/Wireless/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static LoginService service = new LoginService();
   
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String username = request.getParameter("usernum").trim();
		String password = request.getParameter("pwd").trim();
		String identity = request.getParameter("identity").trim();
		
		int code = service.getLoginCode(username, password, identity);
		System.out.println("code = "+code);
		
		if(code == 1) {
			
			response.getWriter().print("success");
			//登录成功
			HttpSession session = request.getSession();
			//设置用户账号到session
			session.setAttribute("userNum", username);
			//重定向到开始界面
			
			System.out.println("重定向");
			
		}else if(code == 2) {
			
			response.getWriter().print("密码错误");
			
		}else if(code == 3) {
			
			response.getWriter().println("用户名不存在");
			
		}else {
			response.getWriter().println("服务器忙，请稍后再试");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
