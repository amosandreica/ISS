<%--
  Created by IntelliJ IDEA.
  User: amosandreica
  Date: 3/5/22
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
  <title>${not empty title ? title : "404"}</title>
  <%-- Stylesheets --%>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<c:url var="actionUrl" value="/"/>
<div class="page-wrap d-flex flex-row align-items-center">
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-12 text-center">
        <span class="display-1 d-block">404</span>
        <div class="mb-4 lead">The page you are looking for was not found.</div>
        <a href="${actionUrl}" class="btn btn-link">Back to Home</a>
      </div>
    </div>
  </div>
</div>
<common:footer/>

</body>
</html>

