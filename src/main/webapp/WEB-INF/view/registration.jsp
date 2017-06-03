<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
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
    <!-- My CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">

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
            <ul class="nav navbar-nav">
                <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                <li class="hidden">
                    <a href="#page-top"></a>
                </li>
                <li>
                    <a class="page-scroll" href="<c:url value="/index" />">To main page</a>
                </li>
                <li style="display:none;" id="hiddenLi">
                    <a class="page-scroll" href="<c:url value="/authorization" />">Sign in</a>
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
        <div class="container" id="mainDivContainer">
                    <p class="intro-text" id="informationP"></p>
                    <form id="registrationForm" name="loginForm" method="POST" action="">REGISTRATION USER
                        <p>
                            <input class="inputEnter" type="text" name="login" id="login" placeholder="Create a login" value="" maxlength="22">
                            <i class="icon-user icon-large"></i>
                        </p>
                        <p class="field">
                            <input class="inputEnter" type="password" name="password" id="password" placeholder="Create a password" value="" maxlength="22">
                            <i class="icon-lock icon-large"></i>
                        </p>
                        <p class="field">
                            <input class="inputEnter" type="text" name="mail" id="mail" placeholder="Your email address" value="" maxlength="22">
                            <i class="icon-lock icon-large"></i>
                        </p>
                        <p>
                            <input type="submit" id="submitButton" class="submitButton" value="Registration"/>
                        </p>
                    </form>
        </div>
    </div>
</header>

<!-- Footer -->
<footer>
    <div class="container text-center">
        <p>Copyright &copy; Artyom Artemyev</p>
    </div>
</footer>

<!-- My scrby.netcracker.artemyev.airline.controllerller -->
<script src="${pageContext.request.contextPath}/resources/js/registration.controller.js" type="text/javascript"></script>

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.js" type="text/javascript"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.js" type="text/javascript"></script>

<!-- Plugin JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.js" type="text/javascript"></script>

<!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>

<!-- Theme JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/grayscale.js" type="text/javascript"></script>


</body>

</html>
