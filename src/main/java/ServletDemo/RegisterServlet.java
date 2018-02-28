package ServletDemo;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 1.请求参数是存放在Map中的
 * 2.这个Map的key为请求参数的名称，为String类型
 *   这个Map的value为请求参数的所有值为String[]类型
 * 3.使用最多的是 getParamter()方法。其等价于getParameterValues()[0]
 * 
 */

public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收指定名称的请求参数
		// getParamter("name")方法，本质上等同于getPrarmterValues("name")[0]
		System.out.println("接收指定名称的请求参数");
		String username = request.getParameter("username");
		System.out.println("username: " + username);
		String password = request.getParameter("password");
		System.out.println("password" + password);
		// 获取所有请求参数名称
		System.out.println("获取所有请求参数名称");
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String names = parameterNames.nextElement();
			String values = request.getParameter(names);
			System.out.println(names + "====" + values);
		}
		//获取指定参数的所有值
		System.out.println("获取指定参数的所有值");
		String[] hobby = request.getParameterValues("hobby");
		for(String h : hobby) {
			System.out.println("hobby: " + h);
		}
		//获取存放请求参数的Map
		System.out.println("获取存放请求参数的Map");
		Map<String, String[]> map = request.getParameterMap();
		for(String key : map.keySet()) {
			System.out.println(key+"-------------"+request.getParameter(key));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
