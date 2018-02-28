package ServletDemo;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericServletExample2 extends GenericServlet2 {
	@Override
	// 此处的ServletConfig对象来源于Tomcat服务器，对象传给实参config
	public void init(ServletConfig config) throws ServletException {
		// 此处的实参config传给父类GenericServlet2的init()方法，所以此句不可删
		super.init(config);
		System.out.println("执行子类的init()方法");
		System.out.println("===============================");
	}
	@Override
	//模板方法设计模式
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("最佳做法:父类里创建无参构造器，在有参构造器里调用，在子类里重写");
		System.out.println("-------------------------------");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("执行GenericServlet2的service方法");
		// 继承servletConfig接口直接调用其各种方法
		String param = this.getInitParameter("Company2");
		System.out.println("Company2: " + param);

	}

}
