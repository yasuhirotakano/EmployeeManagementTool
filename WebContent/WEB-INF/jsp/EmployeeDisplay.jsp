<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>社員情報の詳細</title>
	</head>
	<body>
		<p>社員ID: ${employee.id}</p>
		<p>名前: ${employee.name}</p>
		<p>年齢: ${employee.age}</p>
		<p>生年月日: ${employee.birthDay}</p>
		<p>性別: ${employee.gender}</p>
		<p>電話番号: ${employee.phoneNumber}</p>
		<p>写真</p>
		<img style="width: 100px; height: 100px" src="/EmployeeManagementTool/GetImage?id=${employee.id}"><br/>
		<p>郵便番号: ${employee.郵便番号}</p>
		<p>都道府県: ${employee.prefectures}</p>
		<p>住所: ${employee.address}</p>
		<p>所属部署: ${department.departmentName}</p>
		<p>役職: ${post.postName}</p>
		<p>最寄駅: ${employee.nearestStation}</p>
		<p>入社日: ${employee.enteringDay}</p>
		<p>退社日: ${employee.leavingDay}</p>
		<form action="/EmployeeManagementTool/EEditServlet" method="GET">
			<input type="hidden" name="empId" value="${employee.id}">
			<input type="hidden" name="check" value="編集">
			<input type="submit" value="編集">
		</form>
		<form action="/EmployeeManagementTool/EEditServlet" method="GET">
			<input type="hidden" name="check" value="新規追加">
			<input type="submit" value="新規追加">
		</form>
		<form action="/EmployeeManagementTool/EListServlet" method="GET">
			<input type="submit" value="社員情報一覧ページ">
		</form>
	</body>
</html>