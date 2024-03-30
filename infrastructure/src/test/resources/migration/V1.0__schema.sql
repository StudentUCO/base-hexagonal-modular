CREATE TABLE task (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    creation_date TIMESTAMP WITHOUT TIME ZONE,
    completed BOOLEAN
);
