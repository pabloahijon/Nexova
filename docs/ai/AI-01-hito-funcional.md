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

## Primer plan del agente

El agente analizó la issue #4 y el estado actual del repositorio antes de realizar modificaciones.

Propuso:

1. Mantener la entidad `Property` y revisar su mapeo JPA.
2. Mantener `PropertyRepository`, ya que `JpaRepository` proporciona las operaciones necesarias.
3. Incorporar en `PropertyService` la validación de los campos obligatorios.
4. Adaptar `PropertyController` para gestionar errores de entrada.
5. Adaptar `properties.html` para mostrar los errores de validación.
6. Cambiar inicialmente H2 de memoria a almacenamiento en archivo para conservar los datos entre reinicios.
7. Añadir pruebas para comprobar el flujo de publicación y la persistencia.
8. No añadir funcionalidades ajenas a la historia de usuario.

El agente también planteó que `Owner` no era necesario para cumplir los criterios de aceptación actuales.

## Revisión humana del primer plan

El equipo decidió **modificar** el primer plan propuesto por el agente.

### Cambios solicitados

- Se rechazó el cambio de H2 en memoria a H2 en archivo, ya que para este hito la persistencia se comprobará mediante JPA y la consola H2 durante la ejecución de la aplicación.
- Se solicitó revisar específicamente la necesidad de introducir `Owner`, evitando implementar autenticación, login, permisos o un subsistema de usuarios.
- Se decidió mantener la interfaz web con Thymeleaf.
- Se mantuvo la arquitectura actual:
  `Controller -> Service -> Repository -> Entity`.
- Se decidió limitar las validaciones a los criterios de aceptación y evitar nuevas reglas de negocio no especificadas.
- Las pruebas debían mantenerse acotadas al flujo funcional y a la persistencia del hito.

## Plan final aprobado

Tras la revisión humana, el agente presentó un plan actualizado que fue aprobado por el equipo:

1. Mantener los atributos y el mapeo actual de `Property`.
2. Validar en `PropertyService` los campos exigidos por los criterios de aceptación, evitando reglas adicionales no especificadas.
3. Adaptar `PropertyController` para gestionar correctamente los errores y delegar la lógica en el servicio.
4. Adaptar `properties.html` para mostrar los errores mediante Thymeleaf.
5. Mantener `PropertyRepository` y la configuración actual de H2 en memoria.
6. Añadir pruebas acotadas para comprobar publicación válida, entradas inválidas, generación de identificadores, recuperación desde H2 y listado.
7. Tras la implementación, ejecutar `./mvnw verify`, realizar una prueba manual desde el formulario y comprobar los datos mediante la consola H2.

### Decisiones humanas

- `Owner` queda fuera de este hito porque los criterios de aceptación actuales no exigen almacenar la identidad del propietario ni asociarla al inmueble.
- No se implementará autenticación, login, permisos ni gestión de usuarios.
- `type` se mantiene como campo existente, pero no se añadirá una nueva regla de obligatoriedad si no está especificada en los criterios de aceptación.
- H2 continuará funcionando en memoria.
- No se ampliará el alcance de la issue con funcionalidades adicionales.