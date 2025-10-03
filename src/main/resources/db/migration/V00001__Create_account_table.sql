CREATE TYPE account_status AS ENUM ('ACTIVE', 'BLOCKED');

CREATE TABLE accounts (
    id UUID PRIMARY KEY NOT NULL UNIQUE,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    status account_status NOT NULL
);