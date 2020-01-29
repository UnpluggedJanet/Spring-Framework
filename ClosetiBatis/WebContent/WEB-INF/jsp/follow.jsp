<%@ include file="loginMenu.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <h3>총 ${user_size}명의 ${follow} following하고 있습니다. </h3>

	
	<table class="table table-striped">
		<c:forEach var="userList" items="${userList}">
			 <tr class="success">
			 	 <td><a href="<c:url value="user.do"><c:param name="id" value="${userList.id}"/></c:url>">${userList.username}</a></td><td>${userList.email}</td>
		     <c:if test="${requestScope.isFollowerPage==true&&userList.following==false}">
		   	 	 <td><a href="<c:url value="follow.do"><c:param name="id" value="${userList.id}"/></c:url>" class="btn btn-success">Following</a></td>
		   	 </c:if>
		   </tr>
		</c:forEach>
	</table>


</body>
</html>