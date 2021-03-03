<%--
  Author: VAN
  Date: 2020/11/14
  Time: 23:11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--九大内置对象--%>
    <%
        pageContext.setAttribute("1","van1");
        session.setAttribute("2","name2");
        application.setAttribute("3","name3");
    %>

<%----%>
    <%
        String name1 = (String) pageContext.findAttribute("1");
        String name2 = (String) pageContext.findAttribute("2");
        String name3 = (String) pageContext.findAttribute("3");
    %>

    <h1>${name1}</h1>

</body>
</html>
