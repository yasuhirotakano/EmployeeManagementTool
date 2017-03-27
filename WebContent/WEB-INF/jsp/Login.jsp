<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ログイン</title>
	</head>
	<body>
		<h1>ログイン</h1>
		<c:if test="${check == false}">
			<p>社員IDまたはパスワードが違います</p>
		</c:if>
		<form action="/EmployeeManagementTool/LoginServlet" method="POST">
			<p>社員ID:<input type="number" name="id" maxlength="7" required></p>
			<p>パスワード<input type="password" name="pass" maxlength="12" required></p>
			<input type="submit" value="ログイン">
		</form>
		<form action="/EmployeeManagementTool/NewLoginServlet">
			<input type="submit" value="新規ユーザー作成">
		</form>
	</body>
</html>