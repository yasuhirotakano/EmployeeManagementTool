<%--
社員情報編集、新規追加ページ
check String型 "編集"or"新規追加"
employee Employee型 社員情報１件の情報が入ってる
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>社員データの${check}</title>
	</head>
	<body>
		<h1>社員データを${check}します</h1>
		<form action="/EmployeeManagementTool/EEditServlet" method="POST" enctype="multipart/form-data">
			
			<%-- 名前入力フォーム --%>
			
			<p>名前:<input type="text" name="name" value="${employee.name}" maxlength="20" required></p>
			
			<%-- 年齢入力フォーム --%>
			
			<p>年齢:<input type="number" name="age" value="${employee.age}" min="0" max="120" required></p>
			
			<%-- 生年月日 --%>
			
			<p>生年月日:<input type="text" name="birthDay" value="${employee.birthDay}" maxlength="15" required></p>
			
			<%--
			性別チェックbox
			judge boolean型 true=男性 false=女性
			--%>
			
			<p>
				性別:			
				<c:choose>
					<c:when test="${judge == true}">
						<input type="radio" name="gender" value="男" checked="checked">男性
						<input type="radio" name="gender" value="女">女性
					</c:when>
					<c:when test="${judge == false}">
						<input type="radio" name="gender" value="男">男性
						<input type="radio" name="gender" value="女" checked="checked">女性
					</c:when>
					<c:otherwise>
						<input type="radio" name="gender" value="男" required>男性
						<input type="radio" name="gender" value="女" required>女性
					</c:otherwise>
				</c:choose>
			</p>
			
			<%-- 電話番号入力フォーム --%>
			
			<p>電話番号:<input type="text" name="phoneNumber" value="${employee.phoneNumber}" maxlength="15"required></p>
			
			<%-- 写真表示 --%>
			
			<p>写真</p>
			<c:if test="${employee.id != null}">
				<img style="width: 100px; height: 100px" src="/EmployeeManagementTool/GetImage?id=${employee.id}"><br/>
			</c:if>
			
			<%-- 写真登録フォーム --%>
			
			<p>
				<input type="file" name="imageData">
				<input type="hidden" name="imageId" value="${employee.id}">
			</p>
			
			<%-- 郵便番号入力フォーム --%>
			
			<p>郵便番号:<input type="text" name="postalCode" value="${employee.postalCode}" maxlength="8" required></p>
			
			<%-- 都道府県プルダウンメニュー --%>
			
			<p>
				都道府県:
				<select name="prefectures">
					<option value="北海道" ${employee.prefectures.equals("北海道") ? "Selected" : ""}>北海道</option>
					<option value="青森県" ${employee.prefectures.equals("青森県") ? "Selected" : ""}>青森県</option>
					<option value="岩手県" ${employee.prefectures.equals("岩手県") ? "Selected" : ""}>岩手県</option>
					<option value="宮城県" ${employee.prefectures.equals("宮城県") ? "Selected" : ""}>宮城県</option>
					<option value="秋田県" ${employee.prefectures.equals("秋田県") ? "Selected" : ""}>秋田県</option>
					<option value="山形県" ${employee.prefectures.equals("山形県") ? "Selected" : ""}>山形県</option>
					<option value="福島県" ${employee.prefectures.equals("福島県") ? "Selected" : ""}>福島県</option>
					<option value="茨城県" ${employee.prefectures.equals("茨城県") ? "Selected" : ""}>茨城県</option>
					<option value="栃木県" ${employee.prefectures.equals("栃木県") ? "Selected" : ""}>栃木県</option>
					<option value="群馬県" ${employee.prefectures.equals("群馬県") ? "Selected" : ""}>群馬県</option>
					<option value="埼玉県" ${employee.prefectures.equals("埼玉県") ? "Selected" : ""}>埼玉県</option>
					<option value="千葉県" ${employee.prefectures.equals("千葉県") ? "Selected" : ""}>千葉県</option>
					<option value="東京都" ${employee.prefectures.equals("東京都") ? "Selected" : ""}>東京都</option>
					<option value="神奈川県" ${employee.prefectures.equals("神奈川県") ? "Selected" : ""}>神奈川県</option>
					<option value="新潟県" ${employee.prefectures.equals("新潟県") ? "Selected" : ""}>新潟県</option>
					<option value="富山県" ${employee.prefectures.equals("富山県") ? "Selected" : ""}>富山県</option>
					<option value="石川県" ${employee.prefectures.equals("石川県") ? "Selected" : ""}>石川県</option>
					<option value="福井県" ${employee.prefectures.equals("福井県") ? "Selected" : ""}>福井県</option>
					<option value="山梨県" ${employee.prefectures.equals("山梨県") ? "Selected" : ""}>山梨県</option>
					<option value="長野県" ${employee.prefectures.equals("長野県") ? "Selected" : ""}>長野県</option>
					<option value="岐阜県" ${employee.prefectures.equals("岐阜県") ? "Selected" : ""}>岐阜県</option>
					<option value="静岡県" ${employee.prefectures.equals("静岡県") ? "Selected" : ""}>静岡県</option>
					<option value="愛知県" ${employee.prefectures.equals("愛知県") ? "Selected" : ""}>愛知県</option>
					<option value="三重県" ${employee.prefectures.equals("三重県") ? "Selected" : ""}>三重県</option>
					<option value="滋賀県" ${employee.prefectures.equals("滋賀県") ? "Selected" : ""}>滋賀県</option>
					<option value="京都府" ${employee.prefectures.equals("京都府") ? "Selected" : ""}>京都府</option>
					<option value="大阪府" ${employee.prefectures.equals("大阪府") ? "Selected" : ""}>大阪府</option>
					<option value="兵庫県" ${employee.prefectures.equals("兵庫県") ? "Selected" : ""}>兵庫県</option>
					<option value="奈良県" ${employee.prefectures.equals("奈良県") ? "Selected" : ""}>奈良県</option>
					<option value="和歌山県" ${employee.prefectures.equals("和歌山県") ? "Selected" : ""}>和歌山県</option>
					<option value="鳥取県" ${employee.prefectures.equals("鳥取県") ? "Selected" : ""}>鳥取県</option>
					<option value="島根県" ${employee.prefectures.equals("島根県") ? "Selected" : ""}>島根県</option>
					<option value="岡山県" ${employee.prefectures.equals("岡山県") ? "Selected" : ""}>岡山県</option>
					<option value="広島県" ${employee.prefectures.equals("広島県") ? "Selected" : ""}>広島県</option>
					<option value="山口県" ${employee.prefectures.equals("山口県") ? "Selected" : ""}>山口県</option>
					<option value="徳島県" ${employee.prefectures.equals("徳島県") ? "Selected" : ""}>徳島県</option>
					<option value="香川県" ${employee.prefectures.equals("香川県") ? "Selected" : ""}>香川県</option>
					<option value="愛媛県" ${employee.prefectures.equals("愛媛県") ? "Selected" : ""}>愛媛県</option>
					<option value="高知県" ${employee.prefectures.equals("高知県") ? "Selected" : ""}>高知県</option>
					<option value="福岡県" ${employee.prefectures.equals("福岡県") ? "Selected" : ""}>福岡県</option>
					<option value="佐賀県" ${employee.prefectures.equals("佐賀県") ? "Selected" : ""}>佐賀県</option>
					<option value="長崎県" ${employee.prefectures.equals("長崎県") ? "Selected" : ""}>長崎県</option>
					<option value="熊本県" ${employee.prefectures.equals("熊本県") ? "Selected" : ""}>熊本県</option>
					<option value="大分県" ${employee.prefectures.equals("大分県") ? "Selected" : ""}>大分県</option>
					<option value="宮崎県" ${employee.prefectures.equals("宮崎県") ? "Selected" : ""}>宮崎県</option>
					<option value="鹿児島県" ${employee.prefectures.equals("鹿児島県") ? "Selected" : ""}>鹿児島県</option>
					<option value="沖縄県" ${employee.prefectures.equals("沖縄県") ? "Selected" : ""}>沖縄県</option>
				</select>
			</p>
			
			<%-- 住所入力フォーム --%>
			
			<p>住所:<input type="text" name="address" value="${employee.address}" maxlength="30" required></p>
			
			<%-- 部署一覧プルダウンメニュー --%>
			
			<p>
				所属:
				<select name="departmentId">
					<c:forEach var="department" items="${deparList}">
						<option value="${department.departmentId}" ${department.departmentId == employee.departmentId ? "Selected" : ""}>${department.departmentName}</option>
					</c:forEach>
				</select>
			</p>
			
			<%-- 役職一覧プルダウンメニュー --%>
			
			<p>
				役職:
				<select name="postId">
					<c:forEach var="post" items="${postList}">
						<option value="${post.id}" ${post.id == employee.postId ? "Selected" : ""}>${post.postName}</option>
					</c:forEach>
				</select>
			</p>
			
			<%-- 最寄駅入力フォーム --%>
			
			<p>最寄駅:<input type="text" name="nearestStation" value="${employee.nearestStation}" maxlength="10" required></p>
			
			<%-- 入社日入力フォーム --%>
			
			<p>入社日:<input type="text" name="enteringDay" value="${employee.enteringDay}" maxlength="15"></p>
			
			<%-- 退社日入力フォーム --%>
			
			<p>退社日:<input type="text" name="leavingDay" value="${employee.leavingDay}" maxlength="15"></p>
			
			<%-- 設定ボタン --%>
			
			<input type="hidden" name="check" value="${check}">
			<input type="hidden" name="id" value="${employee.id}">
			<input type="submit" value="設定">
			
		</form>
		
		<%-- キャンセルボタン --%>
		
		<form action="/EmployeeManagementTool/EListServlet" method="GET">
			<input type="submit" value="キャンセル">
		</form>
		
	</body>
</html>