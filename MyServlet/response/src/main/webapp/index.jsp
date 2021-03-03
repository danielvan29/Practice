<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1>Login</h1>

<div style="text-align: center">
    <%--action路径:"${pageContext.request.contextPath}/login"--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        名字：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        <input type="submit">
    </form>
</div>

</body>
</html>
