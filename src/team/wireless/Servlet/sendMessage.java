package team.wireless.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import team.wireless.util.SendMessage;

@WebServlet("/Wireless/sendMessage")
public class sendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    SendMessage message = new SendMessage();
    
    public sendMessage() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String tel = request.getParameter("tel");
		JSONObject result = message.SendCode(tel);
		
		
		if(result==null) {
			//发送成功
			response.getWriter().print("发送失败，请稍后重试");
			
		}else {
			
			Cookie cookie = new Cookie("code", result.getString("verifyCode"));
			//设置Cookie最大存活时长五分钟
			cookie.setMaxAge(30000);
			response.addCookie(cookie);
			
			response.getWriter().print("发送成功，请稍后再试");
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
