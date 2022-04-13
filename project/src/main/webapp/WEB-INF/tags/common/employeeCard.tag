<%--
  Created by IntelliJ IDEA.
  User: amosandreica
  Date: 3/5/22
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="user" type="com.iss.employer.facade.dto.UserDto" required="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="detailsUrl" value="/admin/accounts/"/>
<c:url var="deleteUrl" value="/admin/accounts/delete/"/>
<c:url var="updateUrl" value="/admin/accounts/update/"/>
<c:url var="addTaskUrl" value="/admin/tasks/add/"/>

<div class="card m-2" style="width: 18rem;">
    <div class="card-body">
        <h5 class="card-title"><c:out value="${user.firstName} ${user.lastName}"/></h5>
        <div class="card-text">
            <div><h>email: ${user.email}</h></div>
            <div><h>
            <c:choose>
                <c:when test="${user.status == 'ONLINE'}">
                    status: <b style="color:darkgreen;">ONLINE</b>
                </c:when>
                <c:otherwise>
                    status: <b style="color:red;">OFFLINE</b>
                </c:otherwise>
            </c:choose>
            </h></div>
        </div>
        <a href='${detailsUrl}${user.id}'>More Details</a>
    </div>
    <div class="card-footer">
        <div class="btn-group">
            <form:form method="get" action="${addTaskUrl}${user.id}">
                <button style="border-radius: 0" type="submit" class="btn btn-secondary">Add task</button>
            </form:form>
            <form:form method="post" action="${deleteUrl}${user.id}">
                <button style="border-radius: 0" type="submit" class="btn btn-secondary"
                        onclick="return confirm('You are about to delete the account ${user.firstName} ${user.lastName}. Are you sure?')">
                    Delete
                </button>
            </form:form>
            <form:form method="post" action="${updateUrl}${user.id}">
                <button style="border-radius: 0" type="submit" class="btn btn-secondary">Update
                </button>
            </form:form>
        </div>
    </div>
</div>
