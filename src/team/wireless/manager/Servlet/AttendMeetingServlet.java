package team.wireless.manager.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.wireless.manager.service.AttendMeetingService;


@WebServlet("/Wireless/AttendMeetingServlet")
public class AttendMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AttendMeetingService service = new AttendMeetingService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String usernum = request.getParameter("usernum");
		String json =service.getAttendTeaInfo("10001");
		
		response.getWriter().print(json);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
