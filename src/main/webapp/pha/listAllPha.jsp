<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cha103g2.photoAlbum.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<html>
<head>
    <meta charset="UTF-8">
    <title>會員相簿</title>


    <style>
        .album {
            border: 1px solid #ccc;
            padding: 10px;
            margin: 10px;
            display: inline-block;
        }
        .album-cover {
            width: 200px;
            height: 200px;
            background-color: #eee;
            border: 1px solid #ccc;
            text-align: center;
            line-height: 200px;
        }
        .album-details {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h1>顯示所有相簿</h1>

    <!-- 相簿列表 -->
    <c:forEach var="pha" items="${phaList}">	
    <div class="album">
        <div class="album-cover">
        	 <%--${pha.albPhoto}--%>
        	<img src="<%=request.getContextPath()%>/dbg.do?id=${pha.albNo}" alt="相簿封面">
            <!-- 预览图将显示在这里 -->
        </div>
        <div class="album-details">
        	<table>
        		<tr>
        			<th>相簿名稱</th>
	        		<th>相簿編號</th>
	        		<th>會員編號</th>
	        		<th>相簿建立時間</th>
	        		
	        		<td>${pha.albName}</td>
	        		<td>${pha.albNo}</td>
	        		<td>${pha.memNo}</td>
	        		<td>${pha.albDate}</td>
	        		<td></td>
	        	
        		<tr>
        	</table>

        </div>
    </div>
    </c:forEach>
    <table>
    	<tr>
    		<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/photoAlbum" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="empno"  value="${phaVO.phaNo}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/photoAlbum" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="phaNo"  value="${phaVO.phaNo}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
    	</tr>
    </table>


    <button>回首頁</button>

</body>
</html>
