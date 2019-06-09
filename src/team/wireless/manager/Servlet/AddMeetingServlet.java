package team.wireless.manager.Servlet;

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

import team.wireless.entity.MFile;
import team.wireless.manager.service.AddMeetingService;

@WebServlet("/Wireless/AddMeetingServlet")

public class AddMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static AddMeetingService service = new AddMeetingService();
    public AddMeetingServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
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
					
						//获取上传者账号
						String upuserNum = (String) request.getSession().getAttribute("userNum");
						//获取文件名
						String filename = fileItem.getName();
						//获取文件类型
						String filetype = filename.substring(filename.lastIndexOf("."), filename.length());
						//获取文件大小
						String filesize = String.valueOf(fileItem.getSize());
						//定义文件保存路径
						String fileSavePath =service.produceSavePath(upuserNum);
						//生成文件
						File file = new File(fileSavePath,filename);
						//上传到服务器
						fileItem.write(file);
						
						MFile mFile = new MFile(upuserNum, filename, fileSavePath, filesize, filetype);
						
//						service.SaveFliePath(mFile);
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
