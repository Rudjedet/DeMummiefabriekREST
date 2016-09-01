MUMMIEFABRIEK APPLICATIE

LOGIN.XHTML

* inlogfunctie --> verwijst naar INLOGGELUKT.XHTML
* nieuwe klant --> verwijst naar REGISTREREN.XHTML

REGISTREREN.XHTML

* registratiefunctie (= aanmaak nieuwe klant + adres + account) --> verwijst naar REGISTRATIEGESLAAGD.XHTML

INLOGGELUKT.XHTML

* knop NAAR ARTIKELEN --> verwijst naar ARTIKELEN.XHTML
* knop NAAR ACCOUNT --> verwijst naar ACCOUNT.XHTML

REGISTRATIEGESLAAGD.XHTML

* "Registratie geslaagd. Log hier in."
* inlogfunctie --> verwijst naar INLOGGELUKT.XHTML

ARTIKELEN.XHTML

* lijst met artikelen in database (zie huidige index.xhtml voor code)
* knop PAS ARTIKELEN AAN --> verwijst naar EDITARTIKEL.XHTML
* knop VOEG TOE AAN BESTELLING voor elk artikel (= schrijft weg naar besteldartikel tabel)

EDITARTIKEL.XHTML

* vraagt welk artikel aangepast moet worden (op basis van ID)
* invoervelden met naam, prijs, voorraad

ACCOUNT.XHTML

* NAW-gegevens
* knop PAS KLANTGEGEVENS AAN --> verwijst naar EDITKLANT.XHTML
* knop PAS ADRESGEGEVENS AAN --> verwijst naar EDITADRES.XHTML
* Tabel bestellingen (met ID)
* knop BEKIJK EEN BESTELLING --> verwijst naar KLANTBESTELLING.XHTML 

EDITKLANT.XHTML

* invoervelden naam, achternaam, emailadres (accountnaam kan niet aangepast worden) --> verwijst terug naar ACCOUNT.XHTML wanneer gelukt

EDITADRES.XHTML

* invoervelden straatnaam etc. --> verwijst terug naar ACCOUNT.XHTML wanneer gelukt

KLANTBESTELLING.XHTML

* invoerveld voor bestelling ID
* Tabel met artikelen in deze bestelling + totaalprijs
* knop PAS BESTELLING AAN --> verwijst naar EDITBESTELLING.XHTML
* knop VERWIJDER BESTELLING (= verwijdert bestelling uit database) --> refresht pagina KLANTBESTELLING.XHTML met geupdate db informatie

EDITBESTELLING.XHTML

* invoervelden met artikelnaam & aantal --> verwijst terug naar KLANTBESTELLING.XHTML wanneer gelukt

LOGOUT.XHTML

* logt klant uit --> verwijst terug naar LOGIN.XHTML wanneer gelukt
