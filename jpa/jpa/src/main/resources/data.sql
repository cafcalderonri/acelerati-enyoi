-- Teachers
INSERT INTO teacher (id, name, email) VALUES (1, 'John Doe', 'john@example.com');
INSERT INTO teacher (id, name, email) VALUES (2, 'Jane Smith', 'jane@example.com');

-- Students
INSERT INTO student (id, name, email) VALUES (1, 'Alice', 'alice@example.com');
INSERT INTO student (id, name, email) VALUES (2, 'Bob', 'bob@example.com');

-- Courses
INSERT INTO course (id, name, description) VALUES (1, 'Math', 'Basic Math course');
INSERT INTO course (id, name, description) VALUES (2, 'Science', 'Basic Science course');

-- Teacher-Course associations
INSERT INTO course_teachers (course_id, teachers_id) VALUES (1, 1);
INSERT INTO course_teachers (course_id, teachers_id) VALUES (2, 2);

-- Student enrollments with grades
INSERT INTO course_enrollment (id, course_id, student_id, grade) VALUES (1, 1, 1, 4.5);
INSERT INTO course_enrollment (id, course_id, student_id, grade) VALUES (2, 2, 2, 3.8);

-- Tasks
INSERT INTO task (id, title, description, publication_date, course_id, teacher_id) VALUES (1, 'Task 1', 'Math task', CURRENT_TIMESTAMP, 1, 1);
INSERT INTO task (id, title, description, publication_date, course_id, teacher_id) VALUES (2, 'Task 2', 'Science task', CURRENT_TIMESTAMP, 2, 2);
