<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Superviser</title>

    <%-- Stylesheets --%>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/navbar-static/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<common:header/>
<br>
<br>
<c:url var="actionUrl" value="/login"/>
<main role="main" class="container">
    <div class="jumbotron">
        <h1>Business solutions</h1>
        <p class="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce vehicula dolor est, at imperdiet turpis scelerisque hendrerit. Donec quis sapien efficitur, imperdiet lacus sit amet, malesuada erat. Curabitur non rutrum tellus. Sed nisl odio, tincidunt sit amet cursus non, euismod ac enim. Nullam nec nibh vel turpis tincidunt viverra et vel lectus. Aenean sit amet est rhoncus, blandit orci sit amet, elementum ipsum. Mauris mauris risus, viverra eu nisi in, condimentum maximus nulla.</p>
        <a class="btn btn-lg btn-primary" href=${actionUrl} role="button">Log In »</a>
    </div>
</main>
<br>
<br>
<common:footer/>
<%-- Javascript --%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>