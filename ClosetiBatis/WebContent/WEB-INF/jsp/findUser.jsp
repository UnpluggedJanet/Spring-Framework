<%@ include file="loginMenu.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<div class="container">
		<form method="post" action="finduser.do" class="navbar-search pull-left">
		  <input type="text" name="email" class="search-query" placeholder="Search"/>
		  <input type="submit" value="검색"/>
		</form>
	</div>
	
	<br>
	<br>
	<c:if test="${requestScope.error_message!=null}">
	<div class="alert alert-error">
	  <h4>검색 실패!</h4>
		${requestScope.error_message }
	</div>
	</c:if>
	
	<c:if test="${requestScope.no_result!=null}">
	<div class="alert alert-info">
	  <h4>${requestScope.no_result }</h4>
	</div>
	</c:if>
	
	<table class="table table-striped">
		<c:forEach var="userList" items="${userList}">
			 <tr class="success">
			 	 <td><a href="<c:url value="user.do"><c:param name="id" value="${userList.id}"/></c:url>">${userList.username}</a></td><td>${userList.email}</td>
		   	 <c:if test="${userList.following==false}">
		   	 	<td><a href="<c:url value="follow.do"><c:param name="id" value="${userList.id}"/></c:url>" class="btn btn-success">following</a></td>
		   	</c:if>
		   	<c:if test="${userList.following==true}">
		   	 	<td>following 중 입니다.</td>
		   	</c:if>
		   </tr>
		</c:forEach>
	</table>


</body>
</html>