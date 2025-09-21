<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 22/09/2025
  Time: 02:06
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="user" type="kr.bluenyang.webgame.user.dto.UserDTO"--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="errorMessage" value="${sessionScope.errorMessage}"/>
<c:if test="${not empty errorMessage}">
  <c:remove var="errorMessage" scope="session"/>
</c:if>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value="/resources/css/common.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/users.css"/>"/>
    <title>Management Profile</title>
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
          <a href="${pageContext.request.contextPath}" class="nav-link">return to index</a>
          <div></div>
        </div>
        <c:if test="${errorMessage != null}">
          <div class="alert alert-warning">
            <p>${errorMessage}</p>
          </div>
        </c:if>
        <div class="content">
          <form name="loginForm" method="post" action="${pageContext.request.contextPath}/user/manage">
            <div class="manage-form-group">
              <label for="userId">ID:</label>
              <input type="text" id="userId" name="userId" value="${user.userId}" required readonly/>
            </div>
            <div class="manage-form-group">
              <label for="currentPassword">Current Password:</label>
              <input type="password" id="currentPassword" name="currentPassword" required>
            </div>
            <div class="manage-form-group">
              <label for="password">Password to change (if needed):</label>
              <input type="password" id="password" name="password">
            </div>
            <div class="manage-form-group">
              <label for="username">Username:</label>
              <input type="text" id="username" name="username" value="${user.username}">
            </div>
            <div class="manage-form-group">
              <label for="email">Email:</label>
              <input type="email" id="email" name="userEmail" value="${user.userEmail}">
            </div>
            <div class="manage-form-btn-group">
              <button type="submit" name="action" value="update" class="btn">Update</button>
              <button type="submit" name="action" value="withdraw" class="btn warning">Withdraw</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>