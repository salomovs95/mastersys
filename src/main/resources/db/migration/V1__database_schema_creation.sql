CREATE TABLE students (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    birthdate DATE NOT NULL,
    gender VARCHAR(1) CHECK (gender IN ('F', 'M')),
    registered_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE addresses (
    id BIGSERIAL PRIMARY KEY,
    address VARCHAR(150),
    number INT,
    complement VARCHAR(100),
    neighborhood VARCHAR(20),
    city VARCHAR(20),
    fed_unity VARCHAR(20),
    zip_code VARCHAR(20),
    student_id BIGSERIAL NOT NULL REFERENCES students(id)
);

CREATE TABLE contacts (
    id BIGSERIAL PRIMARY KEY,
    ctype VARCHAR(8) NOT NULL,
    cvalue VARCHAR(150),
    student_id BIGSERIAL NOT NULL REFERENCES students(id),
    CHECK (ctype IN ('PHONE', 'CELLPHONE', 'EMAIL'))
);

CREATE TABLE modalities (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE graduations (
    id BIGSERIAL PRIMARY KEY,
    modality_id BIGSERIAL NOT NULL REFERENCES modalities(id),
    name VARCHAR(100) NOT NULL,
    UNIQUE (modality_id, name)
);

CREATE TABLE plans (
    id BIGSERIAL PRIMARY KEY,
    modality_id BIGSERIAL NOT NULL REFERENCES modalities(id),
    name VARCHAR(100) NOT NULL,
    monthly_price NUMERIC(10,2) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    UNIQUE (modality_id, name),
    CHECK (monthly_price > 0)
);

CREATE TABLE registrations (
    id BIGSERIAL PRIMARY KEY,
    registration_date DATE NOT NULL DEFAULT CURRENT_DATE,
    due_day INTEGER NOT NULL,
    closing_date DATE,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    student_id BIGSERIAL NOT NULL REFERENCES students(id),
    CHECK (status IN ('ACTIVE','CLOSED','CANCELED')),
    CHECK (due_day BETWEEN 1 AND 31)
);

CREATE TABLE registration_modalities (
    id BIGSERIAL PRIMARY KEY,
    registration_id BIGSERIAL NOT NULL REFERENCES registrations(id),
    modality_id BIGSERIAL NOT NULL REFERENCES modalities(id),
    graduation_id BIGSERIAL NOT NULL REFERENCES graduations(id),
    plan_id BIGSERIAL NOT NULL REFERENCES plans(id),
    start_date DATE NOT NULL DEFAULT CURRENT_DATE,
    finish_date DATE,
    UNIQUE (registration_id, modality_id)
);

CREATE TABLE registration_invoices (
    id BIGSERIAL PRIMARY KEY,
    registration_id BIGSERIAL NOT NULL REFERENCES registrations(id),
    due_date DATE NOT NULL,
    payment_date TIMESTAMP,
    cancelment_date DATE,
    invoice_value NUMERIC(10,2) NOT NULL,
    status VARCHAR(10) NOT NULL DEFAULT 'OPEN',
    CHECK (invoice_value > 0),
    CHECK (status IN ('OPEN','PAID','CANCELED','OVERDUE')),
    UNIQUE (registration_id, due_date)
);

CREATE TABLE attendances (
    id BIGSERIAL PRIMARY KEY,
    registration_id BIGSERIAL NOT NULL REFERENCES registrations(id),
    attendande_start_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    attendance_end_date TIMESTAMP
);
