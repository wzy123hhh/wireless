package team.wireless.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.print.resources.serviceui;
import team.wireless.service.LoginService;

@WebServlet("/Wireless/ForgetPwdServlet")
public class ForgetPwdServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static LoginService service = new LoginService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=UTF-8");
				
		//表单数据
		String usernum = req.getParameter("username");
		String tel = req.getParameter("tel");
		String newpwd = req.getParameter("passwd1");
		
		System.out.println("username:"+usernum+" tel:"+tel);
		
		int result =0;
		
		result = service.getResetPwdCode(usernum, newpwd, tel);
		 
		if(result == 1) {
			resp.getWriter().print("密码修改成功");
		}else if (result == -1) {
			resp.getWriter().println("用户名不存在");
		}else {
			resp.getWriter().println("网络繁忙，请稍后重试");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
