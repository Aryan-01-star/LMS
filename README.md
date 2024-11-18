# Library Management System
This is a simple Java-based Library Management System designed to manage books, users, and other essential library operations. The system provides a variety of functionalities, including book management, user authentication, QR code generation, and data export to Excel. It utilizes Hibernate for database interaction, SLF4J for logging, and various services for managing books and users.

## Features
Book Management: Add, view, update, and search books within the library.
User Management: Create, update, and delete users with email validation and role-based access control.
Authentication: Secure JWT-based user authentication for login and authorization.
QR Code Generation: Automatically generate QR codes for each book.
Excel Export: Export book data to Excel files for easy reporting and backup.
Logging: Detailed logging of system activities using SLF4J and Logback for debugging and tracking.

## Technologies Used
Java: The core programming language for the system.
Hibernate: For ORM-based database interaction and object-relational mapping.
SLF4J: For logging framework to record system activities.
JWT (JSON Web Tokens): For secure user authentication and session management.
MySQL: Relational database management system (RDBMS) for storing data (can be replaced with any other RDBMS).
Apache Maven: For dependency management and project building.
QR Code Library: For generating QR codes for books.

## Prerequisites
Before running the project, ensure you have the following installed:

JDK 11 or higher: Make sure you have a compatible Java Development Kit (JDK) installed. The project uses Java 11 or above for compatibility.

Maven: Apache Maven for managing dependencies and building the project.

MySQL (or other RDBMS): Set up your preferred database and configure the connection in the hibernate.cfg.xml file.

You can configure the database connection settings such as username, password, and JDBC URL in the hibernate.cfg.xml file.

## Usage
User Registration: Register as a new user with email validation and role-based permissions.
Login: Use JWT tokens for secure login and authentication.
Book Operations: Add, view, and search books in the system.
QR Code Generation: Generate a QR code for any book for easy reference.
Export to Excel: Export the library's book data to an Excel file for reporting.

### Logging
This project uses SLF4J and Logback for logging system activities. Logs are generated for various events like user login, book operations, and errors. You can find the log files in the logs/ directory.

### Contribution
As this is an ongoing project, contributions are welcome. If you find any bugs or areas for improvement, feel free to fork the repository and submit a pull request.

## Note
This project is still in progress, so there may be some unfinished features or bugs. If you encounter issues, I would greatly appreciate any contributions or fixes to improve the codebase.
