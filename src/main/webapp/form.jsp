<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form id="login"  method="POST" action="/demo/RegisterServlet">
用户名: <input type="text" name="username"><br>
密码: <input type="text" name="password"><br>
爱好：
<input type="checkbox" name = "hobby" value="running"/>跑步
<input type="checkbox" name = "hobby" value="swimming"/>游泳
<input type="checkbox" name = "hobby" value="reading"/>看书<br>
验证:<input type="text" name="chekin"><br>
<img src="/demo/CheckinDrawer"/><br/>
<input type="submit" value="登录">
</form>
</body>
</html>