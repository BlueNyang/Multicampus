<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 01/10/2025
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="authUser" type="java.lang.String"--%>
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
        <c:when test="${not empty authUser}">
          <span>
            <span>환영합니다.</span>
            <a href="<c:url value="/auth/manage"/>">${authUser}</a>
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
<nav>  <!-- 메뉴영역 -->
  <div id="mainMenuBox">
    <ul id="menuItem">
      <li><a href="#">SPECIAL</a></li>
      <li><a href="<c:url value="/product"/>">전체 상품</a></li>
      <li><a href="#">메뉴항목2</a></li>
      <li><a href="#">메뉴항목3</a></li>
      <li><a href="#">메뉴항목4</a></li>
      <li><a href="#" id="showAllMenu">전체보기 ▼</a></li>
    </ul>
  </div> <!-- mainMenuBox 끝 -->
  <div id="subMenuBox">
    <div class="subMenuItem" id="subMenuItem1">
      <ul>
        <li><a href="<c:url value="/product/productCtgList/${1}"/>">노트북</a></li>
        <li><a href="<c:url value="/product/productCtgList/${2}"/>">프린트</a></li>
        <li><a href="<c:url value="/product/productCtgList/${3}"/>">마우스</a></li>
        <li><a href="<c:url value="/product/productCtgList/${4}"/>">키보드</a></li>
      </ul>
    </div>
    <div class="subMenuItem" id="subMenuItem2">
      <ul>
        <li><a href="#">subMenuItem2-1</a></li>
        <li><a href="#">subMenuItem2-2</a></li>
        <li><a href="#">subMenuItem2-3</a></li>
        <li><a href="#">subMenuItem2-4</a></li>
      </ul>
    </div>
    <div class="subMenuItem" id="subMenuItem3">
      <ul>
        <li><a href="#">subMenuItem3-1</a></li>
        <li><a href="#">subMenuItem3-2</a></li>
        <li><a href="#">subMenuItem3-3</a></li>
        <li><a href="#">subMenuItem3-4</a></li>
      </ul>
    </div>
    <div class="subMenuItem" id="subMenuItem4">
      <ul>
        <li><a href="#">subMenuItem4-1</a></li>
        <li><a href="#">subMenuItem4-2</a></li>
        <li><a href="#">subMenuItem4-3</a></li>
        <li><a href="#">subMenuItem4-4</a></li>
      </ul>
    </div>
    <div class="subMenuItem" id="subMenuItem5">
      <ul>
        <li><a href="#">subMenuItem5-1</a></li>
        <li><a href="#">subMenuItem5-2</a></li>
        <li><a href="#">subMenuItem5-3</a></li>
        <li><a href="#">subMenuItem5-4</a></li>
      </ul>
    </div>
    <div class="subMenuItem" id="subMenuItem6">
      <ul>
        <li><a href="#">subMenuItem6-1</a></li>
        <li><a href="#">subMenuItem6-2</a></li>
        <li><a href="#">subMenuItem6-3</a></li>
        <li><a href="#">subMenuItem6-4</a></li>
      </ul>
    </div>
  </div>    <!-- subMenuBox 끝 -->
</nav>
