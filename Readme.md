# Learning Management System (LMS)

A comprehensive full-stack Learning Management System built with Spring Boot and React, featuring course management, student enrollment, real-time updates, rate limiting, and containerized deployment.

## 📋 Features

### Student Features
- User authentication and registration
- Browse and search available courses
- View detailed course information
- Enroll in courses (with seat availability checking)
- View enrolled courses and progress
- Drop courses
- Prevent duplicate enrollments
- Student dashboard with personalized course information

### Admin Features
- Create, update, and delete courses
- Activate/deactivate courses
- Manage course capacity and details
- View comprehensive enrollment statistics
- Promote users to admin role
- View system dashboard with key metrics
- Manage student accounts and profiles

## 🚀 Technology Stack

### Backend
- **Framework**: Spring Boot 4.0.1
- **Java Version**: 21 (LTS)
- **Security**: Spring Security with JWT Token Authentication
- **Database**: PostgreSQL with Spring Data JPA / Hibernate
- **Rate Limiting**: Bucket4j with Redis support
- **Validation**: Jakarta Bean Validation
- **Cache**: Redis (for rate limiting and caching)
- **Build Tool**: Maven 3.6+
- **Monitoring**: Spring Boot Actuator
- **Containerization**: Docker with health checks

### Frontend
- **Framework**: React 19.2.3 with Vite 7.3.1
- **Routing**: React Router 7.12.0
- **Styling**: Tailwind CSS 3.4.17 with PostCSS
- **Icons**: Lucide React 0.562
- **HTTP Client**: Axios
- **Code Quality**: ESLint with React hooks support
- **Node Version**: 18+

### Infrastructure
- **Container Orchestration**: Docker Compose 3.8
- **Services**: Frontend (Nginx), Backend (Spring Boot), Redis
- **Networking**: Custom bridge network
- **Health Checks**: Configured for all services
- **Volume Management**: Persistent storage for Redis and file uploads

## 📁 Project Structure

```
Learning-Management-System/
├── lms/                           # Backend (Spring Boot)
│   ├── src/main/java/lms/lms/
│   │   ├── config/                # Security, Web, and Rate Limit Configuration
│   │   ├── controller/            # REST API Controllers
│   │   │   ├── AuthController
│   │   │   ├── StudentController
│   │   │   └── AdminController
│   │   ├── dto/                   # Data Transfer Objects
│   │   ├── entity/                # JPA Entities (User, Course, Enrollment, etc.)
│   │   ├── exception/             # Custom Exceptions and Global Exception Handler
│   │   ├── repository/            # JPA Repositories
│   │   ├── security/              # JWT Token Service and Security Filters
│   │   └── service/               # Business Logic Layer
│   ├── src/main/resources/
│   │   ├── application.properties
│   │   ├── application-dev.properties
│   │   └── example.application.properties
│   ├── pom.xml                    # Maven Dependencies
│   ├── Dockerfile                 # Backend Container Configuration
│   └── mvnw/mvnw.cmd              # Maven Wrapper
│
├── frontend/lms/                  # Frontend (React + Vite)
│   ├── src/
│   │   ├── components/            # React Components
│   │   │   ├── ProtectedRoute.jsx
│   │   │   ├── SidebarH.jsx
│   │   │   └── TopNavbar.jsx
│   │   ├── pages/                 # Page Components
│   │   │   ├── LandingPage.jsx
│   │   │   ├── LoginPage.jsx
│   │   │   ├── RegisterPage.jsx
│   │   │   ├── CourseCatalog.jsx
│   │   │   └── StudentDashboard.jsx
│   │   ├── context/               # React Context (Authentication State)
│   │   │   └── AuthContext.jsx
│   │   ├── layouts/               # Layout Components
│   │   │   └── DashboardLayout.jsx
│   │   ├── api/                   # API Configuration
│   │   │   ├── axios.js           # Axios instance
│   │   │   └── CourseApi.js       # Course API calls
│   │   ├── App.jsx
│   │   ├── main.jsx
│   │   ├── index.css
│   │   └── App.css
│   ├── public/                    # Static assets
│   ├── package.json               # NPM Dependencies
│   ├── vite.config.js             # Vite Configuration
│   ├── tailwind.config.js         # Tailwind CSS Configuration
│   ├── postcss.config.js          # PostCSS Configuration
│   ├── eslint.config.js           # ESLint Configuration
│   ├── nginx.conf                 # Nginx Configuration for production
│   ├── Dockerfile                 # Frontend Container Configuration
│   └── README.md                  # Frontend Documentation
│
├── Docker-Compose.yml             # Multi-container orchestration
└── Readme.md                      # This file

```

## 🔧 Setup Instructions

### Prerequisites

#### For Local Development
- **Java**: 21 or higher (OpenJDK or Oracle JDK)
- **Maven**: 3.6+ (or use bundled mvnw)
- **Node.js**: 18+ with npm
- **PostgreSQL**: 12+ (local or managed service)
- **Redis**: 6+ (local or managed service)
- **Docker**: (Optional, for containerized deployment)
- **Docker Compose**: 2.0+ (if using Docker)

### Database Setup

#### Option 1: PostgreSQL Locally

1. Create a PostgreSQL database:
```sql
CREATE DATABASE lms_db;
```

2. Configure connection in [lms/src/main/resources/application.properties](lms/src/main/resources/application.properties):
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/lms_db
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
```

#### Option 2: Using Docker Compose (Recommended)
The Docker Compose setup includes PostgreSQL configuration via environment variables.

### Running the Application

#### Option 1: Local Development (Native)

**Backend Setup:**
```bash
cd lms

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The backend will start on `http://localhost:8080`

**Frontend Setup:**
```bash
cd frontend/lms

# Install dependencies
npm install

# Start development server
npm run dev
```

The frontend will start on `http://localhost:5173` (Vite default)

#### Option 2: Docker Compose Deployment (Recommended)

1. Clone the repository:
```bash
git clone <repository-url>
cd Learning-Management-System
```

2. Configure environment variables:
```bash
cp .env.example .env
# Edit .env with your configuration
```

3. Start all services:
```bash
docker-compose up -d
```

Access the application:
- Frontend: `http://localhost:3000`
- Backend API: `http://localhost:8080`
- Redis: `localhost:6379`

### Building for Production

**Backend:**
```bash
cd lms
mvn clean package -DskipTests
java -jar target/lms-0.0.1-SNAPSHOT.jar
```

**Frontend:**
```bash
cd frontend/lms
npm run build
npm run preview
```

## 📡 API Endpoints

### Authentication Endpoints (`/api/auth`)

#### Register New User
```http
POST /api/auth/register
Content-Type: application/json

{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "SecurePassword123!"
}
```

**Response:**
```json
{
  "id": 1,
  "username": "john_doe",
  "email": "john@example.com",
  "role": "STUDENT"
}
```

#### Login
```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "john_doe",
  "password": "SecurePassword123!"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "expiresIn": 86400000,
  "user": {
    "id": 1,
    "username": "john_doe",
    "email": "john@example.com",
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

#### Enroll in Course
```http
POST /api/student/enroll/{courseId}
```

**Request Body:**
```json
{
  "courseId": 1
}
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

### Admin Endpoints (`/api/admin`)

All admin endpoints require `Authorization: Bearer {token}` header with ADMIN role.

#### Get All Courses
```http
GET /api/admin/courses
```

#### Create Course
```http
POST /api/admin/courses
Content-Type: application/json

{
  "title": "Advanced Java",
  "description": "Learn advanced Java concepts",
  "instructor": "Dr. Smith",
  "capacity": 30,
  "credits": 3
}
```

#### Update Course
```http
PUT /api/admin/courses/{id}
Content-Type: application/json

{
  "title": "Advanced Java",
  "description": "Updated description",
  "capacity": 40,
  "isActive": true
}
```

#### Delete Course
```http
DELETE /api/admin/courses/{id}
```

#### Get All Students
```http
GET /api/admin/students
```

#### Get Enrollments
```http
GET /api/admin/enrollments
```

#### Get Dashboard Statistics
```http
GET /api/admin/dashboard/stats
```

**Response:**
```json
{
  "totalStudents": 150,
  "totalCourses": 25,
  "activeEnrollments": 450,
  "totalEnrollments": 500
}
```

## 🔐 Security

### JWT Authentication
- Tokens expire after 24 hours (configurable)
- Tokens include user ID, username, and role
- All protected endpoints require valid JWT token in Authorization header
- Format: `Authorization: Bearer {token}`

### Rate Limiting
- Implemented using Bucket4j with Redis backend
- Prevents API abuse with per-user request limits
- Configurable rate limits per endpoint

### Password Security
- Passwords are hashed using Spring Security's BCrypt
- Passwords require minimum strength validation
- Never transmitted in responses

## 🏗️ Docker Configuration

### Services

**Frontend Service**
- Container: `lms-frontend`
- Port: `3000:80`
- Base Image: Node.js 20 LTS
- Build: Uses multi-stage build for optimization
- Web Server: Nginx reverse proxy

**Backend Service**
- Container: `lms-app`
- Port: `8080:8080`
- Base Image: Eclipse Temurin JDK 21
- Health Check: Actuator endpoint monitoring
- Environment: Configured via `.env` file
- Volumes: Persistent upload storage

**Redis Service**
- Container: `lms-redis`
- Port: `6379:6379`
- Image: `redis:7-alpine`
- Persistence: AOF (Append Only File)
- Health Check: Redis CLI ping

### Environment Variables

Create a `.env` file in the project root:

```env
# Database
SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/lms_db
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=your_secure_password

# JWT
JWT_SECRET=your_jwt_secret_key_here
JWT_EXPIRATION=86400000

# Redis
SPRING_DATA_REDIS_PASSWORD=your_redis_password

# File Upload
MAX_FILE_SIZE=10MB
MAX_REQUEST_SIZE=10MB

# JVM
JAVA_OPTS=-Xmx512m -Xms256m

# Spring Profile
SPRING_PROFILES_ACTIVE=dev
```

## 🧪 Testing

### Backend Tests
```bash
cd lms
mvn test
```

### Frontend Tests
```bash
cd frontend/lms
npm run lint
```

## 📊 Project Statistics

- **Backend Lines of Code**: Java Spring Boot application with comprehensive REST API
- **Frontend Components**: ~5 main page components with protected routing
- **Database Tables**: User, Course, Enrollment entities with proper relationships
- **API Endpoints**: 20+ RESTful endpoints for student, admin, and authentication operations
- **Deployment**: Full containerized deployment with health checks and monitoring

## 🚀 Performance Optimization

### Backend
- Connection pooling for database
- Redis caching for rate limiting
- JPA query optimization
- Actuator for performance monitoring
- Configurable JVM heap size

### Frontend
- Vite for fast development and optimized builds
- React 19 with latest performance features
- Tailwind CSS for minimal CSS output
- Router-based code splitting
- ESLint for code quality

## 🤝 Contributing

1. Create a feature branch
2. Make your changes
3. Run tests locally
4. Submit a pull request

## 📝 Development Tips

### Backend Development
- Use `application-dev.properties` for local development
- Enable detailed logging with `logging.level.root=DEBUG`
- Swagger/Springdoc can be added for API documentation

### Frontend Development
- Use `npm run dev` for hot module replacement (HMR)
- Check console for ESLint warnings
- Tailwind CSS IntelliSense extension recommended for VS Code

## 🐛 Troubleshooting

### Docker Issues
```bash
# View logs
docker-compose logs -f app
docker-compose logs -f frontend
docker-compose logs -f redis

# Restart services
docker-compose restart

# Reset everything
docker-compose down -v
docker-compose up -d
```

### Database Connection Issues
- Ensure PostgreSQL is running and accessible
- Check credentials in `.env` or `application.properties`
- Verify database exists: `CREATE DATABASE lms_db;`

### Redis Connection Issues
- Verify Redis is running on port 6379
- Check Redis health: `redis-cli ping`
- Ensure Spring Redis configuration is correct

### Frontend Build Issues
```bash
cd frontend/lms
rm -rf node_modules package-lock.json
npm install
npm run build
```

## 📚 Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [React Documentation](https://react.dev)
- [Vite Guide](https://vitejs.dev)
- [Tailwind CSS](https://tailwindcss.com)
- [Docker Compose Reference](https://docs.docker.com/compose)

## 📄 License

This project is provided as-is for educational and development purposes.

## 👥 Support

For issues, questions, or improvements, please refer to the project documentation or create an issue in the repository.

---

**Last Updated**: March 5, 2026  
**Project Version**: 0.0.1-SNAPSHOT  
**Java Version**: 21 LTS  
**Spring Boot**: 4.0.1  
**React**: 19.2.3