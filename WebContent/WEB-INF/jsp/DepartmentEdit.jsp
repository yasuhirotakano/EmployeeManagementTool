<%--
部署情報編集、新規追加ページ
check String型 "編集"or"新規追加"
department Department型 社員情報１件の情報が入ってる
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>部署データの${check}</title>
	</head>
	<body>
		<h1>部署データを${check}します</h1>
		<form action="/EmployeeManagementTool/DEditServlet" method="POST">
		
			<%-- 部署名入力フォーム --%>
			
			<p>部署名:<input type="text" name="departmentName" value="${department.departmentName}"></p>
			
			<%--設定ボタン --%>
			
			<input type="hidden" name="departmentId" value="${department.departmentId}">
			<input type="hidden" name="check" value="${check}">
			<input type="submit" value="設定">
			
		</form>
		
		<%-- キャンセルボタン --%>
		
		<form action="/EmployeeManagementTool/DListServlet" method="GET">
			<input type="submit" value="キャンセル">
		</form>
		
	</body>
</html>