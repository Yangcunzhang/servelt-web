package ServletDemo;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public abstract class GenericServlet2 implements Servlet,ServletConfig {

	private ServletConfig config;
	//模板方法设计模式
	@Override
	public void init(ServletConfig config) throws ServletException {
			this.config = config;
			//调用无参的init()方法
			this.init();//此处的this编译时代表GenericServlet2类，运行时代表GenericServletExample2对象
			System.out.println("执行父类的init()方法");
			System.out.println("+++++++++++++++++++++++++++++++");

	}
	//该无参init()方法，就是要让子类来重写的(带参要创建无参的，否则作为父类会报错)
	public void init() {
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public abstract void service(ServletRequest req, ServletResponse res) throws ServletException, IOException;

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getServletName() {
		// TODO Auto-generated method stub
		return config.getServletName();
	}

	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return config.getServletContext();
	}

	@Override
	public String getInitParameter(String name) {
		// TODO Auto-generated method stub
		return config.getInitParameter(name);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		// TODO Auto-generated method stub
		return config.getInitParameterNames();
	}

}
