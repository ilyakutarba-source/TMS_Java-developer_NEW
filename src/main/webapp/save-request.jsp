
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заявка</title>
</head>
<body>
<h2>Оформить заявку</h2>
    <!-- Если пришли обратно из-за ошибки, покажем сообщение -->
    ${not empty errorMsg ? '<p style="color:red">' : ''}${errorMsg}${not empty errorMsg ? '</p>' : ''}
    <form action="${pageContext.request.contextPath}/save-request" method="post">
        <label>Имя:
            <input type="text" name="name" value="${param.name}">
        </label><br><br>
        <label>Email:
            <input type="email" name="email" value="${param.email}">
        </label><br><br>

        <label>Сообщение:
            <textarea name="message" rows="4" cols="40">${param.message}</textarea>
        </label><br><br>

        <button type="submit">Отправить</button>
    </form>

</body>
</html>
