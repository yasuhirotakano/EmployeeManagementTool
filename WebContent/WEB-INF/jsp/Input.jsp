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
		<p>ファイルのインポートに${result}しました</p>
		<c:choose>
		
			<c:when test="${error}">
				<form action="index.jsp">
					<input type="submit" value="トップヘ">
				</form>
			</c:when>
			
			<c:otherwise>
				<p>データベースが更新されました、ユーザーアカウントを再設定する必要があります</p>
				<form action="/EmployeeManagementTool/NewLoginServlet">
					<input type="submit" value="新規ユーザー作成">
				</form>
			</c:otherwise>
			
		</c:choose>
	</body>
</html>