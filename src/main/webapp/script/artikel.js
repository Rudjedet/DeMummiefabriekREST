$(document).ready(function () {

    var url = "http://localhost:8080/DeMummiefabriekREST/rest/artikel";

    $.ajax({
        type: 'GET',
        url: url,
        dataType: "json",
        success: function (artikelen) {
            getAlleArtikelen(artikelen);
        }
    });
    
    //empty, then repopulate
    function getAlleArtikelen(artikelen) {
        $("#artikellijst").empty();
        $.each(artikelen, function (ignore, index) {
            $("#artikellijst").append("<tr id='" + index.artikelId + "'></tr>");
            $("tr#" + index.artikelId).append("<td>" + index.artikelId + "</td>");
            $("tr#" + index.artikelId).append("<td>" + index.artikelnaam + "</td>");
            $("tr#" + index.artikelId).append("<td>" + index.artikelprijs + "</td>");
            $("tr#" + index.artikelId).append("<td>" + index.artikelvoorraad + "</td>");
        });
    }
    
}); 