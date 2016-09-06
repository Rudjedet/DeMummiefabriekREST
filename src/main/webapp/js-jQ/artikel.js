$(document).ready(function(){
var url = "http://localhost:8080/DeMummiefabriekREST/rest/artikel";

//    getArtikellijst();
//    
//    function getArtikellijst() {
//        $.getJSON(url, function(result){
//            $.each(result, function(index, artikel){
//                $("table#artikellijst").append("<td id='" + index + "'>" +
//                  artikel.artikelnaam + "</td>");
//            });
//        });
//    }

    $.ajax({
        type: 'GET',
        url: url,
        dataType: "json",
        success: function(data){
            showAlleArtikelen(data);
        }
    });
    
    function leesArtikelen(artikelen) {
        $.ajax({
            type: 'GET',
            url: url,
            dataType: "json",
            success: function (data) {
                showAlleArtikelen(data);
            }
        });
    }

    function showAlleArtikelen(artikelen){
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