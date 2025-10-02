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
      <form method="post" action="<c:url value='/product/insertCart'/>">
        <table>
          <tr>
            <td rowspan="9">
              <img
                 src="<c:url value='/product_images/${prd.prdImg}'/>"
                 width="300"
                 height="250"
                 alt=""
              >
            </td>
          </tr>
          <tr>
            <td>상품번호</td>
            <td>${prd.prdNo}</td>
          <tr>
            <td>상품명</td>
            <td>${prd.prdName}</td>
          </tr>
          <tr>
            <td>가격</td>
            <td>
              <span id="price" data-price="${prd.prdPrice}">
                <fmt:formatNumber value="${prd.prdPrice}" type="number" maxFractionDigits="3"/>
              </span>
              <span>원</span>
            </td>
          </tr>
          <tr>
            <td>제조회사</td>
            <td>${prd.prdCompany}</td>
          </tr>
          <tr>
            <td>상품설명</td>
            <td>${prd.prdDesc}</td>
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
                <fmt:formatNumber value="${prd.prdPrice}" type="number" maxFractionDigits="3"/>
              </span> 원
            </td>
          </tr>
          <tr>
            <td colspan="2">
              <!-- 로그인 하지 않은 경우에는 [로그인] 버튼  -->


            </td>
          </tr>
        </table>
      </form>

      <br><br>
      <a href="<c:url value='/product/productCtgList/${prd.ctgId}'/>">
        <button>상품 목록 보기</button>
      </a>


      <!--  bottom -->
      <c:import url="/WEB-INF/views/layout/footer.jsp"/>

    </div>
  </body>
</html>






