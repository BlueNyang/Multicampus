<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>신규 게시글 작성</title>
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

        input,
        textarea {
            border: none;
        }

        input:focus,
        textarea:focus {
            outline: none;
        }
    </style>
</head>
<body>
<%
    String sessionID = (String) session.getAttribute("sessionID");
    String sessionName = (String) session.getAttribute("sessionName");
%>
<%
    if (sessionID != null) {
%>
<h1>신규 게시글 작성</h1>
<form action="post_new_send.jsp" method="post">
    <table>
        <tr>
            <td>작성자</td>
            <td>
                <label>
                    <input type="text" name="writer" value="<%= sessionName %>" readonly>
                </label>
            </td>
        </tr>
        <tr>
            <td>제목</td>
            <td>
                <label>
                    <input type="text" name="title">
                </label>
            </td>
        </tr>
        <tr>
            <td>내용</td>
            <td>
                <label>
                    <textarea rows="10" cols="20" name="content"></textarea>
                </label>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">저장</button>
                <button type="button" onclick="location.href='post_list.jsp'">목록으로</button>
                <button type="reset">초기화</button>
            </td>
        </tr>
    </table>
</form>
<%
    } else {
        response.sendRedirect("/csrf/main.html");
    }
%>
</body>
</html>