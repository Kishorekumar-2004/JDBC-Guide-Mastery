-- college_db schema
CREATE DATABASE IF NOT EXISTS college_db;
USE college_db;

CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT,
    department VARCHAR(50)
);

INSERT INTO students (id, name, age, department) VALUES
(101, 'Alice Johnson', 20, 'Computer Science'),
(102, 'Bob Smith', 22, 'Information Tech')
ON DUPLICATE KEY UPDATE name=name;
