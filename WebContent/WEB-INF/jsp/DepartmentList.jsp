<%-- 部署管理ページ --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>部署データベース管理ページ</title>
	</head>
	<body>
		<c:choose>
			
			<%--
			削除できなかったときの表示
			error boolean型
			--%>
			
			<c:when test="${error == false}">
				<p>削除することができませんでした。</p>
				<form action="/EmployeeManagementTool/DListServlet" method="GET">
					<input type="submit" value="部署一覧へ">
				</form>
			</c:when>
			
			<%-- 削除できたときの表示 --%>
			
			<c:otherwise>
				<h1>部署一覧:</h1>
				<table style="border: solid 1px #000000; border-collapse: separate">
					<tr  style="background-color: #cccccc">
						<th>ID</th>
						<th>部署名</th>
					</tr>
					
					<%--
					部署IDと部署名を全部表示
					deparList ArrayList型 部署一覧の情報が入ってる
					--%>
					
					<c:forEach var="department" items="${deparList}">
						<tr>
						
							<%-- 部署IDの表示 --%>
							
							<td><c:out value="${department.departmentId}" /></td>
							
							<%-- 部署名の表示 --%>
							
							<td><c:out value="${department.departmentName}" /></td>
							
							<%-- 編集ボタン --%>
							
							<c:if test="${user.postId == 4}">
								<td>
									<form action="/EmployeeManagementTool/DEditServlet" method="GET">
										<input type="hidden" name="deparId" value="${department.departmentId}">
										<input type="hidden" name="check" value="編集">
										<input type="submit" value="編集">
									</form>
								</td>
								
								<%-- 削除ボタン --%>
								
								<td>
									<form action="/EmployeeManagementTool/DDeleteServlet" method="GET">
										<input type="hidden" name="deparId" value="${department.departmentId}">
										<input type="submit" value="削除">
									</form>
								</td>
							</c:if>
							
						</tr>
					</c:forEach>
					
				</table>
				
				<%-- 新規追加ボタン --%>
				
				<c:if test="${user.postId == 4}">
					<form action="/EmployeeManagementTool/DEditServlet" method="GET">
						<input type="hidden" name="check" value="新規追加">
						<input type="submit" value="新規追加">
					</form>
				</c:if>
				
				<%-- トップページへボタン --%>
				
				<form action="index.jsp">
					<input type="submit" value="トップヘ">
				</form>
				
			</c:otherwise>
		</c:choose>
	</body>
</html>