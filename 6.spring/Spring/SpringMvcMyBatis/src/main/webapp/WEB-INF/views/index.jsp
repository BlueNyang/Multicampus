<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>Index Page</title>
  </head>
  <body>
    <h2>
      MyBatis 사용 DB 연동: 상품 관리
    </h2>
    <hr/>

    <a href="<c:url value="product/listAllProduct"/>">Whole Product View</a>
    <hr/>
  </body>
</html>
