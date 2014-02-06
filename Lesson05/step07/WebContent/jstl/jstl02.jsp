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
<p><a href="jstl01.jsp">[이전]</a><a href="jstl03.jsp">[다음]</a></p>

<h2>c:set 태그</h2>
<h3>값 설정 방식</h3>
<c:set var="username1" value="홍길동"/>
<c:set var="username2">임꺽정</c:set>
1) ${username1}<br>
2) ${username2}<br>

<h3>기본 보관소 - page</h3>
3) ${pageScope.username1}<br>
4) ${requestScope.username1}<br>

<h3>보관소 지정 - scope 속성</h3>
<c:set var="username3" scope="request">일지매</c:set>
5) ${pageScope.username3}<br>
6) ${requestScope.username3}<br>

<h3>기존의 값 덮어씀</h3>
<% pageContext.setAttribute("username4", "똘이장군"); %>
7) 기존 값=${username4}<br>
<c:set var="username4" value="주먹대장"/>
8) 덮어쓴 값=${username4}<br>

<h3>객체의 프로퍼티 값 변경</h3>
<%!
public static class MyMember {
	int no;
	String name;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
%>
<%
MyMember member = new MyMember();
member.setNo(100);
member.setName("홍길동");
pageContext.setAttribute("member", member); 
%>
9) ${member.name}<br>
<c:set target="${member}" property="name" value="임꺽정"/>
10) ${member.name}<br>

<p><a href="jstl01.jsp">[이전]</a><a href="jstl03.jsp">[다음]</a></p>
</body>
</html>