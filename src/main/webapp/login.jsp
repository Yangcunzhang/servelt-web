<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/login.css"/> --%>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" 
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
		crossorigin="anonymous">
<title>IT沙龙后台管理登录</title>
<!-- <script type="text/javascript">
function reCheckcode(img) {
	/* 防止浏览器缓存验证码图片，导致不刷新，故传递一个随机数 */
	img.src="drawCode?"+Math.random();
}
</script> -->
<body>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<div class="container">
	<div class="row">
	<div class="col-md-3">
	<!-- Ajax和表单是post提交 -->
		<form id="login" method="post" action="/demo/paramServlet">
		  <div class="form-group">
		    <label for="exampleInputEmail1"> 用戶</label>
		    <input type="text"  class="form-control" name="username"  placeholder="請輸入賬戶">
		    <small id="emailHelp" class="form-text text-muted">密碼必填</small>
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">密碼</label>
		    <input type="password" class="form-control" name="pass" placeholder="請輸入密碼">
		  </div>
		 
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	</div>
</div>
</body>
</html>