<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 15/10/2025
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Update Password</title>
    <c:import url="/WEB-INF/views/layout/head.jsp"/>
    <link rel="stylesheet" href="<c:url value="/css/auth/join.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/css/auth/changePwd.css"/>"/>
  </head>
  <body>
    <c:import url="/WEB-INF/views/layout/header.jsp"/>

    <h2 id="title-pwd">비밀번호 변경</h2>
    <form id="changePwdForm" name="changePwdForm" method="post" action="<c:url value='/auth/changePwd'/>">
      <input type="hidden" id="memId" name="memId" value="${sessionScope.authId}">

      <table>
        <tr>
          <th>
            <label for="currentPwd">현재 비밀번호*</label>
          </th>
          <td>
            <input type="password" id="currentPwd" name="currentPwd" placeholder="현재 비밀번호를 입력하세요." required>
          </td>
        </tr>
        <tr>
          <th>
            <label for="newPwd">새 비밀번호*</label>
          </th>
          <td>
            <input type="password" id="newPwd" name="newPwd" placeholder="새 비밀번호 (8자 이상)" required>
          </td>
        </tr>
        <tr>
          <th>
            <label for="newPwdConfirm">새 비밀번호 확인*</label>
          </th>
          <td>
            <input type="password" id="newPwdConfirm" name="newPwdConfirm" placeholder="새 비밀번호를 다시 입력하세요." required>
          </td>
        </tr>
        <tr>
          <th></th>
          <td class="no-underline">
            <span id="pwdMatchMsg"></span>
          </td>
        </tr>
        <tr>
          <td colspan="2" id="button-pwd" class="no-underline align-center">
            <br>
            <input type="submit" value="비밀번호 변경">
          </td>
        </tr>
      </table>
    </form>
    <c:import url="/WEB-INF/views/layout/footer.jsp"/>
    <script src="<c:url value="/js/auth/changePwd.js"/>"></script>
  </body>
</html>
