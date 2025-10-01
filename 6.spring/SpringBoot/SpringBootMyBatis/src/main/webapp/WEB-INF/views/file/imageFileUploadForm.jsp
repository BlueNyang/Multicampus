<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
    <title>이미지파일 업로드</title>
    <script src="<c:url value='/js/jquery-3.7.1.min.js'/>"></script>
    <script src="<c:url value='/js/upload/imageFileUpload.js'/>"></script>
  </head>
  <body>
    <h3>이미지 파일 업로드</h3>
    <form id="imageFileFrm" name="imageFileFrm">
      <label for="uploadFile">파일 : </label>
      <input type="file" id="uploadFile" name="uploadFile"><br><br>
      <input type="submit" value="업로드">
    </form>
    <br><br>

    <!-- 업로드한 이미지 출력 -->
    <h3>업로드한 이미지</h3>
    <div id="imageBox"></div>

    <br><br>
    <!--  index 페이지로 이동 링크 추가 -->
    <a href="<c:url value='/'/>">홈으로 이동</a>
  </body>
</html>