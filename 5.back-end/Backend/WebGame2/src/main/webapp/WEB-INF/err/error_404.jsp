<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 19/09/2025
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value='/resources/css/common.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>"/>
    <title>Error::404</title>
  </head>
  <body>
    <div id="app">
      <div class="container">
        <div class="title">
          <div class="logo">
            <div class="icon">
              <img src="<c:url value="/resources/images/controller.svg"/>" alt="Controller Icon"/>
            </div>
            <h1>404 Error</h1>
            <div class="icon">
              <img src="<c:url value="/resources/images/controller-outline.svg"/>" alt="Controller Outline Icon"/>
            </div>
          </div>
          <p>Not Found</p>
        </div>
        <div class="content">
          <h2>해당하는 페이지를 찾을 수 없습니다.</h2>
          <p>주소를 다시 한 번 확인해 주세요.</p>
          <button onclick="document.location='<c:url value='/'/>'" class="btn">홈으로 돌아가기</button>
        </div>
      </div>
    </div>
  </body>
</html>
