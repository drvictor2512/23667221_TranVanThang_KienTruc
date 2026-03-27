
CREATE TABLE users_profile (
    id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(100),
    email NVARCHAR(100),
    created_at DATETIME DEFAULT GETDATE()
);

-- Table 2: User sensitive data (less frequently accessed)
CREATE TABLE users_detail (
    id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT,
    phone NVARCHAR(20),
    address NVARCHAR(200),
    ssn NVARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES users_profile(id)
);

-- Insert sample data
INSERT INTO users_profile (name, email) VALUES 
    ('Nguyễn Văn A', 'nguyen.a@example.com'),
    ('Hoàng Thị B', 'hoang.b@example.com'),
    ('Trần Văn C', 'tran.c@example.com');

INSERT INTO users_detail (user_id, phone, address, ssn) VALUES 
    (1, '0982123456', '123 Nguyen Hue, HN', '001-23-4567'),
    (2, '0983234567', '456 Le Loi, HCMC', '002-34-5678'),
    (3, '0984345678', '789 Vo Van Kiet, HN', '003-45-6789');
