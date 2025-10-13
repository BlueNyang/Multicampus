<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>회원 정보 수정</title>
    <c:import url="/WEB-INF/views/layout/head.jsp"/>
    <link rel="stylesheet" href="<c:url value="/css/auth/join.css"/>"/>
  </head>
  <body>
    <div id="wrap">
      <!-- top.jsp 임포트 -->
      <c:import url="/WEB-INF/views/layout/header.jsp"/>
      <c:choose>
        <%--@elvariable id="authUser" type="java.lang.String"--%>
        <c:when test="${empty authUser}">
          <span>잘못된 접근입니다. 로그인 후 이용해주세요.</span>
          <a href="<c:url value="/auth/loginForm"/>">로그인</a>
        </c:when>
        <c:otherwise>
          <%--@elvariable id="memberInfo" type="kr.bluenyang.practice.springbootex.auth.model.MemberVO"--%>
          <section>
            <h1 id="title">회원 정보 수정</h1>
            <form id="editForm" name="editForm" method="post">
              <table>
                <tr>
                  <th>
                    <label for="memName">성명*</label>
                  </th>
                  <td>
                    <input type="text" id="memName" name="memName" value="${memberInfo.memName}">
                  </td>
                </tr>
                <tr>
                  <th>
                    <label for="memId">ID*</label>
                  </th>
                  <td>
                    <input type="text" id="memId" name="memId" readonly value="${memberInfo.memId}">
                  </td>
                </tr>
                <tr>
                  <th>
                    <label for="memPwd">현재 비밀번호*</label>
                  </th>
                  <td>
                    <input type="password" id="memPwd" name="memPwd" placeholder="비밀번호 입력">
                  </td>
                </tr>
                <tr>
                  <th>
                    <label for="newMemPwd">새 비밀번호(변경 시)</label>
                  </th>
                  <td>
                    <input type="password" id="newMemPwd" name="newMemPwd" placeholder="비밀번호 입력">
                  </td>
                </tr>
                <tr>
                  <th>
                    <label for="newMemPwdConfirm">새 비밀번호 확인</label>
                  </th>
                  <td>
                    <input type="password" id="newMemPwdConfirm" name="newMemPwdConfirm" placeholder="비밀번호 확인">
                  </td>
                </tr>
                <tr>
                  <th>
                    <label for="memHp1">휴대폰 번호</label>
                  </th>
                  <td>
                    <input
                       type="text"
                       id="memHp1"
                       name="memHp1"
                       size="1"
                       maxlength="3"
                       value="${memberInfo.memHp1}"
                    />
                    <label for="memHp2"> - </label>
                    <input
                       type="text"
                       id="memHp2"
                       name="memHp2"
                       size="2"
                       maxlength="4"
                       value="${memberInfo.memHp2}"
                    />
                    <label for="memHp3"> - </label>
                    <input
                       type="text"
                       id="memHp3"
                       name="memHp3"
                       size="2"
                       maxlength="4"
                       value="${memberInfo.memHp3}"
                    />
                  </td>
                </tr>
                <tr>
                  <th>
                    <label for="memEmail">이메일</label>
                  </th>
                  <td>
                    <input type="email" id="memEmail" name="memEmail" size="30" value="${memberInfo.memEmail}">
                  </td>
                </tr>
                <tr>
                  <th class="addrLabel">
                    <label>주소</label>
                  </th>
                  <td colspan="3">
                    <label for="memZipCode" class="hidden"></label>
                    <input
                       type="text"
                       id="memZipCode"
                       name="memZipCode"
                       size="5"
                       value="${memberInfo.memZipCode}"
                       readonly
                    />
                    <input
                       type="button"
                       id="searchZipBtn"
                       name="searchZipBtn"
                       value="우편번호 찾기"
                    />
                    <br/>
                    <label for="memAddress1" class="hidden"></label>
                    <input
                       type="text"
                       id="memAddress1"
                       name="memAddress1"
                       size="40"
                       value="${memberInfo.memAddress1}"
                       readonly
                    />
                    <br/>
                    <label for="memAddress2" class="hidden"></label>
                    <input
                       type="text"
                       id="memAddress2"
                       name="memAddress2"
                       size="40"
                       value="${memberInfo.memAddress2}"
                    />
                    <br/>
                  </td>
                </tr>

                <tr>
                  <th>
                    <label>회원 탈퇴</label>
                  </th>
                  <td>
                    <input
                       type="button"
                       id="unregisterBtn"
                       name="unregisterBtn"
                       value="회원탈퇴"
                       style="color: red;"
                    />
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
        </c:otherwise>
      </c:choose>
      <!-- bottom.jsp 임포트 -->
      <c:import url="/WEB-INF/views/layout/footer.jsp"/>
    </div>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="<c:url value="/js/auth/manage.js"/>"></script>
    <script src="<c:url value="/js/auth/join.js"/>"></script>
  </body>
</html>


