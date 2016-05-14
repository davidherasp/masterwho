<%-- 
    Document   : battleground
    Created on : 01-may-2016, 19:41:51
    Author     : david
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        <h1>Hello mates! Welcome to the Battlegorund</h1>
        <div class="myteam" style="border: 5px solid black; background-color: lightblue; padding: 10px; float: left" > 
        <c:forEach var="champ" items="${team}">
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
        </c:forEach>

        </div>
        
        <div class="enemyteam" style="border: 5px solid black; background-color: lightcoral; padding: 10px; float: left" >
            
        <c:forEach var="champ" items="${enemyTeam}">
            <div style="float: left; width: 221px; height: 400px; margin: 10px;">
                <img src="mwdorso.png" width="100%" height="100%"/>
            </div>
        </c:forEach>

        </div>
    </body>
</html>
