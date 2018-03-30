package com.newlecture.jspprj.controller.student.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.servlet.ServletRequest;
import org.apache.tiles.request.servlet.ServletUtil;

import com.newlecture.jspweb.dao.MemberRoleDao;

@WebServlet("/student/index")
public class IndexController extends HttpServlet {	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("id")==null)
			response.sendRedirect("../member/login?returnurl=../student/index");
		
		/*String memberId = String.valueOf(session.getAttribute("id"));
		
		PrintWriter out = response.getWriter();
		MemberRoleDao memberRoleDao = new JdbcMemberRoleDao();
		if(!memberRoleDao.hasMemberRole(memberId,"ROLE_STUDENT"))
			out.println("<script>alert('허락되지 않는 접급입니다.');history.back();</script>");*/
		
		
		ApplicationContext applicationContext = ServletUtil
				.getApplicationContext(request.getSession().getServletContext());
		TilesContainer container = TilesAccess.getContainer(applicationContext);
		ServletRequest servletRequest = new ServletRequest(applicationContext, request, response);
		container.render("student.home.index", servletRequest);
	}

}
