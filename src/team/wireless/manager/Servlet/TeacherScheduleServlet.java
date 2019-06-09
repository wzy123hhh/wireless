package team.wireless.manager.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *教师日程	
 * @author 王智源
 *
 */
@WebServlet("/Wireless/TeacherScheduleServlet")
public class TeacherScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TeacherScheduleServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		request.getAttribute("userNum");
		String userNum =(String) request.getSession().getAttribute("userNum");
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
