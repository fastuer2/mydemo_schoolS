<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
	<div align="center">
		<form action="/save" method="post">
			姓名：<input type="text" name="name"><br/>
			密码：<input type="text" name="password"><br/>
			电话：<input type="text" name="phone"><br/>
			<input type="submit"  value="保存">
		</form>
	</div>
</body>
</html>