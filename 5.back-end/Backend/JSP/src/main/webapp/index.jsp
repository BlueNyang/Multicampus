<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="style.css"/>
    <style>
        .container {
            margin-bottom: 10rem;
        }

        .container > a {
            padding-left: 1rem !important;
        }
    </style>
  </head>
  <body>
    <h1>
      <%= "Hello JSP!" %>
    </h1>
    <div class="container">
      <a href="sec01/start.jsp">1.1. start.jsp</a><br/>
      <a href="sec01/variable.jsp">1.2. variable.jsp</a>
      <hr/>
      <a href="sec02/jsp_include.jsp">2.1. jsp_include.jsp</a><br/>
      <a href="sec02/jsp_include2.jsp">2.2. jsp_include2.jsp</a>
      <hr/>
      <a href="sec03/request.jsp">3. request.jsp</a><br/>
      <a href="sec03/join.jsp">3.1. join.jsp</a>
      <hr/>
      <a href="sec04/response.jsp">4. response.jsp</a>
      <hr/>
      <a href="sec05/typeConversion.jsp">5. typeConversion.jsp</a>
      <hr/>
      <a href="sec06/forForm.jsp">6. forForm.jsp</a>
      <hr/>
      <a href="sec07/includeAction1.jsp">7. includeAction1.jsp</a>
      <hr/>
      <a href="sec08/login_forward.jsp">8. login_forward.jsp</a>
      <hr/>
      <a href="sec09/studentBean.jsp">9.1. studentBean.jsp</a><br/>
      <a href="sec09/studentForm.jsp">9.2. studentForm.jsp</a><br/>
      <a href="sec09/memberForm.jsp">9.ex. memberForm.jsp</a>
      <hr/>
      <a href="sec10/el.jsp">10.1. el.jsp</a><br/>
      <a href="sec10/memberForm_param.jsp">10.2.ex. memberForm_param.jsp</a><br/>
      <a href="sec10/pageContext.jsp">10.3. pageContext.jsp</a><br/>
      <a href="sec10/el_binding_forward.jsp">10.4. el_binding_forward.jsp</a><br/>
      <a href="sec10/el_binding_forward_member.jsp">10.5. el_binding_forward_member.jsp</a><br/>
      <a href="sec10/el_arrayList.jsp">10.6. el_arrayList.jsp</a><br/>
      <hr/>
      <a href="sec11/c_set.jsp">11.1. c_set.jsp</a><br/>
      <a href="sec11/login.jsp">11.2. login.jsp</a><br/>
      <a href="sec11/c_remove.jsp">11.3. c_remove.jsp</a><br/>
      <a href="sec11/c_if.jsp">11.4. c_if.jsp</a><br/>
      <a href="sec11/c_choose.jsp">11.5. c_choose.jsp</a><br/>
      <a href="sec11/c_for.jsp">11.6. c_for.jsp</a><br/>
      <a href="sec11/c_forEach_ArrayList.jsp">11.7. c_forEach_ArrayList.jsp</a><br/>
      <hr/>
      <a href="sec12/c_url.jsp">12.1. c_url.jsp</a><br/>
      <a href="sec12/urlTest.jsp">12.2. urlTest.jsp</a><br/>
      <a href="sec12/c_redirect.jsp">12.3. c_redirect.jsp</a><br/>
      <hr/>
      <a href="sec13/fmt_format.jsp">13.1. fmt_format.jsp</a><br/>
      <a href="sec13/fn_functions.jsp">13.2. fn_functions.jsp</a><br/>
      <hr/>
      <a href="sec14/main.jsp">14. Member Main</a>
      <hr/>
    </div>
  </body>
</html>