# api-gateway

Punto de entrada HTTP (puerto **8080**) con descubrimiento Eureka y Swagger unificado.

## Rutas (Parte #1)

| Prefijo | Microservicio |
|---------|----------------|
| `/users/**`, `/professors/**`, `/research-lines/**`, `/catalogs/**`, `/professor-research-lines/**` | ms-users |
| `/time-slots/**`, `/professor-references/**` | ms-availability |

Documentación: `http://localhost:8080/swagger-ui.html` (requiere Eureka + MS registrados).

Variables: ver `.env.example` (`EUREKA_URL`, `SERVER_PORT`).
