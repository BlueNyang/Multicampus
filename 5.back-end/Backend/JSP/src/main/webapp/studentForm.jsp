<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>자바 빈 액션 태그 예제</title>
	</head>
	<body>
		<h3>학생 정보 등록</h3>
		<form name="frmStudent" method="post"  action="newStudentOk.jsp">
		 <table>
		   <tr><td>학번</td><td><input type="text" name="stdNo"></td></tr>
	        <tr><td>성명</td><td><input type="text" name="stdName" ></td></tr>
	       <tr><td>전화번호</td><td><input type="text" name="stdPhone" ></td></tr>
	       <tr><td>주소</td><td><input type="text" name="stdAddress" ></td></tr>
	       <tr><td>학년</td>
	       		   <td><input type="radio" name="stdYear" value="1">1학년
	       		  			<input type="radio" name="stdYear" value="2">2학년
	       		  			<input type="radio" name="stdYear" value="3">3학년
	       		  			<input type="radio" name="stdYear" value="4">4학년</td></tr>
	       <tr><td colspan="2"> <input type="submit" value="등록">  
	    		<input type="reset" value="다시입력"></td></tr>
	    </table>
	  </form>
	</body>
</html>