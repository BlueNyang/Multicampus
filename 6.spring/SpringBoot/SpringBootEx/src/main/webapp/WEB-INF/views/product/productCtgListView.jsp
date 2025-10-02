<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 조회</title>
    <!-- head.jsp import -->
    <c:import url="/WEB-INF/views/layout/head.jsp"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/product/orderForm.css"/>"/>
  </head>
  <body>
    <div id="wrap">
      <!-- top.jsp import -->
      <c:import url="/WEB-INF/views/layout/header.jsp"/>
      <br>
      <h3>상품 조회</h3>  <br>
      <table>
        <tr>
          <th>상품 번호</th>
          <th>상품명</th>
          <th>상품 가격</th>
          <th>제조사</th>
          <th>재고</th>
          <th>상품 설명</th>
          <th>사진</th>
        </tr>

        <!-- 검색 상품 반복 출력 -->
        <%--@elvariable id="productList" type="java.util.List"--%>
        <c:forEach var="product" items="${prdList}">
          <tr>
            <td>${product.prdNo}</td>
            <td>
              <a href="<c:url value='/product/productDetail/${product.prdNo}'/>">
                  ${product.prdName}
              </a>
            </td>
            <td><fmt:formatNumber value="${product.prdPrice}" type="currency" currencySymbol="₩"/></td>
            <td>${product.prdCompany}</td>
            <td>${product.prdStock}</td>
            <td>${product.prdDesc}</td>
            <td>
              <c:choose>
                <c:when test="${not empty product.prdImg}">
                  <img
                     src="<c:url value='/product_images/${product.prdImg}'/>"
                     alt="Product Image"
                     class="product-img"
                     width="auto"
                     height="150"
                  />
                </c:when>
                <c:otherwise>
                  이미지 없음
                </c:otherwise>
              </c:choose>
            </td>
          </tr>
        </c:forEach>


      </table>
      <br><br>

      <!--  index 페이지로 이동 링크 추가 -->
      <a href="<c:url value='/' />">홈으로 이동</a><br><br>
      <!-- footer.jsp import -->
      <c:import url="/WEB-INF/views/layout/footer.jsp"/>
    </div>
  </body>
</html>