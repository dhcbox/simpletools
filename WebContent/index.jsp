<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
	<form action="userAction" method="post">
		<input type="hidden" name="flag" value="login"/>
		<img src="vcode"/><span id="imgtips">换一张</span><br/>
		<input type="submit" value="提交"/>
	</form>
	
	<script type="text/javascript" src="http://cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#imgtips").css({"font-size":"12px","color":"red"});
			$("#imgtips").click(function(){
				$("img").attr("src","vcode?a="+new Date().getTime());
			});
		});
	</script>
</body>
</html>