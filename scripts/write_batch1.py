import os
import sys

base_dir = r'F:\JDBC Project\JDBC-Made-Simple'

# Topic 01
t1 = '''# 01. Introduction to Database

Welcome to the foundation of data storage! Before we teach Java how to talk to databases, let us understand what data and databases actually are in simple everyday words.

---

## 1. What is it?

- **Data:** Raw facts, numbers, words, or measurements. For example: 101, Alice, 20, Computer Science.
- **Database:** An organized digital container that stores data systematically so that computers can search, add, update, and delete information quickly and safely.
- **DBMS (Database Management System):** Software that helps you create and manage databases (e.g., storing simple files).
- **RDBMS (Relational Database Management System):** An advanced DBMS that organizes data into neat **tables with rows and columns** and connects related tables together.
- **MySQL:** One of the world's most popular, free, open-source RDBMS software.

---

## 2. Why do we need it?

Imagine storing 50,000 students' information in a plain text file (students.txt):
1. **Searching is painfully slow:** To find student #49,999, you have to read the whole file line by line.
2. **Data corruption:** If two people edit the text file at the same time, data gets destroyed.
3. **No security:** Anyone can open the text file and change marks or delete accounts.

A database solves all these problems:
- Instant search in milliseconds.
- Multiple users can access data at the same time without corruption.
- Strong security with passwords and user permissions.

---

## 3. Real-World Example

- **Messy Room (Raw Data):** Clothes and books tossed all over the floor. You cannot find your blue socks when you are late for college!
- **Organized Wardrobe (Database):** Labeled shelves, shoe racks, and hangers. You open the drawer and grab your socks in 2 seconds.

---

## 4. Visual Explanation

### Data vs Database
![Data vs Database](Visuals/Data-vs-Database.png)

### Database Table Structure
![Database Table](Visuals/Database-Table.png)

### DBMS vs RDBMS
![DBMS vs RDBMS](Visuals/DBMS-vs-RDBMS.png)

---

## 5. How does a Database Table Work?

A database organizes information into **Tables**. Think of a table as an Excel spreadsheet:

| id (INT) | name (VARCHAR) | age (INT) | department (VARCHAR) |
| :--- | :--- | :--- | :--- |
| **101** | Alice Johnson | 20 | Computer Science |
| **102** | Bob Smith | 22 | Information Tech |
| **103** | Charlie Brown | 21 | Electronics Eng |

- **Columns (Fields / Attributes):** The vertical headers defining what kind of data is stored (id, 
ame, ge, department).
- **Rows (Records / Tuples):** The horizontal lines containing actual student data. Row 1 belongs to Alice; Row 2 belongs to Bob.

Throughout this entire repository, we will use this exact table:
- **Database:** college_db
- **Table:** students

---

## 6. Important Points to Remember

1. Data is raw facts; a database is structured, secure storage.
2. An RDBMS stores data in tables linked by relationships.
3. MySQL is the database server we will connect to using Java JDBC.
4. Each record in a table is a **row**, and each property is a **column**.

---

## 7. Common Beginner Mistakes

- **Confusing MySQL with SQL:** SQL is the language you type (SELECT * FROM students); MySQL is the software server that runs the command.
- **Thinking databases are only for big companies:** Even small mobile phone apps use local databases to remember your login!
'''

with open(os.path.join(base_dir, '01-Database-Basics', 'Notes.md'), 'w', encoding='utf-8') as f:
    f.write(t1)

# Topic 02
t2 = '''# 02. Introduction to JDBC

Now that we know what a database is, how does a Java application communicate with MySQL? This is where **JDBC** enters the picture.

---

## 1. What is it?

**JDBC** stands for **Java Database Connectivity**.

In simple words:
> **JDBC is a standard set of Java tools (interfaces and classes) that allows Java programs to talk to a relational database like MySQL.**

It comes built into Java inside the java.sql package.

---

## 2. Why do we need it?

Java and MySQL speak completely different languages:
- Java speaks **Objects** (classes, variables, methods).
- MySQL speaks **SQL** (Structured Query Language) and communicates over binary network sockets.

Without JDBC, you would have to write hundreds of lines of complex socket networking code just to send one query. Even worse, if you switched from MySQL to Oracle, you would have to rewrite your entire program from scratch!

JDBC acts as a universal adapter:
1. You write standard Java JDBC code.
2. The database vendor provides a small driver.
3. Your Java application can now talk to any database without changing its core query code!

---

## 3. Real-World Analogy: The Restaurant Waiter

- **You (Java Application):** You are hungry and want food. You speak English.
- **The Chef (MySQL Database):** Works in the kitchen. He prepares food according to recipes.
- **The Waiter (JDBC):** Takes your order from your table, delivers it to the kitchen in kitchen order language, waits for the cooked meal, and carries the food back to your table.

Without the waiter, you would have to walk into the kitchen, figure out the stoves, and argue with the cook!

---

## 4. Visual Explanation

### What is JDBC?
![What is JDBC](Visuals/What-is-JDBC.png)

### Why Do We Need JDBC?
![Why JDBC](Visuals/Why-JDBC.png)

### Java to MySQL Communication Flow
![Java to MySQL](Visuals/Java-to-MySQL.png)

---

## 5. How does it work?

Here is the high-level communication cycle:
1. **Java Program** creates a database connection request.
2. **JDBC API** passes the request to the MySQL Driver.
3. **Driver** opens a network connection to MySQL server (port 3306).
4. **Java Program** sends an SQL query (e.g., SELECT * FROM students).
5. **MySQL Server** runs the query and returns matching rows.
6. **JDBC** wraps the rows into a Java ResultSet object for your code to read.

---

## 6. Important Points to Remember

1. JDBC is part of standard Java (java.sql).
2. JDBC works with any relational database that provides a JDBC driver.
3. JDBC follows the  Write Once Run Anywhere philosophy for database code.

---

## 7. Common Beginner Mistakes

- **Thinking JDBC is a database:** JDBC is NOT a database; it is the telephone wire connecting Java to the database.
- **Forgetting the driver:** JDBC is just the interface (contract); you always need the database vendor's driver library (e.g., MySQL Connector/J) to actually communicate.
'''

with open(os.path.join(base_dir, '02-Introduction-to-JDBC', 'Notes.md'), 'w', encoding='utf-8') as f:
    f.write(t2)

# Topic 03
t3 = '''# 03. JDBC Architecture

To master JDBC, we must understand how its internal layers fit together.

---

## 1. What is it?

The JDBC Architecture is a **4-layer bridge** that links your high-level Java code to low-level database network sockets.

The four layers are:
1. **Java Application:** Your code (e.g., Main.java).
2. **JDBC API:** Standard Java interfaces located in package java.sql.
3. **JDBC Driver Manager & Driver:** The manager that selects the correct vendor driver (e.g., MySQL Connector/J).
4. **Database Server:** The physical database engine (e.g., MySQL Community Server).

---

## 2. Why do we need this layered architecture?

By separating the **API (interfaces)** from the **Driver (implementation)**:
- Sun Microsystems / Oracle creates the rules (Connection, Statement, ResultSet).
- Database companies (MySQL, Oracle, PostgreSQL, IBM) write the drivers that satisfy those rules.
- You as a developer only ever learn the standard interfaces!

---

## 3. Visual Explanation

### Complete JDBC Architecture
![JDBC Architecture](Visuals/JDBC-Architecture.png)

### Communication Flow
![Communication Flow](Visuals/Communication-Flow.png)

---

## 4. Understanding Key JDBC Components

| Component | Role in Simple Words |
| :--- | :--- |
| **DriverManager** | The factory class that manages drivers and creates database connections. |
| **Connection** | The active session / pipeline between Java and the database. |
| **Statement** | The vehicle that carries your SQL query to the database. |
| **PreparedStatement** | An improved, pre-compiled vehicle that securely accepts parameters. |
| **CallableStatement** | Used to call stored procedures defined inside the database. |
| **ResultSet** | The tabular result returned by a SELECT query. |
| **SQLException** | The exception thrown if something goes wrong during database communication. |

---

## 5. Important Points to Remember

1. JDBC architecture decouples application logic from database vendor protocols.
2. All standard JDBC interfaces live in the java.sql package.
3. DriverManager acts as the coordinator between Java code and the vendor driver.
'''

with open(os.path.join(base_dir, '03-JDBC-Architecture', 'Notes.md'), 'w', encoding='utf-8') as f:
    f.write(t3)

# Topic 04
t4 = '''# 04. JDBC Drivers

A driver is the engine that converts standard Java method calls into the specific network commands understood by a database.

---

## 1. What is it?

A **JDBC Driver** is a software component (usually distributed as a single .jar file) that implements the standard JDBC interfaces for a specific database vendor.

Historically, Sun Microsystems defined **Four Types of JDBC Drivers**:
1. **Type 1: JDBC-ODBC Bridge Driver**
2. **Type 2: Native-API Driver (Partially Java)**
3. **Type 3: Network-Protocol Driver (Middleware)**
4. **Type 4: Thin Driver (Direct 100% Pure Java)**

---

## 2. Explanation of the Four Types

### Type 1: JDBC-ODBC Bridge Driver
- **How it worked:** Java -> JDBC -> ODBC Driver -> Native DB Library -> Database.
- **Problem:** Very slow because of multiple translations. Required ODBC configuration on every single user machine.
- **Status:** **Obsolete and removed in Java 8.**

### Type 2: Native-API Driver
- **How it worked:** Java -> JDBC Driver -> Vendor C/C++ Client Library -> Database.
- **Problem:** Required vendor client software (like Oracle Client) installed on every client machine. Not platform-independent.
- **Status:** Rarely used today.

### Type 3: Network-Protocol Driver (Middleware)
- **How it worked:** Java -> JDBC Driver -> Middleware Application Server -> Database.
- **Problem:** Needed an extra server in between, adding latency and maintenance overhead.
- **Status:** Used only in specialized enterprise proxy environments.

### Type 4: Thin Driver (Pure Java Driver)
- **How it works:** Java -> Type 4 Driver -> Direct TCP/IP Socket -> Database.
- **Why it wins:** Written 100% in Java. Connects directly to database network protocol. No software installation needed on the client machine! Just include the JAR file in your project.
- **Status:** **The universal industry standard used today (e.g., MySQL Connector/J).**

---

## 3. Visual Explanation

### The Four Driver Types
![Four Driver Types](Visuals/Four-Driver-Types.png)

### Driver Comparison Table
![Driver Comparison](Visuals/Driver-Comparison.png)

---

## 4. Comparison Table

| Driver Type | Pure Java? | Client Installation Required? | Performance | Current Industry Status |
| :--- | :--- | :--- | :--- | :--- |
| **Type 1** | No | Yes (ODBC setup) | Slowest | Obsolete (Removed in Java 8) |
| **Type 2** | No (Uses C/C++) | Yes (Vendor Client) | Medium | Rare |
| **Type 3** | Yes (Client side) | No vendor client | Moderate | Specialized middleware |
| **Type 4** | **Yes (100% Pure Java)** | **None (Just 1 JAR file)** | **Fastest** | **Modern Standard (99%)** |

---

## 5. Why Type 4 is Used Everywhere Today

1. **Zero Client Installation:** You do not have to install MySQL on the user's PC. If your Java app runs on a user's laptop, it only needs the JAR file to connect to a cloud database!
2. **Platform Independent:** Works seamlessly on Windows, macOS, Linux, Docker, and Cloud Kubernetes clusters.
3. **Maximum Speed:** Direct network communication without intermediate bridges.
'''

with open(os.path.join(base_dir, '04-JDBC-Drivers', 'Notes.md'), 'w', encoding='utf-8') as f:
    f.write(t4)

# Topic 05
t5 = '''# 05. JDBC Environment Setup

Let us set up everything needed to run your first real JDBC program.

---

## 1. What do we need?

To connect Java to MySQL, you need three software components:
1. **Java Development Kit (JDK 17 or higher):** To compile and run Java programs.
2. **MySQL Server (8.0 or higher):** The database engine that holds our data.
3. **MySQL Connector/J:** The Type 4 JDBC driver JAR file that bridges Java and MySQL.

---

## 2. Visual Explanation

### Java and MySQL Setup Overview
![Java Setup](Visuals/Java-Setup.png)

### Adding MySQL Connector/J to your Project
![MySQL Connector Setup](Visuals/MySQL-Connector-Setup.png)

---

## 3. Step-by-Step Setup Guide

### Step 1: Install MySQL Server and Workbench
1. Download MySQL Community Server from dev.mysql.com.
2. During installation, set root password (e.g., oot123). Remember this password!
3. Start the MySQL service on port 3306.

### Step 2: Create the Database and Table
Open MySQL Workbench or your terminal and execute:

`sql
CREATE DATABASE college_db;

USE college_db;

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT,
    department VARCHAR(50)
);

-- Insert sample records
INSERT INTO students (id, name, age, department) VALUES
(101, 'Alice Johnson', 20, 'Computer Science'),
(102, 'Bob Smith', 22, 'Information Tech');
`

### Step 3: Add MySQL Connector/J to your Java Project

If using **Maven**, add this to your pom.xml:
`xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.3.0</version>
</dependency>
`

If using a plain Java project without Maven:
1. Download mysql-connector-j-8.3.0.jar.
2. Add it to your project classpath / libraries.

---

## 4. Your First Test Program

Let us verify that Java can find the MySQL Driver class.

### Java Code: DriverTest.java

`java
package com.example.jdbc;

public class DriverTest {
    public static void main(String[] args) {
        System.out.println(Checking MySQL JDBC Driver availability...);

        try {
            // Check if the MySQL driver class is present in classpath
            Class.forName(com.mysql.cj.jdbc.Driver);
            System.out.println(SUCCESS: MySQL Connector/J driver found on classpath!);
        } catch (ClassNotFoundException e) {
            System.err.println(ERROR: MySQL Driver not found! Please add mysql-connector-j.jar to classpath.);
            e.printStackTrace();
        }
    }
}
`

---

## 5. Expected Output

When the driver JAR is present in classpath:
`	ext
Checking MySQL JDBC Driver availability...
SUCCESS: MySQL Connector/J driver found on classpath!
`

---

## 6. Common Beginner Mistakes

- **ClassNotFoundException: com.mysql.cj.jdbc.Driver:** This means your project does not have the MySQL Connector/J JAR in its libraries.
- **Using old driver class name:** Old tutorials use com.mysql.jdbc.Driver. For modern MySQL 8.0+, always use com.mysql.cj.jdbc.Driver.
'''

with open(os.path.join(base_dir, '05-Environment-Setup', 'Notes.md'), 'w', encoding='utf-8') as f:
    f.write(t5)

# Example for Topic 05
ex5 = '''package com.example.jdbc;

/**
 * DriverTest.java
 * Simple test to verify that MySQL Connector/J is properly added to classpath.
 */
public class DriverTest {
    public static void main(String[] args) {
        System.out.println(=== Testing MySQL JDBC Driver Setup ===);
        try {
            Class.forName(com.mysql.cj.jdbc.Driver);
            System.out.println(SUCCESS: com.mysql.cj.jdbc.Driver loaded successfully!);
            System.out.println(Your Java environment is ready for JDBC connections.);
        } catch (ClassNotFoundException e) {
            System.err.println(FAILURE: MySQL Driver class not found!);
            System.err.println(Make sure mysql-connector-j.jar is added to your project classpath.);
        }
    }
}
'''

with open(os.path.join(base_dir, '05-Environment-Setup', 'Examples', 'DriverTest.java'), 'w', encoding='utf-8') as f:
    f.write(ex5)

print('BATCH 1 COMPLETE!')
