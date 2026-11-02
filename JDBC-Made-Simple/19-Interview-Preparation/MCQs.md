# 30. JDBC Multiple Choice Questions (MCQs)

Test your JDBC knowledge with topic-wise multiple-choice questions.

---

### Q1: In which package do the core JDBC interfaces reside?
- A) `java.db`
- B) `java.sql`
- C) `javax.database`
- D) `java.net.sql`

**Correct Answer:** **B) `java.sql`**  
**Explanation:** Standard JDBC interfaces (`Connection`, `Statement`, `ResultSet`, `PreparedStatement`) are located in `java.sql`.

---

### Q2: What is the starting index for JDBC `?` placeholders?
- A) 0
- B) 1
- C) -1
- D) Defined by database configuration

**Correct Answer:** **B) 1**  
**Explanation:** JDBC uses 1-based indexing for placeholders and columns. `ps.setInt(1, 101)` sets the first placeholder.

---

### Q3: Which JDBC driver type is written 100% in Java and connects directly to the database engine?
- A) Type 1
- B) Type 2
- C) Type 3
- D) Type 4

**Correct Answer:** **D) Type 4**  
**Explanation:** Type 4 (Thin Driver) is pure Java and communicates directly via database network socket protocols without client installation.

---

### Q4: Which method should be used to execute an `UPDATE` SQL statement?
- A) `executeQuery()`
- B) `executeUpdate()`
- C) `executeSelect()`
- D) `executeBatchOnly()`

**Correct Answer:** **B) `executeUpdate()`**  
**Explanation:** `executeUpdate()` is used for `INSERT`, `UPDATE`, `DELETE`, and DDL, returning the number of affected rows.

---

### Q5: What exception is thrown if `Class.forName()` cannot find the MySQL driver JAR?
- A) `SQLException`
- B) `ClassNotFoundException`
- C) `DriverNotFoundException`
- D) `DatabaseConnectionException`

**Correct Answer:** **B) `ClassNotFoundException`**  
**Explanation:** Java throws `ClassNotFoundException` when the specified class cannot be located in the application classpath.

---

### Q6: What does calling `conn.setAutoCommit(false)` achieve?
- A) Automatically commits every SQL statement immediately
- B) Begins a manual transaction boundary
- C) Closes the connection
- D) Disables database logging

**Correct Answer:** **B) Begins a manual transaction boundary**  
**Explanation:** Disabling auto-commit allows multiple statements to be grouped together and committed or rolled back atomically.

---

### Q7: In what order does `try-with-resources` close database resources?
- A) In the order they were opened
- B) In random order
- C) In reverse order of declaration
- D) All resources close at the exact same microsecond

**Correct Answer:** **C) In reverse order of declaration**  
**Explanation:** Java closes AutoCloseable resources in exact reverse order: `ResultSet` first, followed by `Statement`, then `Connection`.

---

### Q8: What does `ResultSet.next()` return when the cursor reaches the end of data?
- A) `null`
- B) `0`
- C) `false`
- D) Throws `NoSuchElementException`

**Correct Answer:** **C) `false`**  
**Explanation:** `next()` returns `false` when there are no more rows, causing a `while (rs.next())` loop to terminate cleanly.

---

### Q9: Which interface is used to call Stored Procedures?
- A) `ProcedureStatement`
- B) `PreparedStatement`
- C) `CallableStatement`
- D) `DatabaseStatement`

**Correct Answer:** **C) `CallableStatement`**  
**Explanation:** `CallableStatement` extends `PreparedStatement` and provides methods like `registerOutParameter()` to execute stored procedures.

---

### Q10: Which popular connection pool is recognized for ultra-high performance in modern Java applications?
- A) HikariCP
- B) JDBC-Pool-Classic
- C) SunConnectionManager
- D) JavaODBCPool

**Correct Answer:** **A) HikariCP**  
**Explanation:** HikariCP is the default, blazing-fast connection pool used in modern Java and Spring Boot ecosystems.
