package team.wireless.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.wireless.service.LoginService;

/***
 * 登录时验证用户名是否存在
 * @author 王智源
 *
 */
@WebServlet("/Wireless/valiateUserName")
public class valiateUserName extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static LoginService service = new LoginService();
       
    public valiateUserName() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ArrayList<String>  names= service.getUserNumList("select * from User");
		
		String uname = request.getParameter("userName");
		String result = "";
	
		
		if(names.contains(uname)) {
			result = "<font color='blue'>用户名可用</font>";
		}else {
			result = "<font color='red'>用户名不存在</font>";
		}
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		response.getWriter().write(result);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
