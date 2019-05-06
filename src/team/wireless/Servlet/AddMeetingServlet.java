package team.wireless.Servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

@WebServlet("/Wireless/AddMeetingServlet")
public class AddMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddMeetingServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		System.out.println("===============");
		System.out.println(request.getSession().getAttribute("userNum"));
		
		//判断表单字段是否采用文件上传方式
		boolean ismultipartContent = ServletFileUpload.isMultipartContent(request);
		
		if(ismultipartContent) {
			FileItemFactory itemFactory = (FileItemFactory)new DiskFileItemFactory();
			ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
			
			try {
				ArrayList<FileItem> items = (ArrayList<FileItem>) fileUpload.parseRequest((RequestContext) request);
				
				for(FileItem fileItem :items) {
					//判断是否普通表单字段
					if(fileItem.isFormField()) {
						//获取字段值
						if(fileItem.getFieldName().equals("XX")) {
							
						}
	
					}else {
						//获取文件名
						String filename = fileItem.getName();
						//定义文件保存路径
						String fileSavePath = "c://WirelessFile//";
						//生成文件
						File file = new File(fileSavePath,filename);
						//上传到服务器
						fileItem.write(file);
						
					}
					
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
