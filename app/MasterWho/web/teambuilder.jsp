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
    </head>
    <body>
        <h1>Yo, build ya team!</h1>
        <h2>You can't fool me, don't choose the same champ on diferent lanes! 1st advise...</h2>
        <form action="validateteam.do">
            
            Choose your toplaner:
            <select name="top">
            <c:forEach var="top" items="${toplaners}">
            
                <option value="${top.champion.ID}" data-img-src="http://ddragon.leagueoflegends.com/cdn/6.8.1/img/champion/${top.champion.key}.png)">
                    ${top.champion.name}
                </option>
                
            </c:forEach>
            </select>
            <br>
            
            Choose your jungler:
            <select name="jng">
            <c:forEach var="jng" items="${junglers}">
                
                <option value="${jng.champion.ID}" data-img-src="http://ddragon.leagueoflegends.com/cdn/6.8.1/img/champion/${jng.champion.key}.png);">
                    ${jng.champion.name}
                </option>
                
            </c:forEach>
            </select>
            <br>
            
            Choose your midlaner: 
            <select name="mid">
            <c:forEach var="mid" items="${midlaners}">
                
                <option value="${mid.champion.ID}" data-img-src="http://ddragon.leagueoflegends.com/cdn/6.8.1/img/champion/${mid.champion.key}.png);">
                    ${mid.champion.name}
                </option>
                
            </c:forEach>
            </select>
            <br>
            
            Choose your ADC:
            <select name="adc">
            <c:forEach var="adc" items="${adcs}">
                
                <option value="${adc.champion.ID}" data-img-src="http://ddragon.leagueoflegends.com/cdn/6.8.1/img/champion/${adc.champion.key}.png);">
                    ${adc.champion.name}
                </option>
                
            </c:forEach>
            </select>
            <br>
            
            Choose your support:  
            <select name="sup">
            <c:forEach var="sup" items="${supports}">
             
                <option value="${sup.champion.ID}" data-img-src="http://ddragon.leagueoflegends.com/cdn/6.8.1/img/champion/${sup.champion.key}.png);">
                    ${sup.champion.name}
                </option>

            </c:forEach>
            </select>
            <br>
            
            <input type="submit" value="Leggo"/> 
        </form>
    </body>
</html>
