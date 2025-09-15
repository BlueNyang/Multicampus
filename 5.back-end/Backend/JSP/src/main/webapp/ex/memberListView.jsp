<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   isELIgnored="false"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>회원 정보 출력창</title>
    <link rel="stylesheet" type="text/css" href="../style.css">
    <style>
        body {
            display: flex;
            flex-direction: column;
            width: fit-content;
            margin: 0 auto;
            position: relative;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            margin-top: 1rem;
            border: 1px solid #ccc;
            width: fit-content;
            border-radius: 10px;
            overflow: hidden;
        }

        table {
            border-collapse: collapse;
        }

        table,
        tr {
            text-align: center;
        }

        tr:nth-child(even) {
            background-color: #e0e0e0;
            padding: 8px 16px;
        }

        th {
            background-color: lightgreen;
            padding: 8px 16px;
        }

        table,
        th,
        td {
            border-style: hidden;
        }

        .cls1 {
            font-size: 40px;
            text-align: center;
        }

        .cls2 {
            display: inline-flex;
            justify-content: space-between;
        }

        .cls3 {
            font-size: 1rem;
        }
    </style>

  </head>
  <body>
    <p class="cls1">회원정보</p>
    <div class="cls2">
      <a class="cls3" href="${contextPath}/ex/main.jsp">메인으로</a>
      <a class="cls3" href="${contextPath}/exs/memberInsert">회원가입</a>
    </div>
    <div class="container">
      <table>
        <thead>
          <tr>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>이름</th>
            <th>이메일</th>
            <th>가입일</th>
            <th>수정</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
          <jsp:useBean id="memberList" scope="request" type="java.util.List"/>
          <c:forEach var="member" items="${memberList}">
            <tr>
              <td>${member.id}</td>
              <td>${fn:replace(member.pwd, member.pwd, '*******')}</td>
              <td>${member.name}</td>
              <td>${member.email}</td>
              <td>${member.joinDate}</td>
              <td><a href="${contextPath}/exs/memberUpdate?id=${member.id}">수정</a></td>
              <td><a href="${contextPath}/exs/memberDelete?id=${member.id}">삭제</a></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>
