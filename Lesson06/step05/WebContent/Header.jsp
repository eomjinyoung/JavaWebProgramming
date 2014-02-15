<%--  프런트 컨트롤러 적용 - 링크에 .do 붙임 
- 기존의 jsp 태그들을 EL 태그로 교체
--%>
<%@page import="spms.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<div style="background-color:#00008b;color:#ffffff;height:20px;padding: 5px;">
SPMS(Simple Project Management System)
<c:if test="${!empty sessionScope.member and 
              !empty sessionScope.member.email}">
<span style="float:right;">
${sessionScope.member.name}
<a style="color:white;" 
  href="<%=request.getContextPath()%>/auth/logout.do">로그아웃</a>
</span>
</c:if>
</div>