package ServletDemo;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("===================================");
		/*
		 * 多态：分为上转型和下转型 上转型：将子类引用赋值给父类引用 下转型：将父类应用赋值给子类引用。但Java中不支持真正的下转型的；但父类对象本身是由子类对象
		 * 上转型而来的，那么可以通过强转的方式，将其赋值给子类对象
		 */
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		// 获取请求 的提交方式
		service(request, response);

	}

	public void service(HttpServletRequest request, HttpServletResponse response) {
		String method = request.getMethod();
		System.out.println("method = " + method);
		if ("POST".equals(method)) {
			doPost(request, response);
		} else if ("GET".equals(method)) {
			doGet(request, response);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

	}

}
