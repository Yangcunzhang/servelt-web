package ServletDemo;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//缺省适配器设计模式（大多数类不实现，让其子类来实现）
public abstract class GenericServlet implements Servlet {

	private ServletConfig config;
	/*把web.xml的信息抽象成对象，把对象作为实参ServleConfig,把实参传递给形参，在此接受config即可*/
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}
	//抽象方法，专门让子类实现
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

}
