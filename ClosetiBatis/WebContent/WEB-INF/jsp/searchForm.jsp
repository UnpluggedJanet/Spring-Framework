<%@ include file="loginMenu.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1>원하는 스타일을 검색해 보아요~!</h1>
<div class="container">
	<c:if test="${requestScope.blank !=null }">
		<font color="red">${requestScope.blank}</font>
	</c:if>
	<form:form method="post" commandName="post" action="searchPost.do">
	날씨 :<form:checkboxes items="${categoryList1}" path="categoryList1" itemLabel="categName" itemValue="categCode"/>
	<br>
	상황 :<form:checkboxes items="${categoryList2}" path="categoryList2" itemLabel="categName" itemValue="categCode"/>
	<br>
	<input type="submit" value="검색"/>
	</form:form>
</div>
</body>
</html>