# Java Tech Product & Registry Management System

A robust, Object-Oriented CLI application built in Java for managing tech products, manufacturers, and sales transactions. Upgraded from a traditional file-based system to a high-performance relational database architecture, this system serves as an enterprise-grade registry, inventory tracker, and real-time business analytics engine.

## 🚀 Key Features

* **Object-Oriented Architecture:** Full utilization of Core Java principles, including Inheritance, Polymorphism, and Encapsulation to differentiate between product types (e.g., Computers, Mobile Devices).
* **Relational Database Integration (RDBMS):** Migrated from flat CSV files to a structured database layer. Features robust data synchronization and transactional integrity across tables (`manufacturers`, `products`, `sales`).
* **Cloud-Native & Distributed Ready:** Fully compatible with standard **MySQL** and distributed SQL databases like **TiDB**, ensuring high availability and seamless scalability.
* **Business Intelligence & Analytics:** Real-time statistics module driven by optimized SQL queries calculating total revenue, sales per manufacturer, inventory thresholds, and interactive user engagement tracking.
* **Advanced Date/Time Handling:** Implements Java's modern `LocalDateTime` API mapping directly to database `DATETIME`/`TIMESTAMP` fields for accurate financial and transactional auditing.
* **Streamlined UI Experience:** A fully dynamic Console UI with nested sub-menus (`do-while` loops, `switch-case` blocks) and automated screen-clearing execution optimized for native Windows/Linux terminals.

## 🛠️ Tech Stack

* **Language:** Java (SE 8+)
* **Database:** MySQL / TiDB (Distributed SQL)
* **Connectivity:** JDBC (Java Database Connectivity)
* **Build/IDE:** NetBeans / Apache Ant / Maven

## 💻 How to Run

To build and launch the application directly from your terminal using the standalone executable package (Fat JAR), follow these steps:

1. **Build the project** using Maven to package the source code along with the MySQL driver dependencies:
   ```bash
   mvn clean package

2. **Run the standalone** JAR file in your terminal or PowerShell java -jar target/TechProductManager-1.0-SNAPSHOT-jar-with-dependencies.jar

## 📦 Project Structure

```text
├── src/                  # Java Source Code (.java files)
│   └── database/         # DB Connection wrapper & SQL schemas
├── dist/                 # Compiled binaries and distribution package
│   └── TechProductManager.jar
└── schema.sql            # Database schema, table definitions, and constraints
