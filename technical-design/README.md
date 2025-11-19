# Technical Design
## Table of Contents
- [Languages](https://github.com/MercyOl/swe-3313-fall-2025-team-06/tree/main/technical-design#languages)
- [Frameworks](https://github.com/MercyOl/swe-3313-fall-2025-team-06/tree/main/technical-design#frameworks)
- [Data Storage Plan](https://github.com/MercyOl/swe-3313-fall-2025-team-06/tree/main/technical-design#data-storage-plan)
- Entity Relationship Diagram
- Entity/Field Descriptions
- Data Examples
- Database Seed Data
- Authentication and Authorization Plan
- Coding Style Guide

## Languages
Schmendrick's Weaponry will be implemented with **Java 23** due to the following:
- Java is a widely used, strongly typed, object-oriented language.
- It provides long-term stability, performance, and an extensive ecosystem of libraries.
- Everyone in our group is at least proficient in Java.

## Frameworks
We will be using [**Spring Boot**](https://spring.io/projects/spring-boot) as our framework, as it is the industry standard for pairing with Java and helps to streamline the development process.
- It is widely used and well-supported in the Java ecosystem
- It works seamlessly with Maven and modern Java versions

## Data Storage Plan
We plan to use JSON as our storage method, as it is lightweight, flexible, and easy to integrate.

We will use the following libraries/technologies to accomplish data storage:
- a JSON document used as a lightweight database
- [Jackson](https://docs.spring.io/spring-boot/reference/features/json.html), a built-in serializer/deserializer in Spring Boot
- The [Java File I/O library](https://howtodoinjava.com/java11/write-string-to-file/?utm_source=chatgpt.com) to read and write to the JSON database
- A small repository class to manage loading, updating, and saving data

The full data storage life cycle will contain the following steps:
1. On application startup, data is read and deserialized using Jackson
2. During runtime, data is serialized and written to the database as updates occur
3. On application shutdown, the data is serialized and written to the database
