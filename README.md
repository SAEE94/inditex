# Inditex API

## Descripción del Proyecto
Este proyecto es una API desarrollada en Java con Spring Boot utilizando la **arquitectura hexagonal** (también conocida como arquitectura de puertos y adaptadores). La arquitectura hexagonal permite separar las responsabilidades del dominio, la infraestructura y la aplicación para facilitar la mantenibilidad, extensibilidad y pruebas del sistema.

## Estructura del Proyecto
El proyecto está organizado como un **multi-módulo Gradle**, con los siguientes módulos:


### Módulos del Proyecto
1. **application**: Contiene la lógica de aplicación y los casos de uso que interactúan con el dominio. Este módulo define cómo las operaciones del sistema se ejecutan y coordinan.
   
2. **boot-run**: Módulo principal para ejecutar la aplicación. Contiene la configuración de inicio de la aplicación y el arranque (`Application` class) de Spring Boot.

3. **domain**: Contiene las entidades, repositorios, servicios de dominio y lógica de negocio pura. No tiene dependencia en otros módulos ni frameworks. Define las reglas y procesos de negocio que rigen el sistema.

4. **infrastructure**: Contiene las implementaciones de las interfaces de repositorio definidas en el dominio y cualquier otra integración externa (bases de datos, API externas, mensajería, etc.). También incluye controladores REST para exponer la API.

### Arquitectura Hexagonal
La arquitectura hexagonal divide el proyecto en capas bien definidas:

- **Dominio**: 
  - Contiene las entidades y servicios de dominio.
  - No depende de ningún framework ni biblioteca externa.
  
- **Aplicación**:
  - Define los casos de uso y coordina la interacción entre el dominio y la infraestructura.
  
- **Infraestructura**:
  - Implementa los adaptadores necesarios para interactuar con el mundo exterior.
  - Incluye bases de datos, controladores REST, servicios de mensajería, etc.
  
Cada módulo se comunica a través de interfaces, lo que facilita la inyección de dependencias y la realización de pruebas unitarias.

## Requisitos Previos

- Java 21
- Gradle  8.0.1
- Spring Boot 3.3.4
- **H2 Database** (para pruebas y desarrollo)
- **Swagger** (para probar los endpoints de la API)

## Configuración del Proyecto
- ./gradlew clean build
- ./gradlew :boot-run:bootRun
- http://localhost:8080/swagger-ui.html

## Ejecutar pruebas de integracion
En la raiz del proyecto ejecutar el comando

-  ./gradlew :boot-run:test

