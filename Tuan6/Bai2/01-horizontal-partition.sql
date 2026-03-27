-- Horizontal Partitioning: Split by gender (male/female)
CREATE TABLE users_male (
    id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(100),
    email NVARCHAR(100),
    gender NVARCHAR(10),
    created_at DATETIME DEFAULT GETDATE()
);

CREATE TABLE users_female (
    id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(100),
    email NVARCHAR(100),
    gender NVARCHAR(10),
    created_at DATETIME DEFAULT GETDATE()
);

-- Insert sample data
INSERT INTO users_male (name, email, gender) VALUES 
    ('Nguyễn Văn A', 'nguyen.a@example.com', 'Male'),
    ('Trần Văn B', 'tran.b@example.com', 'Male'),
    ('Phạm Văn C', 'pham.c@example.com', 'Male');

INSERT INTO users_female (name, email, gender) VALUES 
    ('Hoàng Thị D', 'hoang.d@example.com', 'Female'),
    ('Lê Thị E', 'le.e@example.com', 'Female'),
    ('Võ Thị F', 'vo.f@example.com', 'Female');
