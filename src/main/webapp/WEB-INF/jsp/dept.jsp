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
<title>部门管理</title>
<script type="text/javascript">
	$(function(){
        //$('table tr:not(:first)').remove();
        var len = $('table tr').length;
        for(var i = 1;i<len;i++){
            $('table tr:eq('+i+') td:first').text(i);
        }      
	});
	function add(){
		$("#content").load("/dept/add");
	}
	function update(e){
		var td=e.parentNode;
		var tr=td.parentNode;
		var id=tr.cells[1].innerHTML;
		$("#content").load("/dept/update?id="+id);
	}
	function del(e){
		var td=e.parentNode;
		var tr=td.parentNode;
		var id=tr.cells[1].innerHTML;
		console.log(id);
		$.ajax({
			type:"POST",
			url:"/dept/del",
			data:"id="+id,
			success:function(){
				$("#content").load("/dept");
			}
		});
	}
</script>
</head>
<body id="content">
	<table border=1>
		<tr>
			<td>编号</td>
			<td>部门名称</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${depts.content}" var="dept">
		<tr>
			<td></td>
			<td hidden="true">${dept.id}</td>
			<td>${dept.name}</td>
			<td><input type="button" onclick="add()" value="添加"></td>
			<td><input type="button" onclick="update(this)" value="修改"></td>
			<td><input type="button" value="删除" onclick="del(this)"></td>
		</tr>
		</c:forEach>
	</table>
		    <br>
	    <div>
	            <a href="/dept?page=0">[首  页]</a>
	            <a href="/dept?page=${depts.number-1}">[上一页]</a>
	            <a href="/dept?page=${depts.number+1}">[下一页]</a>
	            <a href="/dept?page=${depts.totalPages-1}">[末  页]</a>
	    </div>
</body>
</html>