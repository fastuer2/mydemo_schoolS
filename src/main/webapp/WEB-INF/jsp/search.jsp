<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
	<div align="center">
		<form action="/search_user" method="post">
			姓名：<input type="text" name="name"><br/>
			密码：<input type="text" name="password"><br/>
			电话：<input type="text" name="phone"><br/>
			<input type="submit"  value="搜索">
		</form>
				<table>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>密码</th>
				<th>电话</th>
				<th>创建时间</th>
			</tr>
			<c:forEach items="${users.content}" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td>${user.password }</td>
					<td>${user.phone }</td>
					<td>${user.ctime }</td>
				</tr>
			</c:forEach>
		</table>
	    <div>
            <a href="/list?page=0&name=${name }&password=${password}&phone=${phone}">[首  页]</a>
            <a href="/list?page=${users.number-1}&name=${name }&password=${password}&phone=${phone}">[上一页]</a>
            <a href="/list?page=${users.number+1}&name=${name }&password=${password}&phone=${phone}">[下一页]</a>
            <a href="/list?page=${users.totalPages-1}&name=${name }&password=${password}&phone=${phone}">[末  页]</a>
	    </div>
	</div>
</body>
</html>