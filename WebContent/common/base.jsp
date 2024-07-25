<%-- 共通部分JSP --%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../css/style.css">
	<link rel="stylesheet" href="../css/bootstrap.min.css">
</head>

<body>
<div class="wrapper">
<h1 class="toptitle">得点管理システム
		<% String teacher_name = (String) session.getAttribute("teacher_name"); %>
		<c:choose>
		<c:when test="${empty teacher_name}">
			<p>
			<a href="../account/Login.action" class="login-link">ログイン</a>
    		</p>
    	</c:when>
    	<c:otherwise>
	    	<div class="login-link" style="color:black">${teacher_name}さん
    		<a href="../account/logout.jsp" method="get">ログアウト</a>
    		</div>
    	</c:otherwise>
		</c:choose>
		</h1>
${param.title}
${param.scripts}
${param.content}
</div>
</body>

<footer>
		<small>&copy; 2024 group_A</small>
</footer>

</html>
