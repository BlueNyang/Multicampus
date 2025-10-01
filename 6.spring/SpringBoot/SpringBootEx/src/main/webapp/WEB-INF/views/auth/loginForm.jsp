<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>로그인 폼</title>
    <!-- head.jsp -->
    <jsp:include page="/WEB-INF/views/layout/head.jsp"/>
    <script src="<c:url value="/js/auth/login.js"/>"></script>
    <style>
      #button {
        text-align: center;
      }
    </style>
  </head>
  <body>
    <div id="wrap">
      <!-- top.jsp import -->
      <jsp:include page="/WEB-INF/views/layout/header.jsp"/>
      <section>
        <h1 id="title">로그인</h1>
        <form id="loginForm" name="loginForm">
          <table>
            <tr>
              <th><label for="id">ID</label></th>
              <td><input type="text" id="id" name="id"></td>
            </tr>
            <tr>
              <th><label for="pwd">비밀번호</label></th>
              <td><input type="password" id="pwd" name="pwd" autocomplete="off"></td>
            </tr>
            <tr>
              <td colspan="2" id="button">
                <br>
                <input type="submit" value="로그인">
                <input type="reset" value="취소">
              </td>
            </tr>
          </table>
        </form>
      </section>
      <!-- footer.jsp import  -->
      <jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
    </div>
  </body>
</html>