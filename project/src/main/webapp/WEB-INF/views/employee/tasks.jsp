<%--
  Created by IntelliJ IDEA.
  User: amosandreica
  Date: 3/5/22
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<% response.addHeader("Refresh","10"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<!DOCTYPE html>
<html>
<head>
    <title>${not empty title ? title : "Inventory"}</title>
    <%-- Stylesheets --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<common:headerEmployee/>
<div class="container">
    <h2 class="text-center m-3">All tasks</h2>

    <div class="d-flex mt-5">
        <c:forEach var="task" items="${tasks}" >
            <common:taskCardEmployee task="${task}"/>
        </c:forEach>
    </div>


</div>
<common:footer/>
<%-- Javascript --%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>


