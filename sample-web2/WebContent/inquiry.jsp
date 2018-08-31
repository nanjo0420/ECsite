<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>お問い合わせフォーム</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<h1>お問い合わせフォーム</h1>

	<s:if test="!#session.nameErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.nameErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
	</s:if>

	<s:if test="!#session.emailErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.emailErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
	</s:if>

	<s:if test="!#session.bodyErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.bodyErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
	</s:if>
	<s:form action="InquiryConfirmAction">
	<div class="inquiry-form">
	<input type="text"  name="name" placeholder="お名前" size="30"/><br>
	<br>

	<input type="text" name="email" placeholder="メールアドレス" size="30"/><br>
	<br>

	<s:textarea name="body" placeholder="お問い合わせ内容" cols="30" rows="10"/>
	<br>
	<br>
	</div>
	<div class="submit_btn_box">
	<s:submit value="確認" class="submit_btn"/>
	</div>
	</s:form>
	<div class="submit_btn_box">
	<s:form action="HomeAction">
	<input type ="submit" class="submit_btn" value="ホームへ戻る" />
	</s:form>
	</div>
	</div>



<div id="footer">
	<s:include value="footer.jsp"/>
</div>
</body>
</html>