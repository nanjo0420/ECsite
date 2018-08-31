<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>よくある質問</title>

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
<h1>よくある質問</h1>
<div class="accbox">
<!-- ラベル1 -->
	<label for="label1">ログイン</label>
	<input type="checkbox" id="label1" class="cssacc"/>
	<div class="accshow">
		<!-- ここに隠す中身 -->
		<h3>見出し１</h3>
		<p>中身</p>
		<h3>見出し２</h3>
		<p>中身</p>
		<h3>見出し３</h3>
		<p>中身</p>

	</div>

<!-- ラベル2 -->
	<label for="label2">購入</label>
	<input type="checkbox" id="label2" class="cssacc"/>
	<div class="accshow">
		<!-- ここに隠す中身 -->
		<h3>見出し１</h3>
		<p>中身</p>
		<h3>見出し２</h3>
		<p>中身</p>
		<h3>見出し３</h3>
		<p>中身</p>
	</div>

<!-- ラベル3 -->
	<label for="label3">商品配送</label>
	<input type="checkbox" id="label3" class="cssacc"/>
	<div class="accshow">
		<!-- ここに隠す中身 -->
		<h3>見出し１</h3>
		<p>中身</p>
		<h3>見出し２</h3>
		<p>中身</p>
		<h3>見出し３</h3>
		<p>中身</p>
	</div>
<!-- ラベル4 -->
	<label for="label4">その他の質問</label>
	<input type="checkbox" id="label4" class="cssacc"/>
	<div class="accshow">
	<!-- ここに隠す中身 -->
	<h3>見出し１</h3>
		<p>中身</p>
		<h3>見出し２</h3>
		<p>中身</p>
		<h3>それ以外の質問</h3>
		<p>お問い合わせフォーム</p>
	</div>
</div><!-- //.accbox -->

</div>

<div class="submit_btn_box">
<s:form action="InquiryAction">
<input type ="submit" class="submit_btn" value="お問い合わせフォーム" />
</s:form>
</div>

<div class="submit_btn_box">
<s:form action="HomeAction">
<input type ="submit" class="submit_btn" value="ホームへ戻る" />
</s:form>
</div>


<s:include value="footer.jsp"/>
</body>
</html>