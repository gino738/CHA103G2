<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/main/main.css">
<title>Hibernate Demo</title>
</head>
<body>
	<h1>這是一位後端人員作的網頁 QQ</h1>
	<h2>CheckIn系統</h2>
	<a href="${pageContext.request.contextPath}/roomnum/roomnum.do?action=getAll">查詢房間資料</a>
	<br><br>
	<h3><b>複合查詢 (使用 Criteria Query)：</b></h3>
	<form action="${pageContext.request.contextPath}/roomnum/roomnum.do" method="post">
		<p><label>訂單編號</label></p>
		<input type="text" name="roomorderno"><br>
		<p><label>姓名</label></p>
		<input type="text" name="memname">
		<p><label>電話</label></p>
		<input type="text" name="memphone"><br>		
		<p><label>入住日期</label></p>
		<input type="date" name="checkin">
		<p><label>退房日期</label></p>
		<input type="date" name="checkout"><br>		
		<p><input type="submit" value="送出"></p>
		<input type="hidden" name="action" value="compositeQuery">
	</form>
</body>
</html>