<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Superviser</title>

    <%-- Stylesheets --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<common:headerAdmin/>

<div class="container">
    <div class="d-flex mt-5">
        <div class="card m-2" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">Add Employee Account</h5>
                <p class="card-text">Add a new employee account and start monitoring your prodution.</p>
            </div>
            <div class="card-footer">
                <a href="<c:url value="/admin/accounts/add/"/>" class="btn btn-primary">Add account</a>
            </div>
        </div>

        <div class="card m-2" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">See your employees</h5>
                <p class="card-text">You want to see a list of your employees accounts? You're in the right place, click here.</p>
            </div>
            <div class="card-footer">
                <a href="<c:url value="/admin/accounts/"/>" class="btn btn-primary">Accounts list</a>
            </div>
        </div>
    </div>
</div>

<common:footer/>
<%-- Javascript --%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
