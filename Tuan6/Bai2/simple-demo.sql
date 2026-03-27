# Simple Demo - Copy paste vào SQL Server Management Studio

-- =========== 1. HORIZONTAL PARTITIONING ===========
-- Split by gender - Each query hits smaller table
CREATE TABLE users_male (
    id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(100),
    gender NVARCHAR(10)
);

CREATE TABLE users_female (
    id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(100),
    gender NVARCHAR(10)
);

INSERT INTO users_male (name, gender) VALUES ('Nguyễn Văn A', 'Male'), ('Trần Văn B', 'Male');
INSERT INTO users_female (name, gender) VALUES ('Hoàng Thị C', 'Female'), ('Lê Thị D', 'Female');

-- Query
SELECT 'Male' as Gender, COUNT(*) FROM users_male
UNION ALL
SELECT 'Female' as Gender, COUNT(*) FROM users_female;

-- =========== 2. VERTICAL PARTITIONING ===========
-- Split columns - Profile và Detail riêng biệt
CREATE TABLE profile (
    id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(100),
    email NVARCHAR(100)
);

CREATE TABLE detail (
    id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT,
    phone NVARCHAR(20),
    address NVARCHAR(200)
);

INSERT INTO profile (name, email) VALUES ('Nguyễn A', 'a@example.com'), ('Hoàng B', 'b@example.com');
INSERT INTO detail (user_id, phone, address) VALUES (1, '098123', 'HN'), (2, '097456', 'HCMC');

-- Query (chỉ cần profile)
SELECT p.*, d.phone FROM profile p LEFT JOIN detail d ON p.id = d.user_id;

-- =========== 3. FUNCTION-BASED PARTITIONING ===========
-- Split by status logic
CREATE TABLE users_active (id INT PRIMARY KEY, name NVARCHAR(100), status NVARCHAR(20));
CREATE TABLE users_inactive (id INT PRIMARY KEY, name NVARCHAR(100), status NVARCHAR(20));

INSERT INTO users_active VALUES (1, 'User A', 'Active'), (2, 'User B', 'Active');
INSERT INTO users_inactive VALUES (3, 'User C', 'Inactive');

-- Query
SELECT 'Active' as Status, COUNT(*) FROM users_active
UNION ALL
SELECT 'Inactive' as Status, COUNT(*) FROM users_inactive;
