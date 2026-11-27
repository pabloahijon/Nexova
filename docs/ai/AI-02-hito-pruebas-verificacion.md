# AI-02 — Hito 2 · Pruebas y verificación con IA agéntica

> **Ingeniería del Software II · Laboratorio 2026-2027**
>
> Esta ficha documenta el **Hito 2 de IA agéntica**, centrado exclusivamente en la revisión, mejora y verificación de una prueba automatizada propuesta por IA.
>
> Se completa progresivamente durante **S6 y S7**. La sesión **S8 (Sonar y gestión de la calidad)** pertenece a la dimensión de Calidad y prepara evidencias que podrán alimentar posteriormente el **Hito 3 · Mantenimiento de la calidad**, pero **no forma parte del Hito 2**.

---

## 1. Identificación

- **Equipo / empresa:** NEXOVA 
- **Integrantes:**
Pablo Ahijón Hormigos.
Irene Caraballo Jerez.
Anaís Chiquito Patiño.
Hugo Fernández Blanco.
Ronald Denis Pilataxi Lema.
- **Repositorio:**  https://github.com/pabloahijon/Nexova
- **Issue / requisito relacionado:**  HU-04 — Publicar un inmueble (#4).
- **Criterio o comportamiento protegido:**  La aplicación debe rechazar la publicación de inmuebles cuyo título esté formado únicamente por espacios, evitando que se almacenen datos inválidos en la base de datos.
- **Responsable principal del Hito 2:** El equipo de nexova. 
- **Participantes y contribución de cada uno:**  
- **Participantes y contribución de cada uno:**
  - Pablo Ahijón Hormigos:Revisión de los cambios realizados, control de versiones e integración de las pruebas en el repositorio.
  - Irene Caraballo Jerez: Diseño, implementación y verificación de las pruebas automatizadas mediante JUnit y Mockito.
  - Anaís Chiquito Patiño: Revisión de la configuración de Maven, Surefire y JaCoCo, y seguimiento de las ejecuciones.
  - Hugo Fernández Blanco: Revisión de los criterios de aceptación de la HU-04, valoración de las pruebas propuestas por la IA y documentación de las decisiones y evidencias del Hito 2.
  - Ronald Denis Pilataxi Lema: Revisión de los casos de prueba, comprobación de su correspondencia con los requisitos y apoyo en la verificación de los resultados.

---

## 2. Diseño humano previo

> Completar antes de pedir al agente una propuesta de prueba.

- **Caso relacionado de `docs/testing/TEST_PLAN.md`, si procede:** CP-04 — Rechazar inmuebles cuyo título está formado únicamente por espacios.
- **Entrada / situación:**  Se intenta publicar un inmueble cuyo título contiene únicamente tres espacios, mientras que el resto de sus atributos contienen valores válidos.
- **Resultado esperado:**  El servicio debe lanzar una excepción IllegalArgumentException y no debe invocar el método save() del repositorio.
- **Tipo de caso:** Límite  
- **Qué defecto debería detectar una buena prueba:**  Una validación incorrecta que permita publicar inmuebles con títulos formados únicamente por espacios, incumpliendo el requisito de título obligatorio.
- **Qué aserción o resultado observable debería comprobar:**  Mediante assertThrows() se debe comprobar que se lanza la excepción esperada y mediante verify(repository, never()).save(any(Property.class)) se debe verificar que el inmueble inválido no llega a guardarse.

### Contexto proporcionado al agente

- [x] Repositorio abierto.
- [x] `AGENTS.md` y skill de revisión de pruebas aplicable.
- [x] Issue / criterio de aceptación.
- [x] `docs/testing/TEST_PLAN.md`.
- [x] Código de producción relevante.
- [x] Pruebas existentes relacionadas.

**Herramienta / agente:**  Codex integrado en Visual Studio Code

**Prompt principal:**
Analiza el código de nuestro proyecto NEXOVA, teniendo en cuenta las instrucciones de AGENTS.md, la skill de revisión de pruebas y los criterios de aceptación de la HU-04 (Publicar un inmueble), así como los casos definidos en docs/testing/TEST_PLAN.md.

Propón pruebas unitarias utilizando JUnit 5 y Mockito para verificar el comportamiento de PropertyService durante la publicación de inmuebles. Las pruebas deben contemplar casos válidos, inválidos y límite, incluyendo títulos y ciudades con valores nulos, vacíos o formados únicamente por espacios.

Presta especial atención al caso de prueba CP-04, comprobando que un inmueble cuyo título contiene únicamente espacios sea rechazado correctamente y no llegue a almacenarse en el repositorio.

Utiliza el patrón Arrange-Act-Assert, emplea aserciones significativas y mantén la arquitectura y los requisitos existentes del proyecto.

Explica qué comportamiento protege cada prueba, qué defectos permite detectar y cómo podemos comprobar su eficacia introduciendo temporalmente un defecto en el código de producción.

Las propuestas deberán ser revisadas por el equipo antes de su integración y verificadas mediante Maven, Surefire y el análisis de cobertura con JaCoCo.
---

## 3. Propuesta inicial de la IA

### Prueba propuesta

- **Clase / método:**  PropertyServiceTest.java — rechazarTituloConEspacios().
- **Datos de prueba:**  Inmueble cuyo título está formado únicamente por tres espacios, con ciudad «Madrid», tipo «PISO» y descripción «Piso luminoso».
- **Aserciones:**  Uso de assertThrows() para comprobar que el método save() de PropertyService lanza una excepción de tipo IllegalArgumentException.
- **Qué pretende comprobar:**  Que el sistema rechaza la publicación de inmuebles cuyo título está formado únicamente por espacios, cumpliendo el criterio de aceptación de la HU-04 relativo a la obligatoriedad del título.
- **Tipo de prueba:** Unitaria 

### Valoración inicial del equipo

- **¿Protege realmente el criterio seleccionado?:** Parcial  
- **¿Los datos de entrada son adecuados?:** Sí 
- **¿Las aserciones son significativas?:** Parcial  
- **¿Incluye los casos límite relevantes?:** Sí  
- **¿Podría pasar aunque exista un defecto importante?:** Sí

---

## 4. Revisión humana y mejora

### Carencia detectada

-  La prueba inicial propuesta por la IA únicamente comprobaba que se lanzaba una excepción IllegalArgumentException cuando el título estaba formado exclusivamente por espacios. Sin embargo, no verificaba que el inmueble inválido no hubiera sido almacenado previamente en el repositorio.

### Cambio realizado

-  Se añadió una comprobación mediante Mockito utilizando verify(repository, never()).save(any(Property.class)), manteniendo la aserción original assertThrows().

### Motivo del cambio

-  Garantizar que la prueba protege completamente el criterio de aceptación de la HU-04, comprobando tanto el rechazo de los datos inválidos como la ausencia de efectos secundarios sobre la persistencia de los inmuebles.

### Defecto que ahora puede detectar

-  Una implementación incorrecta del servicio que almacene un inmueble con un título inválido antes de lanzar la excepción. La prueba inicial podría superar este escenario, mientras que la prueba mejorada detectaría la llamada indebida al repositorio.

### Decisión sobre la propuesta

- [ ] Aceptada sin cambios.
- [x] Modificada.
- [ ] Rechazada y sustituida por otra propuesta.

**Justificación:**

-  El equipo consideró adecuado el planteamiento inicial de la IA, pero identificó la necesidad de reforzar las comprobaciones realizadas. Por ello, se decidió mantener la estructura y los datos de la prueba original, incorporando una verificación adicional que garantiza que los inmuebles inválidos no llegan a almacenarse. Esta modificación mejora la capacidad de detección de defectos y asegura una mayor correspondencia con los criterios de aceptación de la HU-04.

---

## 5. Verificación de la prueba

### Ejecución reproducible

```powershell
.\mvnw.cmd test
.\mvnw.cmd verify
```

- **Resultado:**  Durante la verificación documentada se ejecutaron correctamente las 11 pruebas automatizadas del proyecto, sin fallos ni errores, obteniendo BUILD SUCCESS.

### Defecto deliberado

- **Defecto introducido:**  Modificación temporal del dato de entrada de la prueba rechazarTituloConEspacios(), sustituyendo el título formado únicamente por espacios por el título válido «Mi piso».
- **Resultado esperado con el defecto:**  La prueba debía fallar, puesto que el servicio no lanza una excepción cuando recibe un título válido.
- **¿La prueba falló?:** Sí   
- **Qué demuestra ese fallo:**  Que la prueba detecta una discrepancia entre el resultado esperado y el comportamiento obtenido durante la ejecución.
- **Corrección realizada:**  Restauración del dato de entrada original, utilizando un título formado únicamente por espacios.
- **Resultado tras corregir:**   Ejecución satisfactoria según las evidencias de verificación disponibles. Pendiente de confirmar nuevamente en la versión actual del proyecto.

### Evidencia mínima obligatoria

- **Prueba propuesta por IA:**   rechazarTituloConEspacios() de la clase PropertyServiceTest.java.
- **Carencia detectada:**  La comprobación de la excepción no garantiza por sí sola que el inmueble inválido no haya sido almacenado.
- **Cambio realizado:**  Incorporación de una comprobación mediante Mockito para verificar que no se invoca el método de guardado del repositorio, pendiente de confirmar como mejora humana sobre la propuesta original.
- **Motivo:**  Garantizar el rechazo de los datos inválidos y evitar su almacenamiento.
- **Defecto que ahora puede detectar:** Una validación incorrecta del título o un intento indebido de guardar un inmueble inválido. 
- **Resultado de ejecución:**  Se ha comprobado el fallo de la prueba al modificar su entrada. Queda pendiente verificar su capacidad para detectar un defecto introducido directamente en el código de producción.

---

## 6. Verificación automatizada y cobertura · S7

> En S7 se completa la parte de verificación del Hito 2 y se actualiza también `docs/testing/TEST_PLAN.md` con la ejecución reproducible, la cobertura observada y la decisión tomada a partir de esa evidencia.

- [x] Las pruebas se ejecutan correctamente mediante Maven / Surefire.
- [x] El build completo es reproducible.
- [x] Se ha generado el informe de cobertura con JaCoCo.
- [x] La cobertura se ha interpretado en relación con requisitos, casos de prueba y defectos.
- [x] Se han identificado zonas relevantes poco ejercitadas cuando proceda.
- [x] Se ha decidido si hace falta añadir, mejorar o mantener una prueba sin cambios.
- [x] La decisión adoptada se ha reflejado en `docs/testing/TEST_PLAN.md`.
- [x] La prueba trabajada en el Hito 2 sigue siendo válida dentro del conjunto completo.

### Evidencia de verificación S7

- **Resultado Maven / Surefire:** Durante la verificación de S7 se ejecutaron 11 pruebas automatizadas, sin fallos ni errores, obteniendo BUILD SUCCESS mediante los comandos test y verify. 
- **Zona de cobertura revisada:**  Se analizó principalmente la clase PropertyService, responsable de la validación y almacenamiento de los inmuebles. El informe JaCoCo muestra una cobertura global de instrucciones del 76 % y una cobertura de ramas del 100 %. En PropertyService se obtuvo una cobertura de instrucciones del 87,5 % y una cobertura de ramas del 100 %.
- **Carencia o riesgo detectado, si existe:**  Una cobertura elevada no garantiza que las pruebas sean capaces de detectar todos los defectos relevantes. Además, se identificaron zonas de los controladores web con una cobertura inferior a la de la capa de servicio.
- **Decisión tomada:** Mantener y justificar  
- **Actualización realizada en `docs/testing/TEST_PLAN.md`:**  Se han incorporado los resultados de ejecución de Maven y Surefire en el apartado 10.1 y los resultados de cobertura de JaCoCo en el apartado 10.2. Queda pendiente registrar la decisión adoptada en el apartado 10.3.
- **Evidencia enlazada:**  Informe de cobertura JaCoCo.

### Decisiones tomadas a partir de la ejecución y cobertura

-  Mantener las pruebas unitarias de validación del título y la ciudad, ya que protegen los criterios de aceptación de la HU-04 y contemplan los casos definidos en el plan de pruebas.

- Priorizar la capacidad real de detección de defectos y la calidad de las aserciones frente al incremento artificial de los porcentajes de cobertura.

- Valorar la incorporación de nuevas pruebas sobre los controladores web conforme se amplíen las funcionalidades del sistema.

- No incorporar pruebas cuyo único objetivo sea aumentar la cobertura de código sin proteger comportamientos relevantes del sistema.

> **Cobertura alta no implica automáticamente buenas pruebas.** La evidencia debe demostrar capacidad real para detectar defectos relevantes.

---

## 7. Evidencias

| Evidencia | Captura / enlace |
|---|---|
| Propuesta inicial de prueba por IA | [AI_USAGE.md — Sesión 6](../../AI_USAGE.md). No se conserva la propuesta original por separado. |
| Revisión / carencia detectada | Apartado 4 del documento. |
| Mejora realizada por el equipo | [Corrección de la prueba CP-04](../evidences/s6/correccion_rechazarTituloConEspacios.png).
| Defecto deliberado y ejecución | [Fallo de la prueba CP-04](../evidences/s6/Error_rechazarTituloConEspacios.png) - [Verify incorrecto](../evidences/s6/Verify_error.png).|
| Resultado Maven / Surefire | [Verify correcto S6](../evidences/s6/Verify_correcto.png) - [Test S7](../evidences/s7/Resultado_defecto_test.png) - [Verify S7](../evidences/s7/Resultado_defecto_verify.png) |
| Cobertura JaCoCo interpretada | [Informe JaCoCo](../evidences/s7/jacoco_index.png) - [TEST_PLAN.md](../testing/TEST_PLAN.md) |

---

---

## 8. Conclusión y defensa

### Conclusión

- **Qué aportó la IA:** Apoyo en el diseño del plan de pruebas, identificación de casos válidos, inválidos y límite, y propuesta de pruebas unitarias mediante JUnit 5 y Mockito para verificar los criterios de aceptación de la HU-04. 
- **Qué tuvo que revisar o corregir el equipo:**  La adecuación de los datos de entrada, la correspondencia de las pruebas con los requisitos y la capacidad de las aserciones para comprobar tanto el rechazo de los inmuebles inválidos como la ausencia de almacenamiento.
- **Qué decisión humana fue más importante:**  Priorizar la capacidad real de detección de defectos y el cumplimiento de los criterios de aceptación frente a la simple ejecución satisfactoria de las pruebas o la obtención de porcentajes elevados de cobertura.
- **Qué defecto puede detectar ahora la prueba:** Una validación incorrecta que permita publicar inmuebles cuyo título esté formado únicamente por espacios o una llamada indebida al repositorio para almacenar un inmueble inválido. 
- **Cómo se verificó:**  Mediante la ejecución automatizada de las pruebas con Maven y Surefire, la demostración del fallo de la prueba CP-04 y el análisis de la cobertura obtenida mediante JaCoCo. Queda pendiente confirmar la detección de un defecto introducido directamente en el código de producción.

### Estado final

- [x] Prueba IA revisada críticamente.
- [x] Carencia identificada.
- [x] Mejora aplicada o rechazo justificado.
- [x] Defecto deliberado detectado.
- [x] Build y pruebas correctos.
- [x] Ejecución reproducible con Maven / Surefire.
- [x] Cobertura JaCoCo interpretada.
- [x] Evidencias completadas.

### Resumen breve para defensa

Prueba seleccionada: Prueba unitaria rechazarTituloConEspacios() de la clase PropertyServiceTest.java, correspondiente al caso CP-04 de la HU-04 (Publicar un inmueble).

Carencia detectada: La ejecución satisfactoria de la prueba no era suficiente para demostrar su capacidad de detectar errores en la validación del título del inmueble. Era necesario comprobar su comportamiento ante una situación incorrecta.

Cambio realizado: Revisión de los datos de entrada y de las aserciones de la prueba, junto con una comprobación experimental de su capacidad para fallar cuando no se cumple el resultado esperado.

Defecto que ahora detecta: Una validación incorrecta que permita aceptar títulos formados únicamente por espacios.

Resultado de ejecución: Durante la verificación documentada en S7 se ejecutaron 11 pruebas automatizadas, sin fallos ni errores, obteniendo BUILD SUCCESS. También se comprobó el fallo de la prueba CP-04 mediante la modificación temporal de su entrada.

Decisión tomada a partir de la cobertura: Mantener y justificar las pruebas unitarias existentes de PropertyService, considerando su cobertura de instrucciones y de ramas, y priorizando la capacidad de detección de defectos frente al incremento artificial de la cobertura.

Conclusión: La IA ha facilitado el diseño y la implementación de las pruebas automatizadas, mientras que la revisión humana ha permitido valorar su adecuación a los requisitos y la calidad de sus aserciones. La ejecución mediante Maven, Surefire y el análisis de cobertura con JaCoCo proporcionan evidencias para evaluar la calidad de las pruebas.

---

### Regla final

> **La IA puede proponer una prueba, pero el equipo debe revisar si protege realmente el comportamiento esperado, mejorarla cuando sea necesario y demostrar mediante ejecución reproducible que detecta el defecto que afirma proteger.**
>
> La evidencia de **Sonar y calidad** se trabaja fuera de este hito y se incorpora al **Hito 3 · Mantenimiento de la calidad** cuando corresponda.