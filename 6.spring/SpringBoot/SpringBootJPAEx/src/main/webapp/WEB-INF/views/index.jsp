<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프로젝트 예제 : index 메인 페이지</title>
    <c:import url="layout/head.jsp"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main/slideShow.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main/product.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/common/tabMenu.css"/>"/>
    <script src="<c:url value="/js/main/index.js"/>"></script>
    <script src="<c:url value="/js/main/tabMenu.js"/>"></script>
    <script src="<c:url value="/js/main/slideShow.js"/>"></script>
  </head>
  <body>
    <div id="wrap"> <!-- 전체 영역 -->
      <c:import url="layout/header.jsp"/>
      <section><!-- 컨텐츠 영역 -->
        <article id="slideShow"> <!-- 슬라이드 쇼 -->

          <!-- 이전/다음 버튼 -->
          <div id="prevNextButtonBox">
            <img id="prevButton" src="<c:url value="/image/prevButton.png"/>" alt="">
            <img id="nextButton" src="<c:url value="/image/nextButton.png"/>" alt="">
          </div>
          <div id="slideShowBox">
            <div id="slidePanel">
              <img src="<c:url value="/image/slide_img_01.jpg"/>" alt="" class="slideImage">
              <img src="<c:url value="/image/slide_img_02.jpg"/>" alt="" class="slideImage">
              <img src="<c:url value="/image/slide_img_03.jpg"/>" alt="" class="slideImage">
              <img src="<c:url value="/image/slide_img_04.jpg"/>" alt="" class="slideImage">
              <img src="<c:url value="/image/slide_img_05.jpg"/>" alt="" class="slideImage">
            </div>
          </div> <!-- slideShowBox 끝 -->
          <div id="controlPanel">
            <img src="<c:url value="/image/controlButton1.png"/>" alt="" class="controlButton">
            <img src="<c:url value="/image/controlButton1.png"/>" alt="" class="controlButton">
            <img src="<c:url value="/image/controlButton1.png"/>" alt="" class="controlButton">
            <img src="<c:url value="/image/controlButton1.png"/>" alt="" class="controlButton">
            <img src="<c:url value="/image/controlButton1.png"/>" alt="" class="controlButton">
          </div>
        </article>
        <article id="content1"> <!-- 탭메뉴 -->
          <div id="tabMenuBox">
            <div id="tabMenu">
              <ul id="tab">
                <li><img src="<c:url value="/image/tab1.png"/>" alt=""></li>
                <li><img src="<c:url value="/image/tab2.png"/>" alt=""></li>
                <li><img src="<c:url value="/image/tab3.png"/>" alt=""></li>
                <li><img src="<c:url value="/image/tab4.png"/>" alt=""></li>
              </ul>
            </div>
            <div id="tabContent">
              <div><a href="#"><img src="<c:url value="/image/tab_img_01.jpg"/>" alt=""></a></div>
              <div><a href="#"><img src="<c:url value="/image/tab_img_02.jpg"/>" alt=""></a></div>
              <div><a href="#"><img src="<c:url value="/image/tab_img_03.jpg"/>" alt=""></a></div>
              <div><a href="#"><img src="<c:url value="/image/tab_img_04.jpg"/>" alt=""></a></div>
            </div>
          </div>

        </article>
        <article id="content2"> <!-- 베스트 상품 -->
          <div id="productBox">
            <h3> 베스트 상품</h3>
            <div class="product">
              <div><a href="#"><img src="<c:url value="/image/prd01.jpg"/>" alt=""></a></div>
              <div><a href="#"><img src="<c:url value="/image/prd02.jpg"/>" alt=""></a></div>
              <div><a href="#"><img src="<c:url value="/image/prd03.jpg"/>" alt=""></a></div>
            </div>
            <div class="product">
              <div><a href="#"><img src="<c:url value="/image/prd04.jpg"/>" alt=""></a></div>
              <div><a href="#"><img src="<c:url value="/image/prd05.jpg"/>" alt=""></a></div>
              <div><a href="#"><img src="<c:url value="/image/prd06.jpg"/>" alt=""></a></div>
            </div>
          </div>
        </article>
      </section>
      <c:import url="layout/footer.jsp"/>
    </div> <!-- wrap 끝 -->
  </body>
</html>