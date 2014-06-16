<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키사용-02</title>
</head>
<body>
<h1>웹 브라우저로부터 받은 쿠키 정보</h1>
email1(path=기본) =  "${cookie.email1.value}"<br>
email2(path=/) =  "${cookie.email2.value}"<br>
</body>
</html>