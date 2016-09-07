$(document).ready(function () {

    var url = "http://localhost:8080/DeMummiefabriekREST/webresources/artikel";

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
//            $("#artikellijst").append("<tr id='" + index + "'></tr>");
//                $("th#" + artikel.artikelId).append("<td>" + artikel.artikelId + "</td>");
//                $("th#" + artikel.artikelId).append("<td>" + artikel.artikelnaam + "</td>");
//                $("th#" + artikel.artikelId).append("<td>" + artikel.artikelvoorraad + "</td>");
//                $("th#" + artikel.artikelId).append("<td>" + artikel.artikelprijs + "</td>");
//        })
//    }

    //doet ook niets
    //technically : empty, then repopulate
    function getAlleArtikelen(artikelen) {
        $("#artikellijst").empty();
        $.each(artikelen, function (ignore, index) {
            $("tbody#artikellijst").append("<th id='" + index.artikelId + "'></th>");
            $("th#" + index.artikelId).append("<td>" + index.artikelId + "</td>");
            $("th#" + index.artikelId).append("<td>" + index.artikelnaam + "</td>");
            $("th#" + index.artikelId).append("<td>" + index.artikelvoorraad + "</td>");
            $("th#" + index.artikelId).append("<td>" + index.artikelprijs + "</td>");
        });
    }
} 