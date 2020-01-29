<%@ include file="notLoginMenu.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<br> 

 <div class="container">
   <form method="post" action="signup.do" class="form-signin">
     <h2 class="form-signin-heading">회원 가입 ㄱㄱ</h2>
     <input type="text" name ="email" class="input-block-level" placeholder="Email address">
     <c:if test="${requestScope.message!=null}">
				<font color="red">${requestScope.message }</font>
		 </c:if>
		 <c:if test="${requestScope.blank_e!=null}">
				<font color="red">${requestScope.blank_e }</font>
		 </c:if>
     <input type="password" name="password" class="input-block-level" placeholder="Password">
     <c:if test="${requestScope.blank_p!=null}">
				<font color="red">${requestScope.blank_p }</font>
		 </c:if>
     <input type="text" name ="username" class="input-block-level" placeholder="User name">
     <c:if test="${requestScope.blank_u!=null}">
				<font color="red">${requestScope.blank_u}</font>
		 </c:if>
     <input type="text" name ="bio" class="input-block-level" placeholder="Bio">
     <button class="btn btn-large btn-primary" type="submit">회원가입</button>
   </form>
</div>


</body>
</html>