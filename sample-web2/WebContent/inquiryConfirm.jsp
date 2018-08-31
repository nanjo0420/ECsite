<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>お問い合わせフォーム確認</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<h1>お問い合わせフォーム確認</h1>
<s:form method="post" action="InquiryCompleteAction">
<table class="vertical-list-table">
<tr>
	<th><s:label value="お名前"/></th>
	<td><s:property value="name"/><s:hidden name="name" value="%{name}"/></td>
</tr>
<tr>
	<th><s:label value="メールアドレス"/></th>
	<td><s:property value="email"/><s:hidden name="email" value="%{email}"/></td>
</tr>
<tr>
	<th><s:label value="お問い合わせ内容"/></th>
	<td><s:property value="body"/><s:hidden name="body" value="%{body}"/></td>
	<s:hidden name="productId" value="%{#session.productId}"/>
</tr>
</table>
	<s:submit value="送信" class="submit_btn" />
</s:form>
<br>
<button type="button" class="submit_btn" onclick="history.back()">修正する</button>
	</div>
<div id="footer">
	<s:include value="footer.jsp"/>
</div>
</body>
</html>