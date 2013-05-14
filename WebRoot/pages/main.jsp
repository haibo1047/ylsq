<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/pages/common/include.jsp"%>

<html>
	<head>
		<title>-ylsq</title>
		<meta http-equiv=Content-Type content=text/html;charset=gb2312>
	</head>
	<script>
		//window.history(-1).foward(1);
		function go(){
			document.form1.submit();
		}
	</script>

	<body>
    This is my JSP page. <br>
		cnt:<c:out value="${cnt }"></c:out>
		
		
		<form action="http://ylsq.sinaapp.com/wechat.x" method="post" name="form1">
			<input type="text" name="__________test_________name___________" value="________value______">
			
			<input type="button" onclick="go()" value="go_to_sae">
		</form>
  </body>
</html>