<%--
データベース登録の結果ページ
result String型 "成功"or"失敗"
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${result}</title>
	</head>
	<body>
		<p>データベースへの登録に${result}しました</p>
		<c:choose>
			
			<%--
			社員管理ページボタン
			choice boolean型 true=社員情報の登録から　false=部署情報の登録から
			--%>
			
			<c:when test="${choice}">
				<form action="/EmployeeManagementTool/EListServlet" method="GET">
					<input type="submit" value="社員情報一覧ページ">
				</form>
			</c:when>
			
			<%-- 部署管理ページボタン --%>
			
			<c:otherwise>
				<form action="/EmployeeManagementTool/DListServlet" method="GET">
					<input type="submit" value="部署情報一覧ページ">
				</form>
			</c:otherwise>
			
		</c:choose>
	</body>
</html>