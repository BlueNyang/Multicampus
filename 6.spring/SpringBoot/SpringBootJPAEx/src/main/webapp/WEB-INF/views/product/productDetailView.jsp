<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 상세 조회</title>
    <c:import url="/WEB-INF/views/layout/head.jsp"/>
    <script src="<c:url value='/js/product/productDetail.js'/>"></script>
  </head>
  <body>
    <div id="wrap">
      <!--  top -->
      <c:import url="/WEB-INF/views/layout/header.jsp"/>

      <h3>상품 상세 조회</h3>
      <br><br>
      <form method="post" action="<c:url value='/cart/insertCart'/>">
        <table>
          <tr>
            <td rowspan="9">
              <img
                 src="<c:url value='/product_images/${product.prdImg}'/>"
                 width="300"
                 height="250"
                 alt=""
              >
            </td>
          </tr>
          <tr>
            <td>상품번호</td>
            <td>${product.prdNo}</td>
          <tr>
            <td>상품명</td>
            <td>${product.prdName}</td>
          </tr>
          <tr>
            <td>가격</td>
            <td>
              <span id="price" data-price="${product.prdPrice}">
                <fmt:formatNumber value="${product.prdPrice}" type="number" maxFractionDigits="3"/>
              </span>
              <span>원</span>
            </td>
          </tr>
          <tr>
            <td>제조회사</td>
            <td>${product.prdCompany}</td>
          </tr>
          <tr>
            <td>상품설명</td>
            <td>${product.prdDesc}</td>
          </tr>
          <tr>
            <td>
              <label for="cartQty">주문수량</label>
            </td>
            <td>
              <input type="button" id="minusBtn" value="-">
              <input type="text" id="cartQty" name="cartQty" value="1" size="1" readonly>
              <input type="button" id="plusBtn" value="+">
            </td>
          </tr>
          <tr>
            <td>구매 예정 금액</td>
            <td>
              <span id="amount">
                <fmt:formatNumber value="${product.prdPrice}" type="number" maxFractionDigits="3"/>
              </span> 원
            </td>
          </tr>
          <tr>
            <td colspan="2">
              <!-- 로그인 하지 않은 경우에는 [로그인] 버튼  -->
              <%--@elvariable id="authUser" type="java.lang.String"--%>
              <c:if test="${empty authUser}">
                <button>
                  <a href="<c:url value="/auth/loginForm"/>">
                    로그인
                  </a>
                </button>
              </c:if>
              <c:if test="${not empty authUser}">
                <input type="hidden" name="prdNo" value="${product.prdNo}">
                <input type="submit" id="insertCart" value="장바구니 담기"/>
                <input type="submit" id="insertOrder" value="주문하기"/>
              </c:if>
            </td>
          </tr>
        </table>
      </form>

      <br><br>
      <a href="<c:url value='/product/productCtgList/${product.ctgId}'/>">
        <button>상품 목록 보기</button>
      </a>

      <!--  bottom -->
      <c:import url="/WEB-INF/views/layout/footer.jsp"/>

    </div>
  </body>
</html>






