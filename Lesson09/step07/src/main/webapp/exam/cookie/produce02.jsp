<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String email = request.getParameter("email");
Cookie cookie = new Cookie("email1", email);
response.addCookie(cookie);

Cookie cookie2 = new Cookie("email2", email);
cookie2.setPath("/");
response.addCookie(cookie2);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키생성-02</title>
</head>
<body>
<h1>웹 브라우저로 보낸 쿠키 정보</h1>
email1(path=기본) = "${param.email}"<br>
email2(path=/) = "${param.email}"<br>
<hr>
<a href="http://www.foo.com:9999/web09/exam/cookie/consume02.jsp" target="_blank">같은 경로 확인</a><br>
<a href="http://www.foo.com:9999/web09/exam/cookie/sub/consume02.jsp" target="_blank">하위 경로 확인</a><br>
<a href="http://www.foo.com:9999/web09/exam/cookie2/consume02.jsp" target="_blank">다른 경로 확인</a><br>

</body>
</html>
