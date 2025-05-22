# Portfolio Backend

This is the **Spring Boot backend** for the Portfolio project. It manages projects, handles image uploads, and provides user authentication via Spring Security.

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Security
- Spring Web & JPA
- PostgreSQL (or H2 for development)
- JUnit & MockMvc (for tests)

## 🚀 Getting Started

### Prerequisites

- Java 17+
- PostgreSQL (if using in production)
- Maven

### Installation

cd backend
./mvnw clean install

### Run the application

./mvnw spring-boot:run
By default, the app runs on http://localhost:8080

## 🖌️ Endpoints

| Method | Endpoint            | Auth Required | Description            |
| ------ | ------------------- | ------------- | ---------------------- |
| GET    | /api/projects       | ❌             | Get all projects       |
| POST   | /api/projects       | ✅             | Create a new project   |
| POST   | /api/login          | ❌             | Log in                 |
| GET    | /uploads/{filename} | ❌             | Access uploaded images |
