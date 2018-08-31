<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>商品追加確認画面</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<h1>商品追加確認</h1>
<s:form method="post" action="AddProductCompleteAction">
<table class="vertical-list-table">
<tr>
	<th><s:label value="商品名"/></th>
	<td><s:property value="productName"/><s:hidden name="productName" value="%{productName}"/></td>
</tr>
<tr>
	<th><s:label value="商品名かな"/></th>
	<td><s:property value="productNameKana"/><s:hidden name="productNameKana" value="%{productNameKana}"/></td>
</tr>
<tr>
	<th><s:label value="商品詳細"/></th>
	<td><s:property value="productDescription"/><s:hidden name="productDescription" value="%{productDescription}"/></td>
</tr>
<tr>
	<th><s:label value="カテゴリID"/></th>
	<td><s:property value="categoryId"/><s:hidden name="categoryId" value="%{categoryId}"/></td>
</tr>
<tr>
	<th><s:label value="商品ID"/></th>
	<td><s:property value="productId"/><s:hidden name="productId" value="%{productId}"/></td>
</tr>
<tr>
	<th><s:label value="価格"/></th>
	<td><s:property value="price"/><s:hidden name="price" value="%{price}"/></td>
</tr>
<tr>
	<th><s:label value="発売年月"/></th>
	<td><s:property value="releaseDate"/><s:hidden name="releaseDate" value="%{releaseDate}"/></td>
</tr>
<tr>
	<th><s:label value="発売会社"/></th>
	<td><s:property value="releaseCompany"/><s:hidden name="releaseCompany" value="%{releaseCompany}"/></td>
</tr>
<tr>
	<th>画像ファイル名</th>
	<td><s:property  value="imageFileName"/><s:hidden name="imageFileName" value="%{imageFileName}"/></td>
<tr>
<tr>
	<th>画像ファイルパス</th>
	<td><s:property  value="imageFilePath"/><s:hidden name="imageFilePath" value="%{imageFilePath}"/></td>
</tr>
</table>
	<s:submit value="追加" class="submit_btn" />
</s:form>
<br>
<button type="button" class="submit_btn" onclick="history.back()">修正する</button>
</div>
<div id="footer">
	<s:include value="footer.jsp"/>
</div>
</body>
</html>