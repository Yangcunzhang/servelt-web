package ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class printWriter extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取标准输出流
		PrintWriter out = response.getWriter();
		//向标准输出流写入数据，那么客户端浏览器就会看到这些数据
		out.append("abc");
		out.append("def");
		out.print("abc");
		out.println("def");
		out.println("ghi");
		out.write("abc");
		out.write("def");
		//对标准输出流的关闭
		out.close();
	}

}
