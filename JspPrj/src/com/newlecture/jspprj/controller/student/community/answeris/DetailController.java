package com.newlecture.jspprj.controller.student.community.answeris;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.servlet.ServletRequest;
import org.apache.tiles.request.servlet.ServletUtil;

import com.newlecture.jspprj.dao.AnswerisDao;
import com.newlecture.jspprj.dao.jdbc.JdbcAnswerisDao;
import com.newlecture.jspprj.entity.AnswerisView;

@WebServlet("/student/community/answeris/detail")
public class DetailController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		AnswerisDao answerisDao = new JdbcAnswerisDao();
		AnswerisView answeris = answerisDao.get(id);
		
		request.setAttribute("answeris", answeris);
		
		/*RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/views/student/community/answeris/detail");
		dispatcher.forward(request, response);*/
		
		ApplicationContext applicationContext = ServletUtil
	             .getApplicationContext(request.getSession().getServletContext());
	       TilesContainer container = TilesAccess.getContainer(applicationContext);
	       ServletRequest servletRequest = new ServletRequest(applicationContext, request, response);
	       container.render("student.community.answeris.detail", servletRequest);
		
	}

}
