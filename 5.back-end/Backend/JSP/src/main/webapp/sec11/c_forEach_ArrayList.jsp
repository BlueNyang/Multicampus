<%@ page import="kr.bluenyang.practice.jsp.sec14.domain.MemberVO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%><%--
  Created by IntelliJ IDEA.
  User: xpsj20
  Date: 15/09/2025
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
  MemberVO m1 = new MemberVO("john", "1234", "John Doe", "jd@example.com", null);
  MemberVO m2 = new MemberVO("jane", "5678", "Jane Smith", "js@example.com", null);
  MemberVO m3 = new MemberVO("alice", "abcd", "Alice Johnson", "aj@example.com", null);

  List<MemberVO> memberList = new ArrayList<>();
  memberList.add(m1);
  memberList.add(m2);
  memberList.add(m3);

  request.setAttribute("memberList", memberList);
%>
<jsp:forward page="c_forEach_ArrayList_result.jsp"/>
