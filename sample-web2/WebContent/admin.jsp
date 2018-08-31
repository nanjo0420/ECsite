<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>管理者画面</title>
<script  type="text/javascript"
src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js">
</script>

</head>
<body>
<jsp:include page="header.jsp"/>

<p id="page-top"><a href="title">PAGE TOP</a></p>
<script>
$(function() {
    var showFlag = false;
    var topBtn = $('#page-top');
    topBtn.css('bottom', '-100px');
    var showFlag = false;
    //スクロールが100に達したらボタン表示
    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            if (showFlag == false) {
                showFlag = true;
                topBtn.stop().animate({'bottom' : '20px'}, 200);
            }
        } else {
            if (showFlag) {
                showFlag = false;
                topBtn.stop().animate({'bottom' : '-100px'}, 200);
            }
        }
    });
    //スクロールしてトップ
    topBtn.click(function () {
        $('body,html').animate({
            scrollTop: 0
        }, 500);
        return false;
    });
});
</script>


<div id="contents">
<h1>管理者画面</h1>

<s:if test="#session.productInfoDtoList.size()>0">

<table class="horizontal-list-table">
<thead>
<tr>
<th><s:label value="削除"/></th>
<th><s:label value="商品名"/></th>
<th><s:label value="ふりがな"/></th>
<th><s:label value="商品画像"/></th>
<th><s:label value="値段"/></th>
<th><s:label value="発売会社名"/></th>
<th><s:label value="発売年月日"/></th>

</tr>
</thead>
<tbody>
<s:iterator value="#session.productInfoDtoList">
<tr>

	<td><s:form action="DeleteProductAction">
	<s:hidden name="productId" value="%{productId}"/>
	<input type ="submit" class="submit_btn" value="商品削除" />
	</s:form></td>
	<td><s:property value="productName"/></td>
	<td><s:property value="productNameKana"/></td>
	<td><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' width="50px" height="50px"/></td>
	<td><s:property value="price"/>円</td>
	<td><s:property value="releaseCompany"/></td>
	<td><s:property value="releaseDate"/></td>

</tr>

</s:iterator>
</tbody>
</table>
</s:if>
<div class="submit_btn_box">
<s:form action="AddProductAction">
<input type ="submit" class="submit_btn" value="商品追加" />
</s:form>
</div>
<div class="submit_btn_box">
<s:form action="GoReviewAdminAction">
<input type ="submit" class="submit_btn" value="レビュー管理" />
</s:form>
</div>
<div class="submit_btn_box">
<s:form action="GoInquiryAdminAction">
<input type ="submit" class="submit_btn" value="問い合わせ管理" />
</s:form>
</div>
</div>

<s:else>
<div class="info">
商品情報はありません。
</div>
</s:else>


<div id="footer">
	<s:include value="footer.jsp"/>
</div>
</body>
</html>