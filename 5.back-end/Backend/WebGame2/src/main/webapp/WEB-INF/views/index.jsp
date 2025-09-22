<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Multicampus - WebGame</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/common.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>"/>
    <%--message가 있으면 alert--%>
    <c:if test="${not empty sessionScope.msg}">
      <script>
        alert("${sessionScope.msg}");
      </script>
      <c:remove var="msg" scope="session"/>
    </c:if>
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
          <p>JAVA 풀스택 개발자 아카데미 6회차_안규태</p>
        </div>
        <div class="navbar">
          <c:choose>
            <c:when test="${empty sessionScope.user}">
              <div></div>
              <div class="navbar-content">
                <a href="${pageContext.request.contextPath}/user/login" class="nav-link">Login</a>
                <a href="${pageContext.request.contextPath}/user/register" class="nav-link">
                  Register
                </a>
              </div>
            </c:when>
            <c:otherwise>
              <span class="nav-user">Welcome, ${sessionScope.user.username}!</span>
              <div class="navbar-content">
                <a href="${pageContext.request.contextPath}/user/manage" class="nav-link">Edit</a>
                <a href="${pageContext.request.contextPath}/user/logout" class="nav-link">Logout</a>
              </div>
            </c:otherwise>
          </c:choose>
        </div>
        <div class="content">
          <button id="hangmanBtn" class="hangman-btn btn">
            Play Hangman
          </button>
          <button id="numBaseballBtn" class="rps-btn btn">
            Play Number Baseball
          </button>
        </div>
      </div>
    </div>
    <script src="<c:url value="/resources/js/app.js"/>"></script>
  </body>
</html>