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
<title>Insert title here</title>
<script type="text/javascript">
	function save(){
		var name=$("#name").val();
		var id=$("#id").val();
		console.log(name);
		$.ajax({
			url:"/dept/dept_save",
			data:"id="+id+"&name="+name,
			success:function(){
				$("#content").load("/dept");
			}
		});
	}
</script>
</head>
<body>
<input id="id" type="text" name="name" value="${dept.id}" hidden=true><br/>
<input id="name" type="text" name="name" value="${dept.name}"><br/>
<input type="button" value="±£´æ" onclick="save()">
</body>
</html>