# 🎓 EduSystem – Fullstack Education Platform

EduSystem is a fullstack education application designed for students, teachers, and administrators. It supports daily recitation reporting, feedback, learning materials, Zoom class scheduling, and weekly evaluations.

---

## 🏗️ Architecture

```
+-------------+       HTTP/REST       +--------------+        JDBC         +-------------+
|  React App  |  <------------------> |  Spring Boot |  <----------------> | PostgreSQL  |
|  (Frontend) |                       |  (Backend)   |                    |   Database  |
+-------------+                       +--------------+                    +-------------+
```

---

## ⚙️ Tech Stack

- **Frontend:** React.js, Nginx
- **Backend:** Spring Boot (JDK 21), Gradle
- **Database:** PostgreSQL 15
- **Database Migration:** Flyway
- **Containerization:** Docker, Docker Compose

---

## 📦 Project Structure

```
edusystem-backend/
├── src/
│   └── main/
│       ├── java/com/example/edusystem/...
│       └── resources/
│           ├── application.yml
│           └── db/migration/V1__init.sql
├── build.gradle
├── Dockerfile
├── .env
├── docker-compose.yml 
└── README.md

```

---

## 🐳 Running with Docker

### Prerequisites
- Docker & Docker Compose installed
- Internet access (to pull images)

### Steps

1. **Build the Spring Boot JAR**
   ```bash
   cd backend
   ./gradlew clean bootJar
   ```

2. **Run Docker containers**
   ```bash
   docker-compose up --build
   ```

3. Access the app:
    - Frontend: [http://localhost:3000](http://localhost:3000)
    - Backend: [http://localhost:8080](http://localhost:8080)
    - PostgreSQL: localhost:5432

---

## 🔐 Environment Variables

Set in the root `.env` file:

```env
POSTGRES_DB=edusystemdb
POSTGRES_USER=eduadmin
POSTGRES_PASSWORD=edupass
```

---

## 🔃 Flyway Migration

Flyway will auto-run SQL files in:

```
backend/src/main/resources/db/migration/
└── V1__initial-setup.sql
```

✅ Ensure:
- File names follow format: `V1__description.sql`
- `ddl-auto` is set to `none` in `application.yml`:

```yaml
spring:
  jpa:
    hibernate:
      ddl-auto: none
```

---

## 🧪 Testing the Setup

1. Open browser:
    - Check frontend loads on port 3000
    - Test REST endpoints via Postman or browser

2. Verify DB tables:
   ```bash
   docker exec -it edusystem_postgres psql -U eduadmin -d edusystemdb
   \dt  -- List all tables
   ```

---

## 📌 Planned Features

- ✅ Daily recitation report and feedback
- ✅ Material upload and access
- ✅ Weekly evaluation system
- ✅ Zoom class scheduling
- 🛠️ Notifications & Chat (Planned)
- 📱 Mobile App (Planned)

---

## 🤝 Contribution

1. Fork the repo
2. Create a new branch
3. Make your changes
4. Submit a pull request

---

## 📄 License

MIT License © 2025 Riskiana