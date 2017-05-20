<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main administrator page</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

    <!-- Theme CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/grayscale.css" rel="stylesheet" type="text/css">
    <!-- My style CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">

    <!-- JQuery -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.js"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

<!-- Navigation -->
<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                Menu <i class="fa fa-bars"></i>
            </button>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
            <ul class="nav navbar-nav" >
                <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                <li class="hidden">
                    <a href="#page-top"></a>
                </li>
                <li style="display:none;" id="hiddenLi">
                    <a class="page-scroll" href="<c:url value="/airline/flight/management" />">Flight management</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Intro Header -->
<header class="intro">
    <div class="intro-body">
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div align="center" id="contentDiv">
                        <p class="intro-text" id="informationP"><br></p>
                        <table id="adminTable" class="table_dark" align="center">
                            <caption>FLIGHT MANAGEMENT</caption>
                            <tr>
                                <th colspan="3">Navigation flight</th>
                                <th colspan="2">Add</th>
                            </tr>
                            <tr>
                                <form method="" action="" id="addForm">
                                    <td colspan="2">
                                        <input type="text" name="navigation" id="navigation" value="">
                                    </td>
                                    <td colspan="3">
                                        <input type="submit" value="Add flight" id="addButton" class="myButtonStyle2">
                                    </td>
                                </form>
                            </tr>

                            <tr>
                                <th>Id</th>
                                <th>Navigation</th>
                                <th>TeamId</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            <form action="" id="flightForm">
                                <c:forEach var="flight" items="${flights}">
                                    <tr id="tr${flight.id}">
                                        <td>${flight.id}</td>
                                        <td>${flight.navigation}</td>
                                        <td>${flight.team.id}</td>
                                        <td><input type="submit" onclick="editButtonClickHandler(event)" value="Edit flight" id="edit${flight.id}" class="myButtonStyle1"></td>
                                        <td><input type="submit" onclick="deleteButtonClickHandler(event)" value="Delete flight" id="${flight.id}" class="myButtonStyle3"></td>
                                    </tr>
                                </c:forEach>
                            </form>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- About Section -->
<section id="about" class="container content-section text-center">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
            <h2>About ArtAirline</h2>
            <p>ArtAirline is one of the trustworthy airline company in the world. You can trust us</p>
        </div>
    </div>
</section>

<!-- Footer -->
<footer>
    <div class="container text-center">
        <p>Copyright &copy; Artyom Artemyev</p>
    </div>
</footer>

<!--My script controller-->
<script src="${pageContext.request.contextPath}/resources/js/administrator.main.controller.js" type="text/javascript"></script>
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.js" type="text/javascript"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.js" type="text/javascript"></script>

<!-- Plugin JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js" type="text/javascript"></script>

<!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>

<!-- Theme JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/grayscale.js" type="text/javascript"></script>

</body>
</html>