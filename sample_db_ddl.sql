-- ###########################################################################--
-- Table: sample.angular_form
-- ###########################################################################--

-- DROP TABLE sample.angular_form;

CREATE TABLE sample.angular_form
(
  id serial NOT NULL,
  email character varying(20),
  password character varying(20),
  username character varying(20),
  cellphone character varying(20),
  soccer character varying(5),
  baseball character varying(5),
  basketball character varying(5),
  volleyball character varying(5),
  agegroup character varying(5),
  CONSTRAINT angular_form_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sample.angular_form
  OWNER TO enterprisedb;
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE sample.angular_form TO ap_user;
GRANT ALL ON TABLE sample.angular_form TO enterprisedb;

-- ###########################################################################--
-- Table: sample.angular_grid
-- ###########################################################################--

-- DROP TABLE sample.angular_grid;

CREATE TABLE sample.angular_grid
(
  id serial NOT NULL,
  firstname character varying(20),
  lastname character varying(20),
  company character varying(20),
  age integer,
  CONSTRAINT angular_grid_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sample.angular_grid
  OWNER TO enterprisedb;
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE sample.angular_grid TO ap_user;
GRANT ALL ON TABLE sample.angular_grid TO enterprisedb;

-- ###########################################################################--
-- Sequence: sample.angular_form_id_seq
-- ###########################################################################--

-- DROP SEQUENCE sample.angular_form_id_seq;

CREATE SEQUENCE sample.angular_form_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 5
  CACHE 1;
ALTER TABLE sample.angular_form_id_seq
  OWNER TO enterprisedb;
GRANT USAGE ON SEQUENCE sample.angular_form_id_seq TO ap_user;
GRANT ALL ON SEQUENCE sample.angular_form_id_seq TO enterprisedb;

ALTER TABLE sample.angular_form ALTER COLUMN id SET DEFAULT nextval('sample.angular_form_id_seq'::regclass);

-- ###########################################################################--
-- Sequence: sample.angular_grid_id_seq
-- ###########################################################################--

-- DROP SEQUENCE sample.angular_grid_id_seq;

CREATE SEQUENCE sample.angular_grid_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 25
  CACHE 1;
ALTER TABLE sample.angular_grid_id_seq
  OWNER TO enterprisedb;
GRANT USAGE ON SEQUENCE sample.angular_grid_id_seq TO ap_user;
GRANT ALL ON SEQUENCE sample.angular_grid_id_seq TO enterprisedb;

ALTER TABLE sample.angular_grid ALTER COLUMN id SET DEFAULT nextval('sample.angular_grid_id_seq'::regclass);

-- ###########################################################################--
-- Table: sample.sffw_employee_info
-- ###########################################################################--

-- DROP TABLE sample.sffw_employee_info;

CREATE TABLE sample.sffw_employee_info
(
  emp_no character varying(6) NOT NULL,
  emp_nm character varying(20),
  hire_date character varying(8),
  CONSTRAINT pk_emp_info PRIMARY KEY (emp_no)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sample.sffw_employee_info
  OWNER TO enterprisedb;
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE sample.sffw_employee_info TO ap_user;
GRANT ALL ON TABLE sample.sffw_employee_info TO enterprisedb;
