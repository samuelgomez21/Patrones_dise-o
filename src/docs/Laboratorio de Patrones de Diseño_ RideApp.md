# **Laboratorio Integrador de Patrones de Diseño Proyecto: RideApp**

## **Contexto General**

La empresa tecnológica RideApp desea desarrollar una plataforma similar a Uber para gestionar viajes, pasajeros y conductores de manera eficiente, escalable y mantenible.

**El sistema deberá permitir:**

* Solicitar viajes.  
* Asignar conductores.  
* Notificar eventos automáticamente.  
* Gestionar estados del viaje.  
* Configurar distintos tipos de servicios.

Para resolver estos problemas de diseño se implementarán patrones creacionales y comportamentales.

# **Objetivo General**

Desarrollar una aplicación ejecutable que simule el flujo completo de un viaje en RideApp, integrando correctamente múltiples patrones de diseño y justificando su uso según los requerimientos funcionales del sistema.

# **Objetivos de Aprendizaje**

Al finalizar el laboratorio, el aprendiz estará en capacidad de:

* Comprender cómo los requerimientos funcionales originan la necesidad de un patrón de diseño.  
* Aplicar patrones creacionales y comportamentales en un contexto real.  
* Implementar un flujo de integración entre múltiples patrones.  
* Identificar ventajas arquitectónicas de cada patrón.  
* Explicar cómo interactúan los patrones para resolver problemas de software.  
* Diseñar soluciones escalables y desacopladas.

# **Reglas Generales del Laboratorio**

## **Restricciones técnicas**

* No se permite crear objetos Viaje directamente usando new fuera del Factory o Builder.  
* Los cambios de estado deben gestionarse exclusivamente mediante el patrón State.  
* Las notificaciones deben implementarse mediante Observer.  
* La comunicación entre pasajero y conductor debe pasar por Mediator.  
* El sistema debe demostrar integración real entre todos los patrones.  
* Debe existir una única instancia central de RideApp.

# **Flujo General del Sistema**

1\. El pasajero solicita un viaje.  
2\. RideApp recibe la solicitud.  
3\. Factory determina el tipo de viaje.  
4\. Builder configura las opciones del viaje.  
5\. Mediator asigna conductor.  
6\. Observer notifica eventos.  
7\. State controla el ciclo de vida del viaje.  
8\. El viaje finaliza.

# **FASE 1 — Implementación de Patrones**

# **1\. Singleton — RideApp**

## **Problema a resolver**

Debe existir una única instancia central que administre viajes y usuarios.

## **Objetivo del patrón**

Garantizar que solo exista una instancia global del sistema.

## **Comportamiento esperado**

RideApp.getInstance()  
siempre devuelve la misma instancia.

## **Tarea**

Implementar:

RideApp

con:

* constructor privado,  
* instancia única,  
* método getInstance().

# **2\. Factory Method — ViajeFactory**

## **Problema a resolver**

El sistema debe crear distintos tipos de viajes sin acoplarse a clases concretas.

## **Tipos de viaje sugeridos**

* ViajeEconomico  
* ViajePremium  
* ViajeMoto  
* ViajeCompartido

## **Objetivo del patrón**

Centralizar la creación de objetos.

## **Pregunta que responde Factory**

¿Qué tipo de viaje debo crear?

## **Ejemplo conceptual**

Viaje viaje \= ViajeFactory.crearViaje("premium");

## **Tarea**

Implementar:

ViajeFactory

capaz de crear distintos tipos de viajes.

# **3\. Builder — ViajeBuilder**

## **Problema a resolver**

Los viajes pueden tener múltiples configuraciones opcionales.

## **Opciones sugeridas**

* Wifi  
* Mascota  
* Aire acondicionado  
* Equipaje  
* Música  
* Número de pasajeros

## **Objetivo del patrón**

Construir objetos complejos paso a paso.

## **Pregunta que responde Builder**

¿Cómo debe configurarse este viaje?

## **Ejemplo conceptual**

Viaje viaje \= new ViajeBuilder()  
    .setWifi(true)  
    .setMascota(false)  
    .setEquipaje(true)  
    .build();

## **Tarea**

Implementar:

ViajeBuilder

para personalizar viajes.

# **Diferencia entre Factory y Builder**

| Factory | Builder |
| ----- | ----- |
| Decide QUÉ crear | Decide CÓMO construirlo |
| Crea tipos de viaje | Configura opciones del viaje |
| Reduce acoplamiento | Evita constructores complejos |

# **4\. Observer — Notificaciones automáticas**

## **Problema a resolver**

Pasajeros, conductores y UI deben recibir notificaciones automáticas cuando cambie el estado del viaje.

## **Objetivo del patrón**

Mantener actualizados múltiples objetos automáticamente.

## **Eventos sugeridos**

* Viaje solicitado  
* Conductor asignado  
* Viaje iniciado  
* Viaje finalizado  
* Viaje cancelado

## **Tarea**

Implementar:

* Observable  
* Observador  
* Pasajero  
* Conductor  
* UIObserver

# **5\. Mediator — Central de viajes**

## **Problema a resolver**

Evitar comunicación directa entre pasajero, conductor y sistema.

## **Objetivo del patrón**

Centralizar la comunicación y reducir acoplamiento.

## **Pregunta que responde Mediator**

¿Quién coordina la interacción entre todos?

## **Ejemplo conceptual**

Pasajero → Mediator → Conductor o viceversa

## **Tarea**

Implementar:

CentralViajesMediator

# **6\. State — Ciclo de vida del viaje**

## **Problema a resolver**

El comportamiento del viaje cambia según su estado.

## **Estados obligatorios**

* Solicitado  
* Asignado  
* EnCamino  
* Finalizado  
* Cancelado

## **Objetivo del patrón**

Eliminar grandes bloques de if/else y encapsular comportamientos.

# **Reglas de negocio**

| Estado | Acciones permitidas |
| ----- | ----- |
| Solicitado | Cancelar |
| Asignado | Iniciar viaje / Cancelar |
| EnCamino | Finalizar |
| Finalizado | Ninguna |
| Cancelado | Ninguna |

# **Pregunta que responde State**

¿Qué acciones son válidas según el estado actual?

## **Tarea**

Implementar:

EstadoViaje y las clases de estado correspondientes.

# **FASE 2 — Integración del Sistema**

# **Flujo obligatorio de ejecución**

La aplicación debe simular completamente el siguiente escenario:

1\. Pasajero solicita viaje.  
2\. RideApp recibe solicitud.  
3\. Factory crea el tipo de viaje.  
4\. Builder configura opciones.  
5\. Mediator asigna conductor.  
6\. Observer notifica asignación.  
7\. Viaje cambia a estado Asignado.  
8\. Viaje inicia.  
9\. Observer notifica inicio.  
10\. Viaje cambia a EnCamino.  
11\. Viaje finaliza.  
12\. Observer notifica finalización.  
13\. Estado final \= Finalizado.

# **Evidencia obligatoria en consola**

El sistema debe mostrar mensajes similares a:

\[RideApp\] Solicitud recibida  
\[Factory\] Creando viaje premium  
\[Builder\] Configurando viaje  
\[Mediator\] Conductor asignado  
\[Observer\] Pasajero notificado  
\[State\] Estado actual: EnCamino

# **Arquitectura sugerida**

src/  
 ├── app/  
 ├── factory/  
 ├── builder/  
 ├── observer/  
 ├── mediator/  
 ├── state/  
 ├── model/  
 └── main/

# **FASE 3 — Documentación**

# **Entregables**

## **1\. Código fuente**

Versionamiento del codigo fuente, en una herramienta de trabajo colaborativo como Git/Github para el Proyecto funcional y organizado.

## **2\. Evidencia de ejecución**

* Video o capturas.  
* Flujo completo funcionando.

## **3\. Diagramas UML**

Debe incluir:

* diagrama de clases,  
* relaciones entre patrones,  
* flujo general.

# **Rúbrica de Evaluación**

| Criterio | Peso |
| ----- | ----- |
| Implementación de patrones creacionales | 20% |
| Implementación de patrones comportamentales | 20% |
| Flujo ejecutable integrado | 30% |
| UML y documentación | 15% |
| Sustentación conceptual | 15% |

