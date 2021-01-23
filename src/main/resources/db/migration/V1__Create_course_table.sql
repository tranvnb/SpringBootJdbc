CREATE TABLE Course (
    id UUID not null PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL
);

INSERT INTO Course VALUES('d985edc1-1d0d-47fd-abb0-ae40c8a4a1a4', '3275', '2021-01-01', '2021-04-13'),
                         ('83b5656d-5f96-4fbb-849c-17f158c3942e', '3380', '2021-01-01', '2021-04-16');