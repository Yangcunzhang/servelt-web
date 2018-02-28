package ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class otherServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		/*//打散 组装
		name = new String(name.getBytes("ISO8859-1"),"UTF-8");*/
		String age = request.getParameter("age");
		System.out.println("name === "+ name);
		System.out.println("age === "+ age);
		//从request中获取属性
		String attrName = (String)request.getAttribute("attrName");
		String attrAge = (String)request.getAttribute("attrAge");
		System.out.println("attrName === "+ attrName);
		System.out.println("attrAge === "+ attrAge);
		System.out.println("request = "+request);
		System.out.println("reponse = "+response);

		PrintWriter out = response.getWriter();
		out.println("otherServlet Date <br>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
