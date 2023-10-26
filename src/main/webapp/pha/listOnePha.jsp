<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cha103g2.photoAlbum.entity.*"%>
<!DOCTYPE html>
<%
  PhotoAlbumVO phaVO = (PhotoAlbumVO) request.getAttribute("PhotoAlbumVO"); 
%>

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
    <h1>會員相簿</h1>

    <!-- 相簿列表 -->
    <div class="album">
        <div class="album-cover">
            <!-- 预览图将显示在这里 -->
        </div>
        <div class="album-details">
        	<table>
        		<tr>
        			<th>相簿名稱</th>
	        		<th>相簿編號</th>
	        		<th>會員編號</th>
	        		<th>相簿建立時間</th>
	        		
	        		<td><%=phaVO.getAlbName() %></td>
	        		<td><%=phaVO.getAlbNo() %></td>
	        		<td><%=phaVO.getMemNo() %></td>
	        		<td><%=phaVO.getAlbDate() %></td>
	        		<td></td>
        		<tr>
        	</table>

        </div>
    </div>
    <table>
    	<tr>
    		<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/pha.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="empno"  value="${phaVO.phaNo}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/pha.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="phaNo"  value="${phaVO.phaNo}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
    	</tr>
    </table>


    <button>回首頁</button>

</body>
</html>
