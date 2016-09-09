$(document).ready(function () {

    var url = "http://localhost:8080/DeMummiefabriekREST/rest/artikel";

    //GET, PUT, POST, DELETE
    
    $.ajax({
        type: 'GET',
        url: url,
        dataType: "json",
        success: function (artikelen) {
            getAlleArtikelen(artikelen);
        }
    });
    
    function nieuwArtikel(url) {
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: url,
            dataType: "application/json",
            data: toJSON(),
            success: function (data, textStatus, jqXHR) {
                alert("Het artikel is succesvol toegevoegd aan de vooorraad.");
                getArtikelen();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('Oeps! Er is iets mis gegaan.\n' + errorThrown);
                getArtikelen();
            }
        });
    }
    
    function verwijderArtikel(url) {
        $.ajax({
            type: 'DELETE',
            url: url,
            success: function (data, textStatus, jqXHR) {
                alert: ("Het artikel is succesvol verwijderd.")
                getArtikellijst();
            },
            error: function (jqXHR, textStatus, error) {
                alert: ("Oeps! Er is iets mis gegaan.\n" + error);
                getArtikellijst();
            }
        });
    }
    
    //GET artikelen, populate table
    function getAlleArtikelen(artikelen) {
        $("#artikellijst").empty();
        $.each(artikelen, function (ignoreVar, index) {
            $("#artikellijst").append("<tr id='" + index.artikelId + "'></tr>");
            $("tr#" + index.artikelId).append("<td>" + index.artikelId + "</td>");
            $("tr#" + index.artikelId).append("<td>" + index.artikelnaam + "</td>");
            $("tr#" + index.artikelId).append("<td>" + index.artikelprijs + "</td>");
            $("tr#" + index.artikelId).append("<td>" + index.artikelvoorraad + "</td>");
            $("tr#" + index.artikelId).append("<td class='verwijder'><button type='button' id='" + index.artikelId + "'>Verwijderen</button>");
        });
    }
    
    function getArtikellijst() {
        $.ajax({
            type: 'GET',
            url: url,
            dataType: "json",
            success: function (artikelen) {
                getAlleArtikelen(artikelen);
            }
        });
    }
    
    //validatie
    $("form#artikelToevoegen").validate({
        rules: {
            artikelnaam: {
                required: true,
                maxlength: 45
            },
            artikelprijs: {
                required: true,
                maxlength: 8
            },
            artikelvoorraad: {
                required: true,
                maxlength: 5
            }
        },
        messages: {
            artikelnaam: {
                required: "Een omschrijving van dit artikel is wel handig voor de klant.",
                maxlength: jQuery.validator.format("Probeer je te beperken tot een artikelnaam van niet meer dan {0} karakters.")
            },
            artikelprijs: {
                required: "Misschien moet je de klant laten weten hoe duur dit product is?",
                maxlength: jQuery.validator.format("Nou nou, dat is wel wat te duur. Geen bedragen van meer dan {0} cijfers graag.")
            },
            artikelvoorraad: {
                required: "Als we het niet op voorraad hebben, waarom probeer je het dan te verkopen?",
                maxlength: jQuery.validator.format("Jeetje, zoveel plek hebben we niet hoor. Probeer eens wat minder dan {0} karakters in te kopen.")
            }
        }
    });
    
    $("#artikelToevoegen").submit(function (event) {
        event.preventDefault();
        if ($("#artikelToevoegen").valid()) {
            nieuwArtikel(url);
            
        }
    });
    
    //Button events
    $(document).on("click", "td.verwijder button", function(event){
        event.preventDefault();
        var artUrl = url + "/" + event.target.id;
        verwijderArtikel(artUrl);
    });
    
    //Input string to JSON
    function toJSON() {
        JSON.stringify({
            "artikelnaam": $("input#artikelnaam").val(),
            "artikelprijs": $("input#artikelprijs").val(),
            "artikelvoorraad": $("input#artikelvoorraad").val()
        });
    }
}); 