<%@ page import="kr.bluenyang.practice.membercontrol.domain.product.ProductDTO"%>
<%@ page import="java.util.List"%>
<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   isELIgnored="false"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="prdList" value="${requestScope.prdList}"/>
<%
  request.setCharacterEncoding("UTF-8");
  String message = (String) session.getAttribute("message");
  session.removeAttribute("message");
%>
<c:set var="message" value="<%=message %>"/>
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
    <p class="cls1">상품 정보</p>
    <div class="cls2">
      <a class="cls3" href="${contextPath}">메인으로</a>
      <a class="cls3" href="${contextPath}/product/productInsertForm.jsp">상품 등록</a>
    </div>
    <div class="container">
      <table>
        <thead>
          <tr>
            <th>상품 번호</th>
            <th>상품 이름</th>
            <th>상품 가격</th>
            <th>제조사</th>
            <th>색상</th>
            <th>카테고리 번호</th>
            <th>수정</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
          <c:choose>
            <c:when test="${empty prdList}">
              <tr>
                <td colspan="8">등록된 상품이 없습니다.</td>
              </tr>
            </c:when>
            <c:otherwise>
              <c:forEach var="prd" items="${prdList}">
                <tr>
                  <td>${prd.getPrdNo()}</td>
                  <td>${prd.getPrdName()}</td>
                  <td>${prd.getPrdPrice()}</td>
                  <td>${prd.getPrdMaker()}</td>
                  <td>${prd.getPrdColor()}</td>
                  <td>${prd.getCtgNo()}</td>
                  <td><a href="${contextPath}/product/productUpdateGet.do?prdNo=${prd.getPrdNo()}">수정</a></td>
                  <td><a href="${contextPath}/product/productDelete.do?prdNo=${prd.getPrdNo()}">삭제</a></td>
                </tr>
              </c:forEach>
            </c:otherwise>
          </c:choose>
          <script>
            window.addEventListener('load', () => {
              <c:choose>
              <c:when test='${message == "updatedProduct"}'>
              alert('상품 정보가 수정되었습니다.');
              </c:when>
              <c:when test='${message == "deletedProduct"}'>
              alert('상품 정보가 삭제되었습니다.');
              </c:when>
              <c:when test='${message == "addedProduct"}'>
              alert('상품 등록이 완료되었습니다.');
              </c:when>
              </c:choose>
            });
          </script>
        </tbody>
      </table>
    </div>
  </body>
</html>
