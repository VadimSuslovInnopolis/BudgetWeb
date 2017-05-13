<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<div class="loginmodal-container" id="loginDiv">
    <form method="post" action="<c:url value='j_spring_security_check' />">
        <input type="text" name="username" placeholder="Логин" required/>
        <input type="text" name="password" placeholder="Пароль" required/>
        <input type="submit" value="login"/>
    </form>


    <a href="login/${loginError}"></a>
    <p style="color: red"><c:out value="${loginError}"/></p>

    <a href="<c:url value="/Registration" />"> Регистрация</a>

</div>
<%--<input type="hidden" name="${_csrf.parameterName}"--%>
       <%--value="${_csrf.token}" />--%>
</body>
</html>
