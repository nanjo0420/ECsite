<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style2.css">
<title>ログイン</title>
<style>
body{
    background-image: url("images/plane.jpg");
    background-size: cover;
    background-size: 1600px 900px;
    background-repeat: no-repeat;
    background-attachment: fixed;
    }
</style>
</head>
<body>
<jsp:include page="header2.jsp" />
<div id="contents2">
<div class="midashi">ログイン画面</div>
<div id="box1">
<s:form id="form" action="LoginAction">


<!--
	SAVED:<s:property value="%{#session.savedLoginId}"/>
	LOGINID:<s:property value="%{#session.loginId}"/>
-->
<br>
<table class="vertical-list-table2">
		<tr>
			<th scope="row"><s:label value="ログインID:"/></th>
			<s:if test="#session.savedLoginId==true">
			<td><s:textfield name="loginId" class="txt" placeholder="ログインID" value='%{#session.loginId}' autocomplete="off"/></td>
			</s:if>
			<s:else>
			<td><s:textfield name="loginId" class="txt" placeholder="ログインID" autocomplet="off"/></td>
			</s:else>
		</tr>

	</table>
 <table class="vertical-list-table2">
		<tr>
			<th scope="row"><s:label value="パスワード:"/></th>
			<td><s:password name="password" class="txt" placeholder="パスワード" autocomplete="off" /></td>
		</tr>
	<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
		<div class="error">
			<div class="error-message">
				<s:iterator value="#session.loginIdErrorMessageList"><s:property /><br></s:iterator>
			</div>
		</div>
	</s:if>
	</table>

	<s:if test="!#session.passwordErrorMessageList.isEmpty()">
		<div class="error">
			<div class="error-message">
				<s:iterator value="#session.passwordErrorMessageList"><s:property /><br></s:iterator>
			</div>
	</div>
	</s:if>
	<div class="box">
		<s:if test="#session.savedLoginId==true">
			<s:checkbox name="savedLoginId" checked="checked"/>
		</s:if>
		<s:else>
			<s:checkbox name="savedLoginId"/>
		</s:else>
		<s:label value="ログインID保存"/><br>
	</div>
	<div class="submit">
		<s:submit value="ログイン" class="submit_btn1" onclick="goLoginAction();"/>
	</div>
</s:form>
<br>
<div class="submit">
	<div id=".contents-btn-set">
		 <s:form action="CreateUserAction">
			<s:submit value="新規ユーザー登録" class="submit_btn1" />
		 </s:form>
	</div>
</div>
<div class="submit">
<div id=".contents-btn-set">
<s:form action="ResetPasswordAction">
	<s:submit value="パスワード再設定" class="submit_btn1" />
</s:form>
<br>
</div>


</div>
</div>
</div>
<s:include value="footer2.jsp"/>
</body>
</html>