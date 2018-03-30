<%@page import="com.newlecture.jspprj.entity.Answeris"%>
<%@page import="com.newlecture.jspprj.entity.AnswerisView"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.jspprj.dao.jdbc.JdbcAnswerisDao"%>
<%@page import="com.newlecture.jspprj.dao.AnswerisDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/* AnswerisDao answerisDao = new JdbcAnswerisDao();
 	List<AnswerisView> list = answerisDao.getList(); */
%>

<%@ taglib prefix="my" uri="http://www.newlecture.com/jsp/tags/control" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="ctx" value="${pageContext.request.servletContext.contextPath}"></c:set>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta name="viewport" content="width=device-width,initial-scale=1"> -->
<title></title>

<link href="${ctx}/student/css/layout.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- header 부분 -->
	
	<tiles:insertAttribute name="header"></tiles:insertAttribute>

	<!-- --------------------------- <visual> --------------------------------------- -->
	<!-- visual 부분 -->
	<tiles:insertAttribute name="visual"></tiles:insertAttribute>
	<!-- --------------------------- <body> --------------------------------------- -->
	<div id="body">
		<div class="content-container clearfix">

			<!-- --------------------------- aside --------------------------------------- -->
			<!-- aside 부분 -->
			<tiles:insertAttribute name="aside"></tiles:insertAttribute>
			<!-- --------------------------- main --------------------------------------- -->
			
			<!-- content 부분 -->
			<tiles:insertAttribute name="main"></tiles:insertAttribute>
		
		</div>
	</div>
	<!-- ------------------- <footer> --------------------------------------- -->
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</body>
</html>