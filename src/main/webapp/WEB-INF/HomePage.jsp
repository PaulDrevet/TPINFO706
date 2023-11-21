<jsp:useBean id="tickets" scope="request" type="java.util.ArrayList"/>
<%--
  Created by IntelliJ IDEA.
  User: dupas
  Date: 19/11/2023
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <a href="../index.jsp">Retour à l'accueil</a><span style="width: 20px;"></span><title>Les Tickets :</title>
</head>
<body>
    <p>
        ${tickets}
    </p>
</body>
</html>
