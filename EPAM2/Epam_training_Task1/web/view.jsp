<%--
  Created by IntelliJ IDEA.
  User: puhli
  Date: 10.12.2019
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="book" items="${books}">
    <tr>
        <td>&nbsp;&nbsp;${book.id}&nbsp;&nbsp;</td>
        <td>&nbsp;&nbsp;${book.name}&nbsp;&nbsp;</td>
        <td>&nbsp;&nbsp;${book.author}&nbsp;&nbsp;</td>
        <td>&nbsp;&nbsp;${book.description}&nbsp;&nbsp;</td>
    </tr>
</c:forEach>
</body>
</html>
