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
<p><a href="jstl03.jsp">[이전]</a><a href="jstl05.jsp">[다음]</a></p>

<h2>c:if 태그</h2>
<c:if test="${10 > 20}" var="result1">
1) 10은 20보다 크다.<br>
</c:if>
2) ${result1}<br>

<c:if test="${10 < 20}" var="result2">
3) 10은 20보다 크다.<br>
</c:if>
4) ${result2}<br>

<p><a href="jstl03.jsp">[이전]</a><a href="jstl05.jsp">[다음]</a></p>
</body>
</html>