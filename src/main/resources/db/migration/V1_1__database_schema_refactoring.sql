ALTER TABLE students
ADD COLUMN tax_id VARCHAR(30) NOT NULL UNIQUE;

ALTER TABLE attendances 
RENAME COLUMN attendande_start_date TO attendance_start_date;
