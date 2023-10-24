<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>會員相簿管理系統</title>
</head>
<body>
    <h1>會員相簿管理系統</h1>
    <form action="${pageContext.request.contextPath}/phaServlet" method="post" enctype="multipart/form-data">
        <label for="albNo">相簿編號：</label>
        <input type="text" id="albNo" name="albNo" required><br><br>

        <label for="memNo">會員編號：</label>
        <input type text" id="memNo" name="memNo" required><br><br>

        <label for="albName">相簿名稱：</label>
        <input type="text" id="albName" name="albName" required><br><br>

        <label for="albPhoto">相簿封面：</label>
        <input type="file" id="albPhoto" name="albPhoto" accept="image/*" required><br><br>
		<input type="hidden" name="base64Image" value="${base64Image}">
        <div>
            <label>相簿建立時間：</label>
            <input type="date" name="albDate" required>
        </div><br>

        <div>
            <label>相簿封面預覽：</label>
            <img id="preview" style="max-width: 300px; max-height: 300px;"><br>
        </div><br>

        <input type="submit" value="建立相簿">
        
    </form>

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