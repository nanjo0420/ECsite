<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>レビュー</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="contents">
<h1>レビュー</h1>

	<s:if test="!#session.starErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.starErrorMessageList"><s:property/>
		<br></s:iterator>
		</div>
		</div>
	</s:if>

	<s:if test="!#session.titleErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.titleErrorMessageList"><s:property/>
		<br></s:iterator>
		</div>
		</div>
	</s:if>

	<s:if test="!#session.nameErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.nameErrorMessageList"><s:property/>
		<br></s:iterator>
		</div>
		</div>
	</s:if>

	<s:if test="!#session.bodyErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.bodyErrorMessageList"><s:property/>
		<br></s:iterator>
		</div>
		</div>
	</s:if>
	<s:form action="ReviewConfirmAction">
	<div class="inquiry-form">
	評価(星をつけなくても問題ありません。)<br>

  <div class="evaluation">
    <input id="star1" type="radio" name="star" value="★★★★★" />
    <label for="star1"><span class="text">最高</span>★</label>
    <input id="star2" type="radio" name="star" value="★★★★" />
    <label for="star2"><span class="text">良い</span>★</label>
    <input id="star3" type="radio" name="star" value="★★★" />
    <label for="star3"><span class="text">普通</span>★</label>
    <input id="star4" type="radio" name="star" value="★★" />
    <label for="star4"><span class="text">悪い</span>★</label>
    <input id="star5" type="radio" name="star" value="★" />
    <label for="star5"><span class="text">最悪</span>★</label>
  </div>

	<br>
	タイトル<br>
	<input type="text"  name="title" size="30"/><br>
	<br>
	お名前<br>
	<input type="text" name="name" size="30"/><br>
	<br>
	レビュー内容<br>
	<s:textarea name="body" cols="30" rows="10"/>
	<br>
	<br>
	</div>
	<div class="submit_btn_box">
	<s:submit value="確認" class="submit_btn"/>
	</div>
	</s:form>
	<div class="submit_btn_box">
	<s:form action="HomeAction">
	<button type="button" class="submit_btn" onclick="history.back()">戻る</button>
	</s:form>
	</div>
	</div>



<div id="footer">
	<s:include value="footer.jsp"/>
</div>
</body>
</html>