import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Calc2 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		PrintWriter out = response.getWriter();
		//OutputStream os = response.getOutputStream();
		//PrintWriter out = new PrintWriter(new OutputStreamWriter(os,StandardCharsets.UTF_8),true);
		//PrintStream out = new PrintStream(os);
		 
		
		/*for(int i =0; i<10; i++)
			out.println("Hello Servlet</br>");*/
		
		int x = 0;
		int y = 0;
		
		
		String tempx = request.getParameter("x");
		String tempy = request.getParameter("y");
		
		if(tempx != null && !tempx.equals(""))
			x = Integer.parseInt(tempx);		
        
		if(tempy != null && !tempy.equals(""))
			y = Integer.parseInt(tempy);

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
		out.write("		<form method=\"post\">");
		out.write("			<div>");
		out.write("				<div>");
		out.write("					<input type=\"text\" name=\"x\"/>");
		out.write("				</div>");
		out.write("				<div>");
		out.write("					<input type=\"text\" name=\"y\"/>");
		out.write("				</div>");
		out.write("				<input id=\"btn-submit\" type=\"submit\" value=\"덧셈\" formmethod=\"get\"/>");
		out.write("				<input id=\"btn-add\" type=\"submit\" value=\"Application\"/>");
		out.write("				<input id=\"btn-session\" type=\"submit\" value=\"Session\"/>");
		out.write("				<input id=\"btn-cookie\" type=\"submit\" value=\"Cookie\"/>");
		out.write("			</div>");
		out.write("			<div>");
		out.println("합은 " + (x+y));
        out.write("			</form>");
	    out.write("	</div>");
		out.write("</body>");
		out.write("</html>");
		
			//out.println("합은 " + (x+y));
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("메롱");
		
	}
}
