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
        $.each(artikelen, function (ignoreVar, index) {
            $("#artikellijst").append("<tr id='" + index.artikelId + "'></tr>");
            $("tr#" + index.artikelId).append("<td>" + index.artikelId + "</td>");
            $("tr#" + index.artikelId).append("<td>" + index.artikelnaam + "</td>");
            $("tr#" + index.artikelId).append("<td>" + index.artikelprijs + "</td>");
            $("tr#" + index.artikelId).append("<td>" + index.artikelvoorraad + "</td>");
            $("tr#" + index.artikelId).append("<td id='verwijder'><button type='button' id='"+ index.artikelId + "'>Verwijderen</button>");
        });
    }
    
    function getArtikelen() {
        $.ajax({
            type: 'GET',
            url: url,
            dataType: "json",
            success: function (artikelen) {
                getAlleArtikelen(artikelen);
            }
        });
    }
    
    $(document).on("click", "td#verwijder button", function(event){
        var artUrl = url + "/" + event.target.id;
        verwijderArtikel(artUrl);
    });
    
    function verwijderArtikel() {
        $.ajax({
            type: 'DELETE',
            url: url,
            success: function (data, textStatus, jqXHR) {
                getArtikelen();
                alert: ("Het artikel is succesvol verwijderd.")
            },
            error: function (jqXHR, textStatus, error) {
                alert: ("Oeps! Er is iets mis gegaan.\n" + error);
            }
        });
    }
    
}); 