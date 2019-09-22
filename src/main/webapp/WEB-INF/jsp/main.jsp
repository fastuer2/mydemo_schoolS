<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-treeview.js"></script>
<title>学校管理系统</title>
<script type="text/javascript">
</script>
<%
	String server_path=request.getContextPath();
	String server_path1= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+server_path;
%>
</head>
<body>
欢迎，${user.name }回来了
<script type="text/javascript">
$(function(){
	$.ajax({
		url:"/load",
		dataType:"json",
		success:function(result){
			console.log(result);
			$("#tree").treeview({
				data:result,
				//enableLinks:true,
				onNodeSelected:function(event,data){
					$("#content").load(data.href);
				}
			})
			var default_url=result[0].href;
			//$("#content").load(default_url,{"page":0,"pageSize":10});
		}
	});
})
</script>

 
<div id="container">
 
	<div id="header" style="background-color:#FFA500;">
		<h1 style="margin-bottom:0;">学校管理系统</h1>
	</div>
	 
	<div id="menu" style="float:left;">
		<b>菜单</b><br>
		<div id="tree">
		</div>
	</div> 
	<div id="content" style="background-color:#EEEEEE;"></div>
	 
	<div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
	版权 © runoob.com</div>
 
</div>
 
</body>
</html>