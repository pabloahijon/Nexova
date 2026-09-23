# Nexova

Proyecto de laboratorio para la asignatura Ingeniería del Software II (curso 2026-2027).

## Descripción

Desarrollo de una plataforma de alquiler de viviendas inspirada en sistemas como Airbnb, siguiendo un proceso iterativo e incremental de ingeniería del software.

El proyecto se desarrolla como parte del laboratorio de Ingeniería del Software II, aplicando técnicas de gestión de proyectos, control de versiones, trazabilidad, pruebas, calidad de software y uso supervisado de inteligencia artificial.

## Equipo
Empresa: Nexova

Integrantes:
 - Pablo Ahijon Hormigos
 - Irene Caraballo Jerez
 - Anais Chiquito Patiño
 - Hugo Fernandez Blanco
 - Ronald Denis Pilataxi Lema

Portavoz: 
  - Pablo Ahijon Hormigos

### Responsabilidades iniciales

- Pablo Ahijón Hormigos
  - Portavoz del equipo
  - Repositorio y control de versiones

- Irene Caraballo Jerez
  - Pruebas y verificación
  - Seguimiento de criterios de aceptación
 
- Anaís Chiquito Patiño
  - Gestión de configuración
  - Coordinación y seguimiento del proyecto

- Hugo Fernández Blanco
  - Gestión del producto
  - Requisitos y backlog
    
- Ronald Denis Pilataxi Lema
  - Requisitos y backlog
  - Repositorio y control de versiones

> Estas responsabilidades son iniciales y podrán modificarse durante el desarrollo del proyecto.

## Objetivo

Desarrollar una plataforma que permita:

- Registro de usuarios.
- Publicación de inmuebles.
- Gestión de disponibilidad.
- Búsqueda de alojamientos.
- Creación y gestión de reservas.
- Simulación de pagos.

## Metodología de trabajo

El proyecto seguirá un proceso iterativo e incremental basado en:

- Product Backlog.
- Historias de usuario.
- Issues de GitHub.
- Iteraciones planificadas.
- Revisión de cambios mediante Pull Requests.
- Uso supervisado de herramientas de IA.

## Documentación

- README.md
- AGENTS.md
- AI_USAGE.md

## Estado del proyecto
### Sesión 1 - Preparación y planificación

Completado:

- Creación del repositorio GitHub.
- Creación del Project Board.
- Definición del Product Backlog.
- Creación de historias de usuario.
- Configuración inicial del proyecto.
- Creación de la documentación base.
- Generación del proyecto Maven/Spring Boot.
- Configuración de la estructura base del proyecto.
- Creación de la primera página de prueba.

## Tecnologías utilizadas

- Java 17
- Maven
- Spring Boot
- Spring Data JPA
- JUnit
- GitHub

## Dependencias principales
### Spring Web

Permite desarrollar aplicaciones web utilizando Spring MVC, controladores y gestión de peticiones HTTP.

### Thymeleaf

Motor de plantillas utilizado para generar vistas HTML.

## Construcción y ejecución
### Requisitos

- Java 17

### Limpiar el proyecto

- .\mvnw.cmd clean

### Ejecutar pruebas

- .\mvnw.cmd test

### Generar el paquete

- .\mvnw.cmd package

### Verificar el proyecto

- .\mvnw.cmd verify

### Ejecutar la aplicación

- .\mvnw.cmd spring-boot:run

### URL local

- http://localhost:8080

### Sesión 2 - Github y flujo profesional de desarrollo

## Documentación del proyecto

La documentación del proyecto se mantiene en:

- `docs/technical/`: base técnica, dependencias y ejecución.
- `docs/diagrams/`: diagramas y modelos.
- `docs/decisions/`: decisiones técnicas relevantes.

## Plan de Gestión de Configuración

### Rama principal

La rama principal del proyecto es `main`. No se realizarán cambios relevantes directamente sobre ella.

### Ramas y commits

Las ramas seguirán el formato:

`<tipo>/<issue>-descripcion-corta`

Tipos utilizados: `feat`, `fix`, `docs` y `refactor`.

### Flujo de trabajo

El flujo de trabajo será:

`Issue → Branch → Commit → Push → Pull Request → Review → Merge → Done`

Cada cambio relevante estará asociado a una Issue y se desarrollará en una rama independiente.

### Pull Requests y revisión

Los cambios relevantes se integrarán en `main` mediante Pull Request.

Toda Pull Request relevante deberá ser revisada por otro miembro del equipo antes de realizar el merge.

### Protección de main

- No se realizará push directo a `main`.
- Todo cambio relevante tendrá una Issue asociada.
- Los cambios se integrarán mediante Pull Request.
- Las Pull Requests relevantes serán revisadas por otro integrante.

### Archivos excluidos

El `.gitignore` evitará versionar archivos generados o locales, como:

- `target/`
- `*.log`
- `.env`
- `.vscode/`

### Conflictos

Los conflictos se resolverán revisando los cambios afectados entre los miembros implicados, conservando la solución correcta y comprobando posteriormente el funcionamiento del proyecto.

### Integración

Antes de realizar el merge se comprobará que se cumplen los criterios de aceptación, que el proyecto compila correctamente y que la Pull Request ha sido revisada.
