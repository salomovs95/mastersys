ALTER TABLE students
ADD COLUMN tax_id VARCHAR(30) NOT NULL UNIQUE;

ALTER TABLE contacts
ADD CONSTRAINT uc_contacts_tax_id UNIQUE (cvalue, student_id);

ALTER TABLE attendances 
RENAME COLUMN attendande_start_date TO attendance_start_date;
