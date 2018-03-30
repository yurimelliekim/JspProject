import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class Test extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		int result = 0;

		int x = 0;
		int y = 0;

		String tempx = request.getParameter("x");
		String tempy = request.getParameter("y");

		if (tempx != null && !tempx.equals(""))
			x = Integer.parseInt(tempx);

		if (tempy != null && !tempy.equals(""))
			y = Integer.parseInt(tempy);

		result = x + y;

		String result_ = request.getParameter("result");
		if(result_ != null && !result_.equals(""))
			result = Integer.parseInt(result_);
			    
            //GET 요청일 경우
			out.write("<!DOCTYPE html>");
			out.write("<html>");
			out.write("<head>");
			out.write("<meta charset=\"UTF-8\">");
			out.write("<title>Insert title here</title>");
			out.write("<style>");
			out.write("</style>");
			out.write("</head>");
			out.write("<body>");
			out.write("	<div>");
			out.write("		<form action=\"add\" method=\"post\">");
			out.write("			<div>");
			out.write("				<div>");
			out.write("					<input type=\"text\" name=\"x\" value=\"\"/>");
			out.write("				</div>");
			out.write("				<div>");
			out.write("					<input type=\"text\" name=\"y\" />");
			out.write("				</div>");
			out.write("				<input id=\"btn-submit\" type=\"submit\" name=\"btn\" value=\"덧셈\"/>");
			out.write("				<input id=\"btn-add\" type=\"submit\" name=\"btn\" value=\"Application\"/>");
			out.write("				<input id=\"btn-session\" type=\"submit\" name=\"btn\" value=\"Session\"/>");
			out.write("				<input id=\"btn-cookie\" type=\"submit\" name=\"btn\" value=\"Cookie\"/>");
			out.write("			</div>");
			out.write("			<div>");
			out.printf("result : %d",result);
			out.write("<input id=\"result\" type=\"hidden\" name=\"result\" value=\""+result+"\"/>");
			out.write("			</div>");
	        out.write("			</form>");
		    out.write("	</div>");
		    out.write("<div>");
		    out.write("	<a href=\"mypage\">마이페이지</a>");
		    out.write("</div>");
			out.write("</body>");
			out.write("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();

		int result = 0;

		int x = 0;
		int y = 0;
		
		String btn = "덧셈";

		String tempx = request.getParameter("x");
		String tempy = request.getParameter("y");

		if (tempx != null && !tempx.equals(""))
			x = Integer.parseInt(tempx);

		if (tempy != null && !tempy.equals(""))
			y = Integer.parseInt(tempy);
		
		String temp1 = request.getParameter("btn");
		if (temp1 != null && !temp1.equals(""))
			btn = temp1;
		
		switch (btn) {

		case "덧셈":
			result = x + y;
			break;

		case "Application":{
			ServletContext application = request.getServletContext();
			int result_ = Integer.parseInt(request.getParameter("result"));
			application.setAttribute("result", result_);

			break;
		}

		case "Session":{
			HttpSession session = request.getSession();
			String result_ = request.getParameter("result");
			session.setAttribute("result",result_);

			break;
		}

		case "Cookie":{
			String result_ = request.getParameter("result");
			Cookie cookie = new Cookie("result", result_);
			cookie.setMaxAge(60*30); //초 단위
			response.addCookie(cookie);
		}
			

			break;

		}
		

		//result = x + y;
		
		//response.sendRedirect("add?x="+x+""&y=result = "+result);
		response.sendRedirect(String.format("add?x=%d&y=%d&result=%d",x,y,result));
	}
	
	/*@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}*/
}
