<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>success</h1>
<%-- 	<div>
 	<img src="upload/${filename }" width="30%" height="30%"/><br>
	
	<a href="/upload/DownServlet?filename=${filename }">${filelist }</a></div> --%>
	
	<c:forEach items="${filelist }" var="filelist">
	<div>
		<img src="upload/${filelist }" width="30%" height="30%"/><br>
	
	<a href="/upload/DownServlet?filename=${filelist }">${filelist }</a>
	</c:forEach></div>
</body>
</html>