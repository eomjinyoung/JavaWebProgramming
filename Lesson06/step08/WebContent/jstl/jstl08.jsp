<%@page import="java.util.ArrayList"%>
<%@page import="spms.vo.Member"%>
<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL</title>
</head>
<body>
<p><a href="jstl07.jsp">[이전]</a><a href="jstl09.jsp">[다음]</a></p>

<h2>c:url 태그</h2>

<c:url var="calcUrl" value="http://localhost:9999/calc">
	<c:param name="v1" value="20"/>
	<c:param name="v2" value="30"/>
	<c:param name="op" value="+"/>
</c:url>
<a href="${calcUrl}">계산하기</a>

<p><a href="jstl07.jsp">[이전]</a><a href="jstl09.jsp">[다음]</a></p>
</body>
</html>