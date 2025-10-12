# 📚 Learning Management System (LMS)

![Java](https://img.shields.io/badge/Java-23-blue.svg)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-Application-green.svg)  
![Status](https://img.shields.io/badge/Sem%20Project-orange.svg)  

---

## 🛠 Overview

This **Learning Management System (LMS)** is a web application built as a class project in the 2nd semester. It enables administrators and students to manage and access courses and course materials (PDFs).  

Though it's College Sem 2, it’s designed such that it can be extended further — e.g. support videos, quizzes, cloud storage, etc.

---

## 🎯 Key Features

- **Admin Panel**
  - Create, update, delete courses  
  - Upload and manage course materials (PDF)  
  - Manage users and enrollment  
- **Student (User) Panel**
  - Browse available courses  
  - Enroll in courses  
  - Download course materials  
- **Authentication & Authorization**
  - User roles: `Admin`, `Student`  
  - JWT-based login and access token  
- **File Upload & Download**
  - Admins upload PDF materials for courses  
  - Students download materials of enrolled courses  

---

## 🧱 Technologies Used

| Component        | Technology / Framework                |
|------------------|----------------------------------------|
| Backend           | Spring Boot, Java, Spring Security, Hibernate, JPA |
| Database          | PostgreSQL                              |
| Frontend / Views  | Thymeleaf / HTML / CSS / JavaScript      |
| Storage           | Local file system (for PDFs)             |
| Build & Dependency | Maven                                  |

---


## 🚀 Installation & Setup

### Prerequisites

- Java 17+  
- PostgreSQL database  
- Maven  

### Steps

1. **Clone the repository**  
   ```bash
   git clone https://github.com/N1CK99925/Learning-Management-System.git
   cd Learning-Management-System
Configure the database
In src/main/resources/application.properties (or application.yml), set your DB credentials:

properties
Copy code
spring.datasource.url=jdbc:postgresql://<host>:<port>/<database_name>
spring.datasource.username=<your_username>
spring.datasource.password=<your_password>
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
Build & Run

bash
Copy code
mvn clean install
mvn spring-boot:run
The server should start (default port 8080 unless you changed it).

🧭 API & Endpoints (Examples)
Note: Some endpoints are protected (only admins can access). Use JWT for authorization.

Authentication
Action	Endpoint	Method	Description
Register	POST /api/users/register	POST	Register a new user
Login	POST /api/users/login	POST	Login and receive JWT token

Courses & Materials
Endpoint	Method	Role	Description
GET /courses	GET	Any	List all courses
POST /admin/courses	POST	Admin only	Create new course
PUT /admin/courses/{id}	PUT	Admin only	Update course metadata
DELETE /admin/courses/{id}	DELETE	Admin only	Remove a course
POST /admin/courses/{id}/upload	POST	Admin only	Upload PDF material for a course
GET /courses/{id}/download	GET	Enrolled Students	Download course material

Example of curl Request
bash
Copy code
curl -X POST http://localhost:8080/api/users/login \
     -H "Content-Type: application/json" \
     -d '{"username":"student1","password":"pass123"}'
You'll receive a JWT token in response, which you should include in Authorization: Bearer <token> header for subsequent protected endpoints.

📌 Notes & Caveats
The file upload / download flows are currently built for PDF files on local filesystem.

To test admin-only features, you may need to manually assign the “ADMIN” role in the database.

Sensitive keys or DB credentials should not be committed — consider using environment variables and .gitignore.

Error handling and edge cases are minimal (this is primarily a class project).

🔭 Future Enhancements
Support for video lectures, audio, and rich media

Quizzes, assignments, grading, and deadlines

Notifications and announcements

Cloud storage for course materials (AWS S3, GCP Storage)

Better front-end (React, Angular, Vue)

Role-based access extension (TA, Instructor)

Logging, monitoring, and error dashboards

Unit tests and integration tests

🤝 Contribution & Licensing
Contributions:
This is a student project, but feel free to fork it, submit issues, or make improvements. If you're adding features, open a PR and note what you changed.
