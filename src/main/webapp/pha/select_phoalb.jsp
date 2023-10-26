<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>會員相簿管理系統</title>
    <style type="text/css">
	    li {
	    list-style: none; 
	    margin: 0; 
	    padding: 0; 
		}
    
    </style>
</head>
<body>
	<h1>會員相簿管理系統</h1>

	<%-- 錯誤表列 --%>
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
		<br></li>
		<h2>相簿查詢</h2>
		<li>
			<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/pha.do">
				<b>輸入相簿編號</b> <input type="text" name="phaNo">
				<!-- 所有請求名稱用hidden送出 -->
				<input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
			<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/pha.do">
				<b>輸入建立日期</b> <input type="date" name="albDate"> <input
					type="hidden" name="action" value="getOne_For_Display"> <input
					type="submit" value="送出">
			</FORM>
		</li>
	</ul>

	<h2>相簿新增</h2>
	<ul>
		<li>
			<form action="${pageContext.request.contextPath}/phaServlet"
				method="post" enctype="multipart/form-data">
				<label for="albNo">相簿編號：</label> <input type="text" id="albNo"
					name="albNo" required><br>
				<br> <label for="memNo">會員編號：</label> <input type
					text" id="memNo" name="memNo" required><br>
				<br> <label for="albName">相簿名稱：</label> <input type="text"
					id="albName" name="albName" required><br>
				<br> <label for="albPhoto">相簿封面：</label> <input type="file"
					id="albPhoto" name="albPhoto" accept="image/*" required><br>
				<br> <input type="hidden" name="base64Image"
					value="${base64Image}">
				<div>
					<label>相簿建立時間：</label> <input type="date" name="albDate" required>
				</div>
				<br>

				<div>
					<label>相簿封面預覽：</label> <img id="preview"
						style="max-width: 300px; max-height: 300px;"><br>
				</div>
				<br> <input type="submit" value="建立相簿">

			</form>
		</li>
	</ul>
	<script>
        document.getElementById('albPhoto').addEventListener('change', function(e) {
            var preview = document.getElementById('preview');
            if (e.target.files.length > 0) {
                var file = e.target files[0];
                var url = URL.createObjectURL(file);
                preview.src = url;
            } else {
                preview.src = '';
            }
        });
    </script>
</body>
</html>