<%--@elvariable id="prdList" type="java.util.List"--%>
<%--@elvariable id="prdListSize" type="java.lang.Integer"--%>
<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>Insert title here</title>
    <style>
      thead tr {
        background-color: limegreen;
      }

      th {
        width: 7%;
      }
    </style>
  </head>
  <body>

    <table>
      <thead>
        <tr>
          <th>상품 번호</th>
          <th>이름</th>
          <th>가격</th>
          <th>제조사</th>
          <th>색상</th>
          <th>카테고리 번호</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="prd" begin="0" end="${prdListSize}" step="1" items="${prdList}">
          <tr>
            <td>${prd.prdNo }</td>
            <td>${prd.prdName }</td>
            <td>${prd.prdPrice }</td>
            <td>${prd.prdMaker }</td>
            <td>${prd.prdColor }</td>
            <td>${prd.ctgNo }</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>