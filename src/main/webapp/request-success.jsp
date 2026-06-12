
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Успех</title>
</head>
<body>
<h2>Заявка успешно сохранена!</h2>

<p><strong>Имя:</strong> ${sessionScope.savedName}</p>
<p><strong>Email:</strong> ${sessionScope.savedEmail}</p>
<p><strong>Сообщение:</strong> ${sessionScope.savedMessage}</p>

<br>
<a href="${pageContext.request.contextPath}/save-request.jsp">Оформить новую заявку</a>
</body>
</html>
