
DROP TABLE if EXISTS task;

CREATE TABLE task (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  status VARCHAR(250) NOT NULL,
  description VARCHAR(250) DEFAULT NULL
);
