-- Initial database setup with sample data
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

INSERT INTO users (name, email) VALUES 
    ('Minh Chung', 'minh.chung@example.com'),
    ('Người dùng 2', 'user2@example.com'),
    ('Người dùng 3', 'user3@example.com');
