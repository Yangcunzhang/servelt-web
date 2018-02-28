package ServletDemo;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class servletExample2 implements Servlet {
	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// 获取ServletContext对象
		ServletContext sc = config.getServletContext();
		// 获取域属性的值(多态，父类转子类，强转)
		String mobile = (String) sc.getAttribute("Mobile");
		System.out.println("Mobile: " + mobile);
		// 重置域属性的值
		sc.setAttribute(mobile, "6464646464");
		System.out.println("New Mobile: " + sc.getAttribute(mobile));
		String contextPath = sc.getContextPath();
		System.out.println("contextPath = " + contextPath);
		String realPath = sc.getRealPath("/resourece/css");
		System.out.println("realPath = " + realPath);
		// 删除域属性的值
		sc.removeAttribute(mobile);
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
