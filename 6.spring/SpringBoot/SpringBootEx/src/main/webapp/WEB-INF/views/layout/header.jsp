<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 01/10/2025
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
  <div id="headerBox">
    <div id="logoBox">
      <a href="<c:url value="/"/>">
        <img src="<c:url value="/image/logo.png"/>" id="logoImg" alt="">
      </a>
    </div>
    <div id="topMenuBox">
      <c:choose>
        <c:when test="${not empty sessionScope.authUser}">
          <span>
            <span>환영합니다.</span>
            <a href="<c:url value="/auth/manage"/>">${sessionScope.authUser}</a>
            <span>님</span>
          </span>
          <a href="<c:url value="/auth/logout"/>">로그아웃</a>
        </c:when>
        <c:otherwise>
          <a href="<c:url value="/auth/loginForm"/>">로그인</a>
          <a href="<c:url value="/auth/joinForm"/>">회원가입</a>
        </c:otherwise>
      </c:choose>
      <span>이벤트</span>
      <span>장바구니</span>
      <span>고객센터</span>
    </div>
  </div>
</header>
