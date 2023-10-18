<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/main/main.css">
<title>List RoomNums</title>
</head>
<body>
	<h1>住房管理系統</h1>
	<c:if test="${roomnumPageQty > 0}">
  		<b><font color=red>第${currentPage}/${roomnumPageQty}頁</font></b>
	</c:if>
	<br>
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/cat.png">
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/cat.png">
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/cat.png">
	<table style="width:50%; text-align:center;">
		<tr>
			<th>房間號碼</th>
			<th>房型</th>
			<th>訂單編號</th>
			<th>住房姓名</th>
			<th>房間狀態</th>
			
		</tr>
		<c:forEach var="roomnum" items="${roomnumList}">
			<tr>
				<td>${roomnum.rNum}</td>
				<td>${roomnum.roomTypeNo}</td>
				<td>${roomnum.roomOrderNo}</td>
				<td>${roomnum.checkInName}</td>
				<td>${roomnum.roomStatus}</td>
				
			</tr>
		</c:forEach>
	</table>
	<c:if test="${currentPage > 1}">
		<a href="${pageContext.request.contextPath}/roomnum/roomnum.do?action=getAll&page=1">至第一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage - 1 != 0}">
		<a href="${pageContext.request.contextPath}/roomnum/roomnum.do?action=getAll&page=${currentPage - 1}">上一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage + 1 <= roomnumPageQty}">
		<a href="${pageContext.request.contextPath}/roomnum/roomnum.do?action=getAll&page=${currentPage + 1}">下一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage != roomnumPageQty}">
		<a href="${pageContext.request.contextPath}/roomnum/roomnum.do?action=getAll&page=${roomnumPageQty}">至最後一頁</a>&nbsp;
	</c:if>
	<br>
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/inversecat.png">
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/inversecat.png">
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/inversecat.png">
	<br><br>
	
	<a href="${pageContext.request.contextPath}/index.jsp">回首頁</a>	
</body>
</html>