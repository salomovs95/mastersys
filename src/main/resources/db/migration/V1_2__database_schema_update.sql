ALTER TABLE students
ADD COLUMN address_id BIGSERIAL NOT NULL REFERENCES addresses(id);

ALTER TABLE students
ADD CONSTRAINT unique_student_address UNIQUE (address_id, id);

ALTER TABLE addresses
DROP COLUMN student_id;
