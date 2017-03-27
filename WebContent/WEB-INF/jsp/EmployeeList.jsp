<%-- 社員管理ページ --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>社員データベース管理ページ</title>
		<script type="text/javascript">
			function disp(){
				if(window.confirm('本当に削除しますか？')){
					return true;
				}else{
					window.alert('キャンセルされました');
					return false;
				}
			}
		</script>
	</head>
	<body>
		<c:choose>
		
			<%--
			削除できなかったときの表示
			error boolean型
			--%>
			
			<c:when test="${error == false}">
				<p>削除することができませんでした。</p>
				<form action="/EmployeeManagementTool/EListServlet" method="GET">
					<input type="submit" value="社員一覧へ">
				</form>
			</c:when>
			
			<%-- 削除できたときの表示 --%>
			
			<c:otherwise>
				<h1>社員一覧:</h1>
				<c:choose>
				
					<%--
					検索で該当するリストがないときの表示
					lCheck　boolean型
					--%>
					
					<c:when test="${lCheck}">
						<p>登録されている社員がいません</p>
					</c:when>
					
					<%-- 検索で該当するリストがあるときの表示 --%>
					
					<c:otherwise>
						<table style="border: solid 1px #000000; border-collapse: separate">
							<tr  style="background-color: #cccccc">
								<th>名前</th>
							</tr>
							
							<%--
							社員IDと名前を全部表示
							empList ArrayList型 社員一覧の情報が入ってる
							--%>
							
							<c:forEach var="employee" items="${empList}">
								<tr>
								
									<%-- 名前の表示 --%>	
									
									<td><c:out value="${employee.name}" /></td>
									
									<%-- 編集ボタン --%>
									<c:if test="${user.postId != 5}">
										<td>
											<form action="/EmployeeManagementTool/EDisplayServlet" method="GET">
												<input type="hidden" name="empId" value="${employee.id}">
												<input type="submit" value="詳細">
											</form>
										</td>
									</c:if>
									
									<%-- 削除ボタン --%>
									
									<c:if test="${user.postId == 4}">
										<td>
											<form action="/EmployeeManagementTool/EDeleteServlet" method="GET">
												<input type="hidden" name="empId" value="${employee.id}">
												<input type="submit" value="削除" onClick="return disp();">
											</form>
										</td>
									</c:if>
									
								</tr>
							</c:forEach>
							
						</table>
					</c:otherwise>
				</c:choose>
				
				<%-- 新規追加ボタン --%>
				
				<c:if test="${user.postId == 4 || user.postId == 1}">
					<form action="/EmployeeManagementTool/EEditServlet" method="GET">
						<input type="hidden" name="check" value="新規追加">
						<input type="submit" value="新規追加">
					</form>
				</c:if>
				
				<%-- 検索ボタン --%>
				
				<form action="/EmployeeManagementTool/SearchServlet" method="GET">
					<input type="submit" value="検索...">
				</form>
				
				<%-- ファイル出力ボタン --%>
				
				<c:if test="${user.postId == 4}">
					<form action="/EmployeeManagementTool/ExportFileServlet" method="GET">
						<input type="submit" value="CSVファイルに出力">
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