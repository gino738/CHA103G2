<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>新增相片</h1>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
	<ul>
		<li><a href='${pageContext.request.contextPath}/pha.do?action=getAll'>查詢</a>所有相簿. <br>
		<br>

	</ul>
			<form action="${pageContext.request.contextPath}/pho.do" method="post" enctype="multipart/form-data">
				<label for="albNo">相簿編號：${phaVO.albNo}</label><input type=hidden name="albNo" value="${phaVO.albNo}"><br>
				<label for="memNo" >會員編號：${phaVO.memNo}</label><input type=hidden name="memNo" value="${phaVO.memNo}"><br>
				<br> <label for="photoDate">相片日期：</label> <input type="date" name="photoDate" required><br>
				<br> <label for="photoName">相片1名稱：</label> <input type="text"  name="photoName1"><br>
				<br> <label for="photo">相片1：</label> <input type="file" name="photo1" accept="image/*" required onchange="showPreview"><br>
				<br> <label for="photoName">相片2名稱：</label> <input type="text"  name="photoName2"><br>
				<br> <label for="photo">相片2：</label> <input type="file"  name="photo2" accept="image/*" required onchange="showPreview"><br>
				<br>
				<div>
					<label>相片預覽：</label> <img id="preview" style="max-width: 300px; max-height: 300px;" ><br>	
				</div>
				<input type="hidden" name="action" value="insert">
				<br> <input type="submit" value="送出">

		</form>

</body>
</html>