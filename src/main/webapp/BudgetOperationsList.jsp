<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.04.2017
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BudgetOperations</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <style>
        table,th,td
        {
            /*border:1px solid black;*/
        }
    </style>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>DateOper</th>
        <th>Budget</th>
        <th>Summa</th>
        <th>Decription</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.BudgetOperations}" var="BudgetOperation">
        <tr>
            <td><c:out value="${BudgetOperation.id}"></c:out></td>
            <td><c:out value="${BudgetOperation.dateOper}"></c:out></td>
            <td><c:out value="${BudgetOperation.budget}"></c:out></td>
            <td><c:out value="${BudgetOperation.summa}"></c:out></td>
            <td><c:out value="${BudgetOperation.description}"></c:out></td>
            <td><a href="${pageContext.request.contextPath}/BudgetOperations/?edit=${BudgetOperation.id}">Редактировать</a>  <a href="${pageContext.request.contextPath}/budgetoperations/?delete=${BudgetOperation.id}" onclick="if (!confirm('Are you sure?')) return false;">Удалить</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="${pageContext.request.contextPath}/BudgetOperations/?add=1">Добавить</a></p>
</body>
</html>