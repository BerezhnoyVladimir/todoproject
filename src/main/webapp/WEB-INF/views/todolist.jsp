<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>TODO list</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a TODO
</h1>

<c:url var="addAction" value="/todo/add" ></c:url>

<form:form action="${addAction}" commandName="todo">
    <table>
        <c:if test="${!empty todo.title}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="id" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="title">
                    <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="title" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="isDone">
                    <spring:message text="is done"/>
                </form:label>
            </td>
            <td>
                <form:input path="isDone" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty todo.title}">
                    <input type="submit"
                           value="<spring:message text="Edit todo"/>" />
                </c:if>
                <c:if test="${empty todo.title}">
                    <input type="submit"
                           value="<spring:message text="Add todo"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>TODO List</h3>
<br>
<a href="/todos">All TODO</a>
<br>
<a href="/completed">Completed TODO</a>
<br>
<a href="/incompleted">Incompeted TODO</a>

<c:if test="${!empty listTodos}">
    <table class="tg">
        <tr>
            <th width="80">Todo ID</th>
            <th width="120">Todo Name</th>
            <th width="120">Is done</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listTodos}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.title}</td>
                <td>${todo.isDone}</td>
                <td><a href="<c:url value='/edit/${todo.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/remove/${todo.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>

