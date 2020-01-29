<%@ include file="loginMenu.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1>검색 결과입니다!</h1>
<br>
<form>

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
						 <a href="<c:url value="like.do"><c:param name="p_id" value="${postList.postId}"/></c:url>" class="btn btn-info"><i class="icon-thumbs-up"></i>like</a>
					 </c:if>
					 <c:if test="${postList.like==true}">
					   <a href="<c:url value="cancellike.do"><c:param name="p_id" value="${postList.postId}"/></c:url>" class="btn btn-info"><i class="icon-thumbs-up"></i>like취소</a>	
					 </c:if>
				  <!-- Dislike관련 코드 -->
					 <c:if test="${postList.disLike==false}">			
						 <a href="<c:url value="dislike.do"><c:param name="p_id" value="${postList.postId}"/></c:url>" class="btn btn-warning"><i class="icon-thumbs-down"></i>dislike</a>
					 </c:if>
					 <c:if test="${postList.disLike==true}">
					   <a href="<c:url value="canceldislike.do"><c:param name="p_id" value="${postList.postId}"/></c:url>" class="btn btn-warning"><i class="icon-thumbs-down"></i>dislike취소</a>	
					 </c:if> 
					 <%-- <a href="<c:url value="deletePost.do"><c:param name="delPostId" value="${postList.postId}"/></c:url>">삭제</a> --%>
				</td>
			</tr>
			</tbody>
		</table>
	<br>
</c:forEach>

    	
</form>

</body>
</html>