# ehb-java-frameworks-werkcolleges-spring-core
Werkcollege voor het vak Java Frameworks les Spring Core aan de Erasmushogeschool Brussel

## Oefening 1.1: Dependency Injection
Run de code en kijk naar de output. Inspecteer vervolgens de code. Je zult zien dat we momenteel code hebben die tight coupled is aan andere stukken code. Implementeer Dependency Injection voor alle services die worden gebruikt in de main klasse. Gebruik bij deze oefening nog geen Spring. Je root component (je main) is op dat moment dus nog verantwoordelijk voor het aanmaken van alle objecten. 

## Oefening 1.2: Spring
We gaan nu gebruik maken van Spring. Inspecteer de pom.xml en kijk welke dependencies aan het project zijn toegevoegd om gebruik te kunnen maken van Spring Core. We gaan nu de werking van onze applicatie niet veranderen, maar gebruik maken van de Spring IoC om aan dependency injection te doen. In deze eerste oefening maken we gebruik van annotatie configuratie, in combinatie met component scanning

- Configureer je componenten met @Component
- Injecteer dependencies
  -	Annoteer constructors met dependencies met @Autowired
  -	Gebruik interfaces in plaats van implementatie klassen
  
- Annoteer je BlogSquare klasse met:
  -	@Configuration
  -	@ComponentScan
  	
- Maak een applicatie-context aan in je main klasse en gebruik de beans die je kan opvragen om dezelfde code als voorgaande oefening uit te voeren. Vervang dus je initialize methode door volgende methode:
```java
private static void getBeans(ApplicationContext ctx) {
  blogService = ctx.getBean(BlogService.class);
  userService = ctx.getBean(UserService.class);
}
```
 
-	Ga na of je nog steeds dezelfde output krijgt

