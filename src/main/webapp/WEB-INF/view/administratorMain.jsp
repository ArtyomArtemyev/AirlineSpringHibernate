<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="css/jspstyle.css" rel="stylesheet" type="text/css">
    <title>Admin main page</title>
</head>
    <body>
    <div align="center">FLIGHTS MANAGEMENT
        <table id="adminTable" align="center">
            <tr>
                <form method="POST" action="/airline/controller" id="createForm">
                    <td>
                        <input type="hidden" name="command" value="add_flight"/>
                        <label for="navigation">Navigation flight</label>
                        <input type="text" name="navigation" id="navigation" value="">
                    </td>
                    <td>
                        <input type="submit" value="Create flight" id="createButton">
                    </td>
                </form>
            </tr>

            <tr>
                <th>Id</th>
                <th>Navigation</th>
                <th>TeamId</th>
                <th>Select</th>
                <th>Action</th>
            </tr>
            <form method="POST" action="/airline/controller" id="deleteForm">
            <c:forEach var="flight" items="${flights}">
                <input type="hidden" name="command" value="delete_flight">
                <tr>
                    <td>${flight.id}</td>
                    <td>${flight.navigationFlight}</td>
                    <td>${flight.idTeam}</td>
                    <td><input type="checkbox" name="id" id="${flight.id}" value="${flight.id}"></td>
                    <td><input type="submit" value="Delete flight" id="deleteButton"></td>
                </tr>
            </c:forEach>
            </form>
        </table>
    </div>
    <script src="js/administrator.main.controller.js"></script>
    </body>
</html>
