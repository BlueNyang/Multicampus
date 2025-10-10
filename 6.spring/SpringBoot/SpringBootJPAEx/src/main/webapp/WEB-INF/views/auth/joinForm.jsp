<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>회원 가입 폼</title>
    <c:import url="/WEB-INF/views/layout/head.jsp"/>
    <link rel="stylesheet" href="<c:url value="/css/auth/join.css"/>"/>
  </head>
  <body>
    <div id="wrap">
      <!-- top.jsp 임포트 -->
      <c:import url="/WEB-INF/views/layout/header.jsp"/>
      <section>
        <h1 id="title">회원 가입</h1>
        <form
           id="joinForm" name="joinForm" method="post"
           action="<c:url value='/auth/join'/>"
        >
          <table>
            <tr>
              <th>
                <label for="memName">성명</label>
              </th>
              <td>
                <input type="text" id="memName" name="memName" placeholder="이름 입력">
              </td>
            </tr>
            <tr>
              <th>
                <label for="memId">ID</label>
              </th>
              <td>
                <input type="text" id="memId" name="memId" placeholder="ID 입력">
                <input type="button" id="idCheck" value="ID 중복 체크">
              </td>
            </tr>
            <tr>
              <th>
                <label for="memPwd">비밀번호</label>
              </th>
              <td>
                <input type="password" id="memPwd" name="memPwd" placeholder="비밀번호 입력">
              </td>
            </tr>
            <tr>
              <th>
                <label for="memPwdConfirm">비밀번호 확인</label>
              </th>
              <td>
                <input type="password" id="memPwdConfirm" name="memPwdConfirm" placeholder="비밀번호 확인">
              </td>
            </tr>
            <tr>
              <th>
                <label for="memHp1">휴대폰 번호</label>
              </th>
              <td>
                <input type="text" id="memHp1" name="memHp1" size="1" maxlength="3" placeholder="000">
                <label for="memHp2"> - </label>
                <input type="text" id="memHp2" name="memHp2" size="2" maxlength="4" placeholder="0000">
                <label for="memHp3"> - </label>
                <input type="text" id="memHp3" name="memHp3" size="2" maxlength="4" placeholder="0000">
              </td>
            </tr>
            <tr>
              <th>
                <label for="memEmail">이메일</label>
              </th>
              <td>
                <input type="email" id="memEmail" name="memEmail" placeholder="이메일 입력" size="30">
              </td>
            </tr>
            <tr>
              <th class="addrLabel">
                <label>주소</label>
              </th>
              <td colspan="3">
                <label for="memZipCode" class="hidden"></label>
                <input type="text" id="memZipCode" name="memZipCode" size="5" readonly placeholder="00000">
                <input type="button" id="searchZipBtn" name="searchZipBtn" value="우편번호 찾기"><br>
                <label for="memAddress1" class="hidden"></label>
                <input type="text" id="memAddress1" name="memAddress1" placeholder="주소 입력" size="40" readonly><br>
                <label for="memAddress2" class="hidden"></label>
                <input type="text" id="memAddress2" name="memAddress2" placeholder="상세 주소 입력" size="40">
              </td>
            </tr>

            <tr>
              <td colspan="2" id="button">
                <br>
                <input type="submit" value="완료">
                <input type="reset" value="취소">
              </td>
            </tr>
          </table>
        </form>
      </section>
      <!-- bottom.jsp 임포트 -->
      <c:import url="/WEB-INF/views/layout/footer.jsp"/>
    </div>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="<c:url value="/js/auth/join.js"/>"></script>
  </body>
</html>


