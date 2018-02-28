package ServletDemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class fieldAttribute extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//向请求中放入属性
		request.setAttribute("Company", "FIL3");
		request.setAttribute("Address", "软件园路");
		//将请求转发FieldAttribute
		request.getRequestDispatcher("/FieldAttribute2").forward(request, response);
	}

}
