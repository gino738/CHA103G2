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
				<label for="albNo">相簿編號：${phaVO.albNo}</label><input type="hidden" name="albNo" value="${phaVO.albNo}"><br>
				<label for="memNo" >會員編號：${phaVO.memNo}</label><input type="hidden" name="memNo" value="${phaVO.memNo}"><br>
				<br> <label for="photoDate">相片日期：</label> <input type="date" name="photoDate" ><br>
				<br> <label for="photoName">相片1名稱：</label> <input type="hidden"  name="photoName1"><br>
				<br> <label for="photo">相片1：</label> <input type="file" name="photo1" accept="image/*" onchange="showPreview"><br>
				<br> <label for="photoName">相片2名稱：</label> <input type="text"  name="photoName2"><br>
				<br> <label for="photo">相片2：</label> <input type="file"  name="photo2" accept="image/*" onchange="showPreview"><br>
				<br> <label for="photoName">相片3名稱：</label> <input type="text"  name="photoName3"><br>
				<br> <label for="photo">相片3：</label> <input type="file"  name="photo3" accept="image/*" onchange="showPreview"><br>
				<br>
				<div>
					<label>相片預覽：</label> <img id="preview" style="max-width: 300px; max-height: 300px;" ><br>	
				</div>
				<input type="hidden" name="action" value="insert">
				<br> <input type="submit" value="送出">

		</form>
		
		<script>
		// 取得"相片1"的輸入元素
		function fileName(inputName, fileInput) {
	        var nameInput = document.querySelector('input[name="' + inputName + '"]');      
	        if (fileInput.files.length > 0) {
	            nameInput.value = fileInput.files[0].name;
	        } else {
	            nameInput.value = "";
	        }
    	}
		
		var photo1 = document.querySelector('input[name="photo1"]');//檔案名稱
		// 當選擇檔案時觸發事件
		photo1.addEventListener('change', function() {
		    // 在此處執行你想要的邏輯，例如將檔案名稱設定給相關的隱藏欄位
		    fileName('photoName1', photo1);
		});




		</script>

</body>
</html>