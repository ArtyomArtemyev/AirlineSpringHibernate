<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="css/jspstyle.css" rel="stylesheet" type="text/css">
    <title>Create team page</title>
</head>
    <body>
        <form method="POST" action="/airline/controller" id="teamForm">
            <input type="hidden" name="command" value="create_team"/>
            <div>
                <table class="myTable" id="employeeTable">
                    <caption> EMPLOYEES </caption>
                    <tr>
                        <th>Id</th>
                        <th>Gender</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Appointment</th>
                        <th>Add</th>
                    </tr>
                    <c:forEach var="employee" items="${list}">
                        <tr>
                            <td>${employee.id}</td>
                            <td>${employee.gender}</td>
                            <td>${employee.firstName}</td>
                            <td>${employee.lastName}</td>
                            <td>${employee.appointment}</td>
                            <td><input type="checkbox" name="id" id="${employee.id}" value="${employee.id}"></td>
                        </tr>
                    </c:forEach>
                    <tr><td><input type="submit" value="Create team" id="createTeamButton"></td></tr>
                </table>
            </div>
        </form>
        <script src="js/dispatcher.create.team.controller.js"></script>
    </body>
</html>
