CREATE TABLE employee_import (
  id            INTEGER       NOT NULL,
  full_name     VARCHAR(64)   NOT NULL,
  job_title     VARCHAR(64)   NOT NULL,
  department    VARCHAR(64)   NOT NULL,
  business_unit VARCHAR(64)   NOT NULL,
  gender        VARCHAR(16),
  age           INTEGER,
  hire_date     VARCHAR(256)  NOT NULL,
  annual_salary VARCHAR(64),
  bonus         VARCHAR(16),
  country       VARCHAR(64),
  city          VARCHAR(64),
  exit_date     VARCHAR(256),
  PRIMARY KEY (id)
);