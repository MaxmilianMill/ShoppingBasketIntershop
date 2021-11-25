# ShoppingBasketIntershop

Genutzte IDE: IntelliJ Ultimate 

Framework: Spring Boot

**Entwurfsmuster**

Ich habe mich für ein 3-Schichten Modell entschieden, um verschiedene Arten von Funktionalität voneinander zu trennen. Jede Layer kann so einfacher verändert oder ersetzt werden und
ist dabei unabhängig von den anderen Schichten. Ein weiterer Vorteil ist, das neue Controller über die gleiche Service Schicht auf die Daten zugreifen können, ohne dass die Logik verändert werden muss. 

![Entwurfsmuster](https://github.com/MaxmilianMill/ShoppingBasketIntershop/blob/master/src/main/resources/raw/Entwurfsmuster.png)

Datenbank: 
- H2 In-Memory Datenbank 
- Ist durch das ItemRepository erreichbar 
- Datenbank enthät die Shopping Basket Tabelle 

Servie Layer: 
- ItemService 
- Enthält Funktionen, um Daten zwischen dem Controller und der Datenbank auszutauschen 

Application Layer: 
- ItemController
- Abfragen der Daten in Datenbank mithilfe von Http Requests 

**HTTP Requests:**

GET: 
- GET http://localhost:8080/allItems
Content-Type: application/json

POST: 
- POST http://localhost:8080/addItem
Content-Type: application/json

{
  "itemName": "Nike Air Force",
  "itemPrice": "399.99",
  "amount": 2
}

PUT: 
- PUT http://localhost:8080/updateItem/1?amount=2000
Content-Type: application/json

DELETE: 
- DELETE http://localhost:8080/deleteItem/2

**Bibliotheken** 

Spring Boot Starter JPA: 
- Kommunikation mit der Datenbank 

H2 Database: 
- Implementierung einer In-Memory Datenbank 

Spring Boot Web: 
- Model View Controller Bibliothek 

Thymeleaf: 
- Nicht genutzt --> Möglichkeit ausprobiert, ein Interface anzubinden 

