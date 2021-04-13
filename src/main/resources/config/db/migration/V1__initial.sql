CREATE TABLE project_import (
  id            INTEGER       NOT NULL,
  name          VARCHAR(64)   NOT NULL,
  key           VARCHAR(64)   NOT NULL,
  category      VARCHAR(16)   NOT NULL,
  comment       VARCHAR(2048),
  sub_category   VARCHAR(16),
  PRIMARY KEY (id)
);