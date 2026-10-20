# Registro de uso de IA

Este documento recoge los usos relevantes de inteligencia artificial realizados durante el proyecto Nexova, desarrollado para la asignatura Ingeniería del Software II (curso 2026-2027).

El objetivo es documentar cómo se ha utilizado la IA como herramienta de apoyo al desarrollo, manteniendo siempre la responsabilidad y supervisión del equipo.

## Principios

- La IA puede proponer, pero el equipo decide.
- Todo cambio debe ser comprendido y revisado.
- Las propuestas deben verificarse mediante las herramientas correspondientes.
- No se integrará código generado por IA sin revisión humana.
- El equipo es responsable de las decisiones técnicas y del funcionamiento del software.
- El uso de IA debe quedar documentado para garantizar la trazabilidad del proceso.

## Hito 1 - Desarrollo funcional

### Objetivo

Utilizar IA agéntica como apoyo para mejorar la funcionalidad de publicación de inmuebles, incorporando validaciones, gestión de errores y pruebas, respetando la arquitectura existente de Nexova.

Está relacionado con la historia de usuario **HU-04 Publicar un inmueble (#4)**.

### Planificación humana previa

Antes de solicitar propuestas al agente, el equipo definió un plan de trabajo que incluía:

1. Revisar la entidad `Property` y su configuración JPA.
2. Comprobar el funcionamiento de `PropertyRepository`.
3. Revisar la lógica de publicación en `PropertyService`.
4. Comprobar el tratamiento de peticiones y errores en `PropertyController`.
5. Revisar el formulario de `properties.html`.
6. Incorporar validaciones para los campos obligatorios.
7. Mantener la arquitectura por capas.
8. Ejecutar las pruebas y verificar el funcionamiento de la aplicación.

### Propuesta inicial de la IA

El agente propuso mejorar la publicación de inmuebles mediante:

- Validación de los campos obligatorios.
- Gestión de errores en el controlador.
- Visualización de mensajes de error en Thymeleaf.
- Incorporación de pruebas de publicación y persistencia.
- Revisión de las capas de la aplicación.
- Cambio de H2 en memoria a H2 en archivo para conservar los datos entre reinicios.

### Revisión y decisiones humanas

El equipo analizó la propuesta y decidió modificarla antes de aprobar su implementación.

Las principales decisiones fueron:

- **Mantener H2 en memoria:** se rechazó el cambio a almacenamiento en archivo porque el alcance del hito contempla comprobar la persistencia durante la ejecución.
- **No incorporar `Owner`:** se decidió no ampliar el alcance con autenticación, permisos o gestión de usuarios.
- **Mantener Thymeleaf:** se conservó la tecnología utilizada para las vistas.
- **Respetar la arquitectura existente:** `Controller → Service → Repository → Entity → Base de datos`.
- **Limitar las validaciones:** se establecieron como obligatorios el título y la ciudad, sin introducir reglas adicionales no especificadas.


### Implementación y verificación

El trabajo del hito incluyó mejoras en la lógica de publicación, tratamiento de entradas inválidas, presentación de errores y pruebas de publicación y persistencia.

La verificación realizada incluyó:

- Ejecución de Maven Wrapper mediante `./mvnw verify` en el entorno correspondiente.
- Comprobación de las pruebas automatizadas.
- Prueba manual de publicación desde la interfaz web.
- Comprobación del almacenamiento y recuperación de inmuebles mediante H2.
- Revisión del cumplimiento de los criterios de aceptación.

Estas comprobaciones se realizaron satisfactoriamente.

Durante el desarrollo del modulo "Consultar Inmuebles" y la integración del campo Descripción, usamos a nuestro agente como un asistente tecnico convencional.

Casos de Uso

# Diseño y arquitectura de consultar inmuebles
Confirmar las necesidades de la historia del usuario, cumpliendo asi la navegacion entre la vista general y la ficha de detalle.
Validacion de nuestra pagina web siguiendo la arquitectura de 4 capas (Entidad, Repositorio, Servicio y Controlador)guiando el diseño de las buenas practicas con esta arquitectura, confirmando la vista detallada mediante enlace directo.


# Creacion de la ficha detalle y Enlace de Visitas
Conexion de nuestro listado principal 'properties.html' con la nueva lista individual 'property-detail.html'
Nos indico exactamente como poner el boton o enlace en cada tarjeta de nuestro listado para que al pulsarlo abra la ficha individual del inmueble correcto.
Nos ayudo a configurar la ruta web en el codigo del servidor ('PropertyController') para que detecte que inmueble ha pinchado nuestro usuario, recupere sus datos y se los mande a pantalla.



# Añadiendo el campo description

Diseñamos la incorporación del atributo 'description' en la entidad property sin romper los test y el constructor legacy. Debido a la observacion de que no habria informacion mas extendidada al consultar el inmueble mas a detalles por parte del cliente. La IA identifico la necesidad de sobrecargar los constructores para java pasando se soportar de 3 a 4 parametros, al igual que los tests.


### Resultado

El equipo dispone de un flujo funcional de publicación de inmuebles, con persistencia mediante Spring Data JPA y H2, validaciones y pruebas.

El uso de IA ha permitido apoyar la revisión y mejora de esta funcionalidad sin sustituir la planificación, las decisiones ni la verificación humana.

## Seguimiento del uso de IA

Los futuros usos relevantes de inteligencia artificial se documentarán indicando:

- La tarea o historia de usuario relacionada.
- El objetivo de la intervención.
- El plan humano previo.
- La propuesta realizada por la IA.
- Las decisiones de aceptación, modificación o rechazo.
- Las pruebas y verificaciones realizadas.
- Las evidencias asociadas en GitHub.
