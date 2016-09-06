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
    
    function getAlleArtikelen() {
        $.getJSON(url, function (artikelen) {
        $.each(artikelen, function(index, artikel){
        $("#artikellijst").append("<tr id='" + index + "'></tr>");
                $("th#" + veld.artikelId).append("<td>" + veld.artikelId + "</td>");
                $("th#" + veld.artikelId).append("<td>" + veld.artikelnaam + "</td>");
                $("th#" + veld.artikelId).append("<td>" + veld.artikelvoorraad + "</td>");
                $("th#" + veld.artikelId).append("<td>" + veld.artikelprijs + "</td>");
        })
    }

//    function getAlleArtikelen(artikelen) {
//            $("#artikellijst").empty();
//            $.each(artikelen, function (index, veld) {
//                $("#artikellijst").append("<th id='" + veld.artikelId + "'></th>");
//                $("th#" + veld.artikelId).append("<td>" + veld.artikelId + "</td>");
//                $("th#" + veld.artikelId).append("<td>" + veld.artikelnaam + "</td>");
//                $("th#" + veld.artikelId).append("<td>" + veld.artikelvoorraad + "</td>");
//                $("th#" + veld.artikelId).append("<td>" + veld.artikelprijs + "</td>");
//            });
//        });
//    }
}