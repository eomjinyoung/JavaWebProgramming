<%@page import="java.util.ListResourceBundle"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="spms.vo.Member"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL(Expression Language)</title>
<style type="text/css">
body {
  font-size: small;
}
table {
  border: 			thin solid gray;
  border-collapse: 	collapse;
}

td, th {
  border:           thin dotted gray;
  padding:          2px;
}

th {
  background-color: lightgray;
}

pre {
  font-size: 90%;
}
</style>
</head>
<body>
<p><a href="el02.jsp">[이전]</a><a href="el04.jsp">[다음]</a></p>
<h2>연산자</h2>
<%
// 데이터 준비
pageContext.setAttribute("title", "EL 연산자!");
%>
<%-- '${' 앞에 '\'가 붙으면 '${'은 EL 문법이 아닌 일반 텍스트로 취급함.  --%>
<table>
<tr><th>분류</th><th>연산자</th><th>EL 코드 = 실행 결과</th></tr>
<tr><td>산술</td><td>+, -, *, /(div), %(mod)</td>
<td><pre>
\${10 + 20} = ${10 + 20}
\${10 - 20} = ${10 - 20}
\${10 * 20} = ${10 * 20}
\${10 / 20} = ${10 / 20}
\${10 div 20} = ${10 div 20}
\${10 % 20} = ${10 % 20}
\${10 mod 20} = ${10 mod 20}
</pre></td>
</tr>

<tr><td>논리</td><td>and(&&), or(||), not(!)</td>
<td><pre>
\${true && false} = ${true && false}
\${true and false} = ${true and false}
\${false || true} = ${false || true}
\${false or true} = ${false or true}
\${not true} = ${not true}
\${!true} = ${!true}
</pre></td>
</tr>

<tr><td>관계</td><td>==(eq), !=(ne), &lt;(lt), &gt;(gt),<br>
&lt;=(le), &gt;=(ge)</td>
<td><pre>
\${10 == 11} = ${10 == 11}
\${10 eq 11} = ${10 eq 11}
\${10 != 11} = ${10 != 11}
\${10 ne 11} = ${10 ne 11}
\${10 < 11} = ${10 < 11}
\${10 lt 11} = ${10 lt 11}
\${10 > 11} = ${10 > 11}
\${10 gt 11} = ${10 gt 11}
\${10 <= 11} = ${10 <= 11}
\${10 le 11} = ${10 le 11}
\${10 >= 11} = ${10 >= 11}
\${10 ge 11} = ${10 ge 11}
</pre></td>
</tr>

<tr><td>Empty 검사</td><td>empty</td>
<td><pre>
\${empty title} = ${empty title}
\${empty title2} = ${empty title2}
</pre></td>
</tr>

<tr><td>조건</td><td>조건 ? A : B</td>
<td><pre>
\${10 > 20 ? "크다" : "작다"} = ${10 > 20 ? "크다" : "작다"}
</pre></td>
</tr>
</table>
<p><a href="el02.jsp">[이전]</a><a href="el04.jsp">[다음]</a></p>
</body>
</html>