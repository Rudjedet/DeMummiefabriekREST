$(document).ready(function () {

    var url = "http://localhost:8080/DeMummiefabriekREST/rest/artikel";
    
    var trHTML = ' ';

    $.ajax({
        type: 'GET',
        url: url,
        dataType: "json",
        success: function (artikelen) {
            getAlleArtikelen(artikelen);
        }
    });
    
    //doet niets
//    function getAlleArtikelen() { 
//        $.getJSON(url, function (artikelen) {
//        $.each(artikelen, function(index, artikel){
//        $("#artikellijst").append("<tr id='" + index + "'></tr>");
//                $("th#" + artikel.artikelId).append("<td>" + artikel.artikelId + "</td>");
//                $("th#" + artikel.artikelId).append("<td>" + artikel.artikelnaam + "</td>");
//                $("th#" + artikel.artikelId).append("<td>" + artikel.artikelvoorraad + "</td>");
//                $("th#" + artikel.artikelId).append("<td>" + artikel.artikelprijs + "</td>");
//        })
//    }

    //doet ook niets
    function getAlleArtikelen(artikelen) { 
            $("#artikellijst").empty();
            $.each(artikelen, function (index, veld) {
                $("#artikellijst").append("<th id='" + veld.artikelId + "'></th>");
                $("th#" + veld.artikelId).append("<td>" + veld.artikelId + "</td>");
                $("th#" + veld.artikelId).append("<td>" + veld.artikelnaam + "</td>");
                $("th#" + veld.artikelId).append("<td>" + veld.artikelvoorraad + "</td>");
                $("th#" + veld.artikelId).append("<td>" + veld.artikelprijs + "</td>");
            });
        });
    }

}