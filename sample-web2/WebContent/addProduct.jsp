<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>商品追加画面</title>

</head>
<body>
<jsp:include page="header.jsp"/>
<div id="contents">
<h1>商品追加画面</h1>
<script>
$(function(){
	  //画像ファイルプレビュー表示のイベント追加 fileを選択時に発火するイベントを登録
	  $('form').on('change', 'input[type="file"]', function(e) {
	    var file = e.target.files[0],
	        reader = new FileReader(),
	        $preview = $(".preview");
	        t = this;

	    // 画像ファイル以外の場合は何もしない
	    if(file.type.indexOf("image") < 0){
	      return false;
	    }

	    // ファイル読み込みが完了した際のイベント登録
	    reader.onload = (function(file) {
	      return function(e) {
	        //既存のプレビューを削除
	        $preview.empty();
	        // .prevewの領域の中にロードした画像を表示するimageタグを追加
	        $preview.append($('<img>').attr({
	                  src: e.target.result,
	                  width: "150px",
	                  class: "preview",
	                  title: file.name
	              }));
	      };
	    })(file);

	    reader.readAsDataURL(file);
	  });
	});
</script>

	<s:if test="!#session.productNameErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.productNameErrorMessageList"><s:property/>
		<br></s:iterator>
		</div>
		</div>
	</s:if>

	<s:if test="!#session.productNameKanaErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.productNameKanaErrorMessageList"><s:property/>
		<br></s:iterator>
		</div>
		</div>
	</s:if>

	<s:if test="!#session.productDescriptionErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.productDescriptionErrorMessageList"><s:property/>
		<br></s:iterator>
		</div>
		</div>
	</s:if>

	<s:if test="!#session.priceErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.priceErrorMessageList"><s:property/>
		<br></s:iterator>
		</div>
		</div>
	</s:if>

	<s:if test="!#session.releaseDateErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.releaseDateErrorMessageList"><s:property/>
		<br></s:iterator>
		</div>
		</div>
	</s:if>

	<s:if test="!#session.releaseCompanyErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.releaseCompanyErrorMessageList"><s:property/>
		<br></s:iterator>
		</div>
		</div>
	</s:if>

	<s:form action="AddProductConfirmAction">
	商品名<br>
	<input type="text" name="productName"/><br>
	<br>
	商品名かな<br>
	<input type="text" name="productNameKana"/><br>
	<br>
	商品詳細<br>
	<input type="text" name="productDescription"/><br>
	<br>
	カテゴリID<br>

	<li><s:select name="categoryId" list="#session.mCategoryDtoList" listValue="categoryName" listKey="categoryId" class="cs-div" id="categoryId"/></li>

	<!-- <input type="text" name="categoryId"/><br> -->
	<br>
	商品ID<br>
	<input type="text" name="productId"/><br>
	<br>
	価格<br>
	<input type="text" name="price"/><br>
	<br>
	発売年月 (例:2018年7月30日→20180730)<br>
	<input type="text" name="releaseDate"/><br>
	<br>
	発売会社<br>
	<input type="text" name="releaseCompany"/><br>
	<br>
	画像ファイル名<br>
	<input accept="image/*" type="file" name="imageFileName"/><br>
	<br>
	画像ファイルパス<br>
	<input type="text" value="./images" name="imageFilePath"/><br>
	<div class="preview"></div>
	<br><
	<div class="submit_btn_box">
	<s:submit value="確認" class="submit_btn"/>
	</div>
	</s:form>
	<br>
	<button type="button" class="submit_btn" onclick="history.back()">戻る</button>

</div>

<div id="footer">
	<s:include value="footer.jsp"/>
</div>
</body>
</html>