proyecto:
  nombre: "Sistema de Gestión de Ventas – Prueba Técnica"
  descripcion: >
    API REST creada como prueba técnica para gestionar sucursales, productos
    y ventas utilizando Spring Boot, JPA/Hibernate y MySQL. El proyecto demuestra
    modelado de entidades, relaciones complejas, consultas personalizadas y
    buenas prácticas en el diseño de APIs REST.

objetivos:
  - Modelar entidades con relaciones 1:N y N:M
  - Crear endpoints REST completos (CRUD)
  - Implementar consultas personalizadas con JPQL y SQL
  - Gestionar asociaciones ManyToMany y evitar recursión en JSON
  - Trabajar con filtros avanzados (fecha + sucursal)

funcionalidades:
  sucursales:
    - Crear sucursales
    - Listar sucursales
    - Obtener sucursal por ID
  productos:
    - Crear productos
    - Listar productos
    - Obtener producto por ID
  ventas:
    - Crear ventas asociadas a una sucursal
    - Añadir múltiples productos a cada venta
    - Listar ventas
    - Filtros de venta por fecha y sucursal
    - Consulta del producto más vendido

relaciones:
  sucursal_venta: "Sucursal 1 -> N Ventas"
  venta_producto: "Venta N -> M Productos"
  detalles: >
    La relación ManyToMany se gestiona mediante tabla intermedia generada por Hibernate.
    Se utilizaron anotaciones como @JsonIgnoreProperties para evitar ciclos infinitos
    en la serialización JSON.

tecnologias:
  lenguaje: "Java 17"
  framework: "Spring Boot"
  persistencia: "Spring Data JPA + Hibernate"
  base_de_datos: "MySQL"
  build: "Maven"

autor:
  nombre: "Fernando"
  objetivo_profesional: "Demostrar habilidades en backend con Spring Boot y arquitectura limpia"
