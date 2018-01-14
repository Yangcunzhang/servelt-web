package ServletDemo;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class servletDemo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("username"));
		System.out.println(req.getParameter("password"));

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		resp.setContentType("text/html;charset=UTF-8");
		Writer webWriter = resp.getWriter();

		webWriter.write("<html>");
		webWriter.write("<body>");
		webWriter.write("<p>" + username + "</p>");
		webWriter.write("<p>" + password + "</p>");
		webWriter.write("</body>");
		webWriter.write("</html>");
		//cookie保存在session中
		Cookie ucookie = new Cookie("username", username);
		Cookie pcookie = new Cookie("password", password);

		ucookie.setMaxAge(3600);
		pcookie.setMaxAge(3600);

		resp.addCookie(ucookie);
		resp.addCookie(pcookie);

		resp.sendRedirect("readCookie.jsp");
	}

}
