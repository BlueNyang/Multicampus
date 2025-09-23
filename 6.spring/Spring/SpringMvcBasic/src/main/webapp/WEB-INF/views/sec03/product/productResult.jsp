<%--@elvariable id="prdNo" type="java.lang.String"--%>
<%--@elvariable id="prdName" type="java.lang.String"--%>
<%--@elvariable id="prdPrice" type="java.lang.Integer"--%>
<%--@elvariable id="prdCompany" type="java.lang.String"--%>
<%--@elvariable id="prdDate" type="java.lang.String"--%>
<%--@elvariable id="prdStock" type="java.lang.Integer"--%>
<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 19/09/2025
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>"/>
    <title>ProductResult</title>
    <style>
        body {
            padding-left: 4rem;
        }

        form {
            display: grid;
            grid-template-columns: 100px 200px;
            row-gap: 0.5rem;
            column-gap: 1rem;
            align-items: center;
        }
    </style>
  </head>
  <body>
    <h2>Product Result</h2>
    <hr/>
    <h3>Product Info</h3>
    <p>Product No: ${prdNo}</p>
    <p>Product Name: ${prdName}</p>
    <p>Product Price: ${prdPrice}</p>
    <p>Product Company: ${prdCompany}</p>
    <p>Product Date: ${prdDate}</p>
    <p>Product Stock: ${prdStock}</p>

    <br/>

    <h2>URL에 의한 데이터 전달</h2>
    <p>proNo만 전달</p>
    <span>제품 번호: </span>
    <a href="<c:url value="/sec03/student/studentDetailView/${prdNo}"/>">
      ${prdNo}
    </a>
    <br/>
    <p>URL을 통한 데이터 여러 개 전달</p>
    <p>proNo, prdStock, prdName 전달</p>
    <span>제품 번호: </span>
    <a href="<c:url value="/sec03/student/studentDetailView/${prdName}/${prdStock}/${prdNo}"/>">
      [${prdNo}, ${prdStock}, ${prdName}]
    </a>
  </body>
</html>
