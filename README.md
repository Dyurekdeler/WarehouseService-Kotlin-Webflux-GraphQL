# WarehouseService-Kotlin-Webflux-GraphQL
A practice project to learn GraphQL with Spring Webflux and Kotlin Spring in Microservice architecture

WarehouseService is a service that receives deliveries and saves them to H2 database.

What does this service do?

Queries:
1- List all received or not-yet received deliveries when parameter is defined
2- List all deliveries when parameter is set null
3- List a delivery with given id

Mutations:
1- Add a new delivery
2- Add a list of new deliveries
3- Update a given delivery's isReceived status to true

The graphql-kotlin library automatically generates the schema.graphql
You can find the library in this link https://github.com/ExpediaGroup/graphql-kotlin

You can send requests via http://localhost:8080/playground



