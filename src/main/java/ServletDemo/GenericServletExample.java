package ServletDemo;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericServletExample extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			System.out.println("执行GenericServlet的service方法");
			//通过getServletConfig()方法来得到config
			ServletConfig servletConfig = this.getServletConfig();
			String param = servletConfig.getInitParameter("Company");
			System.out.println("Company: "+param);
	}

}
