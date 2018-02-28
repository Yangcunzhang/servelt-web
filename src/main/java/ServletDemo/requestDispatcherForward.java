package ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class requestDispatcherForward extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		/*//打散 组装
		name = new String(name.getBytes("ISO8859-1"),"UTF-8");*/
		String age = request.getParameter("age");
		System.out.println("name = "+ name);
		System.out.println("age = "+ age);
		//无论是forward()还是include(),对于请求来说都是一样的，不同点主要集中于响应
		//forward意思是“向前”，说明当前的请求还未结束，需要继续"向前"，所以服务器就不会在这里先打开标准输出流。所以此时写入到out中的数据是不会写入到客户端服务器中
		//使用forward方法的servlet，其标准输出流还未开启
		//对客户端的响应肯定不是由使用forward()方法的Servlet给出的
		//include意思是“包含”，说明当前的请求已经结束，可以对客户端进行响应了，其不仅将自己的数据写入到标准输出流，还要将其他数据包含到自己的输出流中
		//使用include方法的servlet，其标准输出流已经打开
		//对客户端的响应是由使用include()方法的Servlet给出的
		//结论：在使用forward()进行请求转发时，使用forward()的Servlet不应向Response中写入数据
		//	      若要写入数据，则应使用include()
		System.out.println("request = "+request);
		System.out.println("reponse = "+response);

		//向request域中放入属性
		request.setAttribute("attrName", name);
		request.setAttribute("attrAge", age);
		//用html来解析
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("SomeServlet:forward()before<br>");
		//请求转发
		request.getRequestDispatcher("otherServlet").include(request, response);
		out.print("SomeServlet:forward()after<br>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
