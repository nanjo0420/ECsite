<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style2.css">
<title>ヘッダー</title>
<!--<script>
function goLoginAction(){
	document.getElementById("form").action="GoLoginAction";
}
function goMyPageAction(){
	document.getElementById("form").action="MyPageAction";
}
function goCartAction(){
	document.getElementById("form").action="CartAction";
}
function goProductListAction(){
	document.getElementById("categoryId").value=1;
	document.getElementById("form").action="ProductListAction";
}
function goLogoutAction(){
	document.getElementById("form").action="LogoutAction";
}
function goSearchItemAction(){
	document.getElementById("form").action="SearchItemAction";
}
function goHelpAction(){
	document.getElementById("form").action="GoHelpAction";
}
</script>-->

</head>
<body>
<header>
<div id="header2">
<div id ="header-title2">
<img src="images/gray大.png" alt="">
</div>
<!-- <div id="header-menu2">
<ul>
<s:form id="form" name="form"> -->
	<ul>
	<li><div class="btn">検索ワード</div></li>
	<li><div class="btn">商品検索</div></li>
	<li><div class="btn">ログイン</div></li>
	<li><div class="btn">カート</div></li>
	<li><div class="btn">商品一覧</div></li>
	</ul>
	<!--<s:if test='#session.containsKey("mCategoryDtoList")'>
	<li><s:select name="categoryId" list="#session.mCategoryDtoList" listValue="categoryName" listKey="categoryId" class="cs-div" id="categoryId"/></li>
	</s:if>
	<li><s:textfield name="keywords" class="txt-keywords" placeholder="検索ワード"/></li>
	<li><s:submit value ="商品検索" class="submit_btn" onclick="goSearchItemAction();"/></li>
	<s:if test="#session.logined==1 || #session.logined==2">
	<li><s:submit value="ログアウト" class="submit_btn" onclick="goLogoutAction();"/></li>
	</s:if>
	<s:else>
		<li><s:submit value ="ログイン" class="submit_btn" onclick="goLoginAction();"/></li>
	</s:else>
	<li><s:submit value="カート" class="submit_btn" onclick="goCartAction();"/></li>
	<li><s:submit value="商品一覧" class="submit_btn" onclick="goProductListAction();"/></li>
	<s:if test="#session.logined==1">
		<li><s:submit value="マイページ" class="submit_btn" onclick="goMyPageAction();"/></li>
	</s:if>-->
</s:form>
</ul>
</div>
</div>
</header>
</body>
</html>