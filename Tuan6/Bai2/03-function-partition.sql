-- Function-based Partitioning: Split by user status (logic)
CREATE TABLE users_active (
    id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(100),
    email NVARCHAR(100),
    status NVARCHAR(20),
    last_login DATETIME,
    created_at DATETIME DEFAULT GETDATE()
);

CREATE TABLE users_inactive (
    id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(100),
    email NVARCHAR(100),
    status NVARCHAR(20),
    last_login DATETIME,
    created_at DATETIME DEFAULT GETDATE()
);

CREATE TABLE users_suspended (
    id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(100),
    email NVARCHAR(100),
    status NVARCHAR(20),
    last_login DATETIME,
    created_at DATETIME DEFAULT GETDATE()
);

-- Insert sample data
INSERT INTO users_active (name, email, status, last_login) VALUES 
    ('Nguyễn Văn A', 'nguyen.a@example.com', 'Active', '2026-03-27'),
    ('Hoàng Thị B', 'hoang.b@example.com', 'Active', '2026-03-26');

INSERT INTO users_inactive (name, email, status, last_login) VALUES 
    ('Trần Văn C', 'tran.c@example.com', 'Inactive', '2026-02-01');

INSERT INTO users_suspended (name, email, status, last_login) VALUES 
    ('Phạm Thị D', 'pham.d@example.com', 'Suspended', '2026-01-15');
