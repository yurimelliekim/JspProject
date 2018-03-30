package com.newlecture.jspprj.controller.student.community.answeris;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.servlet.ServletRequest;
import org.apache.tiles.request.servlet.ServletUtil;

import com.newlecture.jspprj.dao.AnswerisDao;
import com.newlecture.jspprj.dao.jdbc.JdbcAnswerisDao;
import com.newlecture.jspprj.entity.Answeris;
import com.newlecture.jspprj.entity.AnswerisView;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/student/community/answeris/reg")
@MultipartConfig(
		fileSizeThreshold = 1024*1024, maxFileSize = 1024*1024*5,maxRequestSize = 1024*1024*5*5)
public class RegController extends HttpServlet {
	
	/*@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getPart("");
		request.getParts("");
	}*/
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/views/student/community/answeris/reg.jsp");
		dispatcher.forward(request, response);*/
		
		request.getContextPath();
		
		ApplicationContext applicationContext = ServletUtil
				.getApplicationContext(request.getSession().getServletContext());
		TilesContainer container = TilesAccess.getContainer(applicationContext);
		ServletRequest servletRequest = new ServletRequest(applicationContext, request, response);
		container.render("student.community.answeris.reg", servletRequest);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String pathUrl  = "/student/upload";
		
		String pathSystem = request.getServletContext().getRealPath(pathUrl);
		
		response.getWriter().println(pathSystem);
		
		File file = new File(pathSystem);
		
		if(!file.exists())
			file.mkdirs();
		
		//MultipartRequest req = new MultipartRequest(request, pathSystem, 1024*1024*100, "UTF-8", new DefaultFileRenamePolicy());
		
		
		Part part = request.getPart("attached");
		InputStream is = part.getInputStream();
		String fname = part.getSubmittedFileName();
		
		
		byte[] buf = new byte[1024];
		FileOutputStream fos = new FileOutputStream(pathSystem+File.separator+fname);
		
		int size = 0;
		
		while((size = is.read(buf,0,1024))!=-1)
			fos.write(buf,0,size);
		
		is.close();
		fos.close();
		
		Answeris answeris = new Answeris();
		answeris.setTitle(request.getParameter("title"));
		answeris.setSituation(request.getParameter("situation"));
		answeris.setAttachedFile(fname);
		answeris.setWriterId("ss");
		
		AnswerisDao answerisDao = new JdbcAnswerisDao();
		answerisDao.insert(answeris);
		
		response.sendRedirect("list");
		
		/*String fileName = req.getParameter("attached");
		response.getWriter().println(fileName);
		
		Enumeration en = req.getFileNames();
		while(en.hasMoreElements()) {
			String key = (String)en.nextElement();
			String fname = req.getFilesystemName(key);
		}*/
		

	}

}
