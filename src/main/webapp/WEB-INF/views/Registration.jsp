<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h1>Регистрация</h1><br>
    <form method="post" action="/budget/RegistrationUser">
    <input type="text" name="secondName" placeholder="Фамилия" required>
        <input type="text" name="firstName" placeholder="Имя" required>
        <input type="text" name="login" placeholder="Логин" required minlength="7">
        <input type="password" name="pass" placeholder="Пароль" required minlength="7">
        <input type="submit" name="register" value="Зарегистрировать">
    </form>
</body>
</html>
