package ServletDemo;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class responseSendredirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		//打散 组装
		name = new String(name.getBytes("ISO8859-1"),"UTF-8");
		String age = request.getParameter("age");
		System.out.println("name = "+ name);
		System.out.println("age = "+ age);
		//编码，打散
		String encode = URLEncoder.encode(name,"UTF-8");
		//重定向
		response.sendRedirect("otherServlet2?pname=" + name+"\n"+" &page="+age);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
