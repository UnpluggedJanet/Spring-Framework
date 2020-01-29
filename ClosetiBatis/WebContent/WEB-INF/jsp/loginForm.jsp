<%@ include file="notLoginMenu.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 에러 메시지 출력 코드 추가 -->
<c:if test="${requestScope.message!=null}">
<div class="alert alert-error">
  <h4>${requestScope.message }</h4>
</div>
</c:if>

<c:if test="${requestScope.error_message!=null}">
<div class="alert alert-error">
  <h4>로그인 실패!</h4>
	${requestScope.error_message }
</div>
</c:if><br> 


 <div class="container">
      <form method="post" action="login.do" class="form-signin">
        <h2 class="form-signin-heading">로그인 ㄱㄱ</h2>
        <input type="text" name ="email" class="input-block-level" placeholder="Email address">
        <form:errors path="user.email" class="errors"/>
        <input type="password" name="password" class="input-block-level" placeholder="Password">
        <form:errors path="user.password" class="errors"/><br> 
        <button class="btn btn-large btn-primary" type="submit">로그인</button>
      </form>

    </div> <!-- /container -->


</body>
</html>