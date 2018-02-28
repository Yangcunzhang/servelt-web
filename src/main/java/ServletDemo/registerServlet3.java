package ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registerServlet3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 对于请求中文乱码的万能方法
		// 这里接收到的name，其字符编码为ISO8859-1
		String name = request.getParameter("name");
		// 将name字符串按照原编码进行打散
		byte[] bytes = name.getBytes("ISO8859-1");
		// 将bytes字节数组按照指定字符编码进行组装，组装为string
		name = new String(bytes, "UTF-8");
		String age = request.getParameter("age");
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		// 解决响应的中文乱码问题，设置响应的MIME类型，其中可以指定MIME的字符编码，即响应体的字符编码
		//方式一，setCharacterEncoding()方法使用的前提是之前必须要先使用setContentType()方法
		//setCharacterEncoding()方法用于修改ContextType的MIME类型的字符编码
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		// 方士二
		// response.setContentType("text/html;charset=UTF-8");
		// 获取标准输出流
		PrintWriter out = response.getWriter();
		// 向标准输出流写入数据
		out.println("大连富达");
		out.println("name = " + name);
		out.println("age = " + age);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
