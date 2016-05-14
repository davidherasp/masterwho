<%-- 
    Document   : teambuilder
    Created on : 26-abr-2016, 23:46:53
    Author     : david
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teambuilder</title>
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        
        <h1>Yo, here's ya team! You want to play against?</h1>
        <form action="validateteam.do">
            <input name="name" type="text"></input>    
            <select name="region">
                <option value="EUW">EU West</option>
                <option value="EUNE">EU North East</option>
                <option value="NA">North America</option>
                <option value="LAN">Latino America Norte</option>
                <option value="LAS">Latino America Sur</option>
            </select>
            <input type="submit" value="Leggo"/>
        </form> 
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
        <div class="flip-container" ontouchstart="this.classList.toggle('click');">
            <div class="flipper">
                <div class="front" style=" background-color: pink; border: 5px solid black">
                    <!-- front content -->
                    <img src="http://ih0.redbubble.net/image.30120000.6548/sticker,375x360.u4.png" alt="pink ward photo" style="width: 100%; heigth: 100%;" >
                </div>
                <div class="back">
                    <!-- back content -->
                    <img src="http://ddragon.leagueoflegends.com/cdn/6.9.1/img/item/2043.png" alt="pink ward item" style="width: 120px; height: 120px; border: 5px solid black;">
                    <div class="bcontainer">
                        <p>Pink ward</p>
                        <p>It will reveal the opponent's card you choose</p>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </body>
</html>
