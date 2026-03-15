# 🏫 Rural School Management API

> REST API for managing rural schools, campuses, grades and academic resources.  
> Built with Java 21, Spring Boot and Docker — ready to run in minutes.

---

## 🚀 Tech Stack

| Technology | Version |
|---|---|
| Java | 21 |
| Spring Boot | 3.5.11 |
| Gradle | 8.x |
| MapStruct | 1.6.3 |
| MySQL | 8.x |
| Docker | Latest |
| Springdoc OpenAPI (Swagger) | 2.7.0 |

---

## 🏗️ Architecture

The project follows a **layered architecture** with clear separation of responsibilities:

```
src/
├── domain/
│   ├── dto/
│   │   ├── campus/        # CampusDto, UpdateCampusDto
│   │   ├── grade/         # GradeDto, UpdateGradeDto
│   │   └── school/        # SchoolDto, UpdateSchoolDto
│   ├── repository/        # Domain interfaces (ports)
│   └── service/           # Business logic interfaces + implementations
├── persistence/
│   ├── entity/            # JPA entities
│   ├── mapper/            # MapStruct mappers
│   └── repository/        # JPA repositories + implementations
└── web/
    └── controller/        # REST controllers
```

---

## ⚙️ Prerequisites

- Java 21+
- Docker & Docker Compose
- Git

---

## ▶️ Run the project

**1. Clone the repository**
```bash
git clone https://github.com/Ronald-ICastroG/rural_school_management.git
cd rural_school_management
```

**2. Start with Docker Compose**
```bash
docker compose up
```

The API will be available at: `http://localhost:8090/rc8/api`

---

## 📖 API Documentation

Once the project is running, access the interactive Swagger UI:

```
http://localhost:8090/rc8/api/swagger-ui/index.html
```

---

## 📡 Available Endpoints

### 🏫 School

| Method | Endpoint | Description |
|---|---|---|
| GET | `/school` | Get all schools |
| GET | `/school/{id}` | Get school by ID |
| POST | `/school` | Create new school |
| PATCH | `/school/{id}` | Update school data |
| DELETE | `/school/{id}` | Delete school |

### 🏢 Campus

| Method | Endpoint | Description |
|---|---|---|
| GET | `/campus` | Get all campuses |
| GET | `/campus/{id}` | Get campus by ID |
| GET | `/campus/name/{name}` | Get campus by name |
| POST | `/campus` | Create new campus |
| PATCH | `/campus/{id}` | Update campus data |
| DELETE | `/campus/{id}` | Delete campus by ID |
| DELETE | `/campus/name/{name}` | Delete campus by name |

### 📚 Grades

| Method | Endpoint | Description |
|---|---|---|
| GET | `/grade` | Get all grades |
| GET | `/grade/{id}` | Get grade by ID |
| GET | `/grade/name/{name}` | Get grades by name |
| POST | `/grade` | Create new grade |
| PATCH | `/grade/{id}` | Update grade data |
| DELETE | `/grade/{id}` | Delete grade by ID |

---

## 🗂️ Database Model

The data model is organized into functional domains:

- **Institutional**: School → Campus → Grade
- **Identity**: Person → Student / Teacher / Staff
- **Academic**: Subject → Academic Assignment → Gradebook
- **Security**: User → Role

> See full ERD diagram in `/docs/db_purpose.png`

---

## 🛣️ Roadmap

- [x] School CRUD
- [x] Campus CRUD
- [x] Grade CRUD
- [ ] Person & Contact
- [ ] Student enrollment
- [ ] Teacher & Teacher Profile
- [ ] Subject & Gradebook
- [ ] Spring Security + JWT authentication
- [ ] Deployment

---

## 👨‍💻 Author

**Ronald I. Castro G.**  
Magíster en Ingeniería Industrial | Java Backend Developer  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-ronald--castro--tech-blue?logo=linkedin)](https://www.linkedin.com/in/ronaldcastro-tech)  
[![GitHub](https://img.shields.io/badge/GitHub-Ronald--ICastroG-black?logo=github)](https://github.com/Ronald-ICastroG)

---

## 📄 License

This project is for portfolio purposes.
