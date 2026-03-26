🏫 Rural School Management API

REST API for managing rural schools, campuses, grades, persons and contacts.
Built with Java 21, Spring Boot and Docker — ready to run in minutes.


🚀 Tech Stack
TechnologyVersionJava21Spring Boot3.5.11Gradle8.xMapStruct1.6.3MySQLlatestDockerlatestSpringdoc OpenAPI (Swagger)2.7.0

🏗️ Architecture
The project follows a layered architecture with clear domain separation:
src/
├── domain/
│   ├── dto/
│   │   ├── identity/
│   │   │   ├── contact/       # ContactDto, UpdateContactDto
│   │   │   └── person/        # PersonDto, UpdatePersonDto
│   │   └── institutional/
│   │       ├── campus/        # CampusDto, UpdateCampusDto
│   │       ├── grade/         # GradeDto, UpdateGradeDto
│   │       └── school/        # SchoolDto, UpdateSchoolDto
│   ├── repository/
│   │   ├── Identity/          # ContactRepository, PersonRepository
│   │   └── Institutional/     # CampusRepository, GradeRepository, SchoolRepository
│   └── service/
│       ├── Identity/
│       │   ├── contact/       # IContactService, ContactService
│       │   └── person/        # IPersonService, PersonService
│       └── Institutional/
│           ├── campus/        # ICampusService, CampusService
│           ├── grade/         # IGradeService, GradeService
│           └── school/        # ISchoolService, SchoolService
├── persistence/
│   ├── entity/
│   │   ├── Identity/          # ContactEntity, PersonEntity
│   │   └── Institutional/     # CampusEntity, GradeEntity, SchoolEntity
│   ├── mapper/
│   │   ├── Identity/          # ContactMapper, PersonMapper
│   │   └── Institutional/     # CampusMapper, GradeMapper, SchoolMapper
│   └── repository/
│       ├── Identity/
│       │   ├── contact/       # ContactEntityRepository, JpaContactRepository
│       │   └── person/        # PersonEntityRepository, JpaPersonRepository
│       └── Institutional/
│           ├── campus/        # CampusEntityRepository, JpaCampusRepository
│           ├── grade/         # GradeEntityRepository, JpaGradeRepository
│           └── school/        # SchoolEntityRepository, JpaSchoolRepository
└── web/
    └── controller/
        ├── Identity/          # ContactController, PersonController
        └── Institutional/     # CampusController, GradeController, SchoolController

⚙️ Prerequisites

Java 21+
Docker & Docker Compose
Git


▶️ Run the project
1. Clone the repository
bashgit clone https://github.com/Ronald-ICastroG/rural_school_management.git
cd rural_school_management
2. Start with Docker Compose
bashdocker compose up
The API will be available at: http://localhost:8090/rc8/api

📖 API Documentation
Once the project is running, access the interactive Swagger UI:
http://localhost:8090/rc8/api/swagger-ui/index.html

📡 Available Endpoints
🏫 School
MethodEndpointDescriptionGET/schoolGet all schoolsGET/school/{id}Get school by IDPOST/schoolCreate new schoolPATCH/school/{id}Update school dataDELETE/school/{id}Delete school
🏢 Campus
MethodEndpointDescriptionGET/campusGet all campusesGET/campus/{id}Get campus by IDGET/campus/name/{name}Get campus by namePOST/campusCreate new campusPATCH/campus/{id}Update campus dataDELETE/campus/{id}Delete campus by IDDELETE/campus/name/{name}Delete campus by name
📚 Grade
MethodEndpointDescriptionGET/gradeGet all gradesGET/grade/{id}Get grade by IDGET/grade/name/{name}Get grades by namePOST/gradeCreate new gradePATCH/grade/{id}Update grade dataDELETE/grade/{id}Delete grade by ID
👤 Person
MethodEndpointDescriptionGET/personGet all personsGET/person/{id}Get person by IDPOST/personCreate new personPATCH/person/{id}Update person dataDELETE/person/{id}Delete person
📞 Contact
MethodEndpointDescriptionGET/contactGet all contactsGET/contact/{id}Get contact by IDPOST/contactCreate new contactPATCH/contact/{id}Update contact dataDELETE/contact/{id}Delete contact

> See full ERD diagram in ![Database Model](docs/db_purpose.png)

---

## 🛣️ Roadmap

- [x] School CRUD
- [x] Campus CRUD
- [x] Grade CRUD
- [x] Person CRUD
- [x] Contact CRUD
- [x]  Swagger/OpenAPI documentation
- [x]  Domain-based package structure
- [ ] Student enrollment
- [ ] Teacher & Teacher Profile
- [ ] Staff
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

