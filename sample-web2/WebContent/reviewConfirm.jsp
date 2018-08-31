<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>レビュー内容確認</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<h1>レビュー内容確認</h1>
<s:form method="post" action="ReviewCompleteAction">
<table class="vertical-list-table">
<tr>
	<s:property value="productId"/><s:hidden name="productId" value="%{#session.productId}"/>
	<th><s:label value="評価"/></th>
	<td><div class="decide"><s:property value="star"/></div><s:hidden name="star" value="%{star}"/></td>
</tr>
<tr>
	<th><s:label value="タイトル"/></th>
	<td><s:property value="title"/><s:hidden name="title" value="%{title}"/></td>
</tr>
<tr>
	<th><s:label value="お名前"/></th>
	<td><s:property value="name"/><s:hidden name="name" value="%{name}"/></td>
</tr>
<tr>
	<th><s:label value="レビュー内容"/></th>
	<td><s:property value="body"/><s:hidden name="body" value="%{body}"/></td>
</tr>
</table>
	<s:submit value="投稿" class="submit_btn" />
</s:form>
<br>
<button type="button" class="submit_btn" onclick="history.back()">修正する</button>
	</div>
<div id="footer">
	<s:include value="footer.jsp"/>
</div>
</body>
</html>