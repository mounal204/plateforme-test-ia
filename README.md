#  AI Evaluation Platform

An intelligent web application for generating and managing multiple-choice quizzes (MCQs) using Artificial Intelligence. The platform allows instructors to automatically create quizzes from educational content, manage questions, and evaluate learners efficiently.

---

##  Project Overview

The AI Evaluation Platform is a full-stack web application developed with **Spring Boot** for the backend and **Angular** for the frontend.

The system leverages Artificial Intelligence to generate high-quality multiple-choice questions from user-provided educational content, reducing the time required to create assessments manually.

---

##  Features

*  Secure user authentication
*  User management
*  Course and content management
*  AI-powered MCQ generation
*  Automatic quiz creation
*  Quiz management
*  Database integration
*  RESTful API
*  Modern Angular user interface

---

## 🛠️ Technologies Used

### Backend

* Java 23
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* Maven
* REST API

### Frontend

* Angular
* TypeScript
* HTML5
* CSS3

### Database

* MySQL

### Artificial Intelligence

* Groq API
* Large Language Model (LLM)

---

## 📂 Project Structure

```
Backend/
│
├── src/
├── pom.xml
└── application.properties

Frontend/
│
├── src/
├── angular.json
└── package.json
```

---

##  Installation

### Backend

Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/plateforme-test-ia.git
```

Go to the project directory

```bash
cd backend
```

Configure your database and API key inside

```
application.properties
```

Run the application

```bash
mvn spring-boot:run
```

---

### Frontend

```bash
cd frontend
npm install
ng serve
```

The application will be available at:

```
http://localhost:4200
```

---

## ⚙️ Configuration

Create your own API key and configure it in:

```
src/main/resources/application.properties
```

Example:

```properties
groq.api.key=YOUR_GROQ_API_KEY
```

---

## Screenshots

Screenshots of the application will be added soon.

---

##  Future Improvements

* PDF export
* Quiz history
* User statistics
* Difficulty level selection
* AI-generated explanations
* Timer for quizzes
* Dashboard analytics

---

##  Author

**MOUNA LAAROUSSI**

GitHub: https://github.com/mounal204

---

## 📄 License

This project is developed for educational and research purposes
