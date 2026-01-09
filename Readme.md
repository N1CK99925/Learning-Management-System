# Learning Management System (LMS)

## Features

### Student Features
- Register and login as a student
- Browse available courses
- View course details
- Enroll in courses (if seats are available)
- View enrolled courses
- Drop courses
- Cannot enroll in courses they're already enrolled in

### Admin Features
- Create, update, and delete courses
- Activate/deactivate courses
- Manage course materials
- View all enrollments
- Promote users to admin role
- View dashboard statistics
- Manage student accounts

## Technology Stack

- **Backend**: Spring Boot 4.0.1
- **Security**: Spring Security with JWT authentication
- **Database**: PostgreSQL
- **ORM**: Spring Data JPA / Hibernate
- **Validation**: Jakarta Bean Validation
- **Build Tool**: Maven
- **Java Version**: 21

## Project Structure

```
src/main/java/com/example/lms/
├── config/              # Security and app configuration
├── controller/          # REST controllers
│   ├── AuthController
│   ├── StudentController
│   └── AdminController
├── dto/                 # Data Transfer Objects
├── entity/              # JPA entities
│   ├── User
│   ├── Course
│   └── Enrollment
├── exception/           # Custom exceptions and handlers
├── repository/          # JPA repositories
├── security/            # JWT service and filters
└── service/             # Business logic layer
```

## Setup Instructions

### Prerequisites
- Java 17 or higher
- PostgreSQL database
- Maven 3.6+

### Database Setup

1. Create a PostgreSQL database:
```sql
CREATE DATABASE lms_db;
```

2. Update `application.properties` with your database credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/lms_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Running the Application

1. Clone the repository
2. Navigate to the project directory
3. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### Authentication Endpoints (`/api/auth`)

#### Register Student
```http
POST /api/auth/register
Content-Type: application/json

{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "password123"
}
```

#### Login
```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "password123"
}

Response:
{
  "token": "eyJhbGc...",
  "user": {
    "id": 1,
    "email": "john@example.com",
    "username": "john_doe",
    "role": "STUDENT"
  }
}
```

#### Validate Token
```http
GET /api/auth/validate
Authorization: Bearer {token}
```

#### Get Current User
```http
GET /api/auth/me
Authorization: Bearer {token}
```

### Student Endpoints (`/api/student`)

All student endpoints require `Authorization: Bearer {token}` header with STUDENT role.

#### Get Available Courses
```http
GET /api/student/courses
```

#### Get Course Details
```http
GET /api/student/courses/{id}
```

#### Get Courses by Category
```http
GET /api/student/courses/category/{category}
```

#### Enroll in Course
```http
POST /api/student/enroll/{courseId}
```

#### Drop Course
```http
POST /api/student/drop/{courseId}
```

#### Get My Enrollments
```http
GET /api/student/enrollments
```

#### Get Active Enrollments
```http
GET /api/student/enrollments/active
```

#### Check Enrollment Status
```http
GET /api/student/enrollments/check/{courseId}
```

### Admin Endpoints (`/api/admin`)

All admin endpoints require `Authorization: Bearer {token}` header with ADMIN role.

#### Create Course
```http
POST /api/admin/courses
Content-Type: application/json

{
  "name": "Introduction to Java",
  "description": "Learn Java programming from scratch",
  "price": 99.99,
  "availableSeats": 30,
  "category": "Programming"
}
```

#### Update Course
```http
PUT /api/admin/courses/{id}
Content-Type: application/json

{
  "name": "Advanced Java",
  "description": "Deep dive into Java",
  "price": 149.99,
  "availableSeats": 25,
  "category": "Programming"
}
```

#### Delete Course
```http
DELETE /api/admin/courses/{id}
```

#### Deactivate/Activate Course
```http
PATCH /api/admin/courses/{id}/deactivate
PATCH /api/admin/courses/{id}/activate
```

#### Get All Courses
```http
GET /api/admin/courses
```

#### Add Course Material
```http
POST /api/admin/courses/{id}/materials
Content-Type: application/json

{
  "materialPath": "/files/lecture1.pdf"
}
```

#### Get Course Enrollments
```http
GET /api/admin/courses/{id}/enrollments
```

#### Get Enrollment Count
```http
GET /api/admin/courses/{id}/enrollment-count
```

#### Create Admin User
```http
POST /api/admin/users/admin
Content-Type: application/json

{
  "username": "admin_user",
  "email": "admin@example.com",
  "password": "admin123"
}
```

#### Get All Students
```http
GET /api/admin/users/students
```

#### Promote User to Admin
```http
PATCH /api/admin/users/{email}/promote
```

#### Delete User
```http
DELETE /api/admin/users/{id}
```

#### Get Dashboard Statistics
```http
GET /api/admin/dashboard/stats
```

## Business Logic

### Enrollment Rules
1. Students cannot enroll in a course they're already enrolled in
2. Students can only enroll in active courses
3. Courses must have available seats for enrollment
4. When a student enrolls, available seats are decremented
5. When a student drops, available seats are incremented
6. Enrollment status can be: ACTIVE, COMPLETED, or DROPPED

### Security
- JWT-based authentication
- Role-based access control (STUDENT, ADMIN)
- Password encryption using BCrypt
- Stateless session management
- Token validation on each request

### Database Constraints
- Unique constraint on (student_id, course_id) in enrollments table
- Email uniqueness for users
- Cascade operations for related entities

## Error Handling

The application uses global exception handling with appropriate HTTP status codes:

- `400 Bad Request` - Validation errors, enrollment exceptions
- `401 Unauthorized` - Authentication failures
- `404 Not Found` - Resource not found
- `409 Conflict` - Duplicate resources
- `500 Internal Server Error` - Unexpected errors

## Testing

You can test the API using tools like:
- Postman
- cURL
- Thunder Client (VS Code extension)

### Example Test Flow

1. Register as a student
2. Login to get JWT token
3. Use the token in Authorization header for subsequent requests
4. Browse courses
5. Enroll in a course
6. View your enrollments

## Future Enhancements

- File upload for course materials
- Email notifications
- Course progress tracking
- Assignments and quizzes
- Certificate generation
- Payment integration
- Course reviews and ratings
- Search and filtering
- Pagination for large datasets

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

