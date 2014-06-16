<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String email = request.getParameter("email");
Cookie cookie = new Cookie("email5", "xxxx"); 
cookie.setMaxAge(0);
response.addCookie(cookie);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키생성-03</title>
</head>
<body>
<p>email5 쿠키 삭제 완료!</p>
</body>
</html>
