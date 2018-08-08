*************************************************
***********       CHALLENGE        **************
*************************************************

Phone App
Exercise 1: Create an endpoint to retrieve the phone catalog, and pricing.
* it returns a collection of phones, and their prices.
* Each phone should contain a reference to its image, the name, the description, and its price.
Exercise 2: Create endpoints to check and create an order.
* receives and order that contains the customer information name, surname, and email, and the list of phones that the customer wants to buy.
* Calculate the total prices of the order.
* Log the final order to the console.
Bonus Points: The second endpoint use the first endpoint to validate the order.
Requirements:
- It should have test.
- It should be documented in the readme file.
- It should be a REST API
- Docker oriented.
- Microservice approach.
- Database access from the microservices.
- Java 10, .NET, NodeJS, Scala
Questions
- How would you improve the system?
- How would you avoid your order API to be overflow?

*************************************************
*****       DESIGN DECISIONS        *************
*************************************************

==> TECHNOLGIES
  I have thought about Spring like the best backend technolgy, because it is based on Java, respect JEE standards and improve technology solutions to the market problems. 
  However I had more doubts about persistence system, because challenge don't tell anything about save information, so NoSQL could be the best solution for Rest query services.
  In any case, I finally selected a relational database with mysql driver, because it is a wide range solution.


==> LAYERS
  I decided take a Model Driven layer distribution, because of it suite to a microservices architecture software layers. It 
  distinguish between data, business and application layers. In this way I reckon to have diferent objects in data layer
  and data business is better than spread data persistence model in all layers. Because of this, I design data managers 
  like traductors between data specific layers.
  
  In the other hand, I tried to assure the functional independence between business layer and data layer usinng the facade
  pattern and apliying open/close principle with generics classes in data layer, to let different relational database vendors,
  and software technologies.
  
==> TEST, MICROSERVICE APROACH AND REST API

  Microservice architecture. In this point I should have done it with at least for packages, one for database DAO technology, 
  another for phone business access (facade, manager, DTO's and entities), the third for Order with the same structure, and 
  probably one more for customer. This aproach let:
       * independent access to enterprise domain business and object
       * an easy way to extend and use specific functionality.
       * reusing infraestructure coponents
  
  All services were programmed with Spring annotations for rest web services.
  
  I have programmed a basic tests over most important components, services, managers and facada class. I didn't mind about
  mock classes and complex logic beacause the main problems in the challenge are about infraestructure and configuration
  
  I tried to cover the bonus point accessing to phone catalog service from order service to validate the order phone prices. 
  
  
*************************************************
*****         QUESTIONS             *************
*************************************************
  
  1) How would you improve the system?. 
     The answer is in line 21. In adition, I could have used a Spring Data Rest solution but I am not sure about it's drawbacks for a
     enterprise solution.
	 
  2) How would you avoid your order API to be overflow?
     * Letting only GET actions in service request.
     * Avoid unintended content types defining consume and produces types in RequestMapping
     * In general it should be considered OWASP advices about Rest-Sevices sanitization

