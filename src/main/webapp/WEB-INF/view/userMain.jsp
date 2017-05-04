<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="css/jspstyle.css" rel="stylesheet" type="text/css">
    <title>User main page</title>
</head>
    <body>
    <div align="center">
        <table>
            <caption>FLIGHTS</caption>
            <tr>
                <th>Id</th>
                <th>Navigation</th>
            </tr>
            <c:forEach var="flight" items="${flights}">
                <tr>
                    <td>${flight.id}</td>
                    <td>${flight.navigationFlight}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </body>
</html>
