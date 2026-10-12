# api-gateway

Punto de entrada HTTP (puerto **8080**) con descubrimiento Eureka y Swagger unificado.

## Rutas

| Prefijo | Microservicio |
|---------|----------------|
| `/users/**`, `/professors/**`, `/research-lines/**`, `/catalogs/**`, `/professor-research-lines/**` | ms-users (8081) |
| `/time-slots/**`, `/professor-references/**` | ms-availability (8082) |
| `/reservations/**`, `/consultation-types/**` | ms-reservas (8084) |
| `/notifications/**`, `/email-templates/**`, `/contact/**` | ms-notificaciones (8083) |

Arranque recomendado: **eureka-server** (8761) → microservicios → **api-gateway** (8080). Los clientes HTTP deben apuntar solo al gateway.

Script automático (desde la carpeta `IISS`): `./scripts/start-all.sh` (Git Bash) o `.\scripts\start-all.ps1` (PowerShell). Detener: `stop-all` en la misma carpeta `scripts/`. Verificación: `./scripts/smoke-test.sh`.

En desarrollo local (Windows), el `.env` del gateway puede fijar `GATEWAY_MS_*_URI=http://127.0.0.1:808x` para enrutar sin depender del `lb://` de Eureka; la entrada HTTP sigue siendo solo el puerto **8080**.

Documentación unificada: **http://localhost:8080/swagger-ui/index.html** (arriba, desplegable **Select a definition**: ms-users, ms-availability, ms-reservas, ms-notificaciones). No uses `:8081`–`:8084` para Swagger (solo exponen un microservicio).

Variables: ver `.env.example` (`EUREKA_URL`, `SERVER_PORT`).
