<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 21/09/2025
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="errorMessage" value="${sessionScope.errorMessage}"/>
<c:set var="successMessage" value="${sessionScope.successMessage}"/>
<c:if test="${not empty errorMessage}">
  <c:remove var="errorMessage" scope="session"/>
</c:if>
<c:if test="${not empty successMessage}">
  <c:remove var="successMessage" scope="session"/>
</c:if>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value="/resources/css/common.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/users.css"/>"/>
    <title>Login</title>
  </head>
  <body>
    <div id="app">
      <div class="container">
        <div class="title">
          <div class="logo">
            <div class="icon">
              <img src="<c:url value="/resources/images/controller.svg"/>" alt="Controller Icon"/>
            </div>
            <h1>멀티캠퍼스 WebGame</h1>
            <div class="icon">
              <img src="<c:url value="/resources/images/controller-outline.svg"/>" alt="Controller Outline Icon"/>
            </div>
          </div>
        </div>
        <div class="navbar">
          <a href="${pageContext.request.contextPath}/" class="nav-link">return to index</a>
          <div></div>
        </div>
        <c:if test="${errorMessage != null}">
          <div class="alert alert-warning">
            <p>${errorMessage}</p>
          </div>
        </c:if>
        <c:if test="${successMessage != null}">
          <div class="alert alert-success">
            <p>${successMessage}</p>
          </div>
        </c:if>
        <div class="content">
          <form name="loginForm" method="post" action="${pageContext.request.contextPath}/user/login">
            <div class="form-group">
              <label for="userId">ID:</label>
              <input type="text" id="userId" name="userId" required>
            </div>
            <div class="form-group">
              <label for="password">Password:</label>
              <input type="password" id="password" name="password" required>
            </div>
            <div class="form-btn-group">
              <button
                 class="btn prev"
                 onclick="document.location = '${pageContext.request.contextPath}/user/register'"
              >
                Register
              </button>
              <input type="submit" value="Login" class="btn"/>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
