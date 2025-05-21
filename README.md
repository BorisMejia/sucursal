# 🏢 API de Franquicias

Esta aplicación permite gestionar franquicias, sus sucursales y productos utilizando Java 17, Spring Boot 3, programación reactiva con WebFlux y MongoDB como base de datos.

---

## 🚀 Características

- Crear y consultar franquicias, sucursales y productos.
- Modificar stock y nombre de productos, sucursales y franquicias.
- Obtener el producto con mayor stock por sucursal.
- Arquitectura hexagonal con separación de capas.
- Documentación OpenAPI disponible con Swagger.
- Docker y Docker Compose listos para producción local.

---

## 🧾 Requisitos previos

Antes de iniciar, asegúrate de tener instalado:

- [Git](https://git-scm.com/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Java 17](https://adoptium.net/) y [Maven](https://maven.apache.org/) *(solo si quieres compilar sin Docker)*

---

## 📦 Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/api-franquicias.git
cd api-franquicias




./mvnw clean package -DskipTests && docker-compose build --no-cache && docker-compose up

