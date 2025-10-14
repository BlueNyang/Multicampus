<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 01/10/2025
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<footer> <!-- footer -->
  <div id="footerBox">
    <div id="bottomMenuBox">
      <ul id="bottomMenuItem">
        <li><a href="#">회사소개</a></li>
        <li><a href="#">이용약관</a></li>
        <li><a href="#">개인정보 처리방침</a></li>
        <li><a href="#">전자금융거래약관</a></li>
        <li><a href="#">보안센터</a></li>
        <li><a href="#">채용정보</a></li>
      </ul>
    </div> <!-- bottomMenuBox 끝 -->
    <div id="companyInfo"><img src="<c:url value="/image/footer.png"/>" alt=""></div>
    <div id="moveToTopBox"><img src="<c:url value="/image/moveToTop.png"/>" alt="" id="moveToTop"></div>
  </div>
</footer>
