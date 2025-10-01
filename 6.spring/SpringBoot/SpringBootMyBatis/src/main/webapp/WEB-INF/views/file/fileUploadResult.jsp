<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 30/09/2025
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
    <title>File Upload Result</title>
  </head>
  <body>
    <h3>파일 업로드 결과</h3>
    <%--@elvariable id="originalFileName" type="java.lang.String"--%>
    <c:if test="${not empty originalFileName}">
      <p>원본 파일명: ${originalFileName}</p>
    </c:if>
    <c:if test="${empty originalFileName}">
      <p>파일 업로드에 실패했습니다. 다시 시도해주세요.</p>
    </c:if>
    <br/>
    <a href="<c:url value='/file/fileUploadForm'/>">더 업로드하기</a>
    <br/>
    <a href="<c:url value='/'/>">홈으로</a>
  </body>
</html>
