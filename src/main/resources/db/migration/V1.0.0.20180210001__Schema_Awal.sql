CREATE  TABLE customer(
  id VARCHAR(36) PRIMARY KEY,
  code VARCHAR(5) UNIQUE NOT NULL,
  name VARCHAR(100) NOT NULL,
  address VARCHAR(255),
  birth_of_date DATE NOT NULL,
  credit_limit DECIMAL (15,2)
);