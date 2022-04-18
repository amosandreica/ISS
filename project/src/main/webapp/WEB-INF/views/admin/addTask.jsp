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
    <title>${not empty title ? title : "Add a new Task"}</title>
    <%-- Stylesheets --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<c:url var="actionUrl" value="/admin/tasks/add"/>
<common:headerAdmin/>

<div class="mx-auto p-3" style="width:50%">
    <div class="col-12 col-sm-6 col-md-5 col-lg-4" style="width: 100%">

        <hr class="mt-3 mb-3"/>
        <h1 class="text-primary text-center">Assign a new task</h1>
        <hr class="mt-3 mb-3"/>
        <br>

        <div class="mx-auto card" style="width: 80%">
            <div class="card-body">

                <form:form method="get" action="${actionUrl}" modelAttribute="task">
                    <div class="mb-3">
                        <label for="title" class="form-label">Task Title</label>
                        <form:input type="text" class="form-control" id="title" name="title" path="title" required="true"/>
                    </div>
                    <div class="mb-3">
                        <label for="description" class="form-label">Task Description</label>
                        <form:input type="text" class="form-control" id="description" name="description" path="description" required="true"/>
                    </div>
                    <div class="mb-3">
                        <form:label path="assignee">Select an employee:&nbsp;&nbsp;&nbsp;</form:label>
                        <form:select path="assignee.id" >
                            <c:forEach items="${users}" var="user">
                                <form:option value="${user.id}" selected="${task.assignee.id == user.id ? 'true' : 'false'}">${user.firstName} ${user.lastName}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form:form>
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

