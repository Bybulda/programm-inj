CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(100) NOT NULL,
                       email VARCHAR(150),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
