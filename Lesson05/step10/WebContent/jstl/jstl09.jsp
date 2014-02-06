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
<p><a href="jstl08.jsp">[이전]</a><a href="jstl10.jsp">[다음]</a></p>

<h2>c:import 태그</h2>

<h3>RSS 피드 가져오기</h3>
<textarea rows="10" cols="80">
<c:import url="http://www.zdnet.co.kr/Include2/ZDNetKorea_News.xml"/>
</textarea>

<h3>RSS 피드 가져오기 - 보관소에 저장</h3>
<c:import var="zdnetRSS" 
	url="http://www.zdnet.co.kr/Include2/ZDNetKorea_News.xml"/>
<textarea rows="10" cols="80">${zdnetRSS}</textarea>

<p><a href="jstl08.jsp">[이전]</a><a href="jstl10.jsp">[다음]</a></p>
</body>
</html>