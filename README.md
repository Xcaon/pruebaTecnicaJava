# Sistema de Gestión de Ventas – Prueba Técnica

_Este proyecto es una API REST desarrollada con Spring Boot que permite gestionar Sucursales, Productos y Ventas aplicando relaciones reales de negocio (1:N y N:M) mediante JPA/Hibernate.
Se creó como parte de una prueba técnica, demostrando dominio de backend, consultas SQL/JPQL y diseño de APIs limpias._

## Comenzando

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._


### Pre-requisitos

_Que cosas necesitas para probar la prueba_

```
Java 17+
Maven 3+
MySQL 8+
Postman (opcional)
```

### Objetivo de la prueba

✔️ Modelado de entidades y relaciones

* Implementación de relaciones 1:N (Sucursal → Ventas).

* Implementación de relaciones N:M (Ventas → Productos).

* Gestión de tabla intermedia generada por Hibernate.

* Manejo de recursividad en JSON mediante @JsonIgnoreProperties y @JsonIgnore.

✔️ Creación de una API REST completa

* Endpoints para CRUD de Sucursales, Productos y Ventas.

* Recepción y parseo de JSON con objetos anidados.

* Validación básica de datos.

✔️ Consultas SQL/JPQL personalizadas

* Consultas JPQL para obtener ventas filtradas por sucursal y fecha.

* Consulta SQL nativa para obtener el producto más vendido.

* Uso de agregaciones, GROUP BY, JOIN, filtrado y ordenación.

✔️ Persistencia con JPA/Hibernate

* Mapeo automático de tablas y relaciones.

* Persistencia de entidades compuestas (Ventas con múltiples productos).

* Limpieza automática de relaciones ManyToMany al eliminar ventas.

✔️ Buenas prácticas con Spring Boot

* Separación en capas: Controller, Service, Repository, Entities.

* Uso de anotaciones como @Entity, @Table, @ManyToMany, @ManyToOne.

* Uso correcto del repository con métodos por nomenclatura y @Query.

* Configuración de base de datos en application.properties.

✔️ Manejo de fechas

* Uso de LocalDateTime para registrar la fecha de creación de una venta.

* Conversión y filtrado de rangos de fechas.

✔️ Pruebas manuales con Postman

* Creación de ventas mediante JSON estructurado.

* Llamadas a endpoints de consulta.

* Validación de relaciones en la base de datos.

