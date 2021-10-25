CREATE DATABASE todoapp;

USE todoapp;

CREATE TABLE tasks
(
    id               int PRIMARY KEY AUTO_INCREMENT,
    description      varchar(100),
    date             datetime DEFAULT NOW(),
    completed_status tinyint(1) DEFAULT 0,
    completion_date  DATETIME
);

INSERT INTO tasks (description)
VALUES ('Buy milk'),
       ('Walk the dog'),
       ('Clean the house'),
       ('Play with children'),
       ('Mow the lawn');

update tasks
set completed_status = 1
where id = 1;

select description
from tasks
where completed_status = 0;

DELETE
from tasks
where id = 4;






