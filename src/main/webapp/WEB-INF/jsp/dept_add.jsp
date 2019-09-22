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
<script type="text/javascript">
	function save(){
			var name=$("#name").val();
			$.post({
				url:"/dept/save",
				data:{"name":name},
				success:function(){
					alert("保存部门");
					$("#content").load("/dept");
				}
			});
	}
</script>
<title>添加部门</title>
</head>
<body>
	<table>
		<tr>
			<td>部门名称</td>
			<td>操作</td>
		</tr>
		<tr>
			<td><input id="name" type="text" name="name"></td>
			<td><input type="button" onclick="save()" value="保存"></td>
		</tr>
	</table>
</body>
</html>