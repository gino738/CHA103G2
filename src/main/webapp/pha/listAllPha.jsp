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
            display: flex; <%--滿版--%>
	        justify-content: space-between;

        }
        .album-details {
            margin-top: 10px;
            display: flex;
            flex-direction: column;
            text-align: center;
            align-items: right;
        }
        
        img {
    	width: 100%;
    	height: auto; /* 不改變比例 */
  		}
  		
  		.header {
            display: flex;
            justify-content: space-between;
            align-items: flex-end;
        }
    </style>
</head>
<body>
	<div>
		<h1>顯示所有相簿</h1>	<a href="${pageContext.request.contextPath}/pha/select_phoalb.jsp">回首頁</a>	
	</div>
    

    <!-- 相簿列表 -->
    <c:if test="${phaPageQty > 0}">
  	<b><font color=red>第${currentPage}/${phaPageQty}頁</font></b>
	</c:if>
	<c:forEach var="pha" items="${phaList}">
		<div class="album">
			<div style="" class="album-cover">
				<img src="<%=request.getContextPath()%>/dbg.do?alb_no=${pha.albNo}"
					alt="相簿封面">
				<!--预览图将显示在这里 -->
			</div>
			<div class="album-details">
				<table>
					<tr>
						<th>相簿名稱</th>
						<td>${pha.albName}</td>
					</tr>
					<tr>
						<th>相簿編號</th>
						<td>${pha.albNo}</td>
					</tr>
					<tr>
						<th>會員編號</th>
						<td>${pha.memNo}</td>
					</tr>
					<tr>
						<th>相簿建立時間</th>
						<td>${pha.albDate}</td>
					</tr>

				</table>
				
			</div>
	
			<table>
				<tr>
					<td>
						<FORM METHOD="post"
							ACTION="<%=request.getContextPath()%>/photoAlbum"
							style="margin-bottom: 0px;">
							<input type="submit" value="修改"> <input type="hidden"
								name="empno" value="${phaVO.phaNo}"> <input
								type="hidden" name="action" value="getOne_For_Update">
						</FORM>
					</td>
					<td>
						<FORM METHOD="post"
							ACTION="<%=request.getContextPath()%>/photoAlbum"
							style="margin-bottom: 0px;">
							<input type="submit" value="刪除"> <input type="hidden"
								name="phaNo" value="${phaVO.phaNo}"> <input
								type="hidden" name="action" value="delete">
						</FORM>
					</td>
				</tr>
			</table>
		</div>
		</c:forEach>
		
	<c:if test="${currentPage > 1}">
		<a href="${pageContext.request.contextPath}/pha.do?action=getAll&page=1">至第一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage - 1 != 0}">
		<a href="${pageContext.request.contextPath}/pha.do?action=getAll&page=${currentPage - 1}">上一頁</a>&nbsp;
	</c:if>                                             
	<c:if test="${currentPage + 1 <= empPageQty}">      
		<a href="${pageContext.request.contextPath}/pha.do?action=getAll&page=${currentPage + 1}">下一頁</a>&nbsp;
	</c:if>                                             
	<c:if test="${currentPage != empPageQty}">          
		<a href="${pageContext.request.contextPath}/pha.do?action=getAll&page=${phaPageQty}">至最後一頁</a>&nbsp;
	</c:if>



</body>
</html>
