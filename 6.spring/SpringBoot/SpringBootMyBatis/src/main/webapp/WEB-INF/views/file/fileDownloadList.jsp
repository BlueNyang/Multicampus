<%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 01/10/2025
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
    <title>File Download List</title>
  </head>
  <body>
    <h3>폴더 내 모든 파일 목록 출력</h3>
    <%--@elvariable id="fileList" type="java.util.List"--%>
    <c:forEach items="${fileList}" var="file">
      <a href="<c:url value="/file/fileDownload/${file}"/>">${file} | 파일 다운로드</a>
    </c:forEach>
  </body>
</html>
