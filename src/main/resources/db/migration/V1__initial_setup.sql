-- USERS Table
CREATE TABLE users (
                     id SERIAL PRIMARY KEY,
                     name VARCHAR(100) NOT NULL,
                     email VARCHAR(100) UNIQUE NOT NULL,
                     role VARCHAR(20) NOT NULL CHECK (role IN ('ADMIN', 'STUDENT', 'TEACHER')),
                     password VARCHAR(255) NOT NULL
);

-- RECITATIONS Table
CREATE TABLE recitations (
                           id SERIAL PRIMARY KEY,
                           student_id INTEGER NOT NULL,
                           content TEXT NOT NULL,
                           date DATE NOT NULL,
                           teacher_feedback TEXT,
                           CONSTRAINT fk_recitations_student FOREIGN KEY (student_id) REFERENCES users(id)
                             ON DELETE CASCADE
);

-- MATERIALS Table
CREATE TABLE materials (
                         id SERIAL PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         file_url TEXT NOT NULL,
                         uploaded_by INTEGER NOT NULL,
                         upload_date DATE NOT NULL,
                         CONSTRAINT fk_materials_uploaded_by FOREIGN KEY (uploaded_by) REFERENCES users(id)
                           ON DELETE SET NULL
);

-- EVALUATIONS Table
CREATE TABLE evaluations (
                           id SERIAL PRIMARY KEY,
                           student_id INTEGER NOT NULL,
                           score NUMERIC(5,2) CHECK (score >= 0),
                           week_number INTEGER NOT NULL,
                           teacher_id INTEGER,
                           CONSTRAINT fk_evaluations_student FOREIGN KEY (student_id) REFERENCES users(id)
                             ON DELETE CASCADE,
                           CONSTRAINT fk_evaluations_teacher FOREIGN KEY (teacher_id) REFERENCES users(id)
                             ON DELETE SET NULL
);

-- ZOOM_CLASSES Table
CREATE TABLE zoom_classes (
                            id SERIAL PRIMARY KEY,
                            topic VARCHAR(255) NOT NULL,
                            date TIMESTAMP NOT NULL,
                            zoom_link TEXT NOT NULL,
                            created_by INTEGER NOT NULL,
                            CONSTRAINT fk_zoom_created_by FOREIGN KEY (created_by) REFERENCES users(id)
                              ON DELETE SET NULL
);
