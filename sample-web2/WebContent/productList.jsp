<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>商品一覧</title>

<script  type="text/javascript"
src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js">
</script>

</head>
<body>
<jsp:include page="header.jsp" />

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
<h1>商品一覧画面</h1>
<s:if test="productInfoDtoList==null">
<div class="info">
検索結果がありません。
</div>
</s:if>

<s:else>
<div id="product-list">
<s:iterator value="#session.productInfoDtoList">
<div class="product-list-box">
<ul>
	<li>
	<a href='<s:url action="ProductDetailsAction">
	<s:param name="productId" value="%{productId}"/>
	</s:url>'><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="item-image-box-200"/></a><br>
	<s:property value="productName"/><br>
	<s:property value="productNameKana"/><br>
	<s:property value="price"/>円<br>
	</li>
</ul>
</div>
</s:iterator>
</div>

<div class="pager">
<s:iterator begin="1" end="#session.totalPageSize" status="pageNo">
	<s:if test="#session.currentPageNo == #pageNo.count">
		<s:property value="%{#pageNo.count}"/>
	</s:if>
	<s:else>
		<a href="<s:url action='SearchItemAction'><s:param name='pageNo' value='%{#pageNo.count}'/><s:param name='categoryId' value='%{categoryId}'/></s:url> ">	<s:property value="%{#pageNo.count}"/></a>
	</s:else>
</s:iterator>
</div>

<br>
<div class="submit_btn_box">
<s:else>
<s:form action="HomeAction">
<input type ="submit" class="submit_btn" value="ホームへ戻る" />
</s:form>
</s:else>
</div>

</s:else>
</div>


<s:include value="footer.jsp"/>
</body>
</html>