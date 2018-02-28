package ServletDemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestOtherMethod extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求的URL
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("requestURL:" + requestURL);
		//获取请求的URI：URL去掉请求协议及主机
		String requestURI = request.getRequestURI();
		System.out.println("requestURI: " + requestURI);
		//获取当前Web应用的根目录
		String contextPath = request.getContextPath();
		System.out.println("contextPath: "+ contextPath);
		//获取客户端IP
		String remoteAddr = request.getRemoteAddr();
		System.out.println("remoteAddr:" + remoteAddr);
		//获取servletPath精确部分
		String servletPath = request.getServletPath();
		System.out.println("servletPath: " + servletPath);
		//获取servletPath的非精确部分
		String pathInfo = request.getPathInfo();
		System.out.println("pathInfo: "+pathInfo);
		
		
	}

}
