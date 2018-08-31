<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>問い合わせ管理画面</title>
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
<h1>問い合わせ管理画面</h1>

<s:if test="#session.inquiryDtoList.size()>0">

<table class="horizontal-list-table">
<thead>
<tr>
<th><s:label value="削除"/></th>
<th><s:label value="投稿者名"/></th>
<th><s:label value="メールアドレス"/></th>
<th><s:label value="問い合わせ内容"/></th>

</tr>
</thead>
<tbody>
<s:iterator value="#session.inquiryDtoList">
<tr>

	<td><s:form action="DeleteInquiryAction">
	<s:hidden name="id" value="%{id}"/>
	<input type ="submit" class="submit_btn" value="問い合わせ削除" />
	</s:form></td>
	<td><s:property value="name"/></td>
	<td><s:property value="email"/></td>
	<td><s:property value="body"/></td>

</tr>

</s:iterator>
</tbody>
</table>
</s:if>
</div>

<s:else>
<div class="info">
問い合わせ情報はありません。
</div>
</s:else>

<div class="submit_btn_box">
<s:form action="GoReviewAdminAction">
<input type ="submit" class="submit_btn" value="レビュー管理" />
</s:form>
</div>
<div class="submit_btn_box">
<s:form action="GoAdminAction">
<input type ="submit" class="submit_btn" value="商品管理画面" />
</s:form>
</div>

<div id="footer">
	<s:include value="footer.jsp"/>
</div>
</body>
</html>