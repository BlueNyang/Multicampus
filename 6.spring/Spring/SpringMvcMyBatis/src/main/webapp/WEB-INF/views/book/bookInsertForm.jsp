<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 24/09/2025
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="book" type="kr.bluenyang.practice.book.model.BookDTO"--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
    <title>도서 등록</title>
    <style>
      body {
        width: 60%;
        margin: 0 auto;
        display: flex;
        flex-direction: column;
        align-items: center;
        gap: 10px;
        justify-content: center;
      }

      h2 {
        text-align: center;
      }

      .nav {
        width: 100%;
        display: flex;
        justify-content: space-around;
        border-bottom: 1px solid #333;
      }

      form {
        width: 80%;
        display: grid;
        grid-template-columns: 1fr 2fr;
        row-gap: 15px;
        margin-top: 20px;
        margin-inline: auto;
      }

      input {
        padding: 5px;
        font-size: 1em;
        border-radius: 5px;
        border: 1px solid #333;
      }

      input:focus {
        outline: none;
      }

      input[readonly] {
        background-color: #e0e0e0;
        color: #777;
      }

      .btn-group {
        display: flex;
        width: 100%;
        justify-content: space-evenly;
        grid-column: span 2;
        gap: 20px;
        margin-top: 20px;
      }

      .btn-group .submit {
        width: 200px;
        cursor: pointer;
        background-color: #333;
        color: white;
        border: none;
        transition: background-color 0.3s ease;
      }

      .btn-group .submit:hover {
        background-color: #555;
      }

      .btn-group .cancel {
        width: 200px;
        cursor: pointer;
        background-color: white;
        color: black;
        border: 1px solid #333;
        transition: background-color 0.3s ease;
      }

      .btn-group .cancel:hover {
        background-color: #ddd;
        color: black;
      }
    </style>
  </head>
  <body>
    <h2>도서 등록</h2>
    <!--  index 페이지로 이동 링크 추가 -->
    <div class="nav">
      <a href="<c:url value="/listAllBook"/>">나가기</a>
      <a href="<c:url value="/"/>">홈으로</a>
      <div></div>
    </div>

    <form name="updateBook" method="post" action="<c:url value="/book/insertBook"/>">
      <label for="bookNo">도서번호</label>
      <input name="bookNo" id="bookNo" type="text"/>
      <label for="bookName">도서명</label>
      <input name="bookName" id="bookName" type="text"/>
      <label for="bookAuthor">저자</label>
      <input name="bookAuthor" id="bookAuthor" type="text"/>
      <label for="bookPrice">도서가격</label>
      <input name="bookPrice" id="bookPrice" type="number"/>
      <label for="bookDate">출간일</label>
      <input name="bookDate" id="bookDate" type="date"/>
      <label for="bookStock">도서 재고</label>
      <input name="bookStock" id="bookStock" type="number"/>
      <label for="pubName">출판사명</label>
      <input name="pubName" id="pubName" type="text"/>
      <div class="btn-group">
        <input type="submit" class="submit" value="등록"/>
        <input type="reset" class="cancel" value="초기화"/>
      </div>
    </form>

  </body>
</html>
