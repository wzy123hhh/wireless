package team.wireless.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.wireless.service.LoginService;
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
		
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		String identity = request.getParameter("identity").trim();
		
		
		int code = service.getLoginCode(username, password, identity);
		
		if(code == 1) {
			System.out.println("登录完成");
			//登录成功
			HttpSession session = request.getSession();
			//设置用户账号到session
			session.setAttribute("userNum", username);
			//重定向到开始界面
			response.sendRedirect("index.html");
			
		}else if(code == 2) {
			
		}else if(code == 3) {
			
		}else {
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
