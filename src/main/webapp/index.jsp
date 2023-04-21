<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<form method="get" action="<%=request.getContextPath()%>/post-servlet">
    <input type="submit" value="See posts">
</form>

<a href="insert_form.jsp">Add new Post</a>
</body>
</html>