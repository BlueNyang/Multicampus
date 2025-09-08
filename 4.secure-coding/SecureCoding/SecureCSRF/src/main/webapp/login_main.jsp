<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <style>
        table,
        th,
        td {
            border: 1px solid black;
        }

        th,
        td {
            padding: 4px 8px;
        }
    </style>
</head>
<body>
<h3>로그인(session)</h3>
<form method="post" action="login_action_csrf.jsp">
    <table>
        <tr>
            <th>아이디</th>
            <td>
                <label>
                    <input type="text" name="id"/>
                </label>
            </td>
        </tr>
        <tr>
            <th>패스워드</th>
            <td>
                <label>
                    <input type="password" name="pass"/>
                </label>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="로그인"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>