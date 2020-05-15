# ehb-java-frameworks-werkcolleges-spring-core
Werkcollege voor het vak Java Frameworks les Spring Core aan de Erasmushogeschool Brussel

## Oefening 2.1: Spring Java configuratie

Controleer of je oplossing van oefening 1 overeenkomt met de inhoud van de oefening2 branch. Indien dit niet zo is, probeer dan te begrijpen waarom iets op een andere manier is gedaan. 
Verwijder vervolgens alle @Component, @Autowired annotaties van alle services en alle dao klassen. Verwijder ook de @ComponentScan van de main “BlogSquare” klasse. 
Configureer het project nu opnieuw. Deze keer maak je geen gebruik van annotatie configuratie en component scanning, maar maak je gebruik van Java configuratie. Maak al je beans dus aan in de BlogSquare configuratie klasse (deze heeft nog steeds @Configuration)

## Oefening 2.2: Java configuratie opsplitsen
Maak in je dao package een nieuwe klasse aan genaamd: BlogSquareDaoConfig. We gaan nu de configuratie opsplitsen. Verplaats alle DAO bean definities naar deze nieuwe configuratieklasse. Maak gebruik van @Import in je BlogSquare configuratie om deze configuratie te importeren. 
