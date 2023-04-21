<%--
  Created by IntelliJ IDEA.
  User: Ekaterine
  Date: 4/20/2023
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Form</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/post-servlet">
    <input type="number" name="year" value="" placeholder="year">
    <br><br>
    <input type="text" name="author" value="" placeholder="author">
    <br><br>
    <input type="text" name="title" value="" placeholder="title">
    <br><br>
    <input type="text" name="topic" value="" placeholder="topic">
    <br><br>
    <input type="text" name="fontOfText" value="" placeholder="fontOfText">
    <br><br>
    <input type="submit" value="add post">
</form>
</body>
</html>
