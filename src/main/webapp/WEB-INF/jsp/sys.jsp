<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<title>学校管理系统</title>
<script type="text/javascript">
	function del(e){
		var td=e.parentNode;
		var tr=td.parentNode;
		var id=tr.cells[0].innerHTML;
		$.ajax({
			   type: "POST",
			   url: "/del",
			   async:false,
			   data: "id="+id,
			   success: function(){
			     location.reload();
			   }
			});
	}
	function add(){
		$.get("/add");
	}
</script>
</head>
<body>
	<div align="center">
		<a href="/add">添加</a>&nbsp;<a href="/search">搜索</a>
		<table>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>密码</th>
				<th>电话</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${users.content}" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td>${user.password }</td>
					<td>${user.phone }</td>
					<td>${user.ctime }</td>
					<td><input type="button" value="删除" onclick="del(this)"></td>
				</tr>
			</c:forEach>
		</table>
	    <br>
	    <div>
	            <a href="/list?page=0">[首  页]</a>
	            <a href="/list?page=${users.number-1}">[上一页]</a>
	            <a href="/list?page=${users.number+1}">[下一页]</a>
	            <a href="/list?page=${users.totalPages-1}">[末  页]</a>
	    </div>
    <br>
	</div>
</body>
</html>