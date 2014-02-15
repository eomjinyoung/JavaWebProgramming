<%@page import="java.util.ArrayList"%>
<%@page import="spms.vo.Member"%>
<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL</title>
</head>
<body>
<p><a href="jstl10.jsp">[이전]</a></p>

<h2>날짜 다루기</h2>
<h3>fmt:parseDate 태그</h3>
<code>
&lt;fmt:parseDate var="date1" value="2013-11-16" pattern="yyyy-MM-dd"/>
</code>
<fmt:parseDate var="date1" value="2013-11-16" pattern="yyyy-MM-dd"/>

<h3>fmt:formatDate 태그</h3>
<fmt:formatDate value="${date1}" pattern="MM/dd/yy"/> 

<p><a href="jstl10.jsp">[이전]</a></p>
</body>
</html>