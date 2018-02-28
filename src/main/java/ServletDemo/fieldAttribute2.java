package ServletDemo;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class fieldAttribute2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从请求中获取指定名称的域属性
		String company = (String) request.getAttribute("Company");
		String address = (String) request.getAttribute("Address");
		System.out.println("Company: "+ company);
		System.out.println("Address: "+ address);
		//获取请求中的所有域属性名称
		Enumeration<String> names = request.getAttributeNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println(name + "======="+request.getAttribute(name));
		}
		
	}

	

}
