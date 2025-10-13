<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
  <head>
    <meta charset="UTF-8">
    <title>별별 쇼핑몰</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/auth/mypage.css'/>">
    <c:import url="/WEB-INF/views/layout/head.jsp"/>
    <style>

    </style>
  </head>
  <body>
    <div id="wrap" class="wrap">
      <!--  top -->
      <c:import url="/WEB-INF/views/layout/header.jsp"/>
      <section class="title">
        <h1>my page</h1>
      </section>

      <!-- 콘텐츠 -->
      <main>
        <div class="container">

          <div class="grid_box">

            <a href="<c:url value='/product/myOrder'/>">
              <span>주문내역</span>
            </a>


            <a href="<c:url value='/auth/myInfoUpdateForm'/>">
              <span>내정보수정</span>
            </a>


          </div>

        </div>
      </main>
      <c:import url="/WEB-INF/views/layout/footer.jsp"/>
    </div>


  </body>

</html>
