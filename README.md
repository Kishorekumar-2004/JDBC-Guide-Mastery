# JDBC Guide Mastery

A step-by-step, visual guide to Java Database Connectivity (JDBC), from database
fundamentals to production-minded coding practices, revision notes, and interview
preparation.

## Start here

The learning material is in [`JDBC-Made-Simple/`](JDBC-Made-Simple/). Begin with
the [full learning roadmap](JDBC-Made-Simple/README.md), then work through the
numbered topics in order. Each topic folder contains notes and, where available,
Java examples, SQL scripts, and diagrams.

## Learning path

### JDBC fundamentals

1. [Database Basics](JDBC-Made-Simple/01-Database-Basics/Notes.md) — data,
   databases, DBMS/RDBMS, and tables.
2. [Introduction to JDBC](JDBC-Made-Simple/02-Introduction-to-JDBC/Notes.md) —
   what JDBC is and how Java communicates with a database.
3. [JDBC Architecture](JDBC-Made-Simple/03-JDBC-Architecture/Notes.md) — the
   components and communication flow.
4. [JDBC Drivers](JDBC-Made-Simple/04-JDBC-Drivers/Notes.md) — driver types
   and their differences.
5. [Environment Setup](JDBC-Made-Simple/05-Environment-Setup/Notes.md) — Java,
   MySQL, and MySQL Connector/J.
6. [JDBC Connection](JDBC-Made-Simple/06-JDBC-Connection/Notes.md) — creating
   and managing a database connection.
7. [Four Steps of JDBC](JDBC-Made-Simple/07-Four-Steps-of-JDBC/Notes.md) — the
   standard sequence for a JDBC operation.
8. [Statement](JDBC-Made-Simple/08-Statement/Notes.md) — executing SQL with
   `Statement`.
9. [PreparedStatement](JDBC-Made-Simple/09-PreparedStatement/Notes.md) —
   parameterized queries and safer SQL.
10. [CallableStatement](JDBC-Made-Simple/10-CallableStatement/Notes.md) —
    calling stored procedures.

### Industry-standard JDBC

The [industry-standard section](JDBC-Made-Simple/11-Industry-Standard-JDBC/)
covers:

- Traditional versus modern JDBC
- Connection management and try-with-resources
- Choosing JDBC execute methods and handling exceptions
- SQL injection prevention and database utilities
- Project organization, resource best practices, and a complete JDBC flow

### Advanced topics

12. [ResultSet](JDBC-Made-Simple/12-ResultSet/Notes.md) — reading query results.
13. [Batch Processing](JDBC-Made-Simple/13-Batch-Processing/Notes.md) — grouping
    database operations.
14. [Stored Procedures](JDBC-Made-Simple/14-Stored-Procedures/Notes.md) —
    creating and calling procedures.
15. [Transactions](JDBC-Made-Simple/15-Transactions/Notes.md) — commit,
    rollback, and transaction basics.
16. [Metadata](JDBC-Made-Simple/16-Metadata/Notes.md) — inspecting database
    and result-set information.

### Revision and interview preparation

- [Best Practices Revision](JDBC-Made-Simple/17-Best-Practices-Revision/Notes.md)
- [Quick Revision](JDBC-Made-Simple/18-Quick-Revision/Notes.md)
- [Interview Questions](JDBC-Made-Simple/19-Interview-Preparation/Questions.md)
- [Multiple-choice Questions](JDBC-Made-Simple/19-Interview-Preparation/MCQs.md)

## What you need

To run the Java examples, install:

- JDK 17 or newer
- MySQL Server 8.0 or newer
- MySQL Connector/J added to your project classpath or dependencies

Follow the [environment setup notes](JDBC-Made-Simple/05-Environment-Setup/Notes.md)
to configure these. The examples use a `college_db` database and a `students`
table; the setup notes include the SQL to create them. Some examples may need
database connection settings adjusted for your local MySQL installation.

## Repository layout

```text
JDBC-Guide-Mastery/
├── README.md
├── JDBC-Made-Simple/       # Lessons, examples, SQL, and visual diagrams
└── scripts/                # Project content-generation utility
```

## License

The learning materials are available under the [MIT License](JDBC-Made-Simple/LICENSE).
