<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    <title>productForm</title>
    <script src="<c:url value='/js/jquery-3.7.1.min.js'/>"></script>
    <script src="<c:url value='/js/axios.min.js'/>"></script>
    <script src="<c:url value="/js/ajax/prdNoCheck.js"/>"></script>
  </head>
  <body>
    <h3>상품 정보 등록</h3>
    <!--  index 페이지로 이동 링크 추가 -->
    <div class="nav">
      <a href="<c:url value="/product/listAllProduct"/>">나가기</a>
      <a href="<c:url value="/"/>">홈으로</a>
      <div></div>
    </div>
    <form id="prdForm" method="post" action="<c:url value="/product/insertProduct"/>">
      <table>
        <tr>
          <td><label for="prdNo">상품</label> 번호</td>
          <td><input type="text" name="prdNo" id="prdNo">
          </td>
        </tr>
        <tr>
          <td><label for="prdName">상품명</label></td>
          <td><input type="text" name="prdName" id="prdName"></td>
        </tr>
        <tr>
          <td><label for="prdPrice">가격</label></td>
          <td><input type="text" name="prdPrice" id="prdPrice"></td>
        </tr>
        <tr>
          <td><label for="prdCompany">제조회사</label></td>
          <td><input type="text" name="prdCompany" id="prdCompany"></td>
        </tr>
        <tr>
          <td><label for="prdStock">재고</label></td>
          <td><input type="text" name="prdStock" id="prdStock"></td>
        </tr>
        <tr>
          <td><label for="prdDate">제조일</label></td>
          <td><input type="text" name="prdDate" id="prdDate"></td>
        </tr>
        <tr>
          <td colspan="2">
            <input type="submit" value="등록" id="prdNoCheckBtn">
            <input type="reset" value="초기화">
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>