package team.wireless.Servlet.Ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.print.resources.serviceui;
import team.wireless.service.Ajax.FindTeacherService;

/**
 * .级联下拉列表选择教师
 * 1.传入code
 * 2.根据学校code获取所有对应院部id和name
 * @author 王智源
 *
 */
public class FindTeacherServelt extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private FindTeacherService service = new FindTeacherService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		
		String school =req.getParameter("school");
		String collage=req.getParameter("collage");
		
		if(school!=null) {
			
			//通过学校获取院部编号
			String reString =service.getCollageList(10); //10无意义，只存在一个学校
			resp.getWriter().append(reString);
			
		}else {
			
			//通过院部编号获取教师信息
			String result = service.getTeacherList(collage);
			resp.getWriter().append(result);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
