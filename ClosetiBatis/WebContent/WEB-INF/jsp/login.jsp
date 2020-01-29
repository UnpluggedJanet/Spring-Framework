<%@ include file="notLoginMenu.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

${sessionScope.loginUserInfo.username}<br/>

<a href="logout.do">로그 아웃</a>

</body>
</html>