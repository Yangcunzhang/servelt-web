package ServletDemo;
import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
//使用servlet annotation必須3.0版本以上
@WebServlet(name="parmServlet", urlPatterns={"/paramServlet"},
		initParams={@WebInitParam(name="driver",value="com.mysql.jdbc.Driver"),
				    @WebInitParam(name="url",value="jdbc:mysql://localhost:3306/test"),
				    @WebInitParam(name="user",value="root"),
				    @WebInitParam(name="pass",value="12345678")
					})
public class ParamServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String errMsg = "";
		//later use for forward resquest&response to view layer
		RequestDispatcher rd;
		//get value from jsp
		String username = req.getParameter("username");
		String pass = req.getParameter("pass");
		try{
			BaseDao bdo = new BaseDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/test", "root","12345678");
			ResultSet rs = bdo.query("select name, passwd from t_user where name = ?", username);
			if(rs.next()){
				if(rs.getString("passwd").equals(pass)){
					HttpSession session = req.getSession();
					session.setAttribute("name", username);
					//specify the target jsp
					rd = req.getRequestDispatcher("/welcome.jsp");
					//forward the reqest & reponse
					rd.forward(req, resp);
				}else{
					errMsg = "密码与账户名不符合";
				}
			}else{
				errMsg = "账户不存在";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//if login failure
		if(errMsg != null && !errMsg.equals("")){
			rd = req.getRequestDispatcher("/login.jsp");
			req.setAttribute("err", errMsg);
			rd.forward(req, resp);
		}
	}
}