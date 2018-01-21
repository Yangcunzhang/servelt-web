package ServletDemo;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		String driver = config.getInitParameter("driver");
		String url = config.getInitParameter("url");
		String user = config.getInitParameter("user");
		String pass = config.getInitParameter("pass");
		
		try {
			//regist the driver
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id, NAME FROM t_user");
		
			resp.setContentType("text/html;charSet=gbk");
			PrintStream out = new PrintStream(resp.getOutputStream());
			out.println("<html><head><title>Servlet Init Param Test</title></head>");
			out.println("<body>");
			out.println("<table>");
			while(rs.next()){
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+ rs.getString(2)+"</td></tr>");
				System.out.println(rs.getString(1) + rs.getString(2));
			}
			out.println("</table></body></html>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
}
