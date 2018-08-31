<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>ホーム</title>

<script  type="text/javascript"
src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js">
</script>

<script type="text/javascript">
$(document).ready(function(){
  $('.fuwat').css('visibility','hidden');
  $(window).scroll(function(){
   var windowHeight = $(window).height(),
       topWindow = $(window).scrollTop();
   $('.fuwat').each(function(){
    var objectPosition = $(this).offset().top;
    if(topWindow > objectPosition - windowHeight + 200){
     $(this).addClass("fuwatAnime");
    }
   });
  });
});
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
<h1>ホーム画面</h1>
</div>
<ul class="c-box">
	<li><div class="card">
	<img src="images/sample.jpg" class="c-image">
	<p class="c-title">タイトル</p>
	<p class="c-content">本文</p></div></li>

	<li><div class="card">
	<img src="images/sample.jpg" class="c-image">
	<p class="c-title">タイトル</p>
	<p class="c-content">本文</p></div></li>

	<li><div class="card">
	<img src="images/sample.jpg" class="c-image">
	<p class="c-title">タイトル</p>
	<p class="c-content">本文</p></div></li>

	<li><div class="card">
	<img src="images/sample.jpg" class="c-image">
	<p class="c-title">タイトル</p>
	<p class="c-content">本文</p></div></li>
</ul>

<s:if test="#session.logined==0">
<!--グループ１-->
<div class="cd-fixed-bg cd-bg-1">
<div class="fuwat"><p>テスト</p></div>
</div>
<div class="cd-scrolling-bg">
<div class="cd-container">
	<div class="fuwat"><p>テスト</p>
						<p>テスト</p></div>
</div>
</div>
<!--ここまで-->
<!--グループ２-->
<div class="cd-fixed-bg cd-bg-2">
<div class="fuwat"><p>テスト2</p></div>
</div>
<div class="cd-scrolling-bg ">
<div class="cd-container">
<div class="fuwat"><p>テスト2</p></div>
</div>
</div>
<!--ここまで-->
<!--グループ３-->
<div class="cd-fixed-bg cd-bg-2">
<div class="fuwat"><p>テスト3</p></div>
</div>
<div class="cd-scrolling-bg ">
<div class="cd-container">
<div class="fuwat"><p>テスト3</p></div>
</div>
</div>
</s:if>
<!--ここまで-->
<s:include value="footer.jsp"/>
</body>
</html>