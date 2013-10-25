package lesson02.file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<HTML><HEAD><TITLE>Multipart Test</TITLE></HEAD><BODY>");
		
		try {
			String contextRootPath = 
					this.getServletContext().getRealPath("/");

			DiskFileItemFactory diskFactory = new DiskFileItemFactory();
			diskFactory.setRepository(
					new File(contextRootPath + "/WEB-INF/temp"));
			ServletFileUpload upload = new ServletFileUpload(diskFactory);
			@SuppressWarnings("unchecked")
			List<FileItem> items = upload.parseRequest(request);
			
			FileItem item = null;
			for (int i = 0; i < items.size(); i++) {
				item = items.get(i);
				
				if (item.isFormField()) {
					processFormField(out, item);
				} else {
					processUploadFile(out, item, contextRootPath);
				}
			}
			
		} catch(Exception e) {
			out.println("<PRE>");
			e.printStackTrace(out);
			out.println("</PRE>");
		}
		
		out.println("</BODY></HTML>");
	}

	private void processUploadFile(
			PrintWriter out, FileItem item, String contextRootPath) 
			throws Exception {
		String name = item.getFieldName();
		String fileName = item.getName();
		String contentType = item.getContentType();
		long fileSize = item.getSize();
		
		String uploadedFileName = 
				System.currentTimeMillis() +
				fileName.substring(fileName.lastIndexOf("."));
		File uploadedFile = new File(
				contextRootPath + "/upload/" + uploadedFileName);
		item.write(uploadedFile);
		
		out.println("<P>");
		out.println("파라미터 이름:" + name + "<BR>");
		out.println("파일 이름:" + fileName + "<BR>");
		out.println("콘텐츠 타입:" + contentType + "<BR>");
		out.println("파일 크기:" + fileSize + "<BR>");
		out.println("<IMG SRC='upload/" 
				+ uploadedFileName 
				+ "' width='300'><BR>");
		out.println("</P>");
	}

	private void processFormField(PrintWriter out, FileItem item) 
		throws Exception{
		String name = item.getFieldName();
		String value = item.getString("UTF-8");
		
		out.println(name + ":" + value + "<BR>");
	}
	
	
}
