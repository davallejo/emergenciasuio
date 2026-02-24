# 🚒 Sistema de Registro de Emergencias

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.2-6DB33F?logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Latest-4169E1?logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?logo=apachemaven&logoColor=white)
![REST API](https://img.shields.io/badge/API-RESTful-FF6C37?logo=postman&logoColor=white)
![License](https://img.shields.io/badge/Licencia-MIT-lightgrey)

API RESTful desarrollada con Spring Boot para la **gestión integral de emergencias** en cuerpos de bomberos — permitiendo el registro, seguimiento y asignación de personal en tiempo real ante situaciones críticas.

---

## 📌 Contexto Operativo

En contextos de emergencia, cada segundo cuenta. Este sistema fue diseñado para brindar a los cuerpos de bomberos una herramienta digital robusta que centralice el registro de incidentes, optimice la asignación de personal y garantice la trazabilidad de cada operación. Sus principales beneficios operativos incluyen:

- **Registro inmediato** de emergencias con datos clave como ubicación, tipo y temperatura del incidente
- **Asignación eficiente de personal** (bomberos, paramédicos) a cada emergencia
- **Trazabilidad completa** del historial de incidentes para análisis posterior
- **Arquitectura escalable** lista para integrarse con sistemas de despacho y comunicaciones
- **API RESTful** consumible desde aplicaciones web, móviles o paneles de control

---

## 🛠️ Stack Tecnológico

| Tecnología | Versión | Rol |
|------------|---------|-----|
| ![Java](https://img.shields.io/badge/-Java-ED8B00?logo=openjdk&logoColor=white&style=flat) | 17 LTS | Lenguaje principal |
| ![Spring Boot](https://img.shields.io/badge/-Spring%20Boot-6DB33F?logo=springboot&logoColor=white&style=flat) | 3.1.2 | Framework backend |
| ![Spring Data JPA](https://img.shields.io/badge/-Spring%20Data%20JPA-6DB33F?logo=spring&logoColor=white&style=flat) | — | Capa de persistencia (ORM) |
| ![Spring Web](https://img.shields.io/badge/-Spring%20Web-6DB33F?logo=spring&logoColor=white&style=flat) | — | Exposición de endpoints REST |
| ![PostgreSQL](https://img.shields.io/badge/-PostgreSQL-4169E1?logo=postgresql&logoColor=white&style=flat) | Latest | Base de datos relacional |
| ![Maven](https://img.shields.io/badge/-Maven-C71A36?logo=apachemaven&logoColor=white&style=flat) | — | Gestión de dependencias y build |

---

## 🏗️ Arquitectura del Sistema

La aplicación sigue el patrón de capas estándar de Spring Boot:

```
┌─────────────────────────────────────────┐
│            Cliente / Frontend           │
└────────────────────┬────────────────────┘
                     │ HTTP Requests
┌────────────────────▼────────────────────┐
│           Controllers (REST)            │  ← Manejo de solicitudes HTTP
├─────────────────────────────────────────┤
│              Services                   │  ← Lógica de negocio
├─────────────────────────────────────────┤
│            Repositories (JPA)           │  ← Acceso a datos
├─────────────────────────────────────────┤
│           PostgreSQL Database           │  ← Persistencia
└─────────────────────────────────────────┘
```

---

## 🗄️ Esquema de Base de Datos

El sistema utiliza tres tablas relacionales que modelan la operación de emergencias:

```
┌──────────────────────┐         ┌───────────────────────────┐         ┌──────────────┐
│      emergencia      │         │    emergencia_personal     │         │   personal   │
├──────────────────────┤         ├───────────────────────────┤         ├──────────────┤
│ id (PK)              │◄────────┤ emergencia_id (FK)        │         │ cedula (PK)  │
│ fecha_creacion       │         │ personal_cedula (FK)      ├────────►│ nombres      │
│ codigo               │         └───────────────────────────┘         │ apellidos    │
│ fecha_emergencia     │                                                │ tipo         │
│ titulo               │                                                └──────────────┘
│ descripcion          │
│ ubicacion            │
│ temperatura          │
└──────────────────────┘
```

**Descripción de tablas:**

- **`emergencia`** — Almacena el registro completo de cada incidente: código único, fecha, título, descripción, ubicación geográfica y temperatura registrada en el lugar.
- **`personal`** — Contiene el directorio del personal operativo (bomberos, paramédicos, etc.) identificado por cédula.
- **`emergencia_personal`** — Tabla de relación muchos a muchos que vincula emergencias con el personal asignado a cada una.

---

## 📡 Endpoints Principales de la API

```
Emergencias
  GET    /api/emergencias           → Listar todas las emergencias
  GET    /api/emergencias/{id}      → Obtener emergencia por ID
  POST   /api/emergencias           → Registrar nueva emergencia
  PUT    /api/emergencias/{id}      → Actualizar emergencia existente
  DELETE /api/emergencias/{id}      → Eliminar emergencia

Personal
  GET    /api/personal              → Listar todo el personal
  GET    /api/personal/{cedula}     → Obtener personal por cédula
  POST   /api/personal              → Registrar nuevo personal
  PUT    /api/personal/{cedula}     → Actualizar datos del personal
  DELETE /api/personal/{cedula}     → Eliminar personal

Asignaciones
  POST   /api/emergencias/{id}/personal/{cedula}   → Asignar personal a emergencia
  DELETE /api/emergencias/{id}/personal/{cedula}   → Remover personal de emergencia
```

---

## 🖥️ Capturas del Sistema

| Vista de Registro de Emergencias | Vista de Asignación de Personal |
|:-:|:-:|
| ![Registro](img.png) | ![Asignación](img_1.png) |

---

## ⚙️ Instalación y Configuración

### Prerrequisitos

- Java 17 LTS instalado
- PostgreSQL en ejecución
- Maven 3.8+

### 1. Clonar el repositorio

```bash
git clone https://github.com/davallejo/sistema-emergencias.git
cd sistema-emergencias
```

### 2. Configurar la base de datos

Crear la base de datos en PostgreSQL:

```sql
CREATE DATABASE emergencias_db;
```

Actualizar el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/emergencias_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Compilar y ejecutar

```bash
mvn clean install
mvn spring-boot:run
```

### 4. Acceder a la API

```
http://localhost:8080/api/
```

> Se recomienda usar **Postman** o **Swagger UI** para explorar y probar los endpoints disponibles.

---

## 📁 Estructura del Proyecto

```
sistema-emergencias/
├── src/
│   └── main/
│       ├── java/com/emergencias/
│       │   ├── controller/       # Controladores REST
│       │   ├── service/          # Lógica de negocio
│       │   ├── repository/       # Repositorios JPA
│       │   ├── model/            # Entidades de base de datos
│       │   └── dto/              # Objetos de transferencia de datos
│       └── resources/
│           └── application.properties
├── pom.xml                        # Dependencias Maven
└── README.md
```

---

## 🗺️ Roadmap

- [ ] Autenticación y autorización con Spring Security + JWT
- [ ] Documentación interactiva con Swagger / OpenAPI 3.0
- [ ] Integración con API de geolocalización para mapas en tiempo real
- [ ] Notificaciones push al asignar personal a una emergencia
- [ ] Dashboard de estadísticas e historial de incidentes
- [ ] Dockerización del servicio y base de datos
- [ ] Despliegue en la nube (AWS / Railway / Render)

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

---

## 👤 Autor

**Diego Vallejo**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Diego%20Vallejo-0A66C2?logo=linkedin&logoColor=white)](https://www.linkedin.com/in/ing-diego-vallejo)
[![GitHub](https://img.shields.io/badge/GitHub-davallejo-181717?logo=github&logoColor=white)](https://github.com/davallejo)
[![Portfolio](https://img.shields.io/badge/Portfolio-davallejo.github.io-4A90D9?logo=githubpages&logoColor=white)](https://davallejo.github.io/)

---

> *Solución backend orientada a servicios de emergencia — diseñada para respuestas más rápidas, coordinadas y trazables ante situaciones críticas.*
