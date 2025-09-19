<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Product Form</title>
  </head>
    <body>
      <h3>상품 정보 등록</h3>
      <form method="post" action="<c:url value='/product/newProduct4'/>">
        상품번호 <input type="text" name="prdNo"><br>
        상품명 <input type="text" name="prdName"><br>
        가격 <input type="text" name="prdPrice"><br>
        제조회사 <input type="text" name="prdMaker"><br>
        제조일 <input type="text" name="prdDate"><br>
        재고 <input type="text" name="prdStock"><br><br>
        <input type="submit" value="등록"><input type="reset" value="취소">
      </form>
    </body>
</html>

