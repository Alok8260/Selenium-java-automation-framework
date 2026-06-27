# Selenium Java Automation Framework

A scalable web automation framework built using **Java**, **Selenium WebDriver**, **TestNG**, **Maven**, and the **Page Object Model (POM)** design pattern.

## 🚀 Tech Stack

- Java 21
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Git & GitHub

## 📁 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.automation.pages
│   └── resources
│       └── config.properties
│
├── test
│   └── java
│       ├── com.automation.base
│       └── com.automation.test
│
TestNG
└── testNg.xml
```

## ✅ Features Implemented

- Login Automation
- Base Test Setup
- Browser Initialization
- Configuration Management
- Page Object Model (POM)
- TestNG Test Execution

## 🔄 Upcoming Features

- File Upload Automation
- Database Validation
- API Testing
- AI/RAG Workflow Automation
- Screenshot Capture
- Reporting
- Parallel Execution
- Cross Browser Testing
- Jenkins CI/CD Integration
- Docker Support

## ⚙️ Prerequisites

- Java 21+
- Maven
- IntelliJ IDEA
- Chrome Browser
- Git

## ▶️ Run the Project

Clone the repository:

```bash
git clone https://github.com/<your-username>/<repository-name>.git
```

Go to the project folder:

```bash
cd <repository-name>
```

Install dependencies:

```bash
mvn clean install
```

Run the tests:

```bash
mvn test
```

Or execute the TestNG suite:

```bash
mvn test -DsuiteXmlFile=TestNG/testNg.xml
```

## 🔒 Configuration

Create a `config.properties` file inside:

```
src/main/resources/
```

Example:

```properties
appUrl=https://example.com
browser=chrome
username=your_username
password=your_password
```

> **Note:** `config.properties` is ignored by Git to protect sensitive credentials.

## 📌 Design Pattern

- Page Object Model (POM)

## 🤝 Contributing

Contributions, suggestions, and improvements are welcome.

## 📄 License

This project is for learning and demonstration purposes.

## 👨‍💻 Author

**Alok Bharati**:-
QA Automation Engineer
