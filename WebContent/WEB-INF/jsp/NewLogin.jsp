<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新規ユーザー作成</title>
		<script>
			function errorcheck(){
				if (form.pass1.value != form.pass2.value) {
					form.password.setCustomValidity("パスワードと確認用パスワードが一致しません");
					return false;
				}
				return true;
			};
		</script>
	</head>
	<body>
		<c:if test="${check == false}">
			<p>社員IDが間違っています</p>
		</c:if>
		<form id="form" action="/EmployeeManagementTool/NewLoginServlet" method="POST">
		  <label for="id">社員ID:</label>
		  <input type="number"name="id" maxlength="7" required><br>
		  <label for="password">パスワード:</label>
		  <input type="password" name="password" id="pass1" maxlength="12" required><br>
		  <label for="passwordConfirm">パスワード（確認）:</label>
		  <input type="password" name="passwordConfirm" id="pass2" maxlength="12" required><br>
		  <input type="submit" value="送信" onclick="errorcheck()">
		</form>
		<form action="/EmployeeManagementTool/LoginServlet">
			<input type="submit" value="キャンセル">
		</form>
	</body>
</html>