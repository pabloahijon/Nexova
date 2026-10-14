# AI-01 - Hito funcional

## Issue y objetivo

Issue #4 - HU-04 Publicar un inmueble.

El objetivo es implementar un flujo funcional que permita publicar un inmueble y almacenarlo de forma persistente, respetando la arquitectura por capas del proyecto.

## Plan humano previo

Antes de solicitar una propuesta al agente, el equipo plantea el siguiente plan:

1. Revisar la entidad `Property` para comprobar sus atributos y su configuración como entidad JPA.

2. Revisar `PropertyRepository` para comprobar que permite almacenar y recuperar inmuebles mediante Spring Data JPA.

3. Revisar `PropertyService` y mantener en esta capa la lógica necesaria para la publicación del inmueble.

4. Revisar `PropertyController` para permitir mostrar el formulario de publicación y procesar los datos introducidos por el usuario.

5. Revisar la vista `properties.html` para comprobar que permite introducir los datos necesarios para publicar un inmueble.

6. Validar los campos obligatorios del inmueble y controlar entradas incorrectas o incompletas.

7. Comprobar que el flujo respeta la arquitectura:

   Controller -> Service -> Repository -> Entity -> Base de datos

8. Ejecutar Maven Wrapper para comprobar que el proyecto compila y supera las pruebas.

9. Realizar una prueba manual del flujo de publicación desde la interfaz web.

10. Comprobar mediante la consola H2 que el inmueble se ha almacenado realmente en la base de datos y puede recuperarse posteriormente.

### Dependencias, supuestos y dudas

- Se mantendrá la arquitectura actual del proyecto.
- Se utilizarán Spring Data JPA y H2, ya presentes en el proyecto.
- Se revisarán los atributos actuales de `Property` antes de introducir nuevas propiedades o relaciones.
- No se añadirán funcionalidades que estén fuera del alcance de la issue.
- No se crearán nuevas relaciones o entidades salvo que sean necesarias para cumplir los criterios de aceptación.
- Cualquier cambio propuesto por el agente deberá ser revisado antes de su implementación.