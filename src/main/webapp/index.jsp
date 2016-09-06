<%-- 
    Document   : index
    Created on : 6-sep-2016, 9:00:11
    Author     : Sonja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/mummiefabriekmain.css" />
        <title>De Mummiefabriek</title>
    </head>
    <body>  
        <div id="header">
            <span class="MummieFabriekTekst">De Mummiefabriek</span>
        </div>

        <div id="indexIntroductieLinks">
            <h1>Welkom bij <br>de Mummiefabriek!</h1>
        </div>

        <div id="indexInhoudMidden">

            <table id="productTable">

                <c:forEach var="artikel" items="${artikelen}" varStatus="iter">

                    <tr class="${((iter.index % 2) == 0) ? 'wood' : 'white'}">
                        <td>
                            <img src="${initParam.productImagePath}${artikel.artikelnaam}.png"
                                 alt="${artikel.artikelnaam}" />
                        </td>

                        <td>
                            ${artikel.artikelnaam}
                            <br>
                            <span class="smallText">${artikel.artikelnaam}</span>
                        </td>

                        <td>&euro; ${artikel.artikelprijs}</td>

                    </tr>

                </c:forEach>

            </table>

        </div>

        <div id="footer">
            © 2016, <span class="companyName">Khufu &amp; Dochters</span>
        </div>
    </body>
</html>
