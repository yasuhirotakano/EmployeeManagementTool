<%-- 検索ページ --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>社員データベース検索ページ</title>
	</head>
	<body>
		<form action="/EmployeeManagementTool/SearchServlet" method="POST">
			<h1>条件を指定して社員情報を検索します。</h1>
			
			<%--
				部署一覧プルダウンメニュー
				deparList ArrayList型 部署一覧の情報が入ってる
			--%>
			
			<p>
				<select name="departmentId">
					<option value="0" Selected>未指定</option>
					<c:forEach var="department" items="${deparList}">
						<option value="${department.departmentId}">${department.departmentName}</option>
					</c:forEach>
				</select>
			</p>
			
			<%-- 社員ID検索フォーム --%>
			
			<p>社員ID:<input type="text" name="id"></p>
			
			<%-- 名前検索フォーム --%>
			
			<p>名前に含む文字:<input type="text" name="name"></p>
			
			<%-- 検索ボタン --%>
			
			<p><input type="submit" value="検索"></p>
			
		</form>
		
		<%-- トップへボタン --%>
		
		<form action="index.jsp">
			<input type="submit" value="トップヘ">
		</form>
		
	</body>
</html>