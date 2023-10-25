# NoSQL Exercise

## Opdracht

In een notendop: kies een NoSQL database en migreer naar de API naar die database.

### Ok, iets meer details

In dit project vind je een API gebaseerd op het datamodel dat we toevallig in de Modelling cursus van jaar 1 tegenkwamen.
Er is hier een Postgres JPA koppeling mee gemaakt. Daar kun je een beetje afkijken wat de bedoeling is.

In de POM van de API zie je meerdere mogelijke koppelingen. Na uitchecken staat de dependency op Postgres, maar dat zul
je dus moeten omswitchen naar je gekozen database.

Daarna kun je evt. de andere modules verwijderen (mocht je je ooit bedenken: versiebeheer!).

### Database

Voor elke database is er een stukje in de docker-compose file beschikbaar. Voor elke database behalve Scylla is een GUI 
container beschikbaar (maar wel een IntelliJ plugin). 

Een aantal eigenaardigheden per database:

#### MongoDB

MongoDB draait eigenlijk vrij standaard, geen bijzonderheden. De GUI container draait op http://localhost:9092, er is geen gebruikersnaam of wachtwoord.

#### Neo4J

Neo4J heeft (voor zover gevonden) geen goede manier om bij het opstarten van de container alvast wat dummy-data in te laden.
Je zult na het starten van de container het cyper-scriptje dus met de hand in de GUI moeten knippen/plakken (als je de 
hello-world wil draaien).

Neo4J heeft geen aparte GUI container, want de GUI draait gewoon op de container zelf (http://localhost:9093). Je hoeft
geen gebruikersnaam of wachtwoord in te vullen.
Op de (gratis) Community editie kun je geen aparte databases aanmaken.

CSV import bestanden moeten op de container in de /import directory staan. Is een hard-coded regel in Neo4J.

#### Redis

Redis is echt niet geschikt als 'algemene database', dus je zult echt creatief moeten hacken en aanklooien om dit voor elkaar
te krijgen. Da's uitdagend, maar misschien alleen als je dat soort dingen leuk vindt. De GUI container draait op http://localhost:9094.

Bij het connecten hoef je geen gebruikersnaam of wachtwoord in te vullen, en de 'name' parameter is puur voor jezelf.

#### Scylla

Scylla (een Cassandra kloon) is niet voor de faint of heart. Er is geen prettige tooling beschikbaar, dus je zult met de commandline
aan de slag moeten om de database rauw te kunnen benaderen (er is een IntelliJ database connector die je zou kunnen proberen).

### Data

Voor de SQL-database is er een import scriptje beschikbaar, maar voor de andere databases niet. Logisch want je moet zelf
het model bedenken. Hoe krijg je dan die data er in? Er zijn een aantal opties:

* Je gebruikt de meegeleverde CSV bestanden. Mongo & Neo hebben bijv. vrij handige import-tooltjes.
* Een andere optie is met de CSV-files en een Java import-class. Daarvoor staat in common wat voorbeeldcode klaar die je
  evt. in je eigen database project kan importeren.
* Je kunt het ook gewoon negeren en zelf je eigen dummy-data hetzij via de database gui, of via een stukje java-code erin pompen

Kortom data is handig in dit geval, maar het belangrijkste punt blijft het datamodel.

## Opvallende zaken

Je ziet dat in Common nu los de service-laag met DTOs staat. Op zich is dat een beetje teleurstellend, aangezien we natuurlijk 
juist hebben geleerd dat we met zo'n repository-pattern 'probleemloos' van database kunnen switchen. 

Je ziet dat de werkelijkheid iets complexer is, maar het is zeker een aanrader dit probleem wat netter proberen op te lossen!
Het probleem is dat een XYZRepository een afhankelijkheid heeft op een XYZ class. En die XYZ class heeft weer per database
net andere structuren en annotaties nodig om netjes als repository-entity voor die database te kunnen functioneren.

Ik denk dat je een heel eind zou kunnen komen door puur op CRUD-repository te focussen, maar dan verlies je ook gelijk wat
jouw database zou wel/niet geschikt maakt, dus dat is voor deze oefening een beetje zonde.
