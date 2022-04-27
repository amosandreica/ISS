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

<c:url var="updateUrl" value="/employee/tasks/update/"/>

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
                <form:form method="post" action="${updateUrl}${task.id}">
                    <button style="border-radius: 0" type="submit" class="btn btn-secondary"
                            onclick="return confirm('You are about to change the status to DONE. Are you sure?')">
                        Mark as Done
                    </button>
                </form:form>
            </h></div>
            <div><h>description: ${task.description}</h></div>
        </div>
    </div>
</div>
