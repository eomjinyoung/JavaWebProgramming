<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키사용-03</title>
</head>
<body>
<h1>웹 브라우저로부터 받은 쿠키 정보</h1>
email1(기본) =  "${cookie.email1.value}"<br>
email2(20초만 유지) =  "${cookie.email2.value}"<br>
email3(30초만 유지) =  "${cookie.email3.value}"<br>
email4(쿠키 없음) =  "${cookie.email4.value}"<br>
email5(5분만 유지) =  "${cookie.email5.value}" 
  <a href="delete03.jsp" target="_blank">쿠키 삭제</a><br>
<p>경과 시간: <span id="sec"><%=request.getParameter("count")%></span></p>

<%
int count = Integer.parseInt(request.getParameter("count"));
if (count < 60) {
%>
<script>
setTimeout(function() {
  location.href = "consume03.jsp?count=<%=count + 5%>";
}, 5000);
</script>
<%}%>

</body>
</html>