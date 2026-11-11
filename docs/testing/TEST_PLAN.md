# TEST_PLAN — Plan de Pruebas del Proyecto

> **Ingeniería del Software II · Laboratorio 2026-2027**  
> Este documento recoge la estrategia global de pruebas del proyecto y se actualiza progresivamente durante las sesiones S6–S8 y el resto del desarrollo.
>
> **Es un único documento para todo el proyecto.** No debe duplicarse por cada issue, historia de usuario o prueba. Los casos y pruebas relevantes se registran de forma resumida en las tablas y solo se documentan con mayor detalle cuando exista una decisión, carencia, defecto o evidencia especialmente significativa.
>
> El objetivo no es maximizar el número de tests ni alcanzar un porcentaje aislado de cobertura, sino comprobar comportamientos relevantes mediante pruebas comprensibles, reproducibles y capaces de detectar defectos.

---

## 1. Identificación

- **Equipo / empresa:** Nexova 
- **Repositorio:**  https://github.com/pabloahijon/Nexova
- **Versión del documento:** 0.1  
- **Responsable de mantener el plan:** Equipo Nexova
- **Sprint / iteración actual:**  Sprint 2/Sesion 6
- **Última actualización:**  11/11/2026

---

## 2. Estrategia general de pruebas

### Objetivo

El objetivo de las pruebas automatizadas de Nexova es comprobar que
las funcionalidades principales del sistema funcionan correctamente
y cumplen los requisitos establecidos.

Se dará prioridad a las reglas de negocio, las validaciones de datos
y la persistencia de información, con el fin de detectar errores
y evitar regresiones durante el desarrollo.

Durante la Sesión 6 se priorizarán las pruebas de publicación
de inmuebles (HU-04), comprobando que los datos válidos se guardan
correctamente y que los datos inválidos son rechazados.
### Prioridades actuales

- Flujos funcionales críticos.
- Reglas de negocio relevantes.
- Validaciones y errores controlados.
- Persistencia y consultas significativas.
- Comportamientos propensos a fallo.
- Funcionalidades modificadas o susceptibles de regresión.

### Tipos de prueba utilizados

| Tipo | Cuándo se utiliza | Ejemplos en el proyecto |
|---|---|---|
| Unitaria | Para comprobar una clase o regla de negocio de forma aislada | Validación del título y la ciudad en PropertyService |
| Integración | Para comprobar la colaboración entre componentes y la base de datos | Guardado y recuperación de inmuebles mediante JPA y H2 |
| Web / controlador | Para comprobar las peticiones HTTP y los formularios | Publicación de inmuebles desde el formulario web |

> El equipo no tiene que utilizar todos los tipos de prueba en todas las funcionalidades. Debe seleccionar el nivel de prueba adecuado al comportamiento que quiere proteger.

---

## 3. Funcionalidades y comportamientos prioritarios

> Registrar aquí los principales flujos o comportamientos que el equipo considera relevantes para probar. No es necesario incluir todas las issues del proyecto.

| ID | Funcionalidad / comportamiento | Issue o requisito relacionado | Motivo de prioridad | Estado de pruebas |
|---|---|---|---|---|
| FP-01 | Publicar un inmueble con datos válidos | HU-04 | Garantizar que los inmuebles se guardan correctamente | Parcial |
| FP-02 | Rechazar inmuebles sin título válido | HU-04 | Evitar almacenar inmuebles con información obligatoria incorrecta | Parcial |
| FP-03 | Rechazar inmuebles sin ciudad válida | HU-04 | Garantizar la integridad de los datos almacenados | Parcial |

---

## 4. Catálogo de casos de prueba

> Los casos se diseñan primero en lenguaje natural. Después, cuando proceda, se automatizan con JUnit.
| ID | Funcionalidad | Criterio protegido | Tipo de caso | Entrada / situación | Resultado esperado | Prioridad |
|---|---|---|---|---|---|---|
| CP-01 | Publicar inmueble | Guardado de datos válidos | Válido | Título y ciudad correctos | El inmueble se guarda correctamente | Alta |
| CP-02 | Publicar inmueble | Título obligatorio | Inválido | Título nulo | Se lanza IllegalArgumentException y no se guarda | Alta |
| CP-03 | Publicar inmueble | Título obligatorio | Inválido | Título vacío | Se lanza IllegalArgumentException y no se guarda | Alta |
| CP-04 | Publicar inmueble | Título obligatorio | Límite | Título formado solo por espacios | Se lanza IllegalArgumentException y no se guarda | Alta |
| CP-05 | Publicar inmueble | Ciudad obligatoria | Inválido | Ciudad nula | Se lanza IllegalArgumentException y no se guarda | Alta |
| CP-06 | Publicar inmueble | Ciudad obligatoria | Inválido | Ciudad vacía | Se lanza IllegalArgumentException y no se guarda | Alta |
| CP-07 | Publicar inmueble | Ciudad obligatoria | Límite | Ciudad formada solo por espacios | Se lanza IllegalArgumentException y no se guarda | Alta |
### Convención

- **Válido:** comprueba comportamiento esperado con datos correctos.
- **Inválido:** comprueba que una entrada o situación incorrecta se trata de forma controlada.
- **Límite:** comprueba valores frontera o casos especialmente sensibles.
- **Regresión:** protege un comportamiento ante cambios futuros.

---

## 5. Particiones de equivalencia y valores límite

> Utilizar esta sección únicamente en los comportamientos donde estas técnicas aporten valor. No es necesario rellenarla para cada prueba.

### Particiones de equivalencia
| Dato / condición | Partición válida | Partición inválida | Casos asociados |
|---|---|---|---|
| Título del inmueble | Texto no vacío con caracteres distintos de espacios | Valor nulo, cadena vacía o solo espacios | CP-01, CP-02, CP-03, CP-04 |
| Ciudad del inmueble | Texto no vacío con caracteres distintos de espacios | Valor nulo, cadena vacía o solo espacios | CP-01, CP-05, CP-06, CP-07 |

### Valores límite
| Dato / condición | Valores límite relevantes | Comportamiento esperado | Casos asociados |
|---|---|---|---|
| Título del inmueble | null, "", "   ", "A" | Rechazar valores nulos, vacíos o con solo espacios; aceptar un carácter válido | CP-01, CP-02, CP-03, CP-04 |
| Ciudad del inmueble | null, "", "   ", "A" | Rechazar valores nulos, vacíos o con solo espacios; aceptar un carácter válido | CP-01, CP-05, CP-06, CP-07 |

---

## 6. Pruebas automatizadas implementadas

> Relacionar los casos diseñados con las pruebas JUnit existentes. Una prueba puede cubrir uno o varios casos relacionados si está justificado.

| ID caso | Clase / método JUnit | Tipo | Comportamiento protegido | Estado |
|---|---|---|---|---|
| CP-01 | PropertyServiceTest / guardarInmuebleValido | Unitaria | Guardado correcto de un inmueble | Pendiente |
| CP-02 | PropertyServiceTest / rechazarTituloNulo | Unitaria | Rechazo de título nulo | Pendiente |
| CP-03 | PropertyServiceTest / rechazarTituloVacio | Unitaria | Rechazo de título vacío | Pendiente |
| CP-04 | PropertyServiceTest / rechazarTituloConEspacios | Unitaria | Rechazo de título con espacios | Pendiente |
| CP-05 | PropertyServiceTest / rechazarCiudadNula | Unitaria | Rechazo de ciudad nula | Pendiente |
| CP-06 | PropertyServiceTest / rechazarCiudadVacia | Unitaria | Rechazo de ciudad vacía | Pendiente |
| CP-07 | PropertyServiceTest / rechazarCiudadConEspacios | Unitaria | Rechazo de ciudad con espacios | Pendiente |
### Criterios de diseño

Las pruebas implementadas deberían, cuando resulte aplicable:

- seguir una estructura comprensible **Arrange – Act – Assert**;
- tener nombres descriptivos;
- utilizar datos de prueba claros;
- contener aserciones significativas;
- comprobar un objetivo entendible;
- fallar cuando se rompe el comportamiento protegido;
- evitar dependencias innecesarias de detalles internos;
- ser repetibles desde Maven.

---

## 7. Revisión de calidad de las pruebas

> Esta sección sirve para revisar el conjunto de pruebas, no para crear una ficha por cada test.

### Checklist general

- [ ] Las pruebas están relacionadas con requisitos, criterios o comportamientos relevantes.
- [ ] Existen casos válidos, inválidos y límite cuando corresponda.
- [ ] Las aserciones comprueban resultados significativos.
- [ ] Las pruebas pueden fallar ante defectos reales relacionados con el comportamiento protegido.
- [ ] No existen pruebas vacías o que siempre pasen.
- [ ] No se mezclan demasiados objetivos no relacionados en una misma prueba.
- [ ] Se han detectado y corregido pruebas frágiles cuando ha sido necesario.
- [ ] El equipo comprende qué protege cada prueba relevante.
- [ ] Las pruebas pueden ejecutarse de forma reproducible con Maven.

### Pruebas frágiles, débiles o poco significativas detectadas

| Prueba | Problema detectado | Decisión | Estado |
|---|---|---|---|
|  |  | Modificar / Dividir / Eliminar / Mantener justificada | Pendiente / Resuelto |
|  |  |  |  |

---

## 8. Defecto deliberado — Evidencia S6

> Durante S6 el equipo debe introducir de forma controlada al menos un defecto para comprobar si una prueba es capaz de detectarlo.

- **Prueba seleccionada:**  
- **Comportamiento protegido:**  
- **Defecto introducido:**  
- **Resultado esperado:**  
- **¿La prueba falló?:** Sí / No  
- **Corrección realizada:**  
- **Resultado después de corregir:**  

### Evidencia de ejecución

```powershell
.\mvnw.cmd test
.\mvnw.cmd verify
```

- **Resultado antes del defecto:**  
- **Resultado con el defecto:**  
- **Resultado tras la corrección:**  

> La finalidad no es romper el proyecto sin motivo, sino demostrar que la prueba puede detectar el defecto que afirma proteger.

---

## 9. Ejecución reproducible del conjunto de pruebas

### Comandos de referencia

```powershell
.\mvnw.cmd test
.\mvnw.cmd verify
```

### Estado actual

- [ ] El conjunto de pruebas puede ejecutarse desde Maven.
- [ ] El build completo finaliza correctamente.
- [ ] Los fallos existentes están identificados y documentados.
- [ ] No existen pruebas deshabilitadas o eliminadas únicamente para obtener un build verde.

### Última ejecución

- **Fecha:**  
- **Resultado:**  
- **Incidencias:**  

---

## 10. Verificación y relación con cobertura y calidad

> Esta sección se completa progresivamente durante S7 y S8.
>
> **Importante:** la cobertura y Sonar aportan evidencias complementarias, pero no sustituyen el diseño de buenos casos de prueba. El **Hito 2** se cierra en **S7** con pruebas y verificación automatizada; Sonar pertenece a la dimensión de **Calidad** y prepara información para el mantenimiento posterior.

### 10.1 Verificación — S7 · Maven y Surefire

> Registrar aquí la evidencia mínima de que el conjunto de pruebas puede ejecutarse de forma reproducible fuera del IDE.

- **Fecha de verificación:**  
- **Rama / commit verificado:**  
- **Comandos ejecutados:**

```powershell
.\mvnw.cmd test
.\mvnw.cmd verify
```

- **Resultado de `test`:**  
- **Resultado de `verify`:**  
- **Número de tests ejecutados:**  
- **Fallos o errores relevantes:**  
- **Informe Surefire revisado:** `target/surefire-reports/`  
- **Evidencia / enlace:**  

### 10.2 Cobertura — S7 · JaCoCo

- **Informe generado:** `target/site/jacoco/index.html`  
- **Cobertura observada de forma global:**  
- **Clase / paquete / comportamiento revisado:**  
- **Zonas importantes con cobertura insuficiente:**
  - 
  - 

- **Ramas o casos relevantes no ejercitados:**
  - 
  - 

- **Justificación de zonas no cubiertas cuando proceda:**
  - 
  - 

> No se exige perseguir un porcentaje concreto por sí mismo. La cobertura debe interpretarse en relación con comportamientos, requisitos, casos de prueba y riesgos reales.

### 10.3 Interpretación y decisión — S7

> La cobertura debe provocar una decisión técnica explícita, aunque la decisión sea no añadir ninguna prueba.

- **Carencia o riesgo detectado:**  
- **Caso(s) del plan afectados:**  
- **Decisión:** Añadir prueba / Mejorar prueba / Mantener sin cambios / Justificar no cobertura  
- **Cambio realizado:**  
- **Motivo:**  
- **Resultado tras repetir `test` / `verify`:**  
- **Relación con AI-02, si procede:**  
- **Evidencia / enlace:**  

### 10.4 Sonar — S8 · Contexto para nuevas necesidades de prueba

- Problemas o incidencias que sugieren añadir o revisar pruebas:
  - 
  - 

- Pruebas añadidas o modificadas como consecuencia del análisis de calidad:
  - 
  - 

> **La cobertura no se interpreta como un objetivo aislado.** Debe relacionarse con requisitos, casos de prueba, defectos que se pretende detectar y zonas relevantes del código.

---

## 11. Pendientes y evolución del plan

| Pendiente / mejora | Motivo | Prioridad | Responsable | Estado |
|---|---|---|---|---|
| Implementar pruebas unitarias de PropertyService | Verificar las validaciones de HU-04 | Alta | Equipo Nexova | Pendiente |
| Ejecutar pruebas con Maven | Comprobar que las pruebas funcionan correctamente | Alta | Equipo Nexova | Pendiente |
| Realizar demostración verde-rojo-verde | Demostrar que una prueba detecta un defecto real | Alta | Equipo Nexova | Pendiente |
| Revisar calidad de las pruebas JUnit | Detectar pruebas débiles o frágiles | Alta | Equipo Nexova | Pendiente |
| Analizar cobertura con JaCoCo en S7 | Identificar comportamientos relevantes sin probar | Media | Equipo Nexova | Pendiente |
| Analizar calidad con Sonar en S8 | Detectar problemas de calidad y nuevas necesidades de pruebas | Media | Equipo Nexova | Pendiente |

El plan debe actualizarse cuando:

- se incorporen nuevas funcionalidades relevantes;
- cambien criterios o reglas de negocio;
- se detecten defectos significativos;
- se añadan o eliminen pruebas importantes;
- se detecten pruebas frágiles;
- JaCoCo muestre zonas relevantes no ejercitadas;
- la verificación S7 produzca una decisión sobre añadir, mejorar o justificar pruebas;
- Sonar revele nuevas necesidades de verificación;
- cambie la estrategia de pruebas del equipo.

---

## 12. Resumen del estado de pruebas

- **Principales comportamientos protegidos:** Publicación de inmuebles con datos válidos y validación de los campos obligatorios (título y ciudad).
- **Pruebas automatizadas relevantes:** Pruebas de integración existentes relacionadas con HU-04.
- **Carencias actuales:** Pendiente de implementar y verificar las pruebas unitarias de PropertyService.
- **Próxima prioridad de pruebas:** Implementar pruebas JUnit para los casos CP-01 a CP-07.
- **Estado general:** En progreso.
