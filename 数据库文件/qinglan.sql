/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/11/28 19:18:01                          */
/*==============================================================*/


drop table if exists tbl_course;

drop table if exists tbl_grade;

drop table if exists tbl_homework;

drop table if exists tbl_msg;

drop table if exists tbl_myjob;

drop table if exists tbl_myjobtime;

drop table if exists tbl_mysubject;

drop table if exists tbl_review;

drop table if exists tbl_teachplan;

drop table if exists tbl_user;

/*==============================================================*/
/* Table: tbl_course                                            */
/*==============================================================*/
create table tbl_course
(
   id                   int not null auto_increment,
   tid                  int,
   sid                  int,
   subject              varchar(50),
   primary key (id)
);

/*==============================================================*/
/* Table: tbl_grade                                             */
/*==============================================================*/
create table tbl_grade
(
   id                   int not null auto_increment,
   tid                  int,
   grade                varchar(20),
   primary key (id)
);

/*==============================================================*/
/* Table: tbl_homework                                          */
/*==============================================================*/
create table tbl_homework
(
   id                   int not null auto_increment,
   tid                  int,
   sid                  int,
   content              varchar(1024),
   starttime            datetime,
   endtime              datetime,
   score                decimal,
   primary key (id)
);

/*==============================================================*/
/* Table: tbl_msg                                               */
/*==============================================================*/
create table tbl_msg
(
   id                   int not null auto_increment,
   sendid               int,
   receiveid            int,
   content              varchar(1024),
   sendtime             datetime,
   status               int,
   primary key (id)
);

/*==============================================================*/
/* Table: tbl_myjob                                             */
/*==============================================================*/
create table tbl_myjob
(
   id                   int not null auto_increment,
   tid                  int,
   subject              varchar(30),
   address              varchar(255),
   price                int,
   teacherage           varchar(10),
   primary key (id)
);

/*==============================================================*/
/* Table: tbl_myjobtime                                         */
/*==============================================================*/
create table tbl_myjobtime
(
   id                   int not null auto_increment,
   tid                  int,
   time                 varchar(30),
   primary key (id)
);

/*==============================================================*/
/* Table: tbl_mysubject                                         */
/*==============================================================*/
create table tbl_mysubject
(
   id                   int not null auto_increment,
   tid                  int,
   subject              varchar(20),
   primary key (id)
);

/*==============================================================*/
/* Table: tbl_review                                            */
/*==============================================================*/
create table tbl_review
(
   id                   int not null auto_increment,
   sendid               int,
   receiveid            int,
   reviewtime           datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: tbl_teachplan                                         */
/*==============================================================*/
create table tbl_teachplan
(
   id                   int not null auto_increment,
   tid                  int,
   sid                  int,
   content              text,
   time                 datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: tbl_user                                              */
/*==============================================================*/
create table tbl_user
(
   id                   int not null auto_increment,
   username             varchar(255),
   userpwd              varchar(255),
   emile                char(255),
   role                 char(30),
   regdate              datetime,
   realname             varchar(30),
   idnumber             char(50),
   sex                  char(10),
   stuimg               char(50),
   userimg              char(50),
   school               varchar(50),
   grade                char(20),
   phonenumber          char(30),
   address              varchar(255),
   introduce            varchar(255),
   major                varchar(50),
   status               int,
   primary key (id)
);

