CREATE TYPE account_status AS ENUM ('ACTIVE', 'BLOCKED');

CREATE TABLE accounts (
    id UUID PRIMARY KEY NOT NULL UNIQUE DEFAULT gen_random_uuid(),
    username CHAR(50) NOT NULL UNIQUE,
    email CHAR(255) NOT NULL UNIQUE,
    password_hash CHAR(255) NOT NULL,
    status account_status NOT NULL DEFAULT 'ACTIVE'
);