package ServletDemo;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class servletExample implements Servlet {
	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("config= " + config);
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("执行servletExample的service()方法");
		// 获取servlet名称,一个servlet对应一个config
		String servletName = config.getServletName();
		System.out.println("servletName= " + servletName);
		// 获取servletConfig对象
		ServletContext servletcontext = config.getServletContext();
		System.out.println("servletContext= " + servletcontext);
		// 获取所有的初始化参数
		Enumeration<String> names = config.getInitParameterNames();
		// 遍历枚举，获取枚举的当前遍历的值
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			// 获取指定参数的值
			String value = config.getInitParameter(name);
			System.out.println(name + " = " + value);
		}
		// 获取全局初始化参数
		Enumeration<String> contextNames = servletcontext.getInitParameterNames();
		// 遍历枚举，获取当前遍历的值
		while (contextNames.hasMoreElements()) {
			String name = contextNames.nextElement();
			// 获取指定参数的值
			String value = servletcontext.getInitParameter(name);
			System.out.println(name + " = " + value);

		}
		// 设置域属性,全局性的，都能访问
		servletcontext.setAttribute("email", "123456@qq.com");
		servletcontext.setAttribute("Mobile", "1555533222");

	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
