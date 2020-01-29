<%@ include file="loginMenu.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h1><font color="green">${user.username}</font>님의 페이지</h1>
<br>
<form>

	<c:if test="${requestScope.isFollowing!=null}">
		<c:if test="${requestScope.isFollowing==false}">
	  	<h4><a href="<c:url value="follow.do"><c:param name="id" value="${user.id}"/></c:url>" class="btn btn-success">Following</a></h4>
		</c:if>
		<c:if test="${requestScope.isFollowing==true}">
	  	<font color="blue"><h4>Following중 입니다.</h4></font>
		</c:if>
	</c:if>
	
	<!-- 마이페이지인 경우 following, followers 수 보여줌 -->
	<div class="container">
		<c:if test="${requestScope.followers!=null}">
	  	<a href="<c:url value="followers.do"><c:param name="id" value="${user.id}"/></c:url>" class="btn btn-success">Followers</a> ${requestScope.followers}명
		</c:if>
		<c:if test="${requestScope.following!=null}">
			<a href="<c:url value="following.do"><c:param name="id" value="${user.id}"/></c:url>" class="btn btn-success">Following</a> ${requestScope.following}명
		</c:if>
	
    <br><br>

<c:forEach var="postList" items="${postList}">
	<table class="table table-striped">
		<tbody>
			<tr><td rowspan="4"><b>${postList.username}</b></td>
					<td>${postList.postDate}</td>
			</tr>
			<tr><td><img src="img/${postList.img}" border="1" width="500"></td></tr>
			<tr><td>${postList.text}</td></tr>
			<tr>
				<td>
				 <i class="icon-thumbs-up"></i> ${postList.n_like}  <i class="icon-thumbs-down"></i>${postList.n_dislike}
		      <!-- Like관련 코드 -->
					 <c:if test="${postList.like==false}">			
						 <a href="<c:url value="like.do"><c:param name="p_id" value="${postList.postId}"/></c:url>" class="btn btn-info">like</a>
					 </c:if>
					 <c:if test="${postList.like==true}">
					   <a href="<c:url value="cancellike.do"><c:param name="p_id" value="${postList.postId}"/></c:url>" class="btn btn-info">like취소</a>	
					 </c:if>
				  <!-- Dislike관련 코드 -->
					 <c:if test="${postList.disLike==false}">			
						 <a href="<c:url value="dislike.do"><c:param name="p_id" value="${postList.postId}"/></c:url>" class="btn btn-warning">dislike</a>
					 </c:if>
					 <c:if test="${postList.disLike==true}">
					   <a href="<c:url value="canceldislike.do"><c:param name="p_id" value="${postList.postId}"/></c:url>" class="btn btn-warning">dislike취소</a>	
					 </c:if> 
					 <%-- <a href="<c:url value="deletePost.do"><c:param name="delPostId" value="${postList.postId}"/></c:url>">삭제</a> --%>
				</td>
			</tr>
			</tbody>
		</table>
	<br>
</c:forEach>
	</div>
</form>
</body>
</html>