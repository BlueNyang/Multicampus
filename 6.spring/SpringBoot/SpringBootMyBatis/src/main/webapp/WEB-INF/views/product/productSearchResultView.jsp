<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 29/09/2025
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="prdList" type="java.util.List"--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    <title>Product Search Result</title>
    <style>
      table {
        width: 800px;
      }
    </style>
  </head>
  <body>
    <table>
      <thead>
        <tr>
          <th>상품번호</th>
          <th>상품명</th>
          <th>제조회사</th>
          <th>가격</th>
          <th>재고량</th>
          <th>제조일</th>
          <th>사진</th>
        </tr>
      </thead>
      <tbody>
        <c:choose>
          <c:when test="${empty prdList}">
            <tr>
              <td colspan="6">검색 결과가 없습니다.</td>
            </tr>
          </c:when>
          <c:otherwise>
            <c:forEach var="product" items="${prdList}">
              <tr>
                <td>
                  <a href="<c:url value="detailProduct/${product.prdNo}"/>">
                      ${product.prdNo}
                  </a>
                </td>
                <td>${product.prdName}</td>
                <td>${product.prdCompany}</td>
                <td>${product.prdPrice}</td>
                <td>${product.prdStock}</td>
                <td><fmt:formatDate value="${product.prdDate}" pattern="yyyy-MM-dd"/></td>
                <td>
                  <img
                     src="<c:url value="/images/product/${product.prdNo}.jpg"/>"
                     alt="Product Image"
                     width="100"
                  />
                </td>
              </tr>
            </c:forEach>
          </c:otherwise>
        </c:choose>
      </tbody>
    </table>
  </body>
</html>
