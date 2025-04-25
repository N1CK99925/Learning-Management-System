# Learning Management System (LMS)

## Overview
This Learning Management System (LMS) allows administrators to manage courses and upload course materials (PDFs). Users can enroll in courses and access learning resources.

## Features
- **Admin Panel**
  - Add, edit, and delete courses
  - Upload and manage course materials (PDFs)
  - Manage users and enrollments
- **User Panel**
  - Browse available courses
  - Enroll in courses
  - Download course materials
- **Authentication & Authorization**
  - User roles: Admin, Student
  - JWT-based authentication

## Technologies Used
- **Backend:** Spring Boot (Java, Spring Security, Hibernate, JPA, PostgreSQL)
- **Frontend:** Thymeleaf (or HTML, CSS, JavaScript if applicable)
- **Database:** PostgreSQL (NeonDB Cloud)
- **Storage:** Local file system or cloud storage (for PDFs)
- **Deployment:** Render

## Installation & Setup
### Prerequisites
- Java 17+
- PostgreSQL database
- Maven

### Clone the Repository
```sh
#    will add later 
# cd 
```

### Configure the Database
Update **application.properties**:
```properties
spring.datasource.url=jdbc:postgresql://your-db-url:5432/lms_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```

### Build & Run the Application
```sh
mvn clean install
mvn spring-boot:run
```

### API Endpoints
#### Authentication
- `POST /api/users/register` - Register a new user
- `POST /api/users/login` - Login and obtain JWT token

#### Courses
- `GET /courses` - List all courses
- `POST /admin/courses` (Admin only) - Create a course
- `PUT /admin/courses/{id}` (Admin only) - Update a course
- `DELETE /admin/courses/{id}` (Admin only) - Delete a course

#### Course Materials (PDF Upload)
- `POST /admin/courses/{id}/upload` (Admin only) - Upload PDF
- `GET /courses/{id}/download` - Download course material

## Deployment
### Deploy to Render
1. Push your code to GitHub.
2. Create a new **Render** service for the backend.
3. Add environment variables for **database credentials**.
4. Deploy and monitor logs.

## Future Enhancements
- Implement video lectures
- Add quizzes and assignments
- Enable cloud storage (AWS S3, Firebase, etc.) for PDFs
- Announcements


// need to make test changing manually to ADMIN from ROLE_ADMIN in db and then make changes in the AdminService.java
// also need to put the keys in .env file and edit the .gitignore file for it and destroy db from neon to prevent misuse after making repo public
// need to re implement download and upload pdf controller
