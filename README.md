# ehb-java-frameworks-werkcolleges-spring-core
Werkcollege voor het vak Java Frameworks les Spring Core aan de Erasmushogeschool Brussel

## Oefening 3.1: Stereotype annotatie configuratie

Controleer of je oplossing van oefening 2 overeenkomt met de inhoud van de oefening3 branch. Indien dit niet zo is, probeer dan te begrijpen waarom iets op een andere manier is gedaan. In de oplossing zijn 2 BlogSquare configuratieklassen gemaakt om het verschil tussen oplossing 2.1 en oplossing 2.2 te tonen. Je mag de BlogSquare22 klasse nu terug verwijderen. Verwijder  de BlogSquareDaoConfig klasse en alle @Bean geannoteerde methodes in de BlogSquare(21) klasse. We gaan onze applicatie opnieuw configureren aan de hand van component scanning en annotatie configuratie. Maak deze keer gebruik van stereotype annotaties om de intentie van de bean duidelijk te maken.
Verifier of je applicatie nog steeds werkt en dezelfde output geeft. 

## Oefening 3.2: 2de DAO implementatie, lifecycle methode en meerdere qualifying beans
Schrijf een 2de (fake) implementatie van de UserDao. Deze implementatie maakt achterliggend gebruik van een HashMap om de data in op te slaan. Als key gebruik je een Integer, als value gebruik je een User. Wanneer deze bean wordt aangemaakt, moet deze database automatisch worden opgevuld met de 2 gebruikers die momenteel in onze main functie staan. Gebruik hiervoor een een bean lifecycle methode.
 
Annoteer deze klasse nu ook met een stereotype annotatie. Wanneer je het programma wilt runnen, zal je zien dat dit meteen crashed. Waarom? Los dit eerst op door gebruik te maken van @Qualifier . Eens dit gelukt is, verwijder je de @Qualifier annotatie opnieuw en los je dit opnieuw op door gebruik te maken van @Primary. 

## Oefening 3.3: Externe eigenschappen inlezen
Momenteel staat onze connectie url, username en wachtwoord hardcoded in de DatabaseProperties klasse. Vaak is dit niet wat we willen. We willen geen wachtwoorden committen in Git. Vaak willen we ook de flexibiliteit om de credentials van een database te kunnen wijzigen, zonder code aan te passen. Op die manier kan onze code werken met meerdere databases en kan deze zelfde code dus gedeployed worden op meerdere omgevingen, elk met hun eigen database. Plaats je database eigenschappen (url, username en wachtwoord) in de application.properties file. Lees vervolgens deze waarden in, in de DatabaseProperties klasse zodat je applicatie blijft werken zoals ervoor. Tot slot, wat dan vaak wordt gedaan, is deze file in de .gitignore toevoegen zodat je credentials niet mee gecommit worden. Er wordt dan vaak een 2de file voorzien (bijvoorbeeld genaamd application.properties.example) die toont welke keys moeten worden ingevuld door een gebruiker die deze code uitchecked. Die gebruiker zal dan zijn eigen application.properties file moeten maken en alle key/value paren invullen. 

Note: Spring laat niet toe values te injecteren in statische properties (en zeker ook geen final hint hint). Om dit op te lossen kan je een niet statische setter makken met de @Value annotatie boven. Voor meer informatie: https://mkyong.com/spring/spring-inject-a-value-into-static-variables/

## Oefening 3.4: Profiles
Maak een development en een production profile. Het development profiel moet gebruik maken van de FakeUserDao, het productie profiel moet gebruiken maken van UserDaoImpl. Om te testen of Spring effectief het juiste profiel selecteert, kan je de System.setProperty methode gebruiken voor je de applicatie-context aanmaakt. Vervolgens kan je aan de hand van een breakpoint testen welke implementatie van UserDao Spring heeft gekozen. Je kan ook de fake database nog een extra item geven, zodat je het verschil ziet in de log output.
