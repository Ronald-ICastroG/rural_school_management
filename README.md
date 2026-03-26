# 🏫 Rural School Management API

> REST API for managing rural schools, campuses, grades, persons and contacts.
> Built with Java 21, Spring Boot and Docker — ready to run in minutes.

---

## 🚀 Tech Stack

| Technology | Version |
|---|---|
| Java | 21 |
| Spring Boot | 3.5.11 |
| Gradle | 8.x |
| MapStruct | 1.6.3 |
| MySQL | latest |
| Docker | latest |
| Springdoc OpenAPI (Swagger) | 2.7.0 |

---

## 🏗️ Architecture

The project follows a **layered architecture** with clear domain separation:

**domain/**
- `dto/identity/contact` — ContactDto, UpdateContactDto
- `dto/identity/person` — PersonDto, UpdatePersonDto
- `dto/institutional/campus` — CampusDto, UpdateCampusDto
- `dto/institutional/grade` — GradeDto, UpdateGradeDto
- `dto/institutional/school` — SchoolDto, UpdateSchoolDto
- `repository/Identity` — ContactRepository, PersonRepository
- `repository/Institutional` — CampusRepository, GradeRepository, SchoolRepository
- `service/Identity/contact` — IContactService, ContactService
- `service/Identity/person` — IPersonService, PersonService
- `service/Institutional/campus` — ICampusService, CampusService
- `service/Institutional/grade` — IGradeService, GradeService
- `service/Institutional/school` — ISchoolService, SchoolService

**persistence/**
- `entity/Identity` — ContactEntity, PersonEntity
- `entity/Institutional` — CampusEntity, GradeEntity, SchoolEntity
- `mapper/Identity` — ContactMapper, PersonMapper
- `mapper/Institutional` — CampusMapper, GradeMapper, SchoolMapper
- `repository/Identity/contact` — ContactEntityRepository, JpaContactRepository
- `repository/Identity/person` — PersonEntityRepository, JpaPersonRepository
- `repository/Institutional/campus` — CampusEntityRepository, JpaCampusRepository
- `repository/Institutional/grade` — GradeEntityRepository, JpaGradeRepository
- `repository/Institutional/school` — SchoolEntityRepository, JpaSchoolRepository

**web/controller/**
- `Identity` — ContactController, PersonController
- `Institutional` — CampusController, GradeController, SchoolController

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

### 📚 Grade

| Method | Endpoint | Description |
|---|---|---|
| GET | `/grade` | Get all grades |
| GET | `/grade/{id}` | Get grade by ID |
| GET | `/grade/name/{name}` | Get grades by name |
| POST | `/grade` | Create new grade |
| PATCH | `/grade/{id}` | Update grade data |
| DELETE | `/grade/{id}` | Delete grade by ID |

### 👤 Person

| Method | Endpoint | Description |
|---|---|---|
| GET | `/person` | Get all persons |
| GET | `/person/{id}` | Get person by ID |
| POST | `/person` | Create new person |
| PATCH | `/person/{id}` | Update person data |
| DELETE | `/person/{id}` | Delete person |

### 📞 Contact

| Method | Endpoint | Description |
|---|---|---|
| GET | `/contact` | Get all contacts |
| GET | `/contact/{id}` | Get contact by ID |
| POST | `/contact` | Create new contact |
| PATCH | `/contact/{id}` | Update contact data |
| DELETE | `/contact/{id}` | Delete contact |

---

## 🗂️ Database Model

The data model is organized into functional domains:

- **Institutional**: School → Campus → Grade
- **Identity**: Person → Contact → Student / Teacher / Staff
- **Academic**: Subject → Academic Assignment → Gradebook
- **Security**: User → Role

![Database Model](docs/db_purpose.png)

---

## 🛣️ Roadmap

- [x] School CRUD
- [x] Campus CRUD
- [x] Grade CRUD
- [x] Person CRUD
- [x] Contact CRUD
- [x] Swagger/OpenAPI documentation
- [x] **Domain-based package structure**
- [ ] Student enrollment
- [ ] Teacher & Teacher Profile
- [ ] Staff
- [ ] Subject & Gradebook
- [ ] Spring Security + JWT authentication
- [ ] deployment

---

## 👨‍💻 Author

**Ronald I. Castro G.**
Java Backend Developer | M.Sc. Industrial Engineering
[![LinkedIn](https://img.shields.io/badge/LinkedIn-ronaldcastro--tech-blue?logo=linkedin)](https://www.linkedin.com/in/ronaldcastro-tech)
[![GitHub](https://img.shields.io/badge/GitHub-Ronald--ICastroG-black?logo=github)](https://github.com/Ronald-ICastroG)

---

## 📄 License

This project is for portfolio purposes.
