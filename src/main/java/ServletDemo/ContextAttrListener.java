package ServletDemo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextAttrListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("website", "www.softcits.cn");
		
		System.out.println("web项目启动了---->完成application级别website属性设定");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		sce.getServletContext().removeAttribute("website");
	}

}
