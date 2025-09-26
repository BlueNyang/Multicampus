<%--@elvariable id="prd" type="kr.bluenyang.practice.product.model.ProductVO"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>상품 정보 수정</title>
  </head>
  <body>
    <h3>상품 정보 수정</h3>
    <form method="post" action="<c:url value='/product/updateProduct'/>">
      <table>
        <tr>
          <td><label for="prdNo">상품 번호</label></td>
          <td><input type="text" name="prdNo" id="prdNo" value="${prd.prdNo}" readonly></td>
        </tr>
        <tr>
          <td><label for="prdName">상품명</label></td>
          <td><input type="text" name="prdName" id="prdName" value="${prd.prdName}"></td>
        </tr>
        <tr>
          <td><label for="prdPrice">가격</label></td>
          <td><input type="text" name="prdPrice" id="prdPrice" value="${prd.prdPrice}"></td>
        </tr>
        <tr>
          <td><label for="prdCompany">제조회사</label></td>
          <td><input type="text" name="prdCompany" id="prdCompany" value="${prd.prdCompany}"></td>
        </tr>
        <tr>
          <td><label for="prdStock">재고</label></td>
          <td><input type="text" name="prdStock" id="prdStock" value="${prd.prdStock}"></td>
        </tr>
        <tr>
          <td><label for="prdDate">제조일</label></td>
          <td>
            <input
               type="text"
               name="prdDate"
               id="prdDate"
               value="<fmt:formatDate value="${prd.prdDate}" pattern="yyyy-MM-dd" />"
            >
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <input type="submit" value="수정">
            <input type="reset" value="취소">
          </td>
        </tr>
      </table>
    </form>
    <br><br>

    <a href="<c:url value='/' />">[홈으로 이동]</a>


  </body>
</html>