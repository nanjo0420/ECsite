<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>商品詳細</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="contents">
<h1>商品詳細画面</h1>
	<s:form action="AddCartAction">
	<div class="box">
	<div class="2column-container">
	<div class="right">
		<img src='<s:property value="%{#session.imageFilePath}"/>/<s:property value="%{#session.imageFileName}"/>' class="item-image-box-320"/><br>
	</div>
	<div class="left">
	<table class="vertical-list-table-mini">
		<tr>
			<th scope="row"><s:label value="商品名"/></th>
			<td><s:property value="%{#session.productName}"/></td>
			</tr>
			<tr>
			<th scope="row"><s:label value="商品名かな"/></th>
			<td><s:property value="%{#session.productNameKana}"/></td>
			</tr>
			<tr>
			<th scope="row"><s:label value="値段"/></th>
			<td><s:property value="%{#session.price}"/>円</td>
			</tr>
			<tr>
			<th scope="row"><s:label value="購入個数"/></th>
			<td><s:select name="productCount" list="%{#session.productCountList}"/>個</td>
			</tr>
			<tr>
			<th scope="row"><s:label value="発売会社名"/></th>
			<td><s:property value="%{#session.releaseCompany}"/></td>
			</tr>
			<tr>
			<th scope="row"><s:label value="発売年月日"/></th>
			<td><s:property value="%{#session.releaseDate}"/></td>
			</tr>
			<tr>
			<th scope="row"><s:label value="商品詳細情報"/></th>
			<td><s:property value="%{#session.productDescription}"/></td>
			</tr>
			</table>
		</div>
		</div>
		<s:hidden name="productId" value="%{#session.productId}"/>
		<s:hidden name="productName" value="%{#session.productName}"/>
		<s:hidden name="productNameKana" value="%{#session.productNameKana}"/>
		<s:hidden name="imageFilePath" value="%{#session.imageFilePath}"/>
		<s:hidden name="imageFileName" value="%{#session.imageFileName}"/>
		<s:hidden name="price" value="%{#session.price}"/>
		<s:hidden name="releaseCompany" value="%{#session.releaseCompany}"/>
		<s:hidden name="releaseDate" value="%{#session.releaseDate}"/>
		<s:hidden name="productDescription" value="%{#session.productDescription}"/>
		</div>
		<div class="submit_btn_box">
		<s:submit value="カートに追加" class="submit_btn"/>
		</div>
		</s:form>

</div>

		<div class="product-details-recommend-box">
	<s:iterator value="#session.productInfoDtoList">
	<!--	<div class="product-list">
			<div class="product-list-box"> -->
			<div class="recommend-box">
			<a href='<s:url action="ProductDetailsAction">
			<s:param name="productId" value="%{productId}"/>
			</s:url>'><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="item-image-box-100"/></a>
			<s:property value="productName"/><br>
			</div>
	<!--		</div>
		</div>
	-->
	</s:iterator>
	</div>
<div class="mrh">
	<p><button type="button" class="submit_btn" onclick="history.back()">戻る</button></p>

	<s:if test="#session.logined==1">
	<s:form action="ReviewAction">
	<input type ="submit" class="submit_btn" value="レビューを書く" />
	</s:form>
	</s:if>

	<h2>レビュー欄</h2>
</div>
	<s:if test="#session.reviewDTOList.size()>0">
	<table class="horizontal-list-table">
	<thead>
	<tr>
		<th><s:label value="評価"/></th>
		<th><s:label value="タイトル"/></th>
		<th><s:label value="名前"/></th>
		<th><s:label value="内容"/></th>
	</tr>
	<tbody>
	<s:iterator value="#session.reviewDTOList">
	<tr>
		<td><div class="decide"><s:property value="star"/></div></td>
		<td><s:property value="title"/></td>
		<td><s:property value="name"/></td>
		<td><s:property value="body"/></td>
	</tr>
	</s:iterator>
	</tbody>
	</table>
	<br>
	<br>
	</s:if>

	<s:else>
	<div class="info">
	レビューはまだありません。
	</div>
	</s:else>
	<s:include value="footer.jsp"/>

</body>
</html>