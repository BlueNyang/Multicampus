<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주문서 작성</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/product/orderForm.css'/>">
    <c:import url="/WEB-INF/views/layout/head.jsp"/>
    <style>
      table {
        border: 1px solid #ddd;
        width: 800px;
      }

      .w-200 {
        width: 200px;
      }

      .text-right {
        text-align: right;
      }
    </style>
  </head>
  <body>
    <div id="wrap">
      <!--  top -->
      <c:import url="/WEB-INF/views/layout/header.jsp"/>

      <section>
        <br>
        <form method="post" action="<c:url value='/product/orderComplete'/>">
          <!-- (1) 주문자 정보 -->
          <h3>주문자 정보</h3>
          <table>
            <tr>
              <th>주문자</th>
              <td class="w-200"></td>
              <th>연락처</th>
              <td></td>
            </tr>
          </table>
          <br>

          <!-- (2) 수령인 정보 : 기본 회원 정보로 출력 (수정 가능) -->
          <h3>주문자 정보</h3>
          <table>
            <tr>
              <th>
                <label for="ordRcvReceiver">수령인</label>
              </th>
              <td class="w-200">
                <input id="ordRcvReceiver" type="text" name="ordRcvReceiver" value="">
              </td>
              <th>
                <label for="hp">연락처</label>
              </th>
              <td>
                <input id="hp" type="text" name="hp1" value="" size="3"> -
                <input id="hp" type="text" name="hp2" value="" size="4"> -
                <input id="hp" type="text" name="hp3" value="" size="4"></td>
            </tr>
            <tr>
              <th>
                <label for="ordRcvZipcode">배송지 주소</label>
              </th>
              <td colspan="3">
                <input
                   type="text" id="ordRcvZipcode" name="ordRcvZipcode" size="5"
                   value="$" readonly
                >
                <input type="button" id="searchZipBtn" name="searchZipBtn" value="우편번호 찾기"><br>
                <label for="ordRcvAddress1"></label>
                <input
                   type="text" id="ordRcvAddress1" name="ordRcvAddress1" placeholder="주소 입력" size="70"
                   value="" readonly
                > <br>
                <label for="ordRcvAddress2"></label>
                <input
                   type="text" id="ordRcvAddress2" name="ordRcvAddress2" placeholder="상세 주소 입력" size="70"
                   value=""
                >
              </td>
            </tr>
            <tr>
              <th>
                <label for="ordRcvMsg">배송 메시지</label>
              </th>
              <td colspan="3">

                <select id="ordRcvMsg" name="ordRcvMsg">
                  <option value="배송전 전화주세요">배송전 전화주세요</option>
                  <option value="부재중 전화주세요">부재중 전화주세요</option>
                  <option value="부재중 문 앞에 놓고 가세요">부재중 문 앞에 놓고 가세요</option>
                </select>

              </td>
            </tr>
          </table>
          <br>

          <!-- (3) 주문 상품 목록-->
          <table class="order_list">
            <tr>
              <th>상품번호</th>
              <th>사진</th>
              <th>상품명</th>
              <th>가격</th>
              <th>주문수량</th>
              <th>구매예정금액</th>
            </tr>
            <%--@elvariable id="cartList" type="java.util.List"--%>
            <c:forEach var="prd" items="${cartList}">
              <tr>
                <td>${prd.prdNo}</td>
                <td>
                  <img src="<c:url value='/prd_images/${prd.prdImg}' />" width="50" height="30" alt="">
                </td>
                <td>${prd.prdName }</td>
                <td class="text-right"><fmt:formatNumber value="${prd.prdPrice }" pattern="#,###"/> 원</td>
                <td>
                  <label for="cartQty"></label>
                  <input
                     type="text"
                     id="cartQty"
                     class="cartQty"
                     name="cartQty"
                     value="${prd.cartQty }"
                     size="1"
                     readonly
                  >

                  <input type="hidden" name="cartNo" value="${prd.cartNo}">
                  <input type="hidden" name="prdNo" value="${prd.prdNo}">
                </td>
                <td class="text-right">
                  <span class="amount">
                    <c:set var="amount" value="${prd.prdPrice * prd.cartQty }"/>
                    <%--@elvariable id="sum" type="java.lang.Integer"--%>
                    <c:set var="sum" value="${sum + amount}"/>
                    <fmt:formatNumber value="${amount}" pattern="#,###"/>
                  </span> 원
                </td>
              </tr>
            </c:forEach>
            <tr>
              <td colspan="5">총구매예정금액</td>
              <td class="text-right"><fmt:formatNumber value="${sum}" pattern="#,###"/> 원</td>
            </tr>
          </table>
          <br>

          <!-- (4) 결제 정보 (결제 방법 선택) -->
          <h3>결제 정보</h3>
          <table>
            <tr>
              <th>결제 방법</th>
              <td>
                <input id="ordPayCard" type="radio" name="ordPay" value="card">
                <label for="ordPayCard">신용카드</label>
                <input id="ordPayBack" type="radio" name="ordPay" value="bank">
                <label for="ordPayBack">계좌이체</label>
              </td>
            </tr>
          </table>
          <br>

          <input type="submit" value="주문 완료">
        </form>
        <br>
      </section>

      <!--  bottom -->
      <c:import url="/WEB-INF/views/layout/footer.jsp"/>
    </div>

  </body>
</html>