DROP TABLE IF EXISTS formdata;

-- ------------------------------------
-- Table structure of process
-- ------------------------------------
CREATE TABLE formdata
(
   PROC_DEF_ID_         varchar(64)  comment '',
   PROC_INST_ID_        varchar(64)  comment '',
   FORM_KEY_            varchar(255)  comment '',
   Control_ID_          varchar(100)  comment '',
   Control_VALUE_       varchar(2000)  comment ''
);