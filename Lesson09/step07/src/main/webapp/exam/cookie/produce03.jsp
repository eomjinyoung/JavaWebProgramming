<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String email = request.getParameter("email");
Cookie cookie = new Cookie("email1", email); 
//기본 쿠지 유지 시간: 웹 브라우저가 종료되기 전까지 
response.addCookie(cookie);

Cookie cookie2 = new Cookie("email2", email);
cookie2.setMaxAge(20); // 쿠키 유지 시간: 받은 시간으로부터 20초까지
response.addCookie(cookie2);

Cookie cookie3 = new Cookie("email3", email);
cookie3.setMaxAge(30); // 쿠키 유지 시간: 받은 시간으로부터 30초까지
response.addCookie(cookie3);

Cookie cookie4 = new Cookie("email4", email);
cookie4.setMaxAge(0); // 쿠키 저장 안함
response.addCookie(cookie4);

Cookie cookie5 = new Cookie("email5", email);
cookie5.setMaxAge(300);
response.addCookie(cookie5);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키생성-03</title>
</head>
<body>
<h1>웹 브라우저로 보낸 쿠키 정보</h1>
email1 = "${param.email}"<br>
email2(maxAge=20초) = "${param.email}"<br>
email3(maxAge=30초) = "${param.email}"<br>
email4(쿠키 보내지 않음) = "${param.email}"<br>
email5(maxAge=5분) = "${param.email}"<br>
<hr>
<a href="consume03.jsp?count=0" target="_blank">쿠키 확인</a>
</body>
</html>
