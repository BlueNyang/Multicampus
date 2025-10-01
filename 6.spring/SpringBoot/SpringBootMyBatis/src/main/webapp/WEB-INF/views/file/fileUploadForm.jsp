<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
    <title>파일 업로드 폼</title>
  </head>
  <body>
    <h3>파일 업로드</h3>
    <form
       id="fileUploadFrm"
       method="post"
       action="<c:url value='/file/fileUpload'/>"
       enctype="multipart/form-data"
    >
      <label for="uploadFile">파일 :</label>
      <input type="file" id="uploadFile" name="uploadFile">
      <br><br>
      <input type="submit" value="업로드">
    </form>

    <hr>
    <h3>여러 개의 파일 업로드</h3>
    <form
       id="fileUploadFrmMulti"
       method="post"
       action="<c:url value='/file/fileUploadMultiple'/>"
       enctype="multipart/form-data"
    >
      <label for="uploadFiles">파일 :</label>
      <input
         type="file"
         id="uploadFiles"
         name="uploadFiles"
         multiple="multiple"
      >
      <br><br>
      <input type="submit" value="업로드">
    </form>


    <hr>
    <h3>파일명 변경하지않고 파일 업로드</h3>
    <form
       id="fileOriginalNameUploadForm"
       method="post"
       action="<c:url value='/file/fileOriginalNameUpload'/>"
       enctype="multipart/form-data"
    >
      <label for="uploadFileOriginal">파일 :</label>
      <input
         type="file" id="uploadFileOriginal"
         name="uploadFileOriginal"
      >
      <br><br>
      <input type="submit" value="업로드">
    </form>
  </body>
</html>