🚀 ETL CRUD Java Project

📌 Project Overview

This project is a Java-based ETL (Extract, Transform, Load) and CRUD application that allows users to manage employee data efficiently. It supports multiple data sources such as MySQL Database, CSV files, and JSON files, and provides a console-based interface for performing operations.

The project demonstrates real-world concepts like data pipelines, validation, logging, and testing, making it suitable for learning Data Engineering + Backend Development fundamentals.

⸻

⚙️ Features

🔹 CRUD Operations
	•	Add new employee records
	•	View all employees
	•	Update employee details
	•	Delete employee records

🔹 ETL Pipeline
	•	Extract data from:
	•	CSV files
	•	JSON files
	•	Database
	•	Transform data:
	•	Clean invalid data
	•	Format fields properly
	•	Load data into MySQL database

🔹 Data Validation
	•	Email format validation
	•	Duplicate record prevention
	•	Input sanitization

🔹 Logging
	•	Logs important operations
	•	Helps in debugging and monitoring

🔹 Testing
	•	JUnit test cases for DAO and service layers

🔹 Console-Based Interface
	•	User-friendly menu system
	•	Supports multiple operations in one run

⸻

🏗️ Project Structure

ETL-CRUD-Project/
│
├── model/          # Entity classes (Employee)
├── dao/            # Database interaction (CRUD)
├── service/        # Business logic & ETL processing
├── util/           # Utility classes (DB connection, validation, logger)
├── main/           # Main class with console menu
├── test/           # JUnit test cases
└── resources/      # CSV/JSON sample files


⸻

🛠️ Technologies Used
	•	Java (JDK 17)
	•	JDBC (MySQL)
	•	MySQL Database
	•	Jackson (for JSON processing)
	•	OpenCSV (for CSV handling)
	•	JUnit (Testing)

⸻

🔌 Setup Instructions

1️⃣ Clone the Repository

git clone <your-repo-link>
cd ETL-CRUD-Project

2️⃣ Configure Database
	•	Create a MySQL database
	•	Update DB credentials in:

DBConnection.java

Example:

url = jdbc:mysql://localhost:3306/etl_project
username = root
password = your_password


⸻

3️⃣ Run the Project
	•	Open in your IDE (Antigravity / IntelliJ / Eclipse)
	•	Run the Main.java file

⸻

📋 Sample Menu

1. CSV -> DB
2. JSON -> DB
3. DB -> DB
4. Insert Employee
5. View All Employee
6. Update Employee
7. Delete Employee
8. Exit


⸻

🧪 Testing
	•	Run JUnit test cases from the test/ folder
	•	Covers:
	•	DAO methods
	•	Service logic

⸻

🚧 Challenges Faced
	•	Handling duplicate entries
	•	Validating email formats
	•	Managing multiple data sources
	•	Ensuring smooth ETL pipeline

⸻

📈 Future Enhancements
	•	Add GUI (JavaFX / Web UI)
	•	Integrate REST APIs
	•	Use Hibernate instead of JDBC
	•	Add Docker support for deployment

⸻

⭐ Conclusion

This project demonstrates how to build a robust data pipeline system with CRUD functionality, combining backend development and data engineering concepts in a practical implementation.
