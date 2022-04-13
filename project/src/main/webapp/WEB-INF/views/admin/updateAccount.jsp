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
  <title>${not empty title ? title : "Update an Employee Account"}</title>
  <%-- Stylesheets --%>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<c:url var="actionUrl" value="/admin/accounts/update"/>
<common:headerAdmin/>

<div class="mx-auto p-3" style="width:50%">
  <div class="col-12 col-sm-6 col-md-5 col-lg-4" style="width: 100%">

    <hr class="mt-3 mb-3"/>
    <h1 class="text-primary text-center">Update Account</h1>
    <hr class="mt-3 mb-3"/>
    <br>

    <div class="mx-auto card" style="width: 80%">
      <div class="card-body">

        <form:form method="post" action="${actionUrl}" modelAttribute="user">
          <div class="mb-3">
            <form:input path="id" type="hidden" class="form-control" id="id" name="id" value="${user.id}"/>
          </div>
          <div class="mb-3">
            <label for="employeeFName" class="form-label">First Name</label>
            <form:input type="text" class="form-control" id="employeeFName" name="employeeFName" path="firstName" value="${user.firstName}" required="true"/>
          </div>
          <div class="mb-3">
            <label for="employeeLName" class="form-label">Last Name</label>
            <form:input type="text" class="form-control" id="employeeLName" name="employeeLName" path="lastName" value="${user.lastName}" required="true"/>
          </div>
          <div class="mb-3">
            <label for="employeeEmail" class="form-label">Email</label>
            <form:input type="text" class="form-control" id="employeeEmail" name="employeeEmail" path="email" value="${user.email}" required="true"/>
          </div>
          <div class="mb-3">
            <label for="employeePassword" class="form-label">Password</label>
            <form:input type="password" class="form-control" id="employeePassword" name="employeePassword" path="password" required="true"/>
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

