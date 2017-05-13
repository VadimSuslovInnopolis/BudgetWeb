<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Бюджетная операция</title>
</head>
<body>

<div class="loginmodal-container" id="BudgetOperationsFormDiv">
    <form method="post" action="save">
        <input type="text" name="id" placeholder="id" style="visibility: hidden; display: none" value = "${BudgetOperation.id}" required/>
        <input type="text" name="dateOper" placeholder="Дата" value = "${BudgetOperation.dateOper}" required/>
        <input type="text" name="summa" placeholder="Сумма" value = "${BudgetOperation.summa}" required/>
        <input type="text" name="description" placeholder="Описание" value = "${BudgetOperation.description}" required/>
        <input type="submit" value="OK"/>
    </form>

</div>

</body>
</html>
