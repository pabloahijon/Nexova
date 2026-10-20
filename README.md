
## Nexova
Proyecto de laboratorio para la asignatura Ingeniería del Software II 

## Descripción
Desarrollo de una plataforma de alquiler de viviendas, siguiendo un proceso iterativo e incremental de ingeniería del software.
El proyecto se desarrolla aplicando técnicas de gestión de proyectos, control de versiones, trazabilidad, pruebas, calidad de software y uso supervisado de inteligencia artificial.
El desarrollo se organiza mediante historias de usuario, Issues, Pull Requests y sprints planificados en GitHub, permitiendo incorporar funcionalidades progresivamente y verificar cada incremento.

## Equipo
Empresa: Nexova
Integrantes:
•	Pablo Ahijón Hormigos
•	Irene Caraballo Jerez
•	Anaís Chiquito Patiño
•	Hugo Fernández Blanco
•	Ronald Denis Pilataxi Lema
Portavoz:
Pablo Ahijón Hormigos

## Responsabilidades iniciales
1**Pablo Ahijón Hormigos**
•	Portavoz del equipo.
•	Repositorio y control de versiones.
**Irene Caraballo Jerez**
•	Pruebas y verificación.
•	Seguimiento de criterios de aceptación.
**Anaís Chiquito Patiño**
•	Gestión de configuración.
•	Coordinación y seguimiento del proyecto.
**Hugo Fernández Blanco**
•	Gestión del producto.
•	Requisitos y backlog.
**Ronald Denis Pilataxi Lema**
•	Requisitos y backlog.
•	Repositorio y control de versiones.
Estas responsabilidades son iniciales y podrán modificarse durante el desarrollo del proyecto.

## Objetivo
Desarrollar una plataforma que permita:
•	Registro de usuarios.
•	Publicación de inmuebles.
•	Consulta de inmuebles publicados.
•	Gestión de disponibilidad.
•	Búsqueda de alojamientos.
•	Creación y gestión de reservas.
•	Simulación de pagos.
El objetivo es construir la plataforma mediante incrementos funcionales, manteniendo la trazabilidad entre los requisitos, su implementación, las pruebas y la planificación del proyecto.

## Metodología de trabajo
El proyecto seguirá un proceso iterativo e incremental basado en:
•	Product Backlog.
•	Historias de usuario.
•	Issues de GitHub.
•	Sprints planificados mediante GitHub Milestones.
•	Seguimiento del trabajo mediante GitHub Projects.
•	Desarrollo de funcionalidades en ramas independientes.
•	Revisión de cambios mediante Pull Requests.
•	Verificación de criterios de aceptación.
•	Uso supervisado de herramientas de IA.
•	Documentación de decisiones técnicas y del proceso de desarrollo.

## Organización de los sprints
El equipo ha organizado el desarrollo en cinco sprints, utilizando los Milestones de GitHub para agrupar las historias de usuario y establecer sus objetivos y plazos.
**Sprint 1 — Base técnica y funcionalidad inicial**
Preparación del repositorio, configuración del proyecto, organización del trabajo y documentación inicial.
**Sprint 2 — Gestión de inmuebles**
Implementación de las funcionalidades de publicación y consulta de inmuebles.
**Sprint 3 — Gestión de usuarios**
Implementación del registro de usuarios y consulta de usuarios registrados.
**Sprint 4 — Disponibilidad y búsquedas**
Implementación de la gestión de disponibilidad y búsqueda de alojamientos.
**Sprint 5 — Reservas y pagos**
Implementación de la creación y gestión de reservas y simulación del proceso de pago.
Las funcionalidades pendientes permanecen registradas en el Product Backlog y asociadas a sus respectivos sprints.

## Seguimiento del trabajo
El seguimiento se realiza mediante GitHub Projects, utilizando los siguientes estados:
•	Backlog: tareas pendientes de planificación o desarrollo.
•	Ready: tareas preparadas para comenzar.
•	In progress: tareas en desarrollo.
•	In review: tareas pendientes de revisión y validación.
•	Done: tareas completadas.
Las historias de usuario se trasladan entre estados según su progreso real.

## Documentación
La documentación principal del proyecto se encuentra en:
•	README.md: descripción general, organización, estado y ejecución del proyecto.
•	AGENTS.md: instrucciones y criterios para el trabajo con agentes de IA.
•	AI_USAGE.md: registro general del uso supervisado de inteligencia artificial, con la planificación, propuestas, decisiones y verificación del Hito 1.
Además, el repositorio contiene documentación organizada en los siguientes directorios:
•	docs/technical/: base técnica, dependencias y ejecución.
•	docs/diagrams/: diagramas y modelos.
•	docs/decisions/: decisiones técnicas relevantes.
•	docs/ai/: documentación del proceso de trabajo con IA agéntica, incluido AI-01-hito-funcional.md.

## Estado del proyecto
El proyecto se encuentra en desarrollo mediante incrementos funcionales.
**Sprint 1 — Base técnica y funcionalidad inicial**
Estado: completado.
Se han realizado las siguientes tareas:
•	Creación del repositorio GitHub.
•	Creación del Project Board.
•	Definición del Product Backlog.
•	Creación de historias de usuario.
•	Configuración inicial del proyecto.
•	Creación de la documentación base.
•	Generación del proyecto Maven/Spring Boot.
•	Configuración de la estructura base del proyecto.
•	Creación de la primera página de prueba.
•	Organización inicial del flujo de trabajo con Git y GitHub.
Historias de usuario completadas:
•	HU-01 (#1): Preparar la estructura inicial del proyecto.
•	HU-13 (#13): Organizar la documentación del proyecto.

**Sprint 2 — Gestión de inmuebles**
Estado: funcionalidades implementadas e integradas; verificación final de consulta pendiente de confirmar.
El objetivo de este sprint es desarrollar un incremento funcional que permita publicar inmuebles y consultar los inmuebles registrados en la plataforma.

*HU-04 (#4) — Publicar un inmueble*
Estado: completada.
Se ha implementado un flujo de publicación de inmuebles utilizando la arquitectura por capas:
Controller → Service → Repository → Entity → Base de datos
La funcionalidad permite:
•	Acceder al formulario de publicación.
•	Introducir la información básica de un inmueble.
•	Validar los campos obligatorios.
•	Almacenar el inmueble mediante Spring Data JPA.
•	Generar automáticamente un identificador único.
•	Recuperar los inmuebles registrados desde H2.
•	Mostrar los inmuebles almacenados en la aplicación.
El desarrollo de esta funcionalidad se ha realizado de manera incremental mediante las siguientes Pull Requests:
•	PR #16 — Publicar un inmueble: implementación inicial de la entidad, repositorio, servicio, controlador y vista.
•	PR #17 — Actualización HTML: mejoras en la estructura de la página y en los archivos asociados.
•	PR #18 — Publicación y persistencia de inmuebles con IA agéntica: incorporación de validaciones, pruebas y documentación del proceso supervisado de IA.
La funcionalidad de publicación se encuentra integrada en la rama main.

*HU-05 (#5) — Consultar inmuebles*
Estado: implementada e integrada en main.
La funcionalidad de consulta permite visualizar los inmuebles registrados y acceder a información más detallada sobre ellos.
El desarrollo se incorporó mediante la PR #19 — Consultar inmuebles, fusionada en la rama principal. Esta funcionalidad complementa la publicación de inmuebles y permite presentar ambas historias de usuario como parte del incremento funcional del Sprint 2.
La verificación final de los criterios de aceptación de HU-05 debe confirmarse y documentarse antes de dar por cerrado el sprint.

**Sprint 3 — Gestión de usuarios**
Estado: pendiente de desarrollo.
Historias de usuario planificadas:
•	HU-02 (#2): Registrar usuarios.
•	HU-03 (#3): Consultar usuarios registrados.
Este sprint tiene como objetivo incorporar las funcionalidades básicas de gestión de usuarios de la plataforma.

**Sprint 4 — Disponibilidad y búsquedas**
Estado: pendiente de desarrollo.
Historias de usuario planificadas:
•	HU-06 (#6): Gestionar la disponibilidad de un inmueble.
•	HU-07 (#7): Buscar alojamientos según criterios básicos.
•	HU-08 (#8): Buscar alojamientos disponibles para unas fechas.
Este sprint permitirá gestionar la disponibilidad de los inmuebles y facilitar su búsqueda.

**Sprint 5 — Reservas y pagos**
Estado: pendiente de desarrollo.
Historias de usuario planificadas:
•	HU-09 (#9): Crear reserva.
•	HU-10 (#10): Gestionar solicitudes de reserva.
•	HU-11 (#11): Simular el pago de una reserva.
•	HU-12 (#12): Cancelar reserva.
Este sprint tiene como objetivo completar el flujo principal de reservas de la plataforma.

## Incremento funcional para la defensa intermedia
Para la defensa intermedia, el equipo presenta el desarrollo realizado sobre la gestión de inmuebles.
El incremento incluye dos funcionalidades implementadas e integradas en main:
•	HU-04 — Publicar un inmueble: formulario de publicación, validación de campos obligatorios y almacenamiento mediante Spring Data JPA y H2.
•	HU-05 — Consultar inmuebles: visualización de inmuebles registrados y acceso a sus detalles.
Para HU-04 se han realizado comprobaciones de compilación y pruebas mediante Maven, así como pruebas manuales del formulario y del almacenamiento y recuperación de inmuebles en H2. La PR #19 de consulta ya está fusionada; queda por confirmar y registrar la verificación final de sus criterios de aceptación sobre la versión integrada.
Las funcionalidades que todavía no forman parte del incremento permanecen registradas y planificadas en GitHub Projects y en los sprints posteriores.

## Tecnologías utilizadas
•	Java 17: lenguaje de programación principal.
•	Maven: gestión de dependencias, construcción y verificación.
•	Spring Boot: framework de desarrollo de la aplicación.
•	Spring Web / Spring MVC: controladores y gestión de peticiones HTTP.
•	Spring Data JPA: acceso a datos y persistencia de entidades.
•	H2: base de datos utilizada durante el desarrollo.
•	Thymeleaf: generación de las vistas HTML.
•	JUnit: pruebas automatizadas.
•	Git: control de versiones.
•	GitHub: alojamiento del repositorio, Issues, Pull Requests, Projects y Milestones.

## Construcción y ejecución
**Requisitos** 
•	Java 17.
•	Acceso al repositorio del proyecto.
El proyecto incluye Maven Wrapper, por lo que no es necesario disponer de una instalación independiente de Maven.
**Limpiar el proyecto**
Windows:
.\mvnw.cmd clean
Linux / macOS:
./mvnw clean
**Ejecutar pruebas**
Windows:
.\mvnw.cmd test
Linux / macOS:
./mvnw test
**Generar el paquete**
Windows:
.\mvnw.cmd package
Linux / macOS:
./mvnw package
**Verificar el proyecto**
Windows:
.\mvnw.cmd verify
Linux / macOS:
./mvnw verify
Este comando permite comprobar la construcción del proyecto y ejecutar las pruebas correspondientes.
**Ejecutar la aplicación**
Windows:
.\mvnw.cmd spring-boot:run
Linux / macOS:
./mvnw spring-boot:run
**URL local**
Una vez iniciada la aplicación, se puede acceder mediante:
http://localhost:8080

### Persistencia de datos
El proyecto utiliza Spring Data JPA y una base de datos H2 en memoria.
Los inmuebles registrados se almacenan y pueden recuperarse mientras la aplicación permanece en ejecución.
Al detener y reiniciar la aplicación, los datos almacenados en memoria no se conservan.
Esta configuración se mantiene de acuerdo con las decisiones del equipo y el alcance establecido para el incremento funcional inicial.

## Sesión 2 — GitHub y flujo profesional de desarrollo

### Documentación del proyecto
La documentación del proyecto se mantiene en:
•	docs/technical/: base técnica, dependencias y ejecución.
•	docs/diagrams/: diagramas y modelos.
•	docs/decisions/: decisiones técnicas relevantes.

### Plan de Gestión de Configuración
**Rama principal**
La rama principal del proyecto es main.
No se realizarán cambios relevantes directamente sobre ella.
**Ramas y commits**
Como convención general, las ramas seguirán el formato:
<tipo>/ descripcion-corta
Algunas ramas creadas previamente utilizan nombres diferentes; la convención se aplicará a los nuevos desarrollos para mejorar la trazabilidad.
Tipos utilizados:
•	feat: incorporación de nuevas funcionalidades.
•	feature: funcionalidad o característica.
•	docs: cambios en documentación.
Cada cambio relevante deberá estar asociado a una Issue para facilitar la trazabilidad.
**Flujo de trabajo**
El flujo de trabajo definido es:
Issue → Branch → Commit → Push → Pull Request → Review → Merge → Done
1.	Se selecciona una Issue del Product Backlog.
2.	Se crea una rama para desarrollar la funcionalidad.
3.	Se realizan los cambios y commits necesarios.
4.	Se suben los cambios al repositorio remoto.
5.	Se abre una Pull Request hacia main.
6.	Se revisan los cambios y se comprueba su funcionamiento.
7.	Se realiza el merge cuando se considera que la funcionalidad cumple los criterios establecidos.
8.	Se actualiza el estado de la Issue y del Project Board.
### Pull Requests y revisión
Los cambios relevantes se integrarán en main mediante Pull Request.
Como norma de trabajo, toda Pull Request relevante deberá ser revisada por otro miembro del equipo antes de realizar el merge. La revisión debe quedar registrada en GitHub siempre que sea posible; esta norma no implica que todas las PR anteriores tengan una revisión formal documentada.
Durante la revisión se comprobará:
•	Que los cambios corresponden al alcance de la Issue.
•	Que se cumplen los criterios de aceptación.
•	Que la implementación mantiene la arquitectura del proyecto.
•	Que no se introducen modificaciones innecesarias.
•	Que el proyecto compila correctamente.
•	Que las pruebas correspondientes se ejecutan satisfactoriamente.
El equipo procurará registrar las revisiones y decisiones directamente en GitHub para mantener evidencias del proceso.
### Protección de main
Como normas de trabajo del equipo:
•	No se realizará push directo a main.
•	Todo cambio relevante tendrá una Issue asociada.
•	Los cambios se integrarán mediante Pull Request.
•	Las Pull Requests relevantes serán revisadas por otro integrante.
Estas normas forman parte del proceso de gestión de configuración del proyecto. Se describen como acuerdos de trabajo del equipo y no implican por sí mismas que se hayan configurado reglas técnicas de protección de ramas en GitHub.
### Archivos excluidos
El archivo .gitignore está configurado para excluir archivos generados o locales, como:
•	target/
•	*.log
•	.env
•	.vscode/
### Conflictos
Los conflictos se resolverán revisando los cambios afectados entre los miembros implicados, conservando la solución correcta y comprobando posteriormente el funcionamiento del proyecto.
### Integración
Antes de realizar el merge se comprobará que:
•	Se cumplen los criterios de aceptación.
•	El proyecto compila correctamente.
•	Se han ejecutado las pruebas correspondientes.
•	Los cambios han sido revisados.
•	La Pull Request está correctamente relacionada con la funcionalidad desarrollada.

## Pruebas y verificación
El equipo utiliza pruebas automatizadas y comprobaciones manuales para verificar las funcionalidades desarrolladas.
### Verificación de publicación de inmuebles
Para la funcionalidad HU-04 se han realizado las siguientes comprobaciones:
•	Ejecución de Maven Wrapper mediante verify.
•	Comprobación del registro de inmuebles desde el formulario.
•	Validación de los campos obligatorios.
•	Comprobación de la generación de identificadores.
•	Comprobación del almacenamiento mediante Spring Data JPA.
•	Recuperación de los inmuebles almacenados.
•	Comprobación de los datos mediante la consola H2.
•	Verificación del funcionamiento de la aplicación desde la interfaz web.
### Verificación de consulta de inmuebles
La funcionalidad HU-05 está implementada e integrada en main mediante la PR #19.
Para completar su verificación se comprobará que:
•	Los inmuebles publicados aparecen correctamente en la consulta.
•	Se muestran los datos correspondientes a cada inmueble.
•	Es posible acceder a la información detallada de un inmueble.
•	La funcionalidad se comporta correctamente cuando no hay inmuebles registrados.
•	La integración con la publicación de inmuebles no introduce errores.
Los resultados deberán registrarse como evidencia de validación de los criterios de aceptación definidos en la Issue #5. Esta sección no da por realizadas comprobaciones que aún no constan verificadas.
### Criterio de finalización
Una historia de usuario se considerará completada cuando:
1.	Se haya implementado la funcionalidad acordada.
2.	Se hayan comprobado sus criterios de aceptación.
3.	Se hayan realizado las pruebas correspondientes.
4.	Se hayan revisado los cambios.
5.	Se hayan integrado correctamente en main.
6.	Se haya actualizado su estado en GitHub Projects.

## Uso supervisado de inteligencia artificial
El equipo utiliza herramientas de inteligencia artificial como apoyo al desarrollo, manteniendo la responsabilidad humana sobre las decisiones y los cambios realizados.
El proceso seguido contempla:
•	Definir previamente el objetivo y el alcance de la tarea.
•	Elaborar un plan humano antes de solicitar propuestas al agente.
•	Analizar las recomendaciones recibidas.
•	Aceptar, modificar o rechazar las propuestas según los requisitos.
•	Revisar los cambios realizados.
•	Ejecutar las comprobaciones y pruebas necesarias.
•	Documentar las decisiones relevantes.
La inteligencia artificial se utiliza como herramienta de apoyo, no como sustituto de la revisión y responsabilidad del equipo.
La evidencia del Hito 1 se encuentra en:
docs/ai/AI-01-hito-funcional.md
