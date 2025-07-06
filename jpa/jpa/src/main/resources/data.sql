-- USUARIOS
INSERT INTO users (id, name, email, user_type) VALUES (1, 'Juan Pérez', 'juan.perez@colegio.edu', 'TEACHER');
INSERT INTO users (id, name, email, user_type) VALUES (2, 'Laura Gómez', 'laura.gomez@colegio.edu', 'STUDENT');
INSERT INTO users (id, name, email, user_type) VALUES (3, 'Carlos Mendoza', 'carlos.mendoza@colegio.edu', 'STUDENT');

-- CURSOS
INSERT INTO COURSES (id, name, descriptions, teacher_id) VALUES (100, 'Matemáticas', 'Curso de álgebra y aritmética', 1);
INSERT INTO COURSES (id, name, descriptions, teacher_id) VALUES (101, 'Historia', 'Historia universal desde la antigüedad', 1);

-- RELACIÓN CURSO - ESTUDIANTE (MANY TO MANY)
INSERT INTO STUDENT_COURSE (id, course_id, student_id, qualification) VALUES (1, 100, 2, 3);
INSERT INTO STUDENT_COURSE (id, course_id, student_id, qualification) VALUES (2, 100, 3, 4);

-- ANUNCIOS DE CURSOS (ONE TO MANY)
INSERT INTO TASKS (id, course_id, title, description, publication_date) VALUES (1, 100, 'Bienvenida', 'Bienvenidos al curso de matemáticas', CURRENT_TIMESTAMP);
