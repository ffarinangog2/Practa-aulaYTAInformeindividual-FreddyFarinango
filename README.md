# Práctica Banco del Austro

## Aplicaciones Distribuidas - Bases de Datos Distribuidas

**Estudiante:** Freddy Farinango  
**Universidad:** UTEQ  
**Carrera:** Ingeniería de Software  
**Asignatura:** Aplicaciones Distribuidas  

---

## Descripción

Esta práctica implementa un prototipo de base de datos distribuida para el caso Banco del Austro.

Se levantan dos nodos PostgreSQL independientes usando Docker:

- Nodo Cuenca
- Nodo Quito

Cada nodo tiene sus propias tablas y datos. La aplicación Spring Boot se encarga de consultar el nodo correcto según el número de cuenta.

---

## Tecnologías utilizadas

- Java
- Spring Boot
- Maven
- PostgreSQL
- Docker
- Docker Compose
- IntelliJ IDEA

---

## Estructura del proyecto

```text
banco-austro
├── docker-compose.yml
├── sql-cuenca
│   ├── 01_schema.sql
│   └── 02_datos.sql
├── sql-quito
│   ├── 01_schema.sql
│   └── 02_datos.sql
├── src
│   └── main
│       ├── java
│       │   └── ec.edu.uteq.bancoaustro
│       │       ├── config
│       │       ├── controller
│       │       └── service
│       └── resources
│           └── application.yml
└── pom.xml
