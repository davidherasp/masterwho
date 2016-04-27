<%-- 
    Document   : masterwho
    Created on : 23-abr-2016, 0:49:47
    Author     : david
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Master Who?!</title>
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        <h1>Here you are!</h1>
        <h2>These are your champions sorted descendingly by the mastery points</h2>
        <c:forEach var="champ" items="${champs}">
            <%--ID: ${champ.id} Level: ${champ.level} Points: ${champ.points} Name: ${champ.name}<br>
            http://ddragon.leagueoflegends.com/cdn/img/champion/loading/${champ.key}_0.jpg
            http://ddragon.leagueoflegends.com/cdn/6.8.1/img/champion/${champ.key}.png
            <div class="w3-card-12 w3-margin" style="width:10%; float: left">
                <img src="http://ddragon.leagueoflegends.com/cdn/img/champion/loading/${champ.champion.key}_0.jpg" alt="${champ.champion.name} photo" style="width:100%">
                <div class="w3-container w3-center">
                    <p>Level: ${champ.championMastery.championLevel}</p>
                    <p>Points: ${champ.championMastery.championPoints}</p>
                </div>
            </div>   --%>            
            <div class="flip-container" ontouchstart="this.classList.toggle('click');">
                <div class="flipper">
                    <div class="front">
                        <!-- front content -->
                        <img src="http://ddragon.leagueoflegends.com/cdn/img/champion/loading/${champ.champion.key}_0.jpg" alt="${champ.champion.name} photo" style="width: 100%; heigth: 100%;">
                    </div>
                    <div class="back">
                        <!-- back content -->
                        <img src="http://ddragon.leagueoflegends.com/cdn/6.8.1/img/champion/${champ.champion.key}.png" alt="${champ.champion.name} avatar">
                        <div class="bcontainer">
                            <p>${champ.champion.name} "${champ.champion.title}"</p>
                            <p>Role: ${champ.champion.tags}
                            <p>Level: ${champ.championMastery.championLevel}</p>
                            <p>Points: ${champ.championMastery.championPoints}</p>
                        </div>
                    </div>
                </div>
            </div>
            <%--<div class="polaroid" style="width: 200px;">
                <img src="http://ddragon.leagueoflegends.com/cdn/img/champion/loading/${champ.champion.key}_0.jpg" alt="${champ.champion.name} photo" style="width: 100%; heigth: 100%;">
                <div class="container">
                    <p>${champ.champion.name}</p>
                    <p>"${champ.champion.title}"</p>
                    <p>Level: ${champ.championMastery.championLevel}</p>
                    <p>Points: ${champ.championMastery.championPoints}</p>
                </div>
            </div>--%> 
        </c:forEach>
    </body>
</html>
