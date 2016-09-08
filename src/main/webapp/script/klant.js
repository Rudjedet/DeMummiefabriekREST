$(document).ready(function () {

    var url = "http://localhost:8080/DeMummiefabriekREST/rest/klant";

    $.ajax({
        type: 'GET',
        url: url,
        dataType: "json",
        success: function (klanten) {
            getAlleKlanten(klanten);
        }
    });
    
    //empty, then repopulate
    function getAlleKlanten(klanten) {
        $("#klantgegevens").empty();
        $.each(klanten, function (ignore, index) {
            $("#klantgegevens").append("<tr id='" + index.klantId + "'></tr>");
            $("tr#" + index.klantId).append("<td>" + index.klantId + "</td>");
            $("tr#" + index.klantId).append("<td>" + index.voornaam + "</td>");
            $("tr#" + index.klantId).append("<td>" + index.achternaam + "</td>");
            $("tr#" + index.klantId).append("<td>" + index.emailadres + "</td>");
        });
    }
    
}); 