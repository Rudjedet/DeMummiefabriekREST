$(document).ready(function(){
var url = "http://localhost:8080/DeMummiefabriekREST/rest/artikel";

    $.ajax({
        type: 'GET',
        url: url,
        dataType: "json",
        success: function(data){
            getAlleArtikelen(data);
        }
    });

    function getAlleArtikelen(artikelen){
        $("#artikellijst").empty();
        $.each(artikelen, function(index, veld){
            $("#artikellijst").append("<tr id='" + veld.artikelId + "'></tr>");
            $("tr#" + veld.artikelId).append("<td>" + veld.artikelId + "</td>");
            $("tr#" + veld.artikelId).append("<td>" + veld.artikelnaam + "</td>");
            $("tr#" + veld.artikelId).append("<td>" + veld.artikelvoorraad + "</td>");
            $("tr#" + veld.artikelId).append("<td>" + veld.artikelprijs + "</td>");
        });
    }

}