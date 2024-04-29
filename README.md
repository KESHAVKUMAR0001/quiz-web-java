# 🎓 Java Quiz App
A clean and responsive MCQ quiz web application developed with **Spring Boot 3**, **Spring Data JPA**, **Thymeleaf**, and an embedded **H2 Database**.

---

## 📌 Features
- **Randomized Questions:** Draws random Core Java questions for each session.
- **Server-Side Validation:** Answers are evaluated securely on the backend.
- **Detailed Review:** Shows selected answers vs. correct answers with instant score & accuracy percentage.
- **Leaderboard:** Hall of Fame ranking top candidates by score and completion time.
- **Zero Configuration:** Uses embedded in-memory H2 database; runs out of the box with no external setup.

---

## 🛠️ Tech Stack
- **Language & Framework:** Java 17+, Spring Boot 3.2.5
- **Data & ORM:** Spring Data JPA, Hibernate 6
- **Database:** In-memory H2 (`jdbc:h2:mem:quizdb`) with optional MySQL support
- **UI & Templating:** Thymeleaf, Bootstrap 5.3, Bootstrap Icons, Google Fonts
- **Build Tool:** Apache Maven (Maven Wrapper included)

---

## 🚀 How to Run

### Run from Terminal
```powershell
# Windows
.\mvnw.cmd spring-boot:run

# Linux / macOS
./mvnw spring-boot:run
```

### Run from IDE (IntelliJ / Eclipse / VS Code)
Open the project directory and execute `main()` in:  
`src/main/java/com/quiz/app/QuizApplication.java`

---

## 🌐 Application URLs
- **Quiz App:** [http://localhost:8080](http://localhost:8080)
- **Leaderboard:** [http://localhost:8080/scoreboard](http://localhost:8080/scoreboard)
- **H2 DB Console:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  
  *(JDBC URL: `jdbc:h2:mem:quizdb` | User: `sa` | Password: blank)*

---

## ⚙️ Optional MySQL Setup
To switch from H2 to MySQL, update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quiz_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

## 👨‍💻 Author
- **Keshav Kumar**
- GitHub: [@KESHAVKUMAR0001](https://github.com/KESHAVKUMAR0001)
- Email: [dsaonelove@gmail.com](mailto:dsaonelove@gmail.com)

---

## 📄 License
Open-source and free for academic and college project evaluations.

