<%--
  Created by IntelliJ IDEA.
  User: VAN
  Date: 2020/11/08
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--定制错误页面--%>
<%@page errorPage="error/my500.jsp" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        System.out.println("handle");
        int x = 2/0;
    %>

</body>
</html>
