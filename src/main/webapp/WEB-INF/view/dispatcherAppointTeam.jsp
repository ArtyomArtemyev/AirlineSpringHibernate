<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="css/jspstyle.css" rel="stylesheet" type="text/css">
    <title>Appoint team to flight page</title>
</head>
    <body>
    <form method="POST" action="/airline/controller" id="appointForm">
        <input type="hidden" name="command" value="appoint_team"/>
            <div>
                <table class="myTable" id="teamTable">
                    <caption>Teams</caption>
                    <tr>
                        <th>Id</th>
                        <th>Select</th>
                    </tr>
                    <c:forEach var="team" items="${listTeam}">
                        <tr>
                            <td>${team.id}</td>
                            <td><input type="checkbox" name="id" id="${team.id}" value="${team.id}"></td>
                        </tr>
                    </c:forEach>
                </table>
                <table class="myTable" id="flightTable">
                    <caption>Flights</caption>
                    <tr>
                        <th>Id</th>
                        <th>Navigation</th>
                        <th>Id team</th>
                        <th>Select</th>
                    </tr>
                    <c:forEach var="flight" items="${listFlight}">
                        <tr>
                            <td>${flight.id}</td>
                            <td>${flight.navigationFlight}</td>
                            <td>${flight.idTeam}</td>
                            <td><input type="checkbox" name="id" id="${flight.id}" value="${flight.id}"></td>
                        </tr>
                    </c:forEach>
                </table>
                <input type="submit" value="appointTeam" id="appointButton">
            </div>
        </form>
        <script src="js/dispatcher.appoint.team.controller.js"></script>
    </body>
</html>
