<%@ page
   language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>자바 빈 액션 태그 예제</title>
    <link rel="stylesheet" href="../style.css"/>
  </head>
  <body>
    <h3>학생 정보 등록</h3>
    <form name="frmStudent" method="post" action="newStudentOk.jsp">
      <table>
        <tr>
          <td>
            <label for="stdNo">학번</label>
          </td>
          <td>
            <input type="text" name="stdNo" id="stdNo">
          </td>
        </tr>
        <tr>
          <td>
            <label for="stdName">성명</label>
          </td>
          <td>
            <input type="text" name="stdName" id="stdName">
          </td>
        </tr>
        <tr>
          <td>
            <label for="stdPhone">전화번호</label>
          </td>
          <td>
            <input type="text" name="stdPhone" id="stdPhone">
          </td>
        </tr>
        <tr>
          <td>
            <label for="stdAddr">주소</label>
          </td>
          <td>
            <input type="text" name="stdAddr" id="stdAddr">
          </td>
        </tr>
        <tr>
          <td>
            <label>학년</label>
          </td>
          <td>
            <label for="stdYear1">
              <input type="radio" name="stdYear" value="1" id="stdYear1">
              1학년
            </label>
            <label for="stdYear2">
              <input type="radio" name="stdYear" value="2" id="stdYear2">
              2학년
            </label>
            <label for="stdYear3">
              <input type="radio" name="stdYear" value="3" id="stdYear3">
              3학년
            </label>
            <label for="stdYear4">
              <input type="radio" name="stdYear" value="4" id="stdYear4">
              4학년
            </label>
          </td>
        </tr>
        <tr>
          <td>
            <label>관심분야</label>
          </td>
          <td>
            <input type="checkbox" id="web" value="웹" name="stdInterests">
            <label for="web">웹 프로그래밍</label>
            <input type="checkbox" id="python" value="파이썬" name="stdInterests">
            <label for="python">파이썬</label>
            <input type="checkbox" id="bigdata" value="빅데이터" name="stdInterests">
            <label for="bigdata">빅데이터</label>
            <input type="checkbox" id="java" value="자바" name="stdInterests">
            <label for="java">자바 프로그래밍</label>
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <input type="submit" value="등록">
            <input type="reset" value="다시입력">
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>