<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>장바구니 목록</title>
    <c:import url="/WEB-INF/views/layout/head.jsp"/>
    <link rel="stylesheet" href="<c:url value="/css/product/product.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/css/product/orderForm.css"/>"/>
    <script src="<c:url value='/js/product/cartListView.js' />"></script>
    <style>
      table {
        border: 1px solid #ddd;
        width: 900px;
      }

      #deleteCartBtn {
        width: 100%;
        height: 100%;
        background-color: #333333;
        border: none;
        color: white;
        cursor: pointer;
        font-size: 14px;
        text-align: center;
        text-decoration: none;
        font-weight: bold;
      }

      .text-right {
        text-align: right;
      }

      .text-left {
        text-align: left;
      }

      .text-center {
        text-align: center;
      }

      .border-t {
        border-top: 1px solid #000;
        margin-top: 10px;
      }
    </style>
  </head>
  <body>
    <div id="wrap">
      <!--  top -->
      <c:import url="/WEB-INF/views/layout/header.jsp"/>
      <section>
        <h3>장바구니 목록</h3>
        <form method="post" action="<c:url value='/order/orderForm'/>">
          <table>
            <tr>
              <td class="text-center">
                <input type="checkbox" id="allCheck" name="allCheck">
                <label for="allCheck">전체 선택</label>
              </td>
              <td colspan="5" class="text-left">
                장바구니에서 상품 삭제를 원하시면 체크박스를 선택하시고 [삭제] 버튼을 눌러 주세요
              </td>
            </tr>
            <tr>
              <th><input type="button" id="deleteCartBtn" value="삭제"></th>
              <th>사진</th>
              <th>상품명</th>
              <th>가격</th>
              <th>주문수량</th>
              <th><label for="cartQty">구매예정금액</label></th>
            </tr>
            <%--@elvariable id="cartList" type="java.util.List"--%>
            <c:forEach var="prd" items="${cartList}">
              <tr>
                <td class="text-center">
                  <label>
                    <input type="checkbox" class="chkDelete" value="${prd.cartNo}">
                  </label>
                </td>
                <td>
                  <img src="<c:url value='/product_images/${prd.prdImg}' />" width="150" height="100" alt="">
                </td>
                <td>
                    ${prd.prdName }
                </td>
                <td class="text-right">
                  <span class="price" data-price=${prd.prdPrice}>
                    <fmt:formatNumber value="${prd.prdPrice}" pattern="#,###"/>
                  </span>
                  <span>
                    원
                  </span>
                </td>
                <td class="text-center">
                  <input
                     id="cartQty"
                     type="text"
                     class="cartQty"
                     name="cartQty"
                     value="${prd.cartQty}"
                     size="1"
                     readonly
                  >
                  <input type="hidden" name="cartNo" value="${prd.cartNo}">
                    <%-- <input type="hidden" name="memId" value="${prd.memId}"> --%>
                </td>
                <td class="text-right">
                  <span class="itemPrice" data-price=${prd.prdPrice * prd.cartQty}>
                    <fmt:formatNumber value="${prd.prdPrice * prd.cartQty}" pattern="#,###"/></span>
                  <span>
                    원
                  </span>
                </td>
              </tr>
            </c:forEach>
            <tr class="border-t">
              <td colspan="5">총 구매 예정금액</td>
              <td class="text-right">
                <span id="total"><!--총 구매예정금액 표시--></span>
                <span>
                    원
                </span>
              </td>
            </tr>
          </table>
          <br><br>
          <input type="submit" value="주문하기">
        </form>
      </section>

      <!--  bottom -->
      <c:import url="/WEB-INF/views/layout/footer.jsp"/>
    </div>
  </body>
</html>