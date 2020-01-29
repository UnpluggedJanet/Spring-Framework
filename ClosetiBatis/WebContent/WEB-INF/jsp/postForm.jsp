<%@ include file="loginMenu.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
	<h1>당신의 패션을 이야기 하세요~!!</h1>
	<c:if test="${requestScope.blank !=null }">
		<font color="red">${requestScope.blank}</font>
	</c:if>
	<form:form method="post" commandName="post" action="newPost.do" enctype="multipart/form-data">
	날씨 :<form:checkboxes items="${categoryList1}" path="categoryList1" itemLabel="categName" itemValue="categCode"/>
	<br>
	상황 :<form:checkboxes items="${categoryList2}" path="categoryList2" itemLabel="categName" itemValue="categCode"/>
	<table>
		<tbody>
			<tr><td>Text </td><td><input type="text" name="text"/></td></tr>		
			<tr><td>Image </td><td><input type="file" name="imgFile"/></td>
			<td><input type="submit" value="완료"/></td></tr>
		</tbody>
	</table>
	</form:form>
</div>
</body>
</html>