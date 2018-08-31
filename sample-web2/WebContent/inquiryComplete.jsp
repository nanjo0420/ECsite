<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<meta http-equiv="refresh" content="3;URL='HomeAction'"/>
<title>お問い合わせ完了</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<h1>お問い合わせ送信完了</h1>
<div class="success">
お問い合わせ送信が完了しました。
</div>
	</div>
<div id="footer">
	<s:include value="footer.jsp"/>
</div>
</body>
</html>