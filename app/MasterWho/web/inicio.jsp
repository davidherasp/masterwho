<%-- 
    Document   : inicio
    Created on : 11-abr-2016, 17:25:12
    Author     : david
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${user.name}'s home page</title>
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    </head>
    <body>
        <h1>¡Welcome ${user.name}!</h1>
        <h2>Pick an option:</h2><br>
        <c:url var="masterWhoUrl" value="/playmasterwho.do">
            <c:param name="name" value="${user.name}"/>
            <c:param name="region" value="${user.region}"/>
        </c:url>
        <a href="${masterWhoUrl}">Let's play Master Who?!</a> 
    </body>
</html>
