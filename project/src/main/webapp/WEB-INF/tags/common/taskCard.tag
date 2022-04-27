<%--
  Created by IntelliJ IDEA.
  User: amosandreica
  Date: 3/5/22
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="task" type="com.iss.employer.facade.dto.TaskDto" required="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="detailsUrl" value="/admin/accounts/"/>
<c:url var="deleteUrl" value="/admin/accounts/delete/"/>
<c:url var="updateUrl" value="/admin/accounts/update/"/>
<c:url var="addTaskUrl" value="/admin/tasks/add/"/>

<div class="card m-2" style="width: 18rem;">
    <div class="card-body">
        <h5 class="card-title"><c:out value="${task.title}"/></h5>
        <div class="card-text">
            <div><h>assignee: ${task.assignee.firstName} ${task.assignee.lastName}</h></div>
            <div><h>
                <c:choose>
                    <c:when test="${task.status == 'PENDING'}">
                        status: <b style="color:darkgreen;">PENDING</b>
                    </c:when>
                    <c:otherwise>
                        status: <b style="color:red;">DONE</b>
                    </c:otherwise>
                </c:choose>
            </h></div>
            <div><h>description: ${task.description}</h></div>
        </div>
    </div>
</div>
