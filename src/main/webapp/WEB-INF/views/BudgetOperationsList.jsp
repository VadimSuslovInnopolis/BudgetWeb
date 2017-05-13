<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.04.2017
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BudgetOperations</title>

    <style>
        table,th,td
        {
            /*border:1px solid black;*/
        }
    </style>
</head>
<body>
<%--<input onclick="location.href='<c:url value="/j_spring_security_logout" />'" type="submit" value="logout" style="float: right;">--%>
<input onclick="location.href='<c:url value="/logout" />'"   class="login loginmodal-submit" type="submit" value="logout" style="float: right;">
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>DateOper</th>
        <th>Budget</th>
        <th>Summa</th>
        <th>Description</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${BudgetOperations}" var="BudgetOperation">
        <tr>
            <td>ra<c:out value="${BudgetOpetion.id}"></c:out></td>
            <td><c:out value="${BudgetOperation.dateOper}"></c:out></td>
            <td><c:out value="${BudgetOperation.budget}"></c:out></td>
            <td><c:out value="${BudgetOperation.summa}"></c:out></td>
            <td><c:out value="${BudgetOperation.description}"></c:out></td>
            <td><a href="${pageContext.request.contextPath}/BudgetOperationsForm/edit?id=${BudgetOperation.id}">Редактировать</a>  <a href="${pageContext.request.contextPath}/BudgetOperationsForm/delete?id=${BudgetOperation.id}" onclick="if (!confirm('Are you sure?')) return false;">Удалить</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="${pageContext.request.contextPath}/BudgetOperationsForm/add">Добавить</a></p>
</body>
</html>