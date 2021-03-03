<%--
  Created by IntelliJ IDEA.
  User: VAN
  Date: 2020/11/08
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--JSP表达式：用来将程序的输出显示到客户端--%>
    <%= new java.util.Date()%>

    <hr>

    <%
        int sum = 0;
        for (int i = 1; i <= 100; i++){
            sum++;
        }
        out.print("<h1>" + sum + "</h1>");
    %>

    <%--JSP声明--%>
    <%!
        static {
            System.out.println("Loading");
        }
        private int val = 3;
        public void bbb(){
            System.out.println(val);
        }
    %>

    <%--EL表达式--%>

    <!--html注释，会在客户端显示-->

</body>
</html>
