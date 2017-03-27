<%-- トップページ --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>社員情報管理ツール</title>
	</head>
	<body>
		<c:if test="${user==null}">
			<jsp:forward page="WEB-INF/jsp/Login.jsp" />
		</c:if>
		<h1>社員情報管理ツール</h1>
		<p><a href="/EmployeeManagementTool/EListServlet">社員一覧</a></p>
		<p><a href="/EmployeeManagementTool/DListServlet">部署一覧</a></p>
		<form action="/EmployeeManagementTool/LDeleteServlet" method="GET">
			<input type="submit" value="ログアウト">
		</form>
	</body>
</html>